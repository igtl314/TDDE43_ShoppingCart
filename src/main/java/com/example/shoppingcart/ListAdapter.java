package com.example.shoppingcart;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.HashMap;

public class ListAdapter extends BaseAdapter {
    Integer tempint;
    HashMap<ShoppingObject, Integer> map = new HashMap<ShoppingObject, Integer>();
    ArrayList<ShoppingObject> listItems;
    ArrayList<ShoppingObject> clickedItems = new ArrayList<ShoppingObject>();
    ShoppingCart cart;


    public ListAdapter(ShoppingCart cart) {
        this.cart= cart;
    }
    @Override
    public int getCount() {
        return listItems.toArray().length;
    }

    @Override
    public Object getItem(int position) {
        return listItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        DrawView draw = new DrawView(this.cart.getContext());
        draw.setId(position);
        draw.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        draw.setName(listItems.get(position).getItemName());
        draw.setPrice(listItems.get(position).getPrice());
        draw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cart.setCounter(cart.getCounter()+1);
                cart.counterView.setText("You have " +cart.getCounter() + " items in your cart");
                cart.clickedName.setText(listItems.get(position).getItemName());
                if(map.containsKey(listItems.get(position))) {
                    tempint = map.get(listItems.get(position));
                    tempint++;
                    map.put(listItems.get(position), tempint);
                } else {
                    map.put(listItems.get(position), 1);
                    clickedItems.add(listItems.get(position));


                }

                draw.setId(position);
                System.out.println(draw.getId());
                notifyDataSetChanged();

            }
        });

        return draw;
    }
    public void setListItems(ArrayList<ShoppingObject> listItems) {
        this.listItems = listItems;
    }

    public ArrayList<ShoppingObject> getClickedItems(){
        return clickedItems;
    }

    public HashMap<ShoppingObject, Integer> getMap() {
        return map;
    }

}
