package com.example.selos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public static final String TAG="XPTO";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "On Create");

    }

    public void onButtonClick (View view) {
        EditText num = (EditText)findViewById(R.id.num);
        TextView sel5 = (TextView)findViewById(R.id.resul5);
        TextView ssel3 = (TextView)findViewById(R.id.resul3);


        int quantia = Integer.parseInt(num.getText().toString());
        int s5=0, s3=0, r, q;
        try{
            if (quantia>=8){
                q=quantia/8;
                r=quantia%8;
                switch (r){
                    case 0: s5=q;s3=q;break;
                    case 1: s5=q-1;s3=q+2;break;
                    case 2: s5=q+1;s3=q-1;break;
                    case 3: s5=q;s3=q+1;break;
                    case 4: s5=q-1;s3=q+3;break;
                    case 5: s5=q+1;s3=q;break;
                    case 6: s5=q;s3=q+2;break;
                    case 7: s5=q+2;s3=q-1;break;
                }
            }else if (quantia==3){s5=0;s3=1;}
            else if (quantia==5){s5=1;s3=0;}
            else if (quantia==6){s5=0;s3=+2;}
            else Toast.makeText(this, "Invalid number", Toast.LENGTH_SHORT).show();;

            sel5.setText(Integer.toString(s5));
            ssel3.setText(Integer.toString(s3));

        }catch (Exception erro){
            System.out.println(erro.getMessage());
        }


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