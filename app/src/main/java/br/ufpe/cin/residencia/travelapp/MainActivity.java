package br.ufpe.cin.residencia.travelapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import br.ufpe.cin.residencia.travelapp.databinding.ActivityMainBinding;
import br.ufpe.cin.residencia.travelapp.fragments.Home;
import br.ufpe.cin.residencia.travelapp.fragments.Seacrch;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;

    Home homeFragment = new Home();
    Seacrch searchFragment = new Seacrch();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initNavigation();

    }

    private void initNavigation() {
        this.bottomNavigationView = findViewById(R.id.bottom_navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, homeFragment).commit();

        this.bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.menu_home:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, homeFragment).commit();
                        return true;
                    case R.id.menu_search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_view, searchFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}
