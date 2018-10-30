package com.example.chomy.responsebundle;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView textView1, textView2, textView3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.buttonResult);
        button.setOnClickListener(this);

        textView1 = findViewById(R.id.textViewResult1);
        textView2 = findViewById(R.id.textViewResult2);
        textView3 = findViewById(R.id.textViewResult3);
    }

    @Override
    public void onClick(View v) {
        EditText editTextName = findViewById(R.id.editTextName);
        String editTextNameString = editTextName.getText().toString();
        EditText editTextAge = findViewById(R.id.editTextAge);
        String editTextAgeString = editTextAge.getText().toString();

        RadioGroup radioGroupGender = findViewById(R.id.radioGroupGender);
        RadioButton radioButtonGender = findViewById(radioGroupGender.getCheckedRadioButtonId());
        String radioButtonGenderString = radioButtonGender.getText().toString();


        Bundle bundle = new Bundle();
        bundle.putString("Name", editTextNameString);
        bundle.putString("Age", editTextAgeString);
        bundle.putString("Gender", radioButtonGenderString);

        Intent intent = new Intent(this, ExplicitActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent,100);


    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(data.hasExtra("resultName")) {
//            Toast.makeText(getApplicationContext(), data.getStringExtra("resultValue"), Toast.LENGTH_SHORT).show();
            textView1.setText(data.getStringExtra("resultName"));
        }
        if(data.hasExtra("resultAge")){
//            Toast.makeText(getApplicationContext(), data.getStringExtra("resultAge"),Toast.LENGTH_SHORT).show();
            textView2.setText(data.getStringExtra("resultAge"));
        }
        if(data.hasExtra("resultGender")){
//            Toast.makeText(getApplicationContext(),data.getStringExtra("resultGender"),Toast.LENGTH_SHORT).show();
            textView3.setText(data.getStringExtra("resultGender"));
        }
    }
}
