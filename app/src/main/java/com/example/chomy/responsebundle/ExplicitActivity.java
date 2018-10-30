package com.example.chomy.responsebundle;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ExplicitActivity extends AppCompatActivity {
        TextView textViewName, textViewAge, textViewGender,
                textViewName1, textViewAge1, textViewGender1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explicit);

        Bundle bundle = getIntent().getExtras();
        textViewName =(TextView)findViewById(R.id.textViewName);
        textViewName.setText("이름:  "+bundle.getString("Name","No Data"));

        textViewAge = findViewById(R.id.textViewAge);
        textViewAge.setText("나이:  "+bundle.getString("Age","No Data"));

        textViewGender = findViewById(R.id.textViewGender);
        textViewGender.setText("성별:  "+bundle.getString("Gender","No Data"));

    }

    @Override
    public void finish(){

        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("resultName", ((TextView)textViewName).getText().toString());
        bundle.putString("resultAge", ((TextView)textViewAge).getText().toString());
        bundle.putString("resultGender", ((TextView)textViewGender).getText().toString());
        intent.putExtras(bundle);
        setResult(100, intent);
        super.finish();
    }



}
