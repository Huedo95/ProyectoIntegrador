package com.example.alex_.proyectointegrador.Inicio;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.alex_.proyectointegrador.Login.LoginActivity;
import com.example.alex_.proyectointegrador.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Thread(){
            public void run(){
                try{
                    sleep(2630);
                    startActivity(new Intent(MainActivity.this, LoginActivity.class));
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
