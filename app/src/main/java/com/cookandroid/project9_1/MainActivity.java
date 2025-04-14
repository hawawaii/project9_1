package com.cookandroid.project9_1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

abstract class Shape{
    int startX = -1, startY = -1, stopX = -1, stopY = -1;

}

class Line extends Shape{

}

class Circle extends Shape{

}

class Square extends Shape{

}

public class MainActivity extends AppCompatActivity {
    final static int LINE = 1, CIRCLE = 2, SQUARE = 3;
    static int curShape = LINE;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MyGraphicView(this));
        setTitle("그림판");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        menu.add(0, 1, 0, "선 추가");
        menu.add(0, 2, 0, "원 추가");
        menu.add(0, 3, 0, "사각형 추가");
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case 1:
                curShape = LINE;
                return true;
            case 2:
                curShape = CIRCLE;
                return true;
            case 3:
                curShape = SQUARE;
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static class MyGraphicView extends View {

        ArrayList<Shape> ShapeList = new ArrayList<>();
        int startX = -1, startY = -1, stopX = -1, stopY = -1;

        public MyGraphicView(MainActivity context) {
            super(context);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    startX = (int) event.getX();
                    startY = (int) event.getY();
                    break;
                case MotionEvent.ACTION_MOVE:
                case MotionEvent.ACTION_UP:
                    stopX = (int) event.getX();
                    stopY = (int) event.getY();

                    Shape a = null;
                    switch (curShape){
                        case LINE:
                            a = new Line();
                            break;
                        case CIRCLE:
                            a = new Circle();
                            break;

                        case SQUARE:
                            a = new Square();
                            break;
                    }
                    ShapeList.add(a);

                    this.invalidate();
                    break;
            }
            return true;
        }

        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            /*
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setStrokeWidth(5);
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.RED);
            */

            switch (curShape) {
                case LINE:
                    canvas.drawLine(startX, startY, stopX, stopY, paint);
                    break;
                case CIRCLE:
                    int radius = (int) Math.sqrt(Math.pow(stopX - startX, 2) + Math.pow(stopY - startY, 2));
                    canvas.drawCircle(startX, startY, radius, paint);
                    break;
            }
        }
    }
}