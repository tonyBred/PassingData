package com.example.passingdata;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view){
        Intent i = new Intent("com.example.passindata.SecondActivity");

        i.putExtra("str1", "This is a String");
        i.putExtra("age1", 25);

        Bundle bundle = new Bundle();
        bundle.putString("str2", "This is another String");
        bundle.putInt("age2", 35);

        i.putExtras(bundle);

        startActivityForResult(i, 1);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1){
            if(resultCode == RESULT_OK){
                Toast.makeText(this, Integer.toString(data.getIntExtra("age3", 0)), Toast.LENGTH_SHORT).show();
                Toast.makeText(this, data.getData().toString(),Toast.LENGTH_SHORT).show();
            }
        }

    }

}