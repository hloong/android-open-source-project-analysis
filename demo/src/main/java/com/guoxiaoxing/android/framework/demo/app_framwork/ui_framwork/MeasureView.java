package com.guoxiaoxing.android.framework.demo.app_framwork.ui_framwork;

import android.app.Activity;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * For more information, you can visit https://github.com/guoxiaoxing or contact me by
 * guoxiaoxingse@163.com
 *
 * @author guoxiaoxing
 * @since 2017/10/26 下午3:02
 */
public class MeasureView extends View {

    private static final String TAG = "MeasureView";

    private Paint mPaint;
    private int mScrrenWidth;
    private int mScreenHeight;

    public MeasureView(Context context) {
        super(context);
        setup(context);
    }

    public MeasureView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setup(context);
    }

    public MeasureView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setup(context);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        Log.d(TAG, "widthMeasureSpec = " + widthMeasureSpec + " heightMeasureSpec = " + heightMeasureSpec);

        //指定一组默认宽高，至于具体的值是多少，这就要看你希望在wrap_cotent模式下
        //控件的大小应该设置多大了
        int mWidth = 200;
        int mHeight = 200;

        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);

        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);

        if (widthSpecMode == MeasureSpec.AT_MOST && heightMeasureSpec == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, mHeight);
        } else if (widthSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(mWidth, heightSpecSize);
        } else if (heightSpecMode == MeasureSpec.AT_MOST) {
            setMeasuredDimension(widthSpecSize, mHeight);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(0, 0, 100, mPaint);
    }

    private void setup(Context context) {

        Rect rect = new Rect();
        ((Activity) context).getWindowManager().getDefaultDisplay().getRectSize(rect);
        mScrrenWidth = rect.width();
        mScreenHeight = rect.height();

        mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
    }
}
