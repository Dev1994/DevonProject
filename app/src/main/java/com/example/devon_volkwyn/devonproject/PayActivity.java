package com.example.devon_volkwyn.devonproject;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class PayActivity extends AppCompatActivity {

    public void clickCalculate(View view){
        EditText txtHours = (EditText) findViewById(R.id.txtHours);
        String txtHoursString = txtHours.getText().toString();
        if (txtHoursString.matches("")) {
            Toast.makeText(this, "You did not enter the amount of hours worked!", Toast.LENGTH_SHORT).show();
            return;
        }
        Double numHour = Double.parseDouble(txtHoursString);

        EditText txtRate = (EditText) findViewById(R.id.txtRate);
        String txtRateString = txtRate.getText().toString();
        if (txtRateString.matches("")) {
            Toast.makeText(this, "You did not enter the hourly rate in rands!", Toast.LENGTH_SHORT).show();
            return;
        }
        Double numRate = Double.parseDouble(txtRateString);

        //For testing purposes
        Log.i("Info", "Amount of hours worked = " + txtHoursString);
        Log.i("Info", "Hourly rate = " + txtRateString);

        TextView lblResult = (TextView) findViewById(R.id.lblResult);

        ConstraintLayout contLay = (ConstraintLayout) findViewById(R.id.contLay);

        // Hide the keyboard from the screen when the button is clicked.
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(contLay.getWindowToken(), 0);

        if (numHour == 40 && numRate < 28.50){
            numRate = numRate + 1.50;
            lblResult.setText(String.format("R" + "%.2f",numRate));

        }else if (numHour == 40 && numRate >= 28.50){
            numRate = numRate + 1.20;
            lblResult.setText(String.format("R" + "%.2f",numRate));

        }else if (numHour > 40 && numRate >= 28.50){
            numRate = numRate + (numRate * 0.015);
            lblResult.setText(String.format("R" + "%.2f",numRate));

        }else if (numHour < 40){
            numRate = numRate - 0.50;
            lblResult.setText(String.format("R" + "%.2f",numRate));
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);
    }
}
