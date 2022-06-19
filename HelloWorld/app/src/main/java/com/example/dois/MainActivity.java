package com.example.dois;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="XPTO";
    TextView txt;
    Button btsnake;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt=findViewById(R.id.txt_titulp_main);
        btsnake=findViewById(R.id.bt_snake_main);
        btsnake.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txt.setText("SnackBar");
                Snackbar.make(view, "Snackbar",Snackbar.LENGTH_LONG).setAction("OK", new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Log.i(TAG, "Carreguei no Snackbar");
                    }
                }).show();
            }
        });
        Log.i(TAG, "On Create");
    }

    @Override
    protected void onStart() {
        Log.i(TAG, "On Start");
        super.onStart();
    }

    @Override
    protected void onResume() {
        Log.i(TAG, "On Resume");
        super.onResume();
    }

    @Override
    protected void onPause() {
        Log.i(TAG, "On Pause");
        super.onPause();
    }

    @Override
    protected void onStop() {
        Log.i(TAG, "On Stop");
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Log.i(TAG, "On Destroy");
        super.onDestroy();
    }

    public void MyToas(View view){
        txt.setText("Toast");
        Toast.makeText(view.getContext(), "Toast", Toast.LENGTH_SHORT).show();
    }
}