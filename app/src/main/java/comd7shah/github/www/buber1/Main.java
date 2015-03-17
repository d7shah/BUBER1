package comd7shah.github.www.buber1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.parse.ParseUser;


public class Main extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ParseUser currentUser = ParseUser.getCurrentUser();
        if (currentUser != null) {
           //show user the homepage


        } else {
            // show the signup or login screen
            Intent takeUserToLogin = new Intent(this, LoginActivity.class);
            startActivity(takeUserToLogin);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id) {
            case R.id.LogoutUser:
                //logout the user
                ParseUser.logOut();

                //take the user back to login screen
                Intent takeUserToLogin = new Intent(this, LoginActivity.class);
                startActivity(takeUserToLogin);
                break;
        }


        return super.onOptionsItemSelected(item);
    }
}
