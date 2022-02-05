package com.example.projet1_gestion_de_scolarite;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button button11,button12;
    EditText editText11,editText12;
    MyDatabaseHelper sqLiteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_log);
        sqLiteDatabase=new MyDatabaseHelper(this);
        button11=(Button) findViewById(R.id.button11);
        button12=(Button) findViewById(R.id.button12);
        editText11=(EditText) findViewById(R.id.editText11);
        editText12=(EditText) findViewById(R.id.editText12);
        final Intent intent2 =new Intent(this,MainActivity2.class);
        String user=editText11.getText().toString().toLowerCase().trim();
        String pass=editText11.getText().toString().toLowerCase().trim();
        button11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user=editText11.getText().toString().toLowerCase().trim();
                String pass=editText11.getText().toString().toLowerCase().trim();
                Boolean res = sqLiteDatabase.checkUser(user, pass);
                if(res == true)
                {

                    startActivity(intent2);
                }
                else
                {
                   startActivity(intent2);
                }




            }
        });
        final Intent intent =new Intent(this,MainActivity3.class);
        button12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}
