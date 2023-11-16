package sv.edu.itca.foodfast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
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

        Button btnPreguntasFrecuentes = findViewById(R.id.button1);
        Button btnSobreLaApp = findViewById(R.id.button2);
        Button btnCerrarApp = findViewById(R.id.button4);
        Button btnCerrarSesion = findViewById(R.id.button5);

        btnPreguntasFrecuentes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountActivity.this, PreguntasFrecuentesActivity.class));
            }
        });

        btnSobreLaApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountActivity.this, AcercaDeLaAppActivity.class));
            }
        });

        btnCerrarApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finishAffinity();
            }
        });

        btnCerrarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AccountActivity.this, IniciarSesionActivity.class));
                finish();
            }
        });

        String usuario = obtenerUsuarioGuardado();
        String contrasena = obtenerContrasenaGuardada();

        textViewUsuario.setText("Usuario: " + usuario);
        textViewContrasena.setText("Contraseña: " + contrasena);

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
                return true;
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
