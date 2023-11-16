package sv.edu.itca.foodfast;



  import android.Manifest;
import android.content.Context;
  import android.content.DialogInterface;
  import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
  import androidx.appcompat.app.AlertDialog;
  import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.ByteArrayOutputStream;
import java.util.Objects;

        public class AddActivity extends AppCompatActivity {

            private static final int REQUEST_CAMERA_PERMISSION = 101;
            private static final int REQUEST_IMAGE_CAPTURE = 102;

            private ImageView imageView;
            private EditText editTextNombreReceta;
            private EditText editTextIngredientes;
            private EditText editTextTiempoComida;
            private EditText editTextInstrucciones;

            private Button btnAgregarReceta;
            private Uri imageUri;

            @Override
            protected void onCreate(Bundle savedInstanceState) {
                super.onCreate(savedInstanceState);
                setContentView(R.layout.activity_add);

                btnAgregarReceta = findViewById(R.id.btnAgregarReceta);
                BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
                bottomNavigationView.setSelectedItemId(R.id.add);


                btnAgregarReceta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        mostrarDialogoPremium();

                    }
                });
                bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        int id = item.getItemId();
                        if (id == R.id.home) {
                            startActivity(new Intent(getApplicationContext(), MainActivity.class));
                            return true;
                        }
                        if (id == R.id.search) {
                            startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                            return true;
                        }
                        if (id == R.id.add) {
                            return true;
                        }
                        if (id == R.id.account) {
                            startActivity(new Intent(getApplicationContext(), AccountActivity.class));
                            return true;
                        }

                        return true;
                    }
                });

                imageView = findViewById(R.id.imageView5);
                editTextNombreReceta = findViewById(R.id.editTextNombreReceta);
                editTextIngredientes = findViewById(R.id.editTextDescripcion);
                editTextTiempoComida = findViewById(R.id.editTextDescripcion3);
                editTextInstrucciones = findViewById(R.id.editTextDescripcion2);

                Button btnAgregarImagen = findViewById(R.id.btnAgregarReceta3);
                Button btnAgregarReceta = findViewById(R.id.btnAgregarReceta);

                btnAgregarImagen.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (checkCameraPermission()) {
                            tomarFoto();
                        }
                    }
                });

                btnAgregarReceta.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        guardarReceta();
                    }
                });
            }

            private void tomarFoto() {
                Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
                }
            }

            private boolean checkCameraPermission() {
                if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA_PERMISSION);
                    return false;
                }
                return true;
            }

            @Override
            public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
                super.onRequestPermissionsResult(requestCode, permissions, grantResults);
                if (requestCode == REQUEST_CAMERA_PERMISSION) {
                    if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        tomarFoto();
                    } else {
                        Toast.makeText(this, "Permiso de cámara denegado", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            @Override
            protected void onActivityResult(int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
                    Bitmap imageBitmap = (Bitmap) Objects.requireNonNull(data).getExtras().get("data");
                    imageView.setImageBitmap(imageBitmap);
                    imageUri = getImageUriFromBitmap(getApplicationContext(), imageBitmap);
                }
            }

            private void guardarReceta() {
                String nombreReceta = editTextNombreReceta.getText().toString();
                String ingredientes = editTextIngredientes.getText().toString();
                String tiempoComida = editTextTiempoComida.getText().toString();
                String instrucciones = editTextInstrucciones.getText().toString();

                if (!nombreReceta.isEmpty() && !ingredientes.isEmpty() && !tiempoComida.isEmpty() && !instrucciones.isEmpty() && imageUri != null) {
                    SharedPreferences preferences = getSharedPreferences("RecetasData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("NombreReceta", nombreReceta);
                    editor.putString("Ingredientes", ingredientes);
                    editor.putString("TiempoComida", tiempoComida);
                    editor.putString("Instrucciones", instrucciones);
                    editor.putString("Imagen", imageUri.toString());
                    editor.apply();

                    limpiarCampos();

                  mostrarDialogoPremium();
                } else {
                    Toast.makeText(this, "Llene todos los campos y agregue una imagen", Toast.LENGTH_SHORT).show();
                }
            }

            private void limpiarCampos() {
                editTextNombreReceta.setText("");
                editTextIngredientes.setText("");
                editTextTiempoComida.setText("");
                editTextInstrucciones.setText("");
                imageView.setImageResource(0);
                imageUri = null;
            }

            private Uri getImageUriFromBitmap(Context context, Bitmap bitmap) {
                ByteArrayOutputStream bytes = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
                String path = MediaStore.Images.Media.insertImage(context.getContentResolver(), bitmap, "Image Title", null);
                return Uri.parse(path);
            }

            public void mostrarDialogoPremium() {
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Función Premium");
                builder.setMessage("Esta función está disponible en la versión Premium.");
                builder.setPositiveButton("Entendido", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Aquí puedes agregar lógica adicional si es necesario
                        dialog.dismiss();
                    }
                });
                builder.create().show(); // Muestra el cuadro de diálogo
            }
        }
