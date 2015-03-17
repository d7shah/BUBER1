package comd7shah.github.www.buber1;

import android.app.Application;

import com.parse.Parse;
import com.parse.ParseInstallation;

/**
 * Created by kevalshah on 17/03/15.
 */
public class ParseApplication extends Application {

    public void onCreate() {
        super.onCreate();
        Parse.enableLocalDatastore(this);
        Parse.initialize(this, "DR9Ivs2PTPRPM1OGJgnhfC7Rv28i7OvKM0TUdXsg", "nmaBhQsdOgPtwI4YFZYAAHVr6pYoJibteGzupFK2");
        ParseInstallation.getCurrentInstallation().saveInBackground();
    }
}
