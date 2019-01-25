package com.example.alex_.proyectointegrador;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvTitulo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvTitulo = (TextView) findViewById(R.id.tvTitulo);
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate);
        tvTitulo.startAnimation(animation);
    }
}
