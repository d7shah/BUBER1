package comd7shah.github.www.buber1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/**
 * Created by dhrutishah on 15-03-17.
 */
public class Splash extends Activity {

    //Set the time the splash screen time will take

    private static int splashInterval = 2800;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        new Handler().postDelayed(new Runnable(){

            @Override
            public void run() {
                Intent i = new Intent(Splash.this, Main.class);
                startActivity(i);

                this.finish();

            }

            private void finish() {

            }

        }, splashInterval);
    }
}
