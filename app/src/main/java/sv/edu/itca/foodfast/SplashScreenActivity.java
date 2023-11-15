package sv.edu.itca.foodfast;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashScreenActivity extends AppCompatActivity {

    private static final int SPLASH_DELAY = 2000; // 2 segundos en milisegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen); // Reemplaza "tu_layout" con el nombre de tu archivo XML

        // Usamos un Handler para retrasar el inicio de la siguiente actividad
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreenActivity.this, IniciarSesionActivity.class);
                startActivity(intent);
                finish(); // Finalizamos esta actividad para que el usuario no pueda volver atrás con el botón "Back"
            }
        }, SPLASH_DELAY);
    }
}
