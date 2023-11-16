package sv.edu.itca.foodfast;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class IniciarSesionActivity extends AppCompatActivity {

    private static final String PREFS_NAME = "UserData";
    private int intentosFallidos = 0;
    private AlertDialog alertDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        EditText editTextUsuario = findViewById(R.id.editText);
        EditText editTextContrasena = findViewById(R.id.editText1);
        Button btnIniciarSesion = findViewById(R.id.button2);

        Button btnCrearCuenta = findViewById(R.id.button);
        Button btnCrear = findViewById(R.id.btn2);



        Switch switchRecuerdame = findViewById(R.id.switch1);

        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        boolean recuerdame = preferences.getBoolean("recuerdame", false);
        boolean usuarioRegistrado = preferences.contains("username");

        if (recuerdame) {
            String storedUsuario = preferences.getString("username", "");
            String storedContrasena = preferences.getString("password", "");
            editTextUsuario.setText(storedUsuario);
            editTextContrasena.setText(storedContrasena);
            switchRecuerdame.setChecked(true);
        }

        if (usuarioRegistrado) {
            btnCrearCuenta.setVisibility(View.GONE);

        }

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String usuario = editTextUsuario.getText().toString().trim();
                String contrasena = editTextContrasena.getText().toString().trim();

                if (!usuario.isEmpty() && !contrasena.isEmpty()) {
                    if (verificarDatosEnSharedPreferences(usuario, contrasena)) {
                        if (switchRecuerdame.isChecked()) {
                            guardarDatosRecuerdame(usuario, contrasena);
                        }
                        Intent intent = new Intent(IniciarSesionActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        intentosFallidos++;
                        if (intentosFallidos >= 3) {
                            mostrarMensajeConteoRegresivo();
                        } else {
                            Toast.makeText(IniciarSesionActivity.this, "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    }
                } else {
                    Toast.makeText(IniciarSesionActivity.this, "Ingrese usuario y contraseña", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IniciarSesionActivity.this, RegistrarseActivity1.class);
                startActivity(intent);
            }
        });

        btnCrear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IniciarSesionActivity.this, RegistrarseActivity1.class);
                startActivity(intent);
            }
        });
    }

    private boolean verificarDatosEnSharedPreferences(String usuario, String contrasena) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        String storedUsuario = preferences.getString("username", "");
        String storedContrasena = preferences.getString("password", "");
        return usuario.equals(storedUsuario) && contrasena.equals(storedContrasena);
    }

    private void guardarDatosRecuerdame(String usuario, String contrasena) {
        SharedPreferences preferences = getSharedPreferences(PREFS_NAME, MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("username", usuario);
        editor.putString("password", contrasena);
        editor.putBoolean("recuerdame", true);
        editor.apply();
    }

    private void mostrarMensajeConteoRegresivo() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Has intentado demasiadas veces");
        builder.setMessage("Inténtalo de nuevo más tarde.");
        builder.setCancelable(false); // No permite cancelar el diálogo con el botón de retroceso

        alertDialog = builder.create();
        alertDialog.show();

        CountDownTimer countDownTimer = new CountDownTimer(30000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                alertDialog.setMessage("Has intentado demasiadas veces. Inténtalo de nuevo en: " + millisUntilFinished / 1000 + " segundos");
            }

            @Override
            public void onFinish() {
                alertDialog.dismiss();
                intentosFallidos = 0;
            }
        }.start();
    }
}
