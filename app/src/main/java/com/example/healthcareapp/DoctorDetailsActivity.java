package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {
    String[][] doctors1 = {
            {" Doctor Name: Dr. Alice Green","Hospital Name: City Hospital","EXP: 10 Years","Mobile No: 123-456-7890","600"},
            {" Doctor Name: Dr. Bob Brown","Hospital Name: Central Clinic","EXP: 15 Years","Mobile No: 987-654-3210","600"},
            {" Doctor Name: Dr. Charlie Whit","Hospital Name: Eastside Medical","EXP: 5 Years","Mobile No: 012-345-6710","300"},
            {" Doctor Name: Dr. David Lee","Hospital Name: Westside General","EXP: 8 Years","Mobile No: 555-123-4510","400"},
            {" Doctor Name: Dr. Emily Sanchez","Hospital Name: Northgate Hospital","EXP: 12 Years","Mobile No: 444-789-0110","800"},
    };
    String[][] doctors2= {
            {" Doctor Name: Dr. Alice Green","Hospital Name: City Hospital","EXP: 10 Years","Mobile No: 123-456-7890","600"},
            {" Doctor Name: Dr. Bob Brown","Hospital Name: Central Clinic","EXP: 15 Years","Mobile No: 987-654-3210","600"},
            {" Doctor Name: Dr. Charlie Whit","Hospital Name: Eastside Medical","EXP: 5 Years","Mobile No: 012-345-6710","300"},
            {" Doctor Name: Dr. David Lee","Hospital Name: Westside General","EXP: 8 Years","Mobile No: 555-123-4510","400"},
            {" Doctor Name: Dr. Emily Sanchez","Hospital Name: Northgate Hospital","EXP: 12 Years","Mobile No: 444-789-0110","800"},
    };
    String[][] doctors3 = {
            {"Doctor Name: Dr. Alice Green","Hospital Name: City Hospital","EXP: 10 Years","Mobile No: 123-456-7890","600"},
            {"Doctor Name: Dr. Bob Brown","Hospital Name: Central Clinic","EXP: 15 Years","Mobile No: 987-654-3210","600"},
            {"Doctor Name: Dr. Charlie Whit","Hospital Name: Eastside Medical","EXP: 5 Years","Mobile No: 012-345-6710","300"},
            {"Doctor Name: Dr. David Lee","Hospital Name: Westside General","EXP: 8 Years","Mobile No: 555-123-4510","400"},
            {"Doctor Name: Dr. Emily Sanchez","Hospital Name: Northgate Hospital","EXP: 12 Years","Mobile No: 444-789-0110","800"},
    };
    String[][] doctors4 = {
            {"Doctor Name: Dr. Alice Green","Hospital Name: City Hospital","EXP: 10 Years","Mobile No: 123-456-7890","600"},
            {"Doctor Name: Dr. Bob Brown","Hospital Name: Central Clinic","EXP: 15 Years","Mobile No: 987-654-3210","600"},
            {"Doctor Name: Dr. Charlie Whit","Hospital Name: Eastside Medical","EXP: 5 Years","Mobile No: 012-345-6710","300"},
            {"Doctor Name: Dr. David Lee","Hospital Name: Westside General","EXP: 8 Years","Mobile No: 555-123-4510","400"},
            {"Doctor Name: Dr. Emily Sanchez","Hospital Name: Northgate Hospital","EXP: 12 Years","Mobile No: 444-789-0110","800"},
    };
    String[][] doctors5 = {
            {"Doctor Name: Dr. Alice Green","Hospital Name: City Hospital","EXP: 10 Years","Mobile No: 123-456-7890","600"},
            {"Doctor Name: Dr. Bob Brown","Hospital Name: Central Clinic","EXP: 15 Years","Mobile No: 987-654-3210","600"},
            {"Doctor Name: Dr. Charlie Whit","Hospital Name: Eastside Medical","EXP: 5 Years","Mobile No: 012-345-6710","300"},
            {"Doctor Name: Dr. David Lee","Hospital Name: Westside General","EXP: 8 Years","Mobile No: 555-123-4510","400"},
            {"Doctor Name: Dr. Emily Sanchez","Hospital Name: Northgate Hospital","EXP: 12 Years","Mobile No: 444-789-0110","800"},
    };

    TextView tv;
    Button btn;
    String[][] doctordetails={};
    ArrayList list;
    SimpleAdapter sa;
    HashMap<String,String> item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        btn=findViewById(R.id.buttonBMCBack);
        tv=findViewById(R.id.textViewDDTitle);
        Intent it=getIntent();
        String title=it.getStringExtra("title");
        tv.setText(title);
        if (title.compareTo("Family Physician")==0){
            doctordetails=doctors1;
        } else if (title.compareTo("Dietician")==0){
            doctordetails=doctors2;
        } else if (title.compareTo("Dentist")==0){
            doctordetails=doctors3;
        } else if (title.compareTo("Surgeon")==0){
            doctordetails=doctors4;
        } else if (title.compareTo("Cardiologist")==0){
            doctordetails=doctors5;
        }


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
        list=new ArrayList();
        for (int i=0;i<doctordetails.length;i++){
             item = new HashMap<String, String>();
             item.put("line1",doctordetails[i][0]);
            item.put("line2",doctordetails[i][1]);
            item.put("line3",doctordetails[i][2]);
            item.put("line4",doctordetails[i][3]);
            item.put("line5","Cons Fees : "+doctordetails[i][4]+"/-");
            list.add(item);
        }
        sa=new SimpleAdapter(this,list,R.layout.multi_lines,
                new String[]{"line1","line2","line3","line4","line5"},
                new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e});
        ListView ls=findViewById(R.id.listViewBMCart);
        ls.setAdapter(sa);
        ls.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent=new Intent(DoctorDetailsActivity.this, BookApponitmentActivity.class);
                intent.putExtra("text1",title);
                intent.putExtra("text2",doctordetails[i][0]);
                intent.putExtra("text3",doctordetails[i][1]);
                intent.putExtra("text4",doctordetails[i][3]);
                intent.putExtra("text5",doctordetails[i][4]);
                startActivity(intent);

            }
        });
    }
}