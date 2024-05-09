package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {
    String[][] medicineData = {
            {"Aspirin","","","", "5.00"},
            {"Ibuprofen","","","", "3.75"},
            {"Paracetamol","","","", "4.20"},
            {"Amoxicillin","","","", "12.99"},
            {"Azithromycin","","","", "21.50"}
    };

    String[] medicineDetails = {
            "Pain relief\n "+"fever reduction",
            "Pain relief\n"+"fever reduction\n"+"inflammation",
            "Fever reduction\n"+"pain relief",
            "Antibiotic for bacterial infections",
            "Antibiotic for a wider range of bacterial infections"
    };

    HashMap<String,String> item;
    ArrayList list;
    SimpleAdapter sa;
    Button btnGoToCart,btnBack;
    ListView listView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);
        listView=findViewById(R.id.listViewBMCart);
        btnBack=findViewById(R.id.buttonBMCBack);
        btnGoToCart=findViewById(R.id.buttonBMGoToCart);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });
        list=new ArrayList();
        for (int i=0;i<medicineData.length;i++){
            item = new HashMap<String, String>();
            item.put("line1",medicineData[i][0]);
            item.put("line2",medicineData[i][1]);
            item.put("line3",medicineData[i][2]);
            item.put("line4",medicineData[i][3]);
            item.put("line5","Cons Fees:"+medicineData[i][4]);
            list.add(item);
        }

        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        listView.setAdapter(sa);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it=new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);

                it.putExtra("text1",medicineData[i][0]);
                it.putExtra("text2",medicineDetails[i]);
                it.putExtra("text3",medicineData[i][4]);

                startActivity(it);

            }
        });
        btnGoToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class));
            }
        });

    }
}