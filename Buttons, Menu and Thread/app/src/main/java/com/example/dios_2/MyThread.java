package com.example.dios_2;

import android.os.Looper;
import android.util.Log;

public class MyThread extends Thread{
    private static final String TAG = "XPTO";
    public MyThread(){

    }

    Looper mylooper;
    @Override
    public void run() {
        Looper.prepare();
        mylooper = Looper.myLooper();
        Looper.loop();
        Log.i(TAG,"Fim do Loop");

    }
}
