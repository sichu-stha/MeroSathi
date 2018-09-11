package com.example.MeroSathi.merosaathi;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Handler;
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


public class Main extends AppCompatActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
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
//String variable
    int s[]=new int[4];
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        Button play_nindra=findViewById(R.id.play_nindra);
        Button play_sauchalaya=findViewById(R.id.play_sauchalaya);
        Button play_piuchu=findViewById(R.id.play_piuchu);
        Button play_paani=findViewById(R.id.play_paani);
        Button play_bhat=findViewById(R.id.play_bhat);
        Button play_daal=findViewById(R.id.play_daal);
        Button play_biscuit=findViewById(R.id.play_biscuit);
        Button play_chauchau=findViewById(R.id.play_chauchau);
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
        play_nindra.setOnClickListener(this);
        play_paani.setOnClickListener(this);
        play_bhat.setOnClickListener(this);
        play_biscuit.setOnClickListener(this);
        play_chauchau.setOnClickListener(this);
        play_daal.setOnClickListener(this);
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
                                playall = MediaPlayer.create(Main.this, s[x]);
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
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.ma);
                s[i] = R.raw.ma;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.ma));
                break;
            case R.id.play_aama:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.aama);
                s[i] = R.raw.aama;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.aama));
                break;
            case R.id.play_buba:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.buba);
                s[i] = R.raw.buba;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.buba));
                break;
            case R.id.play_timi:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.timi);
                s[i] = R.raw.timi;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.timi));
                break;
            case R.id.play_hami:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.hami);
                s[i] =R.raw.hami;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.hami));
                break;
            case R.id.play_keta:
                mediaPlayer=MediaPlayer.create(this,R.raw.keta);
                s[i] = R.raw.keta;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.keta));
                break;
            case R.id.play_keti:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.keti);
                s[i] = R.raw.keti;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.keti));
                break;
            case R.id.play_khanchu:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.khanxu);
                s[i] = R.raw.khanxu;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.khanchu));
                break;
            case R.id.play_khelchu:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.khelxu);
                s[i] = R.raw.khelxu;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.khelchu));
                break;
            case R.id.play_sauchalaya:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.sauchalaya);
                s[i] = R.raw.sauchalaya;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.sauchalaya));
                break;
            case R.id.play_piuchu:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.puichu);
                s[i] = R.raw.puichu;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.piuchu));
                break;
            case R.id.play_nindra:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.nindra_lagyo);
                s[i] = R.raw.nindra_lagyo;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.nindra_lagyo));
                break;

            case R.id.play_paani:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.pani);
                s[i] =R.raw.pani;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.paani));
                break;
            case R.id.play_bhat:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.bhat);
                s[i] = R.raw.bhat;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.bhat));
                break;
            case R.id.play_daal:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.dal);
                s[i] = R.raw.dal;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.daal));
                break;
            case R.id.play_biscuit:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.biscuit);
                s[i] = R.raw.biscuit;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.biscuit));
                break;
            case R.id.play_chauchau:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.chauchau);
                s[i] = R.raw.chauchau;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.chauchau));
                break;
            case R.id.play_ho:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.ho);
                s[i] =R.raw.ho;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.ho));
                break;
            case R.id.play_hoina:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.hoina);
                s[i] = R.raw.hoina;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.hoina));
                break;
            case R.id.play_dhanyabad:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.dhanyabad);
                s[i] = R.raw.dhanyabad;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.dhanyabad));
                break;
            case R.id.play_help:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.sahayog);
                s[i] = R.raw.sahayog;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.sahayog));
                break;
            case R.id.play_sorry:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.sorry);
                s[i] = R.raw.sorry;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.sorry));
                break;
            case R.id.play_manparcha:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.maanparcha);
                s[i] = R.raw.maanparcha;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.manparcha));
                break;
            case R.id.play_ramro:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.ramro);
                s[i] = R.raw.ramro;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.ramro));
                break;
            case R.id.play_kharab:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.kharab);
                s[i] =R.raw.kharab;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.kharab));
                break;
            case R.id.play_gara:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.gara);
                s[i] = R.raw.gara;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.gara));
                break;
            case R.id.play_nagara:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.nagar);
                s[i] = R.raw.nagar;
                navbutton[i].setBackgroundDrawable(getResources().getDrawable(R.drawable.nagara));
                break;
            case R.id.play_janxu:
                mediaPlayer=MediaPlayer.create(Main.this,R.raw.janchu);
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


