package sv.edu.itca.foodfast;

import static sv.edu.itca.foodfast.R.id.textViewUsuario;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        // Obtén la información del usuario del Intent
        String usuario = getIntent().getStringExtra("USUARIO");
        String contraseña = getIntent().getStringExtra("CONTRASEÑA");

        // Muestra la información del usuario en TextViews
        TextView textViewUsuario = findViewById(R.id.textViewUsuario);
        TextView textViewContraseña = findViewById(R.id.textViewContraseña);

        textViewUsuario.setText("Usuario: " + usuario);
        textViewContraseña.setText("Contraseña: " + contraseña);


        // Configuración de la barra de navegación inferior
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.account);


        bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home){
                    startActivity(new Intent(getApplicationContext()
                            ,MainActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                }
                if (id == R.id.search){
                    startActivity(new Intent(getApplicationContext()
                            ,SearchActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                }
                if (id == R.id.add){
                    startActivity(new Intent(getApplicationContext()
                            ,AddActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                }
                if (id == R.id.account){
                    return true;
                }
                return false;
            }
        });
    }


}