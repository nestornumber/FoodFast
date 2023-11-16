package sv.edu.itca.foodfast;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class CenasActivity extends AppCompatActivity {

    private Button salmonBtn, quinoaBtn, enchiladaBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cenas);



        salmonBtn = findViewById(R.id.button5);
        quinoaBtn = findViewById(R.id.button6);
        enchiladaBtn = findViewById(R.id.button7);

        enchiladaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent enchilada = new Intent(CenasActivity.this, VistaRecetaEnchiladasActivity.class);
                startActivity(enchilada);
            }
        });

        salmonBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent salmon = new Intent(CenasActivity.this, VistaRecetaSalmonActivity.class);
                startActivity(salmon);
            }
        });

        quinoaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent quinoa = new Intent(CenasActivity.this, VistaRecetaQuinoaActivity.class);
                startActivity(quinoa);
            }
        });

    }
}