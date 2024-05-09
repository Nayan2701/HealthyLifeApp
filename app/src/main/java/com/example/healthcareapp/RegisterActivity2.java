package com.example.healthcareapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity2 extends AppCompatActivity {
    EditText edUsername, edEmail,edPassword,edConfPassword;
    Button btn;
    TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);
        btn=findViewById(R.id.buttonAppBook);
        edUsername=findViewById(R.id.editTextAppName);
        edEmail=findViewById(R.id.editTextAppAddress);
        edPassword=findViewById(R.id.editTextAppContact);
        edConfPassword=findViewById(R.id.editTextAppFees);
        tv1=findViewById(R.id.textViewExistingUser);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(RegisterActivity2.this,LoginActivity.class));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=edUsername.getText().toString();
                String email=edEmail.getText().toString();
                String password=edPassword.getText().toString();
                String confirm=edConfPassword.getText().toString();
                DataBase db=new DataBase(getApplicationContext(),"healthCare",null,1);
                if(username.length()==0||password.length()==0||email.length()==0||confirm.length()==0){
                    Toast.makeText(RegisterActivity2.this, "Fill Details Properly", Toast.LENGTH_SHORT).show();
                }else {
                    if(password.compareTo(confirm)==0){
                        if (isValid(password)){
                            db.register(username,email,password);
                            Toast.makeText(RegisterActivity2.this, "Record Inserted", Toast.LENGTH_SHORT).show();
                            startActivity(new Intent(RegisterActivity2.this,LoginActivity.class));
                        }else {
                            Toast.makeText(RegisterActivity2.this, "Password must contain 8 Characters,alphabets,digits", Toast.LENGTH_SHORT).show();
                        }
                    }else{
                        Toast.makeText(RegisterActivity2.this, "Registration successfully", Toast.LENGTH_SHORT).show();
                    }
                }
            }

        });
    }
    public static boolean isValid(String pass){
        int f1=0,f2=0,f3=0;
        int n=pass.length();
        if(n<8){
            return false;
        }else{
            for(int p=0;p<n;p++){
                if(Character.isLetter(pass.charAt(p))){
                    f1=1;
                }
            }
            for(int q=0;q<n;q++){
                if(Character.isDigit(pass.charAt(q))){
                    f2=1;
                }

            }
            for (int r=0;r<n;r++){
                char c=pass.charAt(r);
                if(c>=33&&c<=46||c==46){
                    f3=1;
                }
            }
            if(f1==1&&f2==1&&f3==1){
                return true;
            }else return false;
        }
    }

}