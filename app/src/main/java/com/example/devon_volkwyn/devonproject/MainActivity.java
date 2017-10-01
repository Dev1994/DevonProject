package com.example.devon_volkwyn.devonproject;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //Button that will open a new intent when clicked
    public void clickTrailer(View view) {

        /** An Intent is an object that provides runtime binding between separate components, such as
         * two activities. The Intent represents an app’s "intent to do something." */
        Intent intent = new Intent(this, TrailerHireActivity.class);
        startActivity(intent);
    }


    public void clickPay(View view) {
        /** An Intent is an object that provides runtime binding between separate components, such as
         *  two activities. The Intent represents an app’s "intent to do something."  */
        Intent intent = new Intent(this, PayActivity.class);
        startActivity(intent);
    }


    public void clickOption(View view) {
        /** An Intent is an object that provides runtime binding between separate components, such as
         *  two activities. The Intent represents an app’s "intent to do something."  */
        Intent intent = new Intent(this, OptionActivity.class);
        startActivity(intent);
    }
}

//Testing for Bru