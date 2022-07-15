package com.example.workindiaapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Product> products;
    private static String JSON_URL = "https://run.mocky.io/v3/b6a30bb0-140f-4966-8608-1dc35fa1fadc";
    Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.productList);
        products = new ArrayList<>();
        extractProducts();
    }

    private void extractProducts() {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(Request.Method.GET, JSON_URL, null, new Response.Listener<JSONObject>() {




            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONObject res1=response.getJSONObject("data");
                    System.out.println("hiiiiiiiiii" + res1);
//                    JSONObject data=response.getJSONObject("data").getJSONObject("data");
//                    System.out.println(data);
                    JSONArray res = response.getJSONObject("data").getJSONArray("items");
                    System.out.println(res);
                    for (int i = 0; i < res.length(); i++) {

                        JSONObject productObject = res.getJSONObject(i);
                        System.out.println(productObject.getString("name"));

                        Product product = new Product();
                        product.setName(productObject.getString("name").toString());
                        product.setPrice(productObject.getString("price".toString()));
                        //product.setCoverImage(productObject.getString("cover_image"));
                        product.setExtra(productObject.getString("extra"));
                        products.add(product);
                    }
                }catch (JSONException e) {
                    e.printStackTrace();
                }






                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new Adapter(products);
                recyclerView.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("tag", "onErrorResponse: " + error.getMessage());
            }
        });

        queue.add(jsonArrayRequest);

    }
}