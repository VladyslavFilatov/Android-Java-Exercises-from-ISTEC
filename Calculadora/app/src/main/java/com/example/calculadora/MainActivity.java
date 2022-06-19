package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="XPTO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "On Create");
    }

    public void onButtonClick (View view) {
        EditText el1 = (EditText)findViewById(R.id.num1);
        EditText el2 = (EditText)findViewById(R.id.num2);
        TextView resText = (TextView)findViewById(R.id.res);

        int num1 = Integer.parseInt(el1.getText().toString());
        int num2 = Integer.parseInt(el2.getText().toString());
        int resSum = num1 + num2;
        resText.setText(Integer.toString(resSum));
    }

    public void onButtonClickmin (View view) {
        EditText el1 = (EditText)findViewById(R.id.num1);
        EditText el2 = (EditText)findViewById(R.id.num2);
        TextView resText = (TextView)findViewById(R.id.res);

        int num1 = Integer.parseInt(el1.getText().toString());
        int num2 = Integer.parseInt(el2.getText().toString());
        int resSum = num1 - num2;
        resText.setText(Integer.toString(resSum));
    }

    public void onButtonClickmul (View view) {
        EditText el1 = (EditText)findViewById(R.id.num1);
        EditText el2 = (EditText)findViewById(R.id.num2);
        TextView resText = (TextView)findViewById(R.id.res);

        int num1 = Integer.parseInt(el1.getText().toString());
        int num2 = Integer.parseInt(el2.getText().toString());
        int resSum = num1 * num2;
        resText.setText(Integer.toString(resSum));
    }

    public void onButtonClickdiv (View view) {
        EditText el1 = (EditText)findViewById(R.id.num1);
        EditText el2 = (EditText)findViewById(R.id.num2);
        TextView resText = (TextView)findViewById(R.id.res);

        int num1 = Integer.parseInt(el1.getText().toString());
        int num2 = Integer.parseInt(el2.getText().toString());
        int resSum = num1 / num2;
        resText.setText(Integer.toString(resSum));
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

}