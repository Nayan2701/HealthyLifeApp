package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class BuyMedicineDetailsActivity extends AppCompatActivity {
    TextView tvPackageName,tvTotalCost;
    EditText edMultiline;
    Button btnBack,btnAddToCart;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);
        tvPackageName=findViewById(R.id.textViewCartBMTitle);
        tvTotalCost=findViewById(R.id.textViewBMCartTotalCost);
        edMultiline=findViewById(R.id.editTextTextMultiline);
        edMultiline.setKeyListener(null);
        btnBack=findViewById(R.id.buttonBMDBack);
        btnAddToCart=findViewById(R.id.buttonBMDAddToCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineDetailsActivity.this,BuyMedicineActivity.class));
            }
        });
        Intent it=getIntent();
        tvPackageName.setText(it.getStringExtra("text1"));
        edMultiline.setText(it.getStringExtra("text2"));
        tvTotalCost.setText(it.getStringExtra("Total Cost : "+it.getStringExtra("text3")+"/-"));

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences=getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                String username=sharedPreferences.getString("username","").toString();
                String product=tvPackageName.getText().toString();
                float price=Float.parseFloat(it.getStringExtra("text3").toString());

                DataBase db=new DataBase(getApplicationContext(),"healthCare",null,1);
                if(db.checkCart(username,product)==1){
                    Toast.makeText(BuyMedicineDetailsActivity.this, "Product Already Added", Toast.LENGTH_SHORT).show();
                }else {

                    db.addCart(username,product,price,"Medicine");
                    Toast.makeText(BuyMedicineDetailsActivity.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicineDetailsActivity.this,BuyMedicineActivity.class));
                }
            }
        });



    }
}