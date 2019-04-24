package com.example.bharat.firstproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

public class RegisterUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_user);

        ImageButton student,counsellor;
        TextView tv;
        student=findViewById(R.id.Student);
        counsellor=findViewById(R.id.Counsellor);
        tv=findViewById(R.id.Signin);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(v.getContext(),Registeract.class);
                startActivity(intent);
            }
        });

        counsellor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(v.getContext(),Registeract.class);
                startActivity(intent);
            }
        });

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent=new Intent(v.getContext(),MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
