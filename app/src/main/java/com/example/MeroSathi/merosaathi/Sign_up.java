package com.example.MeroSathi.merosaathi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Sign_up extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        btn = (Button)findViewById(R.id.sign_upr);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSign_up();
            }
        });
    }
    public void openSign_up(){
        Intent intent = new Intent(this,Request.class);
        startActivity(intent);
    }
}
