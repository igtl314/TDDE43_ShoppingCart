package com.example.shoppingcart;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class ShoppingCartAdapter extends BaseAdapter {
    ArrayList<ShoppingObject> cartItems;
    HashMap<ShoppingObject, Integer> map;
    ShoppingCart cart;
    Integer tempint;


    public ShoppingCartAdapter(ShoppingCart cart) {
        this.cart= cart;
    }
    @Override
    public int getCount() {
        return cartItems.toArray().length;
        //return map.size();
    }

    @Override
    public Object getItem(int position) {
        return cartItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        shoppingView view = new shoppingView(this.cart.getContext());

        view.setId(position+10);
        System.out.println(view.getId());
        //view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));

        view.setName(cartItems.get(position).getItemName());
        view.setPrice(cartItems.get(position).getPrice());
        view.setNumber(map.get(cartItems.get(position)));
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.setCounter(cart.getCounter()-1);
                cart.counterView.setText("You have " +cart.getCounter() + " items in your cart");
                if (view.getNumber() == 1) {
                    map.remove(cartItems.get(position));
                    cartItems.remove(cartItems.get(position));
                } else {
                    tempint = map.get(cartItems.get(position));
                    tempint--;
                    map.put(cartItems.get(position), tempint);
                }
                    notifyDataSetChanged();


            }
        });
        return view;
    }
    public void setCartItems(ArrayList<ShoppingObject> cartItems) {
        this.cartItems = cartItems;
    }

    public void setMap (HashMap<ShoppingObject, Integer> map){
        this.map = map;
    }

}
