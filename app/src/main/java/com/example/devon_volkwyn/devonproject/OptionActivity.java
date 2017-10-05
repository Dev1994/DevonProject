package com.example.devon_volkwyn.devonproject;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

public class OptionActivity extends AppCompatActivity {

    // Button method to to show the conversion from dollar to rands.
    public void clickConvert (View view){

        // Retrieving the content from the layout in order to modify it.
        EditText txtNumber = (EditText) findViewById(R.id.txtNumber);
        ConstraintLayout clsLay = (ConstraintLayout) findViewById(R.id.clsLay);

        // Converting a String to a double.
        Double dollAmountParsed = Double.parseDouble(txtNumber.getText().toString());
        Double randAmount = dollAmountParsed * 13.55;

        // Show the conversion result as a toast message.
        Toast.makeText(OptionActivity.this, "R" + String.format("%.2f", randAmount), Toast.LENGTH_LONG).show();

        // Hide the keyboard from the screen when the button is clicked.
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(clsLay.getWindowToken(), 0);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_option);
    }
}
