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

public class mortgageSummary extends AppCompatActivity {
    private Button home;
    private TextView view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mortgage_summary);

       home = (Button) findViewById(R.id.button2);

        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mortgageSummary.this, MainActivity.class));
                view = (TextView) findViewById(R.id.textView2);

                String text = getIntent().getStringExtra("data");
                view.setText(text);
            }

        });

    }

}
