package com.akbros.anonymous;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class food extends AppCompatActivity {
    Button submit;
    Spinner pickup;
    Spinner weight;
    Spinner slot;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        submit = (Button)findViewById(R.id.submit);
        pickup = (Spinner)findViewById(R.id.pickup);
        weight = (Spinner)findViewById(R.id.weight);
        slot  =  (Spinner)findViewById(R.id.slot);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendRequest();
            }
        });


        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.pickups, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        pickup.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.weights, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        weight.setAdapter(adapter);

        adapter = ArrayAdapter.createFromResource(this,
                R.array.slots, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        slot.setAdapter(adapter);
    }

    public void sendRequest(){

        String URL = "https://anonymous-mdakram28.c9users.io/newFood" ;
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(food.this, "Request sent", Toast.LENGTH_SHORT).show();
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(food.this, "Request failed", Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> ret = new HashMap();
                ret.put("pickup",pickup.getSelectedItem().toString());
                ret.put("weight",weight.getSelectedItem().toString());
                ret.put("slot",slot.getSelectedItem().toString());
                return ret;
            }
        };
        AppController.getInstance().addToRequestQueue(stringRequest);
    }
}
