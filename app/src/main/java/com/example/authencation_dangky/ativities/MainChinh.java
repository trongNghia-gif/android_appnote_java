package com.example.authencation_dangky.ativities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import com.example.authencation_dangky.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainChinh extends AppCompatActivity {

    Button btnDN,btnDK;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_chinh);


//        Handler handler=new Handler();
//        handler.postDelayed(new Runnable() {
//            @Override
//            public void run() {
//                nextAtivity();
//            }
//        },2000);

    }
//    private void nextAtivity(){
//        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
//        if(user==null){//chua login
//            Intent i=new Intent(MainChinh.this,note.class);
//            startActivity(i);
//        }else{//da login
//            Intent i=new Intent(MainChinh.this,MainDangNhap.class);
//            startActivity(i);
//        }
//    }
}