package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    String username=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView title=findViewById(R.id.title);

        EditText editText=findViewById(R.id.editText);

        ImageView image=findViewById(R.id.image);

        Button button1=findViewById(R.id.button1);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                username = editText.getText().toString();

                if(username.isEmpty())
                {
                    Toast.makeText(MainActivity.this,
                            "Please enter your name",
                            Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Intent i = new Intent(getApplicationContext(), MainActivity2.class);
                    i.putExtra("name", username);
                    startActivity(i);
                }
            }
        });
    }
}