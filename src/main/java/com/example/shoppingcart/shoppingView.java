package com.example.shoppingcart;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class shoppingView extends View {
    Context c;
    Paint myPaint;
    String name;
    int number;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Context getC() {
        return c;
    }

    public void setC(Context c) {
        this.c = c;
    }

    public Paint getMyPaint() {
        return myPaint;
    }

    public void setMyPaint(Paint myPaint) {
        this.myPaint = myPaint;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    int price;

    public shoppingView(Context context) {
        super(context);
        this.c = context;
        init();
    }

    public shoppingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.c = context;
        init();
    }

    public shoppingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.c = context;
        init();
    }

    public shoppingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        this.c = context;
        init();
    }
    private void init(){
        super.setBackgroundColor(Color.TRANSPARENT);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        //super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension(1000,190);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        myPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        myPaint.setColor(Color.BLACK);
        myPaint.setTextSize(55);
        canvas.drawText(name + " Pris: " + price + " Antal: " + number,0,60,myPaint);
        canvas.drawText("Total summa: " + price*number,0,140, myPaint);
    }
}
