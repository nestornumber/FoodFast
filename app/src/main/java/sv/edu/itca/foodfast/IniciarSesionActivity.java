package sv.edu.itca.foodfast;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class IniciarSesionActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "UserData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        EditText editTextUsuario = findViewById(R.id.editText);
        EditText editTextContrasena = findViewById(R.id.editText1);
        Button btnIniciarSesion = findViewById(R.id.button2);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuarioGuardado = obtenerUsuarioGuardado();
                String contrasenaGuardada = obtenerContrasenaGuardada();

                String usuarioIngresado = editTextUsuario.getText().toString().trim();
                String contrasenaIngresada = editTextContrasena.getText().toString().trim();

                if (usuarioIngresado.equals(usuarioGuardado) && contrasenaIngresada.equals(contrasenaGuardada)) {
                    // Si las credenciales son correctas, inicia sesión
                    Intent intent = new Intent(IniciarSesionActivity.this, MainActivity.class);
                    startActivity(intent);
                } else {
                    // Si las credenciales no coinciden, muestra un mensaje de error
                    Toast.makeText(IniciarSesionActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                }
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
