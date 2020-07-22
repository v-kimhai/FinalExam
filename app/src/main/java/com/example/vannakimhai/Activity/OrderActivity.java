package com.example.vannakimhai.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.vannakimhai.Adpator.AdaptorOrder;
import com.example.vannakimhai.Model.Product;
import com.example.vannakimhai.R;
import com.google.gson.Gson;

import org.json.JSONArray;

public class OrderActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        recyclerView = findViewById(R.id.recycler_view);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        loadOrder();
        recyclerView.setLayoutManager(layoutManager);
    }

    private void loadOrder() {

        RequestQueue requestQueue = Volley.newRequestQueue(this);

        String url = "http://ite-rupp.ap-southeast-1.elasticbeanstalk.com/orders.php";

        JsonArrayRequest request = new JsonArrayRequest(url, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {

                // Deserialize json using gson library
                Gson gson = new Gson();
                Product[] order = gson.fromJson(response.toString(), Product[].class);
                AdaptorOrder adaptor = new AdaptorOrder(order);
                recyclerView.setAdapter(adaptor);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(OrderActivity.this, "Load data error.", Toast.LENGTH_LONG).show();
                Log.d("log data", "Load data error: " + error.getMessage());
            }
        });

        // Add request to Queue
        requestQueue.add(request);
    }
}
