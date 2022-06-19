package com.example.dios_2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        Intent it;
        switch (item.getItemId()){
            case R.id.web:
                it = new Intent(MainActivity.this, Web.class);
                startActivity(it);
                break;
            case R.id.alfa:
                it = new Intent(MainActivity.this,Alfa.class);
                startActivity(it);
                break;
            case R.id.item_primos:
                it = new Intent(MainActivity.this,Primos.class);
                startActivity(it);
                break;
            case R.id.item_primosII:
                it = new Intent(MainActivity.this,PrimosII.class);
                startActivity(it);
                break;
            case R.id.item_primosIII:
                it = new Intent(MainActivity.this,PrimosIII.class);
                startActivity(it);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}