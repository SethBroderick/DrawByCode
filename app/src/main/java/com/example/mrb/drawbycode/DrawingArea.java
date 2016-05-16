package com.example.mrb.drawbycode;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by mrb on 16-04-26.
 */
public class DrawingArea extends View // You need to extend the View class
{
    boolean blnShowText;
    int intTextPosition;

    Paint pntTextPaint;     // Painting object to handle the paint jobs for text
    Paint pntBlackPaint;    // Painting object to handle the paint jobs for graphics
    Paint pntRedPaint;      // Painting object to handle the paint jobs for graphics

    public DrawingArea(Context context, AttributeSet attrs)
    {
        super(context, attrs);

        TypedArray a = context.getTheme().obtainStyledAttributes(
                attrs,
                R.styleable.DrawingArea,
                0, 0);

        try {
            blnShowText = a.getBoolean(R.styleable.DrawingArea_displayText, false);
            intTextPosition = a.getInteger(R.styleable.DrawingArea_labelPosition, 0);
        } finally {
            a.recycle();
        }

        init(); // Calling the init() method happens once, when we set up our Paint objects
    }

    private void init()
    {
        // This method is called once when the DrawingArea object is made.
        // It is best practice to handle the set-up of our Paint objects here rather than in onDraw()
        // Colours used for stickman

        pntTextPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntBlackPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        pntRedPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        pntBlackPaint.setColor(Color.BLACK);
        pntBlackPaint.setStrokeWidth(3);

        pntRedPaint.setColor(Color.RED);
        pntRedPaint.setStrokeWidth(3);





    }

    protected void onSizeChanged(int w, int h, int oldw, int oldh)
    {
        // This method exists to handle re-drawing of the DrawingArea object in the event of a
        //   resize of our App. For example, tilting the device may require us to redraw our content.
        // More instructions are meant to be added at the bottom if required.

        super.onSizeChanged(w, h, oldw, oldh);

    }

    protected void onDraw(Canvas canvas)
    {
        // This method is where we issue our actual drawing commands.
        // The Canvas parameter is what we draw ON; the Paint objects defined above are what we draw WITH.
        // Stickman sizes

        super.onDraw(canvas);

         canvas.drawCircle((float) 100.0, (float) 100.0, (float) 100.0, pntBlackPaint);

        canvas.drawRect((float) 350.0, (float) 400.0, (float) 350.0, (float) 400.0, pntBlackPaint);

        canvas.drawRect((float) 253.0, (float) 200.0, (float) 253.0, (float) 200.0, pntBlackPaint);

        canvas.drawRect((float) 253.0, (float) 153.0, (float) 253.0, (float) 153.0, pntBlackPaint);

        canvas.drawRect((float) 100.0, (float) 200.0, (float) 100.0, (float) 200.0, pntBlackPaint);

        canvas.drawRect((float) 100.0, (float) 200.0, (float) 100.0, (float) 200.0, pntBlackPaint);



    }


}
