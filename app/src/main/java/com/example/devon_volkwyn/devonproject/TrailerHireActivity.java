package com.example.devon_volkwyn.devonproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class TrailerHireActivity extends AppCompatActivity {

    public void clickCalculate(View view){

        // Retrieve the cost per km and converting it to a number
        EditText txtNumCostKM = (EditText) findViewById(R.id.txtNumCostKM);
        String costKM = txtNumCostKM.getText().toString();
        if (costKM.matches("")) {
            Toast.makeText(this, "You did not enter the cost per kilometer!", Toast.LENGTH_SHORT).show();
            return;
        }
        double costKMNum = Double.parseDouble(costKM);

        // Retrieve the amount of km travelled and converting it to a number
        EditText txtKMAmount = (EditText) findViewById(R.id.txtKMAmount);
        String kmAmount = txtKMAmount.getText().toString();
        if (kmAmount.matches("")) {
            Toast.makeText(this, "You did not enter the amount of km travelled!", Toast.LENGTH_SHORT).show();
            return;
        }
        int kmAmountNum = Integer.parseInt(kmAmount);

        TextView txtDistResult = (TextView) findViewById(R.id.txtDistResult);
        TextView txtTotal = (TextView) findViewById(R.id.txtTotal) ;
        ImageView fivePercent = (ImageView) findViewById(R.id.fivePercent);
        TextView viewExplanation = (TextView) findViewById(R.id.viewExplanation);
        TextView viewExtra = (TextView) findViewById(R.id.viewExtra);
        ImageView imgEleven = (ImageView) findViewById(R.id.imgEleven);

        // For testing purposes.
        Log.i("Info" , "Cost per km is R" + costKMNum);
        Log.i("Info" , "KM travelled = " + kmAmountNum);

        double total = kmAmountNum * costKMNum;

        if (kmAmountNum < 40){

            double amDist = total;
            double totalExtra = 0.05 * total;
            total = total + totalExtra + 300;

            txtDistResult.setText(String.format("R" + "%.2f",amDist));
            txtTotal.setText(String.format("R" + "%.2f", total));
            fivePercent.setVisibility(View.VISIBLE);
            viewExplanation.setVisibility(View.VISIBLE);
            viewExtra.setText(String.format("+ R" + "%.2f", totalExtra));
            viewExtra.setVisibility(View.VISIBLE);

        }else if (kmAmountNum > 200){

            double amDist = total;
            double totalExtra = (total*(11/100.%.2f));
            total = total - totalExtra + 300;

            txtDistResult.setText(String.format("R" + "%.2f",amDist));
            txtTotal.setText(String.format("R" + "%.2f", total));
            imgEleven.setVisibility(View.VISIBLE);
            viewExplanation.setText("Travelled over 200km");
            viewExplanation.setVisibility(View.VISIBLE);
            viewExtra.setText(String.format("Discount R" + "%.2f", totalExtra));
            viewExtra.setVisibility(View.VISIBLE);

        }else {
            double amDist = total;
            total = total +300;

            txtDistResult.setText(String.format("R" + "%.2f",amDist));
            txtTotal.setText(String.format("R" + "%.2f", total));

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer_hire);
    }
}
