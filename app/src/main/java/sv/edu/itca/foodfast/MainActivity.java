package sv.edu.itca.foodfast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomNavigationView bottomNavigationView;
    InicioFragment inicioFragment = new InicioFragment();
    BuscarFragment buscarFragment = new BuscarFragment();
    AnadirFragment anadirFragment = new AnadirFragment();
    MiCuentaFragment miCuentaFragment = new MiCuentaFragment();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, inicioFragment).commit();
        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.inicio:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, inicioFragment).commit();
                        return true;
                    case R.id.buscar:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, buscarFragment).commit();
                        return true;
                    case R.id.anadir:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, anadirFragment).commit();
                        return true;
                    case R.id.micuenta:
                        getSupportFragmentManager().beginTransaction().replace(R.id.contenedor, miCuentaFragment).commit();
                        return true;
                }
                return false;
            }
        });
    }
}