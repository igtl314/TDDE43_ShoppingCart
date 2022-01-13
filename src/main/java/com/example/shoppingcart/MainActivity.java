package com.example.shoppingcart;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button cartItems;
    View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ShoppingCart cart = findViewById(R.id.shoppingCart);

        cart.addItem("Mjöl", 10);
        cart.addItem("Bröd", 1000);
        cart.addItem("Får", 20);

    }
}