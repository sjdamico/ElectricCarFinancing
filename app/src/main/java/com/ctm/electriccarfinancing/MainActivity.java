package com.ctm.electriccarfinancing;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText years = (EditText) findViewById(R.id.txtYears);
        final EditText loan = (EditText)findViewById(R.id.txtLoan);
        final EditText interest = (EditText)findViewById(R.id.txtInterest);
        Button button = (Button)findViewById(R.id.btnPayment);
        final SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int intYears;
                int intLoan;
                float decInterest;
                intYears = Integer.parseInt(years.getText().toString());
                System.out.println("Years :" + intYears);
                intLoan = Integer.parseInt(loan.getText().toString());
                System.out.println("Loan :" + intLoan);
                decInterest = Float.parseFloat(interest.getText().toString());
                System.out.println("Interest5 :" + decInterest);
                // Persistent Data with SharedPreferences
                SharedPreferences.Editor editor = sharedPref.edit();
                editor.putInt("key1", intYears);
                editor.putInt("key2", intLoan);
                editor.putFloat("key3", decInterest);
                editor.commit();
                startActivity(new Intent(MainActivity.this, Payment.class));
            }
        });
    }
}

