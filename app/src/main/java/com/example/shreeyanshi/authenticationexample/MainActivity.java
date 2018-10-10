package com.example.shreeyanshi.authenticationexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button signinButton, signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signinButton = (Button) findViewById(R.id.signIn_btn);
        signupButton = (Button) findViewById(R.id.signup_btn);

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Sign Up", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this, "Sign In", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);

            }
        });
    }
}
