package com.example.projet1_gestion_de_scolarite;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class etudiants extends AppCompatActivity {

        RecyclerView recyclerView;
        MyDatabaseHelper mydb;
        ArrayList<String> student_cne, student_name1, student_name2, student_filiere;
        CustomAdapterEtudiants customAdapterEtudiants;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_etudiants);

            recyclerView = findViewById(R.id.recycle_all_student);

            mydb = new MyDatabaseHelper(etudiants.this);
            student_cne = new ArrayList<>();
            student_name1 = new ArrayList<>();
            student_name2 = new ArrayList<>();
            student_filiere = new ArrayList<>();

            storeDataInArrays();

            customAdapterEtudiants= new CustomAdapterEtudiants(etudiants.this,student_cne,student_name1,student_name2,student_filiere);
            recyclerView.setAdapter(customAdapterEtudiants);
            recyclerView.setLayoutManager(new LinearLayoutManager(etudiants.this));

        }

        void storeDataInArrays(){
            Cursor cursor = mydb.readAllStudent();
            if (cursor.getCount()==0){
                Toast.makeText(this, "NO DATA", Toast.LENGTH_SHORT).show();
            }else{
                while (cursor.moveToNext()){
                    student_cne.add(cursor.getString(0));
                    student_name1.add(cursor.getString(1));
                    student_name2.add(cursor.getString(2));
                    student_filiere.add(cursor.getString(3));
                }
            }
        }

    }
