package sv.edu.itca.foodfast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SearchActivity extends AppCompatActivity {

    private Button desayunosBtn, almuerzosBtn, cenasBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        desayunosBtn = findViewById(R.id.button2);
        almuerzosBtn = findViewById(R.id.button3);
        cenasBtn = findViewById(R.id.button4);

        desayunosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent desayuno = new Intent(SearchActivity.this, DesayunosActivity.class);
                startActivity(desayuno);
            }
        });

        almuerzosBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View vista) {
                Intent almuerzo = new Intent(SearchActivity.this, AlmuerzosActivity.class);
                startActivity(almuerzo);
            }
        });

        cenasBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cenas = new Intent(SearchActivity.this, CenasActivity.class);
                startActivity(cenas);
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.home);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                if (id == R.id.home){
                    startActivity(new Intent(getApplicationContext()
                            ,MainActivity.class));
                    overridePendingTransition(0,0);
                    return true;
                }
                if (id == R.id.search){
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