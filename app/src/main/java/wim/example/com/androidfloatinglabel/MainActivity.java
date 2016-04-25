package wim.example.com.androidfloatinglabel;

import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnSubmit;
    TextInputLayout lyUsername, lyEmail, lyPassword;
    EditText textUsername, textEmail, textPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSubmit = (Button) findViewById(R.id.btnSubmit);

        lyUsername = (TextInputLayout) findViewById(R.id.lyUsername);
        lyEmail = (TextInputLayout) findViewById(R.id.lyEmail);
        lyPassword = (TextInputLayout) findViewById(R.id.lyPassword);

        textUsername = (EditText) findViewById(R.id.username);
        textEmail = (EditText) findViewById(R.id.email);
        textPassword = (EditText) findViewById(R.id.password);

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validation();
            }
        });
    }

    private void validation(){

        if(TextUtils.isEmpty(textUsername.getText().toString())){
            lyUsername.setErrorEnabled(true);
            lyUsername.setError("Username must not empty");
            return;
        }else{
            lyUsername.setErrorEnabled(false);
        }

        if(TextUtils.isEmpty(textEmail.getText().toString())){
            lyEmail.setErrorEnabled(true);
            lyEmail.setError("Email must not empty");
            return;
        }else{
            lyEmail.setErrorEnabled(false);
        }

        if(TextUtils.isEmpty(textPassword.getText().toString())){
            lyPassword.setErrorEnabled(true);
            lyPassword.setError("Password must not empty");
            return;
        }else{
            lyPassword.setErrorEnabled(false);
        }

        if(!new EmailValidation().validateEmail(textEmail.getText().toString())){
            lyEmail.setErrorEnabled(true);
            lyEmail.setError("Please enter a valid email address");
            return;
        }else{
            lyEmail.setErrorEnabled(false);
        }

        Toast.makeText(this, "Thank You!", Toast.LENGTH_SHORT).show();
    }
}
