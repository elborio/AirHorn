package nl.melbasolutions.airhorn;

import android.app.Application;

import com.activeandroid.ActiveAndroid;

/**
 * Created by Boris on 4/19/2017.
 */

public class ApplicationState extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        ActiveAndroid.initialize(this);
    }
}
