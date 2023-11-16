package sv.edu.itca.foodfast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DesayunosActivity extends AppCompatActivity {

    private Button avenaBtn, omeletteBtn, pupusabBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desayunos);


        pupusabBtn = findViewById(R.id.button3);
        avenaBtn = findViewById(R.id.button1);
        omeletteBtn = findViewById(R.id.button2);

        pupusabBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pupusa = new Intent(DesayunosActivity.this, VistaRecetaPupusasActivity.class);
                startActivity(pupusa);
            }
        });

        avenaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent avena = new Intent(DesayunosActivity.this, VistaRecetaAvenaActivity.class);
                startActivity(avena);
            }
        });

        omeletteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent omelette = new Intent(DesayunosActivity.this, VistaRecetaOmeletteActivity.class);
                startActivity(omelette);
            }
        });

    }
}