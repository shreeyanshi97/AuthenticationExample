package com.example.shreeyanshi.authenticationexample;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shreeyanshi.authenticationexample.Common.Common;
import com.example.shreeyanshi.authenticationexample.Model.Category;
import com.example.shreeyanshi.authenticationexample.Model.User;
import com.google.android.gms.signin.SignIn;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignInActivity extends AppCompatActivity {

    Button signinButton;
    EditText numberEditText, passwordEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);

        signinButton = (Button) findViewById(R.id.signIn_btn);
        numberEditText = (EditText) findViewById(R.id.number);
        passwordEditText = (EditText) findViewById(R.id.password);

        //initialise firebase

        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        signinButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog progressDialog = new ProgressDialog(SignInActivity.this);
                progressDialog.setTitle("Processing...");
                progressDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                        //Check if user exists or not
                        if(dataSnapshot.child(numberEditText.getText().toString()).exists()) {

                            progressDialog.dismiss();
                            //get the user info
                            User user;
                            user = dataSnapshot.child(numberEditText.getText().toString()).getValue(User.class);
                            if (user.getPassword().equals(passwordEditText.getText().toString())) {
                                //moving to home activity
                                Toast.makeText(SignInActivity.this, "SignIn Successful!", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(SignInActivity.this, HomeActivity.class);
                                Common.currentUser = user;
                                startActivity(intent);
                                finish();
                            } else {

                                Toast.makeText(SignInActivity.this, "Wrong Password!", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            progressDialog.dismiss();
                            Toast.makeText(SignInActivity.this, "User does not exist", Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });
    }
}
