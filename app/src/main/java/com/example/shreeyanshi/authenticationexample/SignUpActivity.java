package com.example.shreeyanshi.authenticationexample;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shreeyanshi.authenticationexample.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUpActivity extends AppCompatActivity {

    EditText numberEditText, nameEditText, passwordEditText;
    Button signupButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        numberEditText = (EditText) findViewById(R.id.number);
        nameEditText = (EditText) findViewById(R.id.name);
        passwordEditText = (EditText) findViewById(R.id.password);
        signupButton = (Button) findViewById(R.id.signup_btn);

        //Initialise firebase

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference table_user = database.getReference("User");

        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                final ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
                progressDialog.setTitle("Processing....");
                progressDialog.show();

                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                       if (dataSnapshot.child(numberEditText.getText().toString()).exists()){
                           progressDialog.dismiss();
                           Toast.makeText(SignUpActivity.this, "NUmber Already registered!", Toast.LENGTH_SHORT).show();
                       }
                       else{
                           progressDialog.dismiss();
                           //now signup
                           User user;
                           user = new User(nameEditText.getText().toString(), passwordEditText.getText().toString());
                           table_user.child(numberEditText.getText().toString()).setValue(user);
                           Toast.makeText(SignUpActivity.this, "Number Registered!", Toast.LENGTH_SHORT).show();
                           finish();
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
