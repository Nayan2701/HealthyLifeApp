package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);
        CardView exitcard=findViewById(R.id.cardFDBack);
        exitcard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(FindDoctorActivity.this, HomeActivity.class));
            }
        });
        CardView physician=findViewById(R.id.cardFDFamilyPhysician);
        physician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title","Family Physician");
                startActivity(intent);
            }
        });
        CardView dietician=findViewById(R.id.cardFDDietician);
        dietician.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title","Dietician");
                startActivity(intent);
            }
        });
        CardView dentist=findViewById(R.id.cardFDDentist);
        dentist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title","Dentist");
                startActivity(intent);
            }
        });
        CardView surgeon=findViewById(R.id.cardFDSurgeon);
        surgeon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title","Surgeon");
                startActivity(intent);
            }
        });
        CardView cardiologist=findViewById(R.id.cardFDCardiologists);
        cardiologist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(FindDoctorActivity.this,DoctorDetailsActivity.class);
                intent.putExtra("title","Cardiologist");
                startActivity(intent);
            }
        });


    }
}