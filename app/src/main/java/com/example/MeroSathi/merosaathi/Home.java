//Activity.java
package com.example.MeroSathi.merosaathi;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home extends AppCompatActivity {
    Button ghar,vidhyalaya,sarbajanik_sthal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        ghar =(Button)findViewById(R.id.ghar);
        ghar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGhar();
            }
        });

        vidhyalaya =(Button)findViewById(R.id.vidhyalaya);
        vidhyalaya.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openVidhyalaya();
            }
        });

        sarbajanik_sthal =(Button)findViewById(R.id.sarbajanik_sthal);
        sarbajanik_sthal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openSarbajanik_sthal();
            }
        });

    }

    public void openGhar(){
        Intent intent1 = new Intent(this,Main.class);
        startActivity(intent1);
    }

    public void openVidhyalaya(){
        Intent intent2 = new Intent(this,School.class);
        startActivity(intent2);
    }

    public void openSarbajanik_sthal(){
        Intent intent = new Intent(this,PublicPlace.class);
        startActivity(intent);
    }
}
