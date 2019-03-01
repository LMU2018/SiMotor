package com.digitalnetworkasia.simotor;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText nohp;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nohp = findViewById(R.id.nohp);
        button = findViewById(R.id.button);
    }

    @Override
    protected void onResume() {
        super.onResume();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mobile =  nohp.getText().toString().trim();

                if (mobile.isEmpty() || mobile.length()<10){
                    nohp.setError("No HP salah");
                    nohp.requestFocus();
                    return;
                }
                Intent intent = new Intent(MainActivity.this,AuthActivity.class);
                intent.putExtra("mobile",mobile);
                startActivity(intent);
            }
        });

    }
}
