package com.androidarchitecture.learn.noteapplication.Drawing;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.androidarchitecture.learn.noteapplication.R;

public class DrawingActivity extends AppCompatActivity {

    private DrawingView drawView;
    private ImageButton currentPaint;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_drawing);

        drawView = findViewById(R.id.drawingView);
        setContentView(R.layout.activity_drawing);

        LinearLayout paintLayout = findViewById(R.id.paint_colors);
        currentPaint = (ImageButton) paintLayout.getChildAt(0);  //Сохраняем кнопку в качестве переменной
        currentPaint.setImageDrawable(getDrawable(R.drawable.paint_pressed));
    }





    public void paintClicked(View view) {
        if(view != currentPaint) {
            Log.i(currentPaint.toString(), "Current paint");
            ImageButton imageButton = (ImageButton) view;
            String color = view.getTag().toString(); //получаем тег цвета
            Log.i(color, "Paint color");

            drawView.setColor(color);

            imageButton.setImageDrawable(getDrawable(R.drawable.paint_pressed));
            currentPaint.setImageDrawable(getDrawable(R.drawable.paint));
            currentPaint =(ImageButton)view;
        }

    }

    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
    }
}
