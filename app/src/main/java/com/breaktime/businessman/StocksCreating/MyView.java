package com.breaktime.businessman.StocksCreating;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.DisplayMetrics;
import android.view.View;

public class MyView extends View {

    Canvas canvas;
    Paint mPaint;
    int[][] points;
    int price;

    public MyView(Context context, int[][] points) {
        super(context);

        this.points = points;

        mPaint = new Paint();
        mPaint.setAntiAlias(true);

        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(3);

        DisplayMetrics displayMetrics = new DisplayMetrics();

        ((Activity) getContext()).getWindowManager()
                .getDefaultDisplay()
                .getMetrics(displayMetrics);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        this.canvas = canvas;

        checkPoints();
        canvas.drawLine(points[0][0], points[0][0], points[0][0], 500, mPaint);
        for(int i = 50 + points[0][0]; i < 500; i += 50){
            mPaint.setStrokeWidth(1);
            canvas.drawLine(points[0][0], i, 1000, i, mPaint);
            mPaint.setStrokeWidth(2);
            mPaint.setTextSize(30);
            canvas.drawText("" + 140, 10, i + 7, mPaint);
        }

        for (int i = 0; i < points.length - 1; i++){
            System.out.println(i);
            mPaint.setStrokeWidth(10);
            mPaint.setColor(Color.parseColor("#FF0890DD"));
            canvas.drawCircle(points[i][0], points[i][1], 2, mPaint);
            mPaint.setColor(Color.BLUE);
            mPaint.setStrokeWidth(3);
            canvas.drawLine(points[i][0], points[i][1], points[i + 1][0], points[i + 1][1], mPaint);
            mPaint.setStrokeWidth(10);
            mPaint.setColor(Color.parseColor("#FF0890DD"));
            canvas.drawCircle(points[points.length - 1][0], points[points.length - 1][1], 2, mPaint);
            mPaint.setColor(Color.BLUE);
        }
    }

    public void checkPoints() {
        boolean flag = false;
        for (int i = 0; i < points.length; i++) {
            if (points[i][1] > 500) {
                System.out.println(points[i][1]);
                flag = true;
            }
        }
        if(flag){
            for(int i = 0; i < points.length; i++){
                points[i][1] -= 200;
                price -= 0;
                }
            }
    }
}
