package id.ac.id.telkomuniversity.tass.praktikalert;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    private Button toastButton, snackbarButton, dialogButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toastButton=findViewById(R.id.buttonToast);
        snackbarButton=findViewById(R.id.buttonSnackbar);
        dialogButton=findViewById(R.id.buttonDialog);

        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Ini adalah contoh toast", Toast.LENGTH_SHORT).show                ();
            }
        });

        snackbarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                snackbarButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Snackbar.make(snackbarButton, "Buka website D3 SI", Snackbar.LENGTH_SHORT)
                                .setAction("Buka", new View.OnClickListener() {
                                    @Override
                                    public void onClick(View view) {
                                        Uri webpage = Uri.parse("https://dim.telkomuniversity.ac.id/");
                                        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
                                        startActivity(intent);
                                    }
                                })
                                .show();
                    }
                });

            }
        });

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setPositiveButton("Bangga", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Mantabb!", Toast.LENGTH_SHORT).show();
            }
        }).setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(MainActivity.this, "Harus bangga dong!", Toast.LENGTH_SHORT).show();
            }
        }).setMessage("Kamu bangga menjadi mahasiswa TelU?");
        AlertDialog dialog = alertDialogBuilder.create();

        dialogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
            }
        });



    }
}