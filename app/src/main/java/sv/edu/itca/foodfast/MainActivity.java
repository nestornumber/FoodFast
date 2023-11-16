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

    private Button avenaButton, salmonButton , pastaButton, ensaladaButton, omeletteButton ,quinoaButton, pupusasBtn, soparesBtn, panespolloBtn, tamalesBtn, enchiladabtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         avenaButton = findViewById(R.id.button5);
         salmonButton = findViewById(R.id.button1);
         pastaButton = findViewById(R.id.button2);
         ensaladaButton = findViewById(R.id.button3);
         omeletteButton = findViewById(R.id.button4);
         quinoaButton = findViewById(R.id.button6);
         pupusasBtn = findViewById(R.id.button7);
         soparesBtn = findViewById(R.id.button8);
         panespolloBtn = findViewById(R.id.button11);
         tamalesBtn = findViewById(R.id.button10);
         enchiladabtn = findViewById(R.id.button9);

         enchiladabtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent enchilada = new Intent(MainActivity.this, VistaRecetaEnchiladasActivity.class);
                 startActivity(enchilada);
             }
         });

         tamalesBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent tamales = new Intent(MainActivity.this, VistaRecetaTamalesActivity.class);
                 startActivity(tamales);
             }
         });

         panespolloBtn.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 Intent panespollo = new Intent(MainActivity.this, VistaRecetaPanespolloActivity.class);
                 startActivity(panespollo);
             }
         });

        soparesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sopares = new Intent(MainActivity.this, VistaRecetaSoparesActivity.class);
                startActivity(sopares);
            }
        });

        pupusasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pupusa = new Intent(MainActivity.this, VistaRecetaPupusasActivity.class);
                startActivity(pupusa);
            }
        });
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
                    return true;
                }
                if (id == R.id.add){
                    startActivity(new Intent(getApplicationContext()
                            ,AddActivity.class));
                    return true;
                }
                if (id == R.id.account){
                    startActivity(new Intent(getApplicationContext()
                            ,AccountActivity.class));
                    return true;
                }
                return false;
            }
        });
    }
}