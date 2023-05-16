package com.adriancasantos.acetime;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.adriancasantos.acetime.feature.arbitrajes.lista.ui.FragmentArbitrajes;
import com.adriancasantos.acetime.feature.partidos.lista.ui.FragmentPartidos;
import com.adriancasantos.acetime.feature.perfil.ui.FragmentPerfil;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class NavigationActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener, NavigationInterface {

    public static final String EXTRA_USER_ID = "EXTRA_PARTIDO_ARBITRAJE";

    private BottomNavigationView navigationView ;
    FragmentTransaction transaction;
    Fragment fragmentPartidos, fragmentArbitrajes, fragmentPerfil;
    Integer userId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Mostrar la barra de navegación
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation);
        userId = getIntent().getIntExtra(EXTRA_USER_ID, 0);

        fragmentPartidos = new FragmentPartidos(this);
        fragmentArbitrajes = new FragmentArbitrajes(this);
        fragmentPerfil = new FragmentPerfil(userId);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedorFragments, fragmentPartidos).commit();

        navigationView = findViewById(R.id.navigationView);
        navigationView.setOnNavigationItemSelectedListener(this);

    }

    // Método para cambiar de fragment

    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        System.out.println("HAS SELECCIONADO UN ELEMENTO");

        transaction = getSupportFragmentManager().beginTransaction();
        switch (item.getItemId()) {

            case R.id.partidos:
                System.out.println("HAS SELECCIONADO PARTIDOS");
                transaction.replace(R.id.contenedorFragments, fragmentPartidos);
                transaction.addToBackStack(null);
                break;
            case R.id.favoritos:
                System.out.println("HAS SELECCIONADO ARBITRAJES");
                transaction.replace(R.id.contenedorFragments, fragmentArbitrajes);
                transaction.addToBackStack(null);
                break;
            case R.id.perfil:
                System.out.println("HAS SELECCIONADO PERFIL");
                transaction.replace(R.id.contenedorFragments, fragmentPerfil);
                transaction.addToBackStack(null);
                break;
        }

        transaction.commit();
        return true;
    }

    @Override
    public void navigateToFragment(Fragment fragment) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.contenedorFragments, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

    public static Intent getNavigationActivityIntent(Context fromContext, Integer userId) {
        return new Intent(fromContext, NavigationActivity.class).putExtra(EXTRA_USER_ID,userId);
    }
}

