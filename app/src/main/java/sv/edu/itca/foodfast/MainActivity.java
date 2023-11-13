package sv.edu.itca.foodfast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private Button avenaButton, salmonButton , pastaButton, ensaladaButton, omeletteButton ,quinoaButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         avenaButton = findViewById(R.id.button11);
         salmonButton = findViewById(R.id.button7);
         pastaButton = findViewById(R.id.button8);
         ensaladaButton = findViewById(R.id.button10);
         omeletteButton = findViewById(R.id.button9);
         quinoaButton = findViewById(R.id.button12);

        avenaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent avena = new Intent(MainActivity.this, VistaRecetaAvenaActivity.class);
                startActivity(avena);
            }
        });

        salmonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salmon = new Intent(MainActivity.this, VistaRecetaSalmonActivity.class);
                startActivity(salmon);
            }
        });

        pastaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasta = new Intent(MainActivity.this, VistaRecetaPastaActivity.class);
                startActivity(pasta);
            }
        });

        ensaladaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ensalada = new Intent(MainActivity.this, VistaRecetaEnsaladaActivity.class);
                startActivity(ensalada);
            }
        });

        omeletteButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent omelette = new Intent(MainActivity.this, VistaRecetaOmeletteActivity.class);
                startActivity(omelette);
            }
        });

        quinoaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent quinoa = new Intent(MainActivity.this, VistaRecetaQuinoaActivity.class);
                startActivity(quinoa);
            }
        });






        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home){
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
                    startActivity(new Intent(getApplicationContext()
                            ,AccountActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                }
                return false;
            }
        });
    }
}