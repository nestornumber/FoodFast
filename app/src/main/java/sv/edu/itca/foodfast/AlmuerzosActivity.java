package sv.edu.itca.foodfast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class AlmuerzosActivity extends AppCompatActivity {

    Button ensaladaPolloButton, pastaBtn, soparesBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_almuerzos);


        pastaBtn = findViewById(R.id.button2);
        ensaladaPolloButton = findViewById(R.id.button3);
        soparesBtn = findViewById(R.id.button3);


        soparesBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent sopares = new Intent(AlmuerzosActivity.this, VistaRecetaSoparesActivity.class);
                startActivity(sopares);
            }
        });
        ensaladaPolloButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salad = new Intent(AlmuerzosActivity.this, VistaRecetaEnsaladaActivity.class);
                startActivity(salad);
            }
        });

        pastaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pasta = new Intent(AlmuerzosActivity.this, VistaRecetaPastaActivity.class);
                startActivity(pasta);
            }
        });
    }
}