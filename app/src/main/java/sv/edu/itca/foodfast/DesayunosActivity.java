package sv.edu.itca.foodfast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class DesayunosActivity extends AppCompatActivity {

    private Button avenaBtn, omeletteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_desayunos);



        avenaBtn = findViewById(R.id.button15);
        omeletteBtn = findViewById(R.id.button16);

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