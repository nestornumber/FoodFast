package sv.edu.itca.foodfast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IniciarSesionActivity extends AppCompatActivity {

    private EditText editTextUsuario;
    private EditText editTextContraseña;
    private Button btnIniciarSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        editTextUsuario = findViewById(R.id.editText);
        editTextContraseña = findViewById(R.id.editText1);
        btnIniciarSesion = findViewById(R.id.button2);

        btnIniciarSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Obtén la información del usuario
                String usuario = editTextUsuario.getText().toString();
                String contraseña = editTextContraseña.getText().toString();

                // Crea un Intent para pasar a la siguiente actividad (AccountActivity)
                Intent intent = new Intent(IniciarSesionActivity.this, AccountActivity.class);

                // Pasa la información del usuario al Intent
                intent.putExtra("USUARIO", usuario);
                intent.putExtra("CONTRASEÑA", contraseña);

                // Inicia la siguiente actividad
                startActivity(intent);
            }
        });

    }
}