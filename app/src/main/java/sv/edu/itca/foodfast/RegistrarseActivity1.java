package sv.edu.itca.foodfast;


import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class RegistrarseActivity1 extends AppCompatActivity {

    private static final String PREFS_NAME = "UserData";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse1);

        // Referencias a las vistas
        EditText editTextUsername = findViewById(R.id.editText);
        EditText editTextPassword = findViewById(R.id.editText1);
        Button buttonRegistrarse = findViewById(R.id.button2);
        Button buttonIniciarSesion = findViewById(R.id.button3); // Asumiendo que este es el botón para iniciar sesión

        // Configurar el evento de clic para el botón "Registrarse"
        buttonRegistrarse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Obtener los datos ingresados
                String username = editTextUsername.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                // Verificar si ambos campos están llenos
                if (!username.isEmpty() && !password.isEmpty()) {
                    // Guardar los datos en la memoria de la app
                    guardarDatos(username, password);

                    // Navegar a activity_iniciar_sesion
                    Intent intent = new Intent(RegistrarseActivity1.this, IniciarSesionActivity.class);
                    startActivity(intent);
                } else {
                    // Mostrar mensaje de alerta si no se ingresaron ambos datos
                    Toast.makeText(RegistrarseActivity1.this, "Debe ingresar usuario y contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Configurar el evento de clic para el botón "Iniciar Sesión"
        buttonIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Navegar a activity_iniciar_sesion
                Intent intent = new Intent(RegistrarseActivity1.this, IniciarSesionActivity.class);
                startActivity(intent);
            }
        });
    }

    private void guardarDatos(String username, String password) {
        SharedPreferences.Editor editor = getSharedPreferences(PREFS_NAME, MODE_PRIVATE).edit();
        editor.putString("username", username);
        editor.putString("password", password);
        editor.apply();
    }
}
