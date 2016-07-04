package com.akbros.anonymous;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button foodBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodBtn = (Button)findViewById(R.id.food_btn);
        foodBtn.setOnClickListener(this);
    }
    @Override
    public void onClick(View v) {
        Intent i = new Intent(this,food.class);
        startActivity(i);
    }
}
