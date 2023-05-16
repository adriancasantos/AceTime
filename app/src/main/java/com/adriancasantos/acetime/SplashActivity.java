package com.adriancasantos.acetime;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Button btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setVisibility(View.INVISIBLE);

        ImageView imageView = findViewById(R.id.imageView);
        Glide.with(this).asGif().load(R.drawable.animatedlogo).into(imageView);

        // Crea una instancia de la animación personalizada desde un archivo XML
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.animation);

        // Establece el listener de animación
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
                // No se necesita implementación adicional
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                // La animación ha finalizado, muestra el botón "Entrar"
                btnEntrar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                // No se necesita implementación adicional
            }
        });

        // Inicia la animación en el ImageView
        imageView.startAnimation(animation);

        // Al pulsar el botón, se abrirá la actividad Login
        btnEntrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
