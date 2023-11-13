package sv.edu.itca.foodfast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Lógica para verificar si el usuario ha iniciado sesión
                boolean usuarioHaIniciadoSesion = verificarSesion();

                if (usuarioHaIniciadoSesion) {
                    Intent intent = new Intent(SplashScreenActivity.this, IniciarSesionActivity.class);
                    startActivity(intent);
                } else {
                    // Puedes agregar lógica para abrir otra actividad si el usuario no ha iniciado sesión
                }

                finish();
            }
        }, 2000); // 2000 milisegundos o el tiempo que desees para mostrar la SplashScreen

    }

    private boolean verificarSesion() {
        // Ejemplo usando SharedPreferences, ajusta según tu implementación real
        SharedPreferences sharedPreferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        return sharedPreferences.getBoolean("sesion_iniciada", false);
    }
}