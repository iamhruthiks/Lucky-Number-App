package com.example.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {

    int randomnumbergenerated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        TextView textView=findViewById(R.id.textView);
        TextView result=findViewById(R.id.result);
        Button share_button=findViewById(R.id.share_button);

        Intent i=getIntent();
        String username=i.getStringExtra("name");

        textView.setText(username+", your luck number is");

        randomnumbergenerated=generaterandomnumber();

        result.setText(""+randomnumbergenerated);

        share_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sharedata(username,randomnumbergenerated);
            }
        });
    }
    public int generaterandomnumber()
    {
        Random r=new Random();
        int upper_limit=1000;
        int randomnumber=r.nextInt(upper_limit);
        return randomnumber;
    }

    public void sharedata(String username,int randomnumbergenerated)
    {
        Intent i=new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        i.putExtra(Intent.EXTRA_SUBJECT,username+", got lucky today");
        i.putExtra(Intent.EXTRA_TEXT,username+"'s lucky number is "+randomnumbergenerated);

        startActivity(Intent.createChooser(i,"choose a platform"));
    }
}