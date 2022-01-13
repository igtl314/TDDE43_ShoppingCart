package com.example.shoppingcart;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.ListPopupWindow;

import java.util.ArrayList;

public class ShoppingCart extends LinearLayout {
    Button cartButton;
    Context c;
    View v;
    ListView listItems;
    ListPopupWindow cartItems;
    TextView clickedName;
    Integer counter =0;
    TextView counterView;

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }



    // Adaptar och arraylist
    ArrayList<ShoppingObject> ObjectList = new ArrayList<ShoppingObject>(); // Vad som går att köpa
    ListAdapter listAdapter = new ListAdapter(this);
    ShoppingCartAdapter cartAdapter = new ShoppingCartAdapter(this);

    public ShoppingCart(Context context) {
        super(context);
        this.c = context;
        init();

    }

    public ShoppingCart(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.c = context;
        init();

    }

    public ShoppingCart(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.c = context;
        init();

    }

    public ShoppingCart(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.c = context;
        init();
    }
    public void setAfterClickingList(String line) {
        clickedName.setText(line);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();

    }
    private void init(){

        LinearLayout.LayoutParams wholeScreen = new LinearLayout.LayoutParams
                (LinearLayout.LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);



        /** GIVING ADAPTER THE ARRAYLIST **/
        listAdapter.setListItems(ObjectList);

        /** INITIALIZE ITEMS YOU CAN BUY  **/
        listItems = new ListView(c);
        listItems.setAdapter(listAdapter);
        listItems.setLayoutParams(wholeScreen);

        /** INIT SHOPPINGCART ADAPTER **/
        cartAdapter.setCartItems(listAdapter.getClickedItems());
        cartAdapter.setMap(listAdapter.getMap());

        /** INIT Show ShoppingCart Button  **/
        cartButton = new Button(c);
        cartButton.setText("CECKOUT");
        cartButton.setId(R.id.cartButton);

        /** VIEW FOR ITEMS IN CART **/
        cartItems = new ListPopupWindow(c);
        cartItems.setAdapter(cartAdapter);
        cartItems.setAnchorView(this);
        /** Testing stuff **/
        clickedName = new TextView(c);
        clickedName.setId(R.id.clickedItem);
        counterView = new TextView(c);
        counterView.setId(R.id.itemsInBag);

        /** INIT "MAIN SCREEN"  **/
        this.setLayoutParams(wholeScreen);
        this.setOrientation(VERTICAL);
        this.addView(listItems);
        this.addView(clickedName);
        this.addView(counterView);
        this.addView(cartButton);





        /** Show ShoppinClart click Lisnter **/
        cartButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                showList();
                clickedName.setText("You have opened the shoppingcard");
            }
        });
    }


    public void showList(){
        listAdapter.notifyDataSetChanged();
        cartAdapter.notifyDataSetChanged();
        cartItems.dismiss();
        cartItems.show();


    }


    public void addItem(String name, int price){
        ShoppingObject  test= new ShoppingObject(name, price);
        ObjectList.add(test);

        listAdapter.notifyDataSetChanged();
    }
}