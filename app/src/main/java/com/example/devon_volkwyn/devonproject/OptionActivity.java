package com.example.devon_volkwyn.devonproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class OptionActivity extends AppCompatActivity {

    public void clickConvert (View view){

        EditText txtNumber = (EditText) findViewById(R.id.txtNumber);
        Double dollAmountParsed = Double.parseDouble(txtNumber.getText().toString());
        Double randAmount = dollAmountParsed * 13.55;

        Toast.makeText(OptionActivity.this, "R" + String.format("%.2f", randAmount), Toast.LENGTH_LONG).show();

        // For testing purposes
        Log.i("Amount", txtNumber.getText().toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
    }
}
