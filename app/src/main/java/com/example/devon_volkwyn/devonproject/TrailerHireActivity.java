package com.example.devon_volkwyn.devonproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
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

        // For testing purposes.
        Log.i("Info" , "Cost per km is R" + costKMNum);
        Log.i("Info" , "KM travelled = " + kmAmountNum);

        double total = kmAmountNum * costKMNum;

        if (kmAmountNum < 40){

            double amDist = total;
            double totalExtra = (total*(5/100));
            total = total + totalExtra + 300;

            Log.i("Info" , "TotalExtra = R" + totalExtra);
            Log.i("Info" , "Total if < 40km = R" + total);

            String amDistString = new Double(amDist).toString();
            txtDistResult.setText("R" + amDistString);
            Toast.makeText(this, "Total Amount Due After 5% surcharge and R300 daily fee added: R" + total, Toast.LENGTH_LONG).show();

        }else if (kmAmountNum > 200){

            double amDist = total;
            double totalExtra = (total*(11/100.%.2f));
            total = total - totalExtra + 300;

            Log.i("Info" , "TotalExtra = R" + totalExtra);
            Log.i("Info" , "Total if > 200km = R" + total);

            Toast.makeText(this, "Amount due for distance travelled: R" + amDist, Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Total Amount Due after 11% Discount and R300 daily fee added: R" + total, Toast.LENGTH_LONG).show();

        }else {
            double amDist = total;
            total = total +300;
            Log.i("Info" , "Total if >= 40km && <= 200km = R" + total);

            Toast.makeText(this, "Amount due for distance travelled: R" + amDist, Toast.LENGTH_LONG).show();
            Toast.makeText(this, "Total Amount Due after R300 daily fee added: R" + total, Toast.LENGTH_LONG).show();

        }

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trailer_hire);
    }
}
