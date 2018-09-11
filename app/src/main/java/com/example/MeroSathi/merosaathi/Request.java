package com.example.MeroSathi.merosaathi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Request extends AppCompatActivity {

    Button submit_btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_request);
        submit_btn =(Button)findViewById(R.id.submit_btn);
        submit_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Request.this, "Request sent", Toast.LENGTH_SHORT).show();
                openMain();
            }
        });
}
    public void openMain(){
        Intent intent1 = new Intent(this,Home.class);
        startActivity(intent1);
    }
}