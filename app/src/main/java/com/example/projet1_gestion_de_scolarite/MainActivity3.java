package com.example.projet1_gestion_de_scolarite;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity3 extends AppCompatActivity {
    MyDatabaseHelper db;
    Button button21,button22;
    EditText editText21,editText22;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_re);
        db=new MyDatabaseHelper(this);
        button21=(Button) findViewById(R.id.button21);
        button22=(Button) findViewById(R.id.button22);
        editText21=(EditText) findViewById(R.id.editText21);
        editText22=(EditText) findViewById(R.id.editText22);
        final Intent intent3 =new Intent(this,MainActivity.class);
        button21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editText21.getText().length() == 0 || editText22.length() == 0)
                    Toast.makeText(MainActivity3.this, "Please enter all values", Toast.LENGTH_SHORT).show();
                else {

                    String data[] = new String[2];
                    String user = editText21.getText().toString().toLowerCase().trim();
                    String pass = editText22.getText().toString().toLowerCase().trim();
                    db.addUser(user,pass);
                    long val = db.addUser(user,pass);
                    if(val > 0){
                        Toast.makeText(MainActivity3.this,"You have registered",Toast.LENGTH_SHORT).show();
                        startActivity(intent3);
                    }


                    else {
                        Toast.makeText(MainActivity3.this, "Failed to insert", Toast.LENGTH_SHORT).show();
                        editText21.setText(" ");
                        editText22.setText(" ");
                    }
                }
            }



        });
        button22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent3);
            }
        });

    }
}
