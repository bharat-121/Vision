package com.example.bharat.firstproject;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

public class MainActivity extends AppCompatActivity {
    EditText email;
    EditText password;
    Button signin;
    TextView signup;

    ProgressDialog progressDialog;

    FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser() != null) {
            finish();
            startActivity(new Intent(this, Interest.class));
        }
        email = findViewById(R.id.TextEmail);
        password = findViewById(R.id.TextPassword);
        signup = findViewById(R.id.Signup);
        signin = findViewById(R.id.Signin);
        progressDialog = new ProgressDialog(this);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //register user;
                finish();
                Intent intent=new Intent(v.getContext(),RegisterUser.class);
                startActivity(intent);

            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("MainActivity","Line 63");
                loginuser(v);
            }
        });
    }



    public void loginuser(final View v)
    {
        //System.out.println("fdf");

        Log.v("MainActivity","Line 75");
        String Email = email.getText().toString();

        Log.v("MainActivity","Line 77");
        String Password = password.getText().toString();

        Log.v("MainActivity","Line 79");


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
        progressDialog.setMessage("Logging In....");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(Email,Password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressDialog.dismiss();
                if(task.isSuccessful())
                {
                    finish();
                    //start profile activity here
                    startActivity(new Intent(getApplicationContext(),Interest.class));
                    //  Toast.makeText(this,"You are SuccessFlly Logged in",Toast.LENGTH_SHORT).show();
                    // Snackbar.make(v, "SucessFully Logging You In", Snackbar.LENGTH_LONG)
                    //       .setAction("Action", null).show();
                }
                else
                {
                    Snackbar.make(v, "Error Logging You In", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                    return;
                }
            }
        });
    }
}
