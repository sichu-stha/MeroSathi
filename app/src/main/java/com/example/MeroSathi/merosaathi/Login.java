package com.example.MeroSathi.merosaathi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Login extends AppCompatActivity {
    Button button1,button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button1 =(Button)findViewById(R.id.sign_up);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSign_up();
            }
        });

        button2 =(Button)findViewById(R.id.login);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLogin();
            }
        });
    }
    public void openSign_up(){
        Intent intent1 = new Intent(this,Sign_up.class);
        startActivity(intent1);
    }
    public void openLogin(){
        Intent intent2 = new Intent(this,Request.class);
        startActivity(intent2);
    }
}
