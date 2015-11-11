package com.zhangqi.autohomerefreshlistview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by zhangqi on 15/10/27.
 */
public class PointerView extends View {
    private int x;
    private int y;
    private Bitmap finalPointerBitmap;
    private Bitmap pointerBitmap;
    public PointerView(Context context) {
        super(context);
        init();
    }

    public PointerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public PointerView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        pointerBitmap = Bitmap.createBitmap(BitmapFactory.decodeResource(getResources(), R.drawable.load_icon_pointer2x));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        setMeasuredDimension(measureWidth(widthMeasureSpec), measureHeight(heightMeasureSpec));
    }

    private int measureWidth(int widthMeasureSpec){
        int result = 0;
        int size = MeasureSpec.getSize(widthMeasureSpec);
        int mode = MeasureSpec.getMode(widthMeasureSpec);
        if (mode == MeasureSpec.EXACTLY){
            result = size;
        }else{
            result = pointerBitmap.getWidth();
            if (mode == MeasureSpec.AT_MOST){
                result = Math.min(result,size);
            }
        }
        return result;
    }
    private int measureHeight(int heightMeasureSpec){
        int result = 0;
        int size = MeasureSpec.getSize(heightMeasureSpec);
        int mode = MeasureSpec.getMode(heightMeasureSpec);
        if (mode == MeasureSpec.EXACTLY){
            result = size;
        }else{
            result = pointerBitmap.getHeight();
            if (mode == MeasureSpec.AT_MOST){
                result = Math.min(result,size);
            }
        }
        return result;
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        x = w;
        y = h;
        finalPointerBitmap = Bitmap.createScaledBitmap(pointerBitmap, x, y, true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.rotate(270,x/2,y/2);
        canvas.drawBitmap(finalPointerBitmap,0,0,null);
    }
}
