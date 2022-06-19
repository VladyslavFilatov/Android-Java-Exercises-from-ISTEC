package com.example.dios_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class PrimosII extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "XPTO";
    Button btstart, bttask, btstop;
    EditText editlim;
    ProgressBar prog;
    TextView txt;
    MyThread myThread;
    Handler mainHandler = new Handler(Looper.getMainLooper()){
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
            if (msg.what==1){
                txt.setText(msg.obj.toString());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primos_ii);
        btstart = findViewById(R.id.bt_btstart_primosII);
        btstart.setOnClickListener(this);
        btstop = findViewById(R.id.bt_btstop_primosII);
        btstop.setOnClickListener(this);
        bttask = findViewById(R.id.bt_bttask_primosII);
        bttask.setOnClickListener(this);
        txt = findViewById(R.id.txt_tit_primosII);
        editlim = findViewById(R.id.edit_lim_primosII);
        prog = findViewById(R.id.prog_prog_primosII);
    }

    @Override
    public void onClick(View view) {
        try {
            switch (view.getId()){
                case R.id.bt_btstart_primosII:
                    txt.setText("Start");
                    myThread = new MyThread();
                    myThread.start();
                    break;
                case R.id.bt_bttask_primosII:
                    txt.setText("Task");
                    prog.setProgress(0);
                    int limite = Integer.parseInt(editlim.getText().toString());
                    Handler handler = new Handler(myThread.mylooper);
                    handler.post(new Runnable() {
                        int i, cont;
                        @Override
                        public void run() {
                            for (i = 0, cont= 0; cont < limite; i++){
                                if (Utils.EPrimo(i)){
                                    cont++;
                                    Log.i(TAG,String.valueOf(i) );
                                    mainHandler.post(new Runnable() {
                                        @Override
                                        public void run() {
                                            txt.setText(String.valueOf(i));
                                            prog.setProgress((cont*100) /limite);
                                            if (cont>=limite){
                                                Message m = Message.obtain();
                                                m.what=1;
                                                m.obj="Fim da Rotina";
                                                mainHandler.sendMessage(m);
                                            }
                                        }
                                    });
                                }

                                try {
                                    Thread.sleep(1000);
                                } catch (InterruptedException e){
                                    e.printStackTrace();
                                }
                            }
                        }
                    });
                    break;
                case R.id.bt_btstop_primosII:
                    txt.setText("Stop");
                    myThread.mylooper.quit();
                    break;
            }

        }catch (Exception erro){
            Toast.makeText(view.getContext(), erro.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
}