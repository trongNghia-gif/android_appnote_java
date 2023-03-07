package com.example.authencation_dangky.ativities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.authencation_dangky.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainDangNhap extends AppCompatActivity {
    Button btnDangNhap,btnDangKy;
    EditText edtTK,edtMK;
    FirebaseAuth mAuthencation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_dang_nhap);
        mAuthencation= FirebaseAuth.getInstance();
        anhXa();
        btnDangNhap=findViewById(R.id.btnDangNhap);
        btnDangKy=findViewById(R.id.btnDangKy);
        btnDangNhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangNhap();
            }
        });
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(MainDangNhap.this, MainActivity.class);
                startActivity(i);
            }
        });
    }
    private  void dangNhap(){
        String taiKhoan=edtTK.getText().toString();
        String matKhau=edtMK.getText().toString();
        mAuthencation.signInWithEmailAndPassword(taiKhoan, matKhau)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Intent i=new Intent(MainDangNhap.this, note.class);
                            startActivity(i);
                        }else{
                            Toast.makeText(MainDangNhap.this, "Loi !!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void anhXa(){
        edtTK=(EditText) findViewById(R.id.edtgmaildn);
        edtMK=(EditText) findViewById(R.id.edtpassdn);
    }
}