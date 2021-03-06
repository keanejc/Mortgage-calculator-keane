package com.introtoandriod.mortgage_calculator_keane;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private Button mSum;
    private Button pSum;

    private EditText homeVal;
    private EditText loan;
    private EditText interest;
    private EditText term;
    private EditText date;
    private EditText tax;
    private EditText pmi;
    private EditText insurance;
    private EditText hoa;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        mSum = (Button) findViewById(R.id.button);
        pSum = (Button) findViewById(R.id.button4);

        homeVal = (EditText) findViewById(R.id.editText);
        loan = (EditText) findViewById(R.id.editText2);
        interest = (EditText) findViewById(R.id.editText3);
        term = (EditText) findViewById(R.id.editText4);
        date = (EditText) findViewById(R.id.editText11);
        tax = (EditText) findViewById(R.id.editText6);
        pmi = (EditText) findViewById(R.id.editText7);
        insurance = (EditText) findViewById(R.id.editText8);
        hoa = (EditText) findViewById(R.id.editText9);




        mSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateMortgage();
                Intent intentm = new Intent(MainActivity.this, mortgageSummary.class);
                intentm.putExtra("data", calculateMortgage());
                startActivity(intentm);
            }

        });

        pSum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculatePayment();
                Intent intentp = new Intent(MainActivity.this, paymentSummary.class);
                intentp.putExtra("data", calculatePayment());
                startActivity(intentp);
            }

        });


    }

    public String calculateMortgage(){
        String string = "Mortgage Repayment Summary:" + "\n" ;

        int minsurance = Integer.parseInt(insurance.getText().toString())/12;
        int ytax = Integer.parseInt(homeVal.getText().toString()) * Integer.parseInt(tax.getText().toString());
        int mtax = ytax/12;
        int HOA = Integer.parseInt(hoa.getText().toString());

        string += "Monthly Insurance: "+ minsurance + "\n";
        string+= "Yearly Tax Amount: " + ytax + "\n";
        string+= "Monthly Tax: " + mtax + "\n";
        string+= "Monthly Fees: " + (minsurance + mtax + HOA)+ "\n";
        string+= "Total Interest: ???" + "\n";
        string += "Total Loan Cost: ???" + "\n";
        string += "Total Monthly Payment: ???";


        return string;

    }

    public String calculatePayment(){
        String string = "Monthly Vs Bi-Weekly Payment:" + "\n";

        string += "Monthly Payment: ???" + "\n";
        string += "Monthly Pay Off Date: ???" + "\n";
        string += "Total Interest (Monthly): ???" + "\n";
        string += "Bi-Weekly Payment: ???" + "\n";
        string += "Bi-Weekly Payment Date: ???" + "\n";
        string += "Total Interest (Bi-Weekly): ???";



        return string;
    }

    @Override
    public void onSaveInstanceState( Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putCharSequence("homeVal", homeVal.getText());
        savedInstanceState.putCharSequence("loan", loan.getText());
        savedInstanceState.putCharSequence("interest", interest.getText());
        savedInstanceState.putCharSequence("term", term.getText());
        savedInstanceState.putCharSequence("date", date.getText());
        savedInstanceState.putCharSequence("tax", tax.getText());
        savedInstanceState.putCharSequence("pmi", pmi.getText());
        savedInstanceState.putCharSequence("insurance", insurance.getText());
        savedInstanceState.putCharSequence("hoa", hoa.getText());


    }

    @Override
    public void onRestoreInstanceState( Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        homeVal.setText(savedInstanceState.getCharSequence("homeVal"));
        loan.setText(savedInstanceState.getCharSequence("loan"));
        interest.setText(savedInstanceState.getCharSequence("interest"));
        term.setText(savedInstanceState.getCharSequence("term"));
        date.setText(savedInstanceState.getCharSequence("date"));
        tax.setText(savedInstanceState.getCharSequence("tax"));
        pmi.setText(savedInstanceState.getCharSequence("pmi"));
        insurance.setText(savedInstanceState.getCharSequence("insurance"));
        hoa.setText(savedInstanceState.getCharSequence("hoa"));

    }

}