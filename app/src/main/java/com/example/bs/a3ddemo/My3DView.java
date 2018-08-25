package com.example.bs.a3ddemo;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by bs on 18-8-23.
 */

public class My3DView extends ViewGroup {
    //容器的宽高
    private int mWidth;
    private int mHeight;

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childTop = 0;
        for (int i = 0; i < getChildCount(); i++) {
            View child = getChildAt(i);
            if (child.getVisibility() != GONE) {
                child.layout(0, childTop,
                        child.getMeasuredWidth(), childTop + child.getMeasuredHeight());
                childTop = childTop + child.getMeasuredHeight();
            }
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        mWidth = getMeasuredWidth();
        mHeight = getMeasuredHeight();
    }


    public My3DView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    //
    @Override
    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
    }
}
