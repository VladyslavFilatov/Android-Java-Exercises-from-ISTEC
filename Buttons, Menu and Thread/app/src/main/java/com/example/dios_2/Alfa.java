package com.example.dios_2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class Alfa extends AppCompatActivity implements View.OnClickListener {

    Button btmain, btclose, btalert, btsnack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alfa);
        btclose=findViewById(R.id.bt_close_alfa);
        btclose.setOnClickListener(this); //отправляем в onClick после нажатия
        btmain=findViewById(R.id.bt_Main_alfa);
        btmain.setOnClickListener(this);
        btsnack=findViewById(R.id.bt_snackbar_alfa);
        btsnack.setOnClickListener(this);
        btalert=findViewById(R.id.bt_alerta_alfa);
        btalert.setOnClickListener(this);
    }

    public void myToast(View view){
        Toast.makeText(view.getContext(), "Toast", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.bt_close_alfa:
                finish();
                break;
            case R.id.bt_Main_alfa:
                Intent it = new Intent(view.getContext(), MainActivity.class);
                startActivity(it);
                break;
            case R.id.bt_snackbar_alfa:
                Snackbar snack= Snackbar.make(view, "SnackBar", Snackbar.LENGTH_LONG).setAction("Web", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent it = new Intent(view.getContext(), Web.class);
                        startActivity(it);
                    }
                });
                View v = snack.getView();
                FrameLayout.LayoutParams params =(FrameLayout.LayoutParams)view.getLayoutParams();
                params.gravity = Gravity.CENTER_VERTICAL;
                v.setLayoutParams(params);
                snack.show();
                break;
            case R.id.bt_alerta_alfa:
                AlertDialog.Builder builder = new AlertDialog.Builder(Alfa.this);
                builder.setTitle("Nova Mensagem").setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(), "OK", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(view.getContext(), "No", Toast.LENGTH_SHORT).show();
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
                break;

        }
                ;
        }

    }
