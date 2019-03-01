package com.digitalnetworkasia.simotor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.SignInButton;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {

    EditText nohp;
    Button button;
    SignInButton google;

    private static final int RC_SIGN_IN = 234;

    //Tag for the logs optional
    private static final String TAG = "simplifiedcoding";

    //creating a GoogleSignInClient object

    //And also a Firebase Auth object
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nohp = findViewById(R.id.nohp);
        button = findViewById(R.id.button);
        google = findViewById(R.id.sign_in_button);
        //te


    }

    @Override
    protected void onResume() {
        super.onResume();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile = nohp.getText().toString().trim();

                if (mobile.isEmpty() || mobile.length() < 10) {
                    nohp.setError("No HP salah");
                    nohp.requestFocus();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, AuthActivity.class);
                intent.putExtra("mobile", mobile);
                startActivity(intent);
            }
        });

    }
}
