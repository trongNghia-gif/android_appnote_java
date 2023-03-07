package com.example.authencation_dangky.ativities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class MainActivity extends AppCompatActivity {

    Button btnDangKy;

    EditText edtEmail, edtPass;
    FirebaseAuth mAuthencation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAuthencation=FirebaseAuth.getInstance();
        anhXa();
        btnDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dangKy();
            }
        });


    }

    private void dangKy(){
        String email=edtEmail.getText().toString();
        String pass=edtPass.getText().toString();
        mAuthencation.createUserWithEmailAndPassword(email, pass)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if(task.isSuccessful()){
                            Toast.makeText(MainActivity.this, "Dang Ky Thanh Cong", Toast.LENGTH_SHORT).show();
                        }else{
                            Toast.makeText(MainActivity.this, "Loi !!!", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
    private void anhXa(){
        btnDangKy=(Button) findViewById(R.id.btnDangKy);
        edtEmail=(EditText) findViewById(R.id.editTextTextPersonName4);
        edtPass=(EditText) findViewById(R.id.editTextTextPersonName5);

    }
}