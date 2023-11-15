package sv.edu.itca.foodfast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AccountActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "UserData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);

        TextView textViewUsuario = findViewById(R.id.textViewUsuario);
        TextView textViewContrasena = findViewById(R.id.textViewContraseña);

        String usuario = obtenerUsuarioGuardado();
        String contrasena = obtenerContrasenaGuardada();

        textViewUsuario.setText("Usuario: " + usuario);
        textViewContrasena.setText("Contraseña: " + contrasena);

        // Configuración de la barra de navegación inferior
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.account);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home){
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    return true;
                }
                if (id == R.id.search){
                    startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                    return true;
                }
                if (id == R.id.add){
                    startActivity(new Intent(getApplicationContext(), AddActivity.class));
                    return true;
                }
                return true; // En el caso de 'account', no inicia una nueva actividad
            }
        });
    }

    private String obtenerUsuarioGuardado() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        return preferences.getString("username", "");
    }

    private String obtenerContrasenaGuardada() {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        return preferences.getString("password", "");
    }
}
