package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="XPTO";

    TextView txt;
    int buffer;
    char op;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        op = '1';
        buffer = 0;
        txt = findViewById(R.id.txt);
        Button ans = findViewById(R.id.eql);
        ans.setOnClickListener(view -> {
            switch (op) {
                case '+':
                    buffer += Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '-':
                    buffer -= Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '*':
                    buffer *= Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
                case '/':
                    buffer /= Integer.parseInt(txt.getText().toString());
                    txt.setText(String.valueOf(buffer));
                    break;
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

    public void ops(View view) {
        buffer = Integer.parseInt(txt.getText().toString());
        Button but = (Button) view;
        op = but.getText().charAt(0);
        txt.setText("");
        Log.d("ops", buffer + " " + op);
    }

    public void appendText(View view) {
        Button but = (Button) view;
        txt.setText(txt.getText().toString() + but.getText().toString());
    }
}