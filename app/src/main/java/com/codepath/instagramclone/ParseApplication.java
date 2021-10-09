package com.codepath.instagramclone;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseObject;

public class ParseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        ParseObject.registerSubclass(Post.class);
        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("j8oCzmbI5JFR4U6ssZ4RvXACReVWDCLTMFt4Cdb6")
                .clientKey("8q4DhU7x709G19qOM2RCvY8S09BEaaW9likkUt4a")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
    }
}
