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

import com.parse.Parse;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;


public class RegisterActivity extends Activity {

    protected EditText mUsername;
    protected EditText mUserEmail;
    protected EditText mUserPassword;
    protected Button mRegisterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        // Enable Local Datastore.
        //Parse.enableLocalDatastore(this);


        //initialize
        mUsername = (EditText)findViewById(R.id.usernameRegisterEditText);
        mUserEmail = (EditText)findViewById(R.id.emailRegisterEditText);
        mUserPassword = (EditText)findViewById(R.id.passwordRegisterEditText);
        mRegisterButton = (Button)findViewById(R.id.registerButton);

        //listen to register button click
        mRegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //get the username, password, and emaill and convert them to string
                String username = mUsername.getText().toString().trim();
                String password = mUserPassword.getText().toString().trim();
                String email = mUserEmail.getText().toString().trim();

                //store user in parse
                ParseUser user = new ParseUser();
                user.setUsername(username);
                user.setPassword(password);
                user.setEmail(email);
                user.signUpInBackground(new SignUpCallback() {
                    @Override
                    public void done(ParseException e) {
                        if (e == null) {
                            //user signed up successfully
                            Toast.makeText(RegisterActivity.this, "Successfully Signed Up!", Toast.LENGTH_LONG).show();

                            //take user to homepage
                            Intent takeUsertoMain = new Intent(RegisterActivity.this, Main.class);
                            startActivity(takeUsertoMain);

                        } else {
                            //there was an error signing up user. advice user
                            //sorry there was a problem. Advice user
                            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
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
                getMenuInflater().inflate(R.menu.menu_register, menu);
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