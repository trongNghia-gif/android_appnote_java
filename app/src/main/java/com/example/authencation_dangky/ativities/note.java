package com.example.authencation_dangky.ativities;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.authencation_dangky.R;
import com.example.authencation_dangky.database.NoteDatabase;
import com.example.authencation_dangky.entities.Note;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.List;

public class note extends AppCompatActivity {

    private TextView txtName, txtPass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note);


        ImageView imgAdd=findViewById(R.id.imgAddNote);
        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(note.this, newNote.class);
                startActivity(i);
            }
        });

        anhXa();
        showIF();
        getNote();

    }
    private  void getNote(){
        @SuppressLint("StaticFieldLeak")
        class GetNotesTask extends AsyncTask<Void, Void, List<Note>>{
            @Override
            protected List<Note> doInBackground(Void... voids) {
                return NoteDatabase.getDatabase(getApplicationContext()).noteDao().getAllNote();
            }

            @Override
            protected void onPostExecute(List<Note> notes) {
                super.onPostExecute(notes);
                Log.d("MY_NOTE", notes.toString());
            }
        }
        new GetNotesTask().execute();
    }
    private void anhXa(){
        txtName=findViewById(R.id.txt_note_name);
        txtPass=findViewById(R.id.txt_note_pass);
    }
    private void showIF(){
        FirebaseUser user= FirebaseAuth.getInstance().getCurrentUser();
        if(user==null){
            return;
        }

        String name = user.getDisplayName();
        String email = user.getEmail();
        if(name==null){
            txtName.setVisibility(View.GONE);
        }else{
            txtName.setVisibility(View.VISIBLE);
            txtName.setText(name);
        }

        txtPass.setText(email);

    }
}