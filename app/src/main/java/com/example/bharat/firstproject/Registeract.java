package com.example.bharat.firstproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Registeract extends AppCompatActivity {

    Button signup;
    TextView signin;
    EditText email,password;

    ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeract);

        signup=findViewById(R.id.Signup);
        signin=findViewById(R.id.Signin);
        email=findViewById(R.id.TextEmail);
        password=findViewById(R.id.TextPassword);

        firebaseAuth=FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                registerUser();
            }
        });
    }
    public void registerUser()
    {   String Email = email.getText().toString().trim();
        String Password = password.getText().toString().trim();

        if (TextUtils.isEmpty(Email)) {
            //empty mail
            Toast.makeText(this, "Please Fill Email Id", Toast.LENGTH_SHORT).show();
            return;//to exit functiom
        }
        if (TextUtils.isEmpty(Password)) {
            //empty mail
            Toast.makeText(this, "Please enter PassWord", Toast.LENGTH_SHORT).show();
            return;
        }
        //if validations are ok
        //we will show a progress dialog
        progressDialog.setMessage("Registering User....");
        progressDialog.show();

        firebaseAuth.createUserWithEmailAndPassword(Email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            Toast.makeText(Registeract.this, "Registered Successfully", Toast.LENGTH_SHORT).show();
                            finish();
                            startActivity(new Intent(getApplicationContext(), Interest.class));
                        } else {
                            Toast.makeText(Registeract.this, "Error IN Registration", Toast.LENGTH_SHORT).show();
                        }
                        progressDialog.hide();
                    }
                });
    }
}
