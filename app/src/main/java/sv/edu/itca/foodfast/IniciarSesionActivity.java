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

    private Button btnInvitado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        btnInvitado = findViewById(R.id.btnInvitado);

        btnInvitado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            //Inicia la actividad Main
                Intent intent = new Intent(IniciarSesionActivity.this, MainActivity.class);
                startActivity(intent);

            }
        });

    }

    public void onInvitadoButtonClick(View view) {
        // Inicia la actividad MainActivity
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}