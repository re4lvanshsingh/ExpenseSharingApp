package com.example.sharingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.UUID;

public class MainActivity2 extends AppCompatActivity {

    private EditText edit;
    private Button add;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        edit=findViewById(R.id.editTextTextPersonName);
        add=findViewById(R.id.button);

        HashMap<String, Object> map = new HashMap<>();

        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                String txt_name= edit.getText().toString();
                if(txt_name.isEmpty()){
                    Toast.makeText(MainActivity2.this, "No group name entered", Toast.LENGTH_SHORT).show();
                }
                else{
                    String lol = UUID.randomUUID().toString();
                    map.put(lol,txt_name);
                    FirebaseDatabase.getInstance().getReference().child("Unique User Name").child("Group Names").updateChildren(map);
                }
            }
        });
    }
}