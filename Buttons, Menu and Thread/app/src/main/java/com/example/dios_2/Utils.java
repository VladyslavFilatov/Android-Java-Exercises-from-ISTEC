package com.example.dios_2;

public class Utils {
    public static boolean EPrimo(int num){
        int div=2, quoc, r;
        do{
            r=num%div;
            quoc=num/div;
            div++;
        }while(r!=0 && quoc >div);
        return num==2 || r!=0;
    }

}
