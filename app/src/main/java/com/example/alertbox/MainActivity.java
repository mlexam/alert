package com.example.alertbox;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView wifi_btn, blutooth_btn, volume_btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wifi_btn= findViewById(R.id.wifi_btn);
        blutooth_btn= findViewById(R.id.blutooth_btn);
        volume_btn= findViewById(R.id.volume_btn);

        wifi_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAlertBox("Android Button");
            }
        });

        blutooth_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAlertBox("Bluetooth Button");
            }
        });

        volume_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myAlertBox("Volume Button");
            }
        });
    }
    public void myAlertBox(String buttonname){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Click ok to confirm the selected option ?");
        builder.setTitle("Alert !");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(getApplicationContext(), buttonname+" is successfully selected.", Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("No", (DialogInterface.OnClickListener) (dialog, which) -> {
            dialog.cancel();
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}


