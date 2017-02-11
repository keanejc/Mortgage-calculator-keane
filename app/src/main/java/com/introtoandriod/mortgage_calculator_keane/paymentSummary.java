package com.introtoandriod.mortgage_calculator_keane;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class paymentSummary extends AppCompatActivity {
    private Button home;
    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_summary);


        home = (Button) findViewById(R.id.button3);
        view = (TextView) findViewById(R.id.textView);
        String text = getIntent().getStringExtra("data");
        view.setText(text);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(paymentSummary.this, MainActivity.class));

            }

        });
    }

}
