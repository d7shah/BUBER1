package comd7shah.github.www.buber1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;


public class LoginActivity extends Activity {

    protected EditText mUsername;
    protected EditText mPassword;
    protected Button mLoginBtn;
    protected Button mCreateAccountBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //initialize
        mUsername = (EditText) findViewById(R.id.usernameLoginTextBox);
        mPassword = (EditText) findViewById(R.id.passwordLoginTextBox);
        mLoginBtn = (Button) findViewById(R.id.loginBtn);
        mCreateAccountBtn = (Button) findViewById(R.id.createAccountbtnLogin);

        //listen to CreateAccountBtn click
        mCreateAccountBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //take user to register
                Intent takeUserToRegister = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(takeUserToRegister);
            }
        });

        //listen to when the mlogin button is clicked
        mLoginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //get the user inputs from the edit text and convert to string
                String username = mUsername.getText().toString().trim();
                String password = mPassword.getText().toString().trim();


                //login the user using parse sdk
                ParseUser.logInInBackground(username, password, new LogInCallback() {
                    @Override
                    public void done(ParseUser parseUser, ParseException e) {
                        if (e == null) {
                            //success! user logged in
                            Toast.makeText(LoginActivity.this, "Welcome Back!", Toast.LENGTH_LONG).show();

                            //take user to the homepage
                            Intent takeUserHome = new Intent(LoginActivity.this, Main.class);
                            startActivity(takeUserHome);
                        }

                        else {

                            //sorry there was a problem. Advice user
                            AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
                            builder.setMessage(e.getMessage());
                            builder.setTitle("Sorry!");
                            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {
                                    //close the dialog
                                    dialogInterface.dismiss();


                                }
                            });

                            AlertDialog dialog = builder.create();
                            dialog.show();
                        }


                    }


                });


            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
