package com.example.dios_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class Primos extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "XPTO";
    TextView txt;
    EditText edit;
    Button btprimos, btlimpa;
    ProgressBar prog;
    Handler handler = new Handler(){
        @Override
        public void handleMessage(@NonNull Message msg) {
            switch (msg.what){
                case 1:
                    edit.setText(msg.obj.toString() + " " + String.valueOf(msg.arg1));
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primos);
        txt=findViewById(R.id.txt_tit_primos);
        edit=findViewById(R.id.edit_total_primos);
        btlimpa=findViewById(R.id.btlimpa);
        btprimos=findViewById(R.id.btprimos);
        btprimos.setOnClickListener(this);
        prog = findViewById(R.id.prog_prog_primos);
    }

    public void limpa(View view){
        try {

            txt.setText("");
            edit.setText("");
        }catch (Exception erro){
            Toast.makeText(Primos.this, "Numero Invalido" + erro.getMessage(), Toast.LENGTH_LONG).show();
        }

    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()){
                case R.id.btprimos:
                    prog.setVisibility(View.VISIBLE);
                    prog.setProgress(0);
                    int limit = Integer.parseInt(edit.getText().toString());
                    Thread t = new Thread(new Runnable() {
                        public int c, n;
                        @Override
                        public void run() {
                            for (n = 2, c =0; c<limit; n++){
                                if(Utils.EPrimo(n)){
                                    c++;
                                    Log.i(TAG,String.valueOf(n));
                                    handler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            txt.setText(String.valueOf(n));
                                            int trabalhofeito = (c*100)/limit;
                                            prog.setProgress(trabalhofeito);
                                            if (c>=limit){
                                                prog.setVisibility(View.INVISIBLE);
                                                Message msg = Message.obtain();
                                                msg.what=1;
                                                msg.arg1=limit;
                                                msg.obj="Fin da Tarefa";
                                                handler.sendMessage(msg);

                                            }

                                        }
                                    });
                                    try {
                                        Thread.sleep(1000);

                                    } catch (InterruptedException e) {
                                        e.printStackTrace();
                                    }
                                }

                            }
                        }
                    });
                    t.start();
                    break;
            }
        }catch (Exception erro){
            Toast.makeText(Primos.this, erro.getMessage(), Toast.LENGTH_SHORT).show();
        }

    }
}