package com.example.MeroSathi.merosaathi;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class PublicPlace extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    //toolbar variable
    Toolbar toolbar;
    //mediaplayer variable
    MediaPlayer mediaPlayer;
    MediaPlayer playall;

    //navigationdrawer varaibles
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;
    //    header buttons
    Button navbutton[]=new Button[4];

    //counter variable
    int i;
    int mCompleted;
    int x;
    //String variable
     int s[]=new int[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_public_place);

        //toolbar initialization
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("");
        toolbar.setLogo(R.drawable.applogo);

        //drawerLayout code
        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawerLayout);
        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Navigation button clicked code
        NavigationView navigationView=findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        //counter initialization
        i=0;

        //Buttons created for MediaPlayer to play audio
        Button play_ma=(Button) this.findViewById(R.id.play_ma);
        final Button play_aama=(Button) this.findViewById(R.id.play_aama);
        Button play_buba=(Button) this.findViewById(R.id.play_buba);
        Button play_timi=(Button) this.findViewById(R.id.play_timi);
        Button play_hami=(Button) this.findViewById(R.id.play_hami);
        Button play_keta=findViewById(R.id.play_keta);
        Button play_keti=findViewById(R.id.play_keti);
        Button play_khanchu=findViewById(R.id.play_khanchu);
        Button play_khelchu=findViewById(R.id.play_khelchu);
        Button play_sauchalaya=findViewById(R.id.play_sauchalaya);
        Button play_piuchu=findViewById(R.id.play_piuchu);
        Button play_paani=findViewById(R.id.play_paani);
        Button play_ghar=findViewById(R.id.play_ghar);
        Button play_kina=findViewById(R.id.play_kina);
        Button play_ko=findViewById(R.id.play_ko);
        Button play_bhok_lagyo=findViewById(R.id.play_bhok_lagyo);
        Button play_ho=findViewById(R.id.play_ho);
        Button play_hoina=findViewById(R.id.play_hoina);
        Button play_dhanyabad=findViewById(R.id.play_dhanyabad);
        Button play_sorry=findViewById(R.id.play_sorry);
        Button play_help=findViewById(R.id.play_help);
        Button play_manparcha=findViewById(R.id.play_manparcha);
        Button play_ramro=findViewById(R.id.play_ramro);
        Button play_kharab=findViewById(R.id.play_kharab);
        Button play_gara=findViewById(R.id.play_gara);
        Button play_nagara=findViewById(R.id.play_nagara);
        Button play_janxu=findViewById(R.id.play_janxu);
        //clear button
        final Button clear_button=findViewById(R.id.clearbutton);
        //replay button
        final Button play_all=findViewById(R.id.play_all);


        //onclick event for all buttons that calls method onclick and passes id of button
        play_ma.setOnClickListener(this);
        play_aama.setOnClickListener(this);
        play_buba.setOnClickListener(this);
        play_timi.setOnClickListener(this);
        play_hami.setOnClickListener(this);
        play_keta.setOnClickListener(this);
        play_keti.setOnClickListener(this);
        play_khanchu.setOnClickListener(this);
        play_khelchu.setOnClickListener(this);
        play_sauchalaya.setOnClickListener(this);
        play_piuchu.setOnClickListener(this);
        play_paani.setOnClickListener(this);
        play_ghar.setOnClickListener(this);
        play_kina.setOnClickListener(this);
        play_ko.setOnClickListener(this);
        play_bhok_lagyo.setOnClickListener(this);
        play_ho.setOnClickListener(this);
        play_hoina.setOnClickListener(this);
        play_dhanyabad.setOnClickListener(this);
        play_help.setOnClickListener(this);
        play_sorry.setOnClickListener(this);
        play_manparcha.setOnClickListener(this);
        play_ramro.setOnClickListener(this);
        play_kharab.setOnClickListener(this);
        play_gara.setOnClickListener(this);
        play_nagara.setOnClickListener(this);
        play_janxu.setOnClickListener(this);

        navbutton[0]=findViewById(R.id.button1);
        navbutton[1]=findViewById(R.id.button2);
        navbutton[2]=findViewById(R.id.button3);
        navbutton[3]=findViewById(R.id.button4);

        //clear button onclick event
        clear_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (i >= 1) {
                    i--;
                    navbutton[i].setBackgroundResource(0);
                }
            }
        });
        //play all
        play_all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0) {
                    Thread t=new Thread(){
                        public void run(){
                            for(int x=0;x<i;x++) {
                                playall = MediaPlayer.create(PublicPlace.this, s[x]);
                                playall.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                    @Override
                                    public void onCompletion(MediaPlayer mp) {
                                        // TODO Auto-generated method stub
                                        mp.reset();
                                        mp.release();
                                        mp = null;
                                    }

                                });
                                playall.start();
                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    };
                    t.start();
                }
            }
        });
    }
    //method for navigationbar
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    //method for navigation button clicked
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                Intent intent1 = new Intent(this,Home.class);
                startActivity(intent1);
                break;
            case R.id.request:
                Intent intent2 = new Intent(this,Login.class);
                startActivity(intent2);
                break;
            case R.id.About:
                Intent intent3 = new Intent(this,Janakari.class);
                startActivity(intent3);
                break;
        }
        return true;
    }

    //method for button click listener
    @Override
    public void onClick(View v) {
        if(i>3)
            clearall();
        switch (v.getId()){
            case R.id.play_ma:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.ma);
                s[i] = R.raw.ma;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.ma));
                break;
            case R.id.play_aama:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.aama);
                s[i] = R.raw.aama;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.aama));
                break;
            case R.id.play_buba:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.buba);
                s[i] = R.raw.buba;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.buba));
                break;
            case R.id.play_timi:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.timi);
                s[i] = R.raw.timi;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.timi));
                break;
            case R.id.play_hami:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.hami);
                s[i] = R.raw.hami;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.hami));
                break;
            case R.id.play_keta:
                mediaPlayer=MediaPlayer.create(this,R.raw.keta);
                s[i] = R.raw.keta;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.keta));
                break;
            case R.id.play_keti:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.keti);
                s[i] = R.raw.keti;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.keti));
                break;
            case R.id.play_khanchu:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.khanxu);
                s[i] = R.raw.khanxu;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.khanchu));
                break;
            case R.id.play_khelchu:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.khelxu);
                s[i] = R.raw.khelxu;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.khelchu));
                break;
            case R.id.play_sauchalaya:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.sauchalaya);
                s[i] = R.raw.sauchalaya;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.sauchalaya));
                break;
            case R.id.play_piuchu:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.puichu);
                s[i] =R.raw.puichu;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.piuchu));
                break;
            case R.id.play_paani:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.pani);
                s[i] = R.raw.pani;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.paani));
                break;
            case R.id.play_kina:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.kina);
                s[i] = R.raw.kina;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.kina));
                break;
            case R.id.play_ko:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.ko);
                s[i] = R.raw.ko;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.ko));
                break;
            case R.id.play_ghar:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.ghar);
                s[i] = R.raw.ghar;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.home));
                break;
            case R.id.play_bhok_lagyo:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.bhoklagyo);
                s[i] = R.raw.bhoklagyo;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.bhok_lagyo));
                break;
            case R.id.play_ho:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.ho);
                s[i] = R.raw.ho;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.ho));
                break;
            case R.id.play_hoina:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.hoina);
                s[i] = R.raw.hoina;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.hoina));
                break;
            case R.id.play_dhanyabad:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.dhanyabad);
                s[i] = R.raw.dhanyabad;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.dhanyabad));
                break;
            case R.id.play_help:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.sahayog);
                s[i] = R.raw.sahayog;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.sahayog));
                break;
            case R.id.play_sorry:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.sorry);
                s[i] = R.raw.sorry;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.sorry));
                break;
            case R.id.play_manparcha:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.maanparcha);
                s[i] =R.raw.maanparcha;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.manparcha));
                break;
            case R.id.play_ramro:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.ramro);
                s[i] =R.raw.ramro;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.ramro));
                break;
            case R.id.play_kharab:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.kharab);
                s[i] = R.raw.kharab;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.kharab));
                break;
            case R.id.play_gara:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.gara);
                s[i] = R.raw.gara;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.gara));
                break;
            case R.id.play_nagara:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.nagar);
                s[i] = R.raw.nagar;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.nagara));
                break;
            case R.id.play_janxu:
                mediaPlayer=MediaPlayer.create(PublicPlace.this,R.raw.janchu);
                s[i] = R.raw.janchu;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.janchu));
                break;
        }
        i++;
        //stop listener after completion
        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener(){
            @Override
            public void onCompletion(MediaPlayer mp) {
                // TODO Auto-generated method stub
                mp.reset();
                mp.release();
                mp=null;
            }

        });
        mediaPlayer.start();
    }
    //clear all function to clear header images
    public void clearall(){
        i=0;
        for(int j=0;j<4;j++){
            navbutton[j].setBackgroundResource(0);
        }
    }
}

