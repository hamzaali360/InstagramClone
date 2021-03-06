package com.codepath.instagramclone;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import fragments.ComposeFragment;
import fragments.PostsFragment;
import fragments.ProfileFragment;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = "MainActivity";

   // public static final int CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE = 42;
//    private EditText etDescription;
//    private Button btnCaptureImage;
//    private ImageView ivPostImage;
//    private Button btnSubmit;
   final FragmentManager fragmentManager = getSupportFragmentManager();
   private BottomNavigationView bottomNavigationView;
//    private File photoFile;
//    private Button btnLogout;
//    private String photoFileName = "photo.jpg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        etDescription = findViewById(R.id.etDescription);
//        btnCaptureImage = findViewById(R.id.btnCaptureImage);
//        ivPostImage = findViewById(R.id.ivPostImage);
//        btnSubmit = findViewById(R.id.btnSubmit);
//        btnLogout = findViewById(R.id.btnLogout);
        bottomNavigationView = findViewById(R.id.bottom_navigation);

//        btnLogout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Log.i(TAG, "onClick logout button");
//                ParseUser.logOut();
//                ParseUser currentUser = ParseUser.getCurrentUser();
//                logout(currentUser);
//            }
//        });

//        btnCaptureImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                launchCamera();
//            }
//        });
//
//        //queryPost();
//        btnSubmit.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                String description = etDescription.getText().toString();
//                if (description.isEmpty()) {
//                    Toast.makeText(MainActivity.this, "Description cannot be empty", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                if (photoFile == null || ivPostImage.getDrawable() == null) {
//                    Toast.makeText(MainActivity.this, "There is no image!", Toast.LENGTH_SHORT).show();
//                    return;
//                }
//                ParseUser currentUser = ParseUser.getCurrentUser();
//                savePost(description, currentUser, photoFile);
//            }
//
//        });

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment;
                switch (menuItem.getItemId()) {
                    case R.id.action_home:
                        //Toast.makeText(MainActivity.this, "Home!", Toast.LENGTH_SHORT).show();
                        fragment = new PostsFragment();
                        break;
                    case R.id.action_compose:
                        //Toast.makeText(MainActivity.this, "Compose!", Toast.LENGTH_SHORT).show();
                        fragment = new ComposeFragment();
                        break;
                    case R.id.action_profile:
                    default:
                        //Toast.makeText(MainActivity.this, "Profile!", Toast.LENGTH_SHORT).show();
                        fragment = new ProfileFragment();
                        break;
                }
                fragmentManager.beginTransaction().replace(R.id.flContainer, fragment).commit();
                return true;
            }
        });
        // Set default selection
        bottomNavigationView.setSelectedItemId(R.id.action_home);
    }
//    private void logout(ParseUser currentUser) {
//        Log.i(TAG, "Attempting to logout user " + currentUser);
//        if (currentUser != null) {
//            // do stuff with the user
//            ParseUser.logOut();
//            currentUser = ParseUser.getCurrentUser();
//        } else {
//            Intent i = new Intent(MainActivity.this, LoginActivity.class);
//            startActivity(i);
//            finish();
//            // show the signup or login screen
//        }
//    }
//    private void launchCamera() {
//        // create Intent to take a picture and return control to the calling application
//        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
//        // Create a File reference for future access
//        photoFile = getPhotoFileUri(photoFileName);
//
//        // wrap File object into a content provider
//        // required for API >= 24
//        // See https://guides.codepath.com/android/Sharing-Content-with-Intents#sharing-files-with-api-24-or-higher
//        Uri fileProvider = FileProvider.getUriForFile(MainActivity.this, "com.codepath.fileprovider", photoFile);
//        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileProvider);
//
//        // If you call startActivityForResult() using an intent that no app can handle, your app will crash.
//        // So as long as the result is not null, it's safe to use the intent.
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            // Start the image capture intent to take photo
//            startActivityForResult(intent, CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE);
//        }
//    }
//
//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//        if (requestCode == CAPTURE_IMAGE_ACTIVITY_REQUEST_CODE) {
//            if (resultCode == RESULT_OK) {
//
//                Bitmap takenImage = BitmapFactory.decodeFile(photoFile.getAbsolutePath());
//                ivPostImage.setImageBitmap(takenImage);
//            } else {
//                Toast.makeText(this, "Picture wasn't taken!", Toast.LENGTH_SHORT).show();
//            }
//
//
//        }
//    }
//
//    // Returns the File for a photo stored on disk given the fileName
//    public File getPhotoFileUri(String fileName) {
//        // Get safe storage directory for photos
//        // Use `getExternalFilesDir` on Context to access package-specific directories.
//        // This way, we don't need to request external read/write runtime permissions.
//        File mediaStorageDir = new File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), TAG);
//
//        // Create the storage directory if it does not exist
//        if (!mediaStorageDir.exists() && !mediaStorageDir.mkdirs()){
//            Log.d(TAG, "failed to create directory");
//        }
//
//        // Return the file target for the photo based on filename
//        return new File(mediaStorageDir.getPath() + File.separator + fileName);
//    }
//
//
//    private void savePost(String description, ParseUser currentUser, File photoFile) {
//        Post post = new Post();
//        post.setDescription(description);
//        post.setImage(new ParseFile(photoFile));
//        post.setUser(currentUser);
//        post.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                if (e != null) {
//                    Log.e(TAG, "Error while saving", e);
//                    Toast.makeText(MainActivity.this, "Error while saving!", Toast.LENGTH_SHORT).show();
//                }
//                Log.i(TAG, "Post save was successful!!");
//                etDescription.setText("");
//                ivPostImage.setImageResource(0);
//            }
//
//    });
//    }
//
//
//    private void queryPost() {
//        ParseQuery<Post> query = ParseQuery.getQuery(Post.class);
//        query.include(Post.KEY_USER);
//        query.findInBackground(new FindCallback<Post>() {
//            @Override
//            public void done(List<Post > posts, com.parse.ParseException e) {
//                if (e != null) {
//                    Log.e(TAG, "Issue with getting posts", e);
//                    return;
//                }
//                for (Post post : posts) {
//                    Log.i(TAG, "Post: " + post.getDescription() + ", username: " + post.getUser().getUsername());
//                }
//            }
//        });
//    }
}