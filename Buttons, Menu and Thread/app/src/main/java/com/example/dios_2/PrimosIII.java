package com.example.dios_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class PrimosIII extends AppCompatActivity {

    TextView txttit;
    EditText editlim;
    ProgressBar prog;
    Button btstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primos_iii);
        txttit = findViewById(R.id.txt_tit_primosIII);
        editlim = findViewById(R.id.edit_lim_primosIII);
        prog = findViewById(R.id.prog_prog_primosIII);
        btstart = findViewById(R.id.bt_btstart_primosIII);
        btstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    int l = Integer.parseInt(editlim.getText().toString());
                    MyAsyncTask task = new MyAsyncTask();
                    task.execute(l);
                }catch (Exception erro){
                    Toast.makeText(view.getContext(), erro.getMessage(), Toast.LENGTH_SHORT).show();
                }
            }
        });
    } //oncreate

    public class MyAsyncTask extends AsyncTask<Integer, Integer, String>{

        @Override
        protected void onPreExecute() {
            Toast.makeText(getApplicationContext(), "Tarefa Iniciada", Toast.LENGTH_SHORT).show();
        }

        @Override
        protected String doInBackground(Integer... integers) {
            for (int n = 0; n<=integers[0]; n++){
                publishProgress(n, integers[0]);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            return "Fim da tarefa";
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
            txttit.setText(String.valueOf(values[0]));
            prog.setProgress((values[0]*100)/values[1]);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            txttit.setText(s);
        }
    }
}