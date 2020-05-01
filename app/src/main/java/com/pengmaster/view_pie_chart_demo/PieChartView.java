package com.pengmaster.view_pie_chart_demo;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

import androidx.annotation.Nullable;

/**
 * <pre>
 *     author : Wp
 *     e-mail : 1101313414@qq.com
 *     time   : 2020-05-01 16:21
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class PieChartView extends View {

    private Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private RectF rectF;
    private static float RADIUS = px2dp(100);

    public PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);

    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        float width = getWidth() / 2f;
        float height = getHeight() / 2f;
        rectF = new RectF(width - RADIUS , height  -RADIUS ,
                width  +RADIUS , height  + RADIUS);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.save();
        // 第一个扇形偏移出去
        int transLength = 40;
        float dx = (float) Math.cos(Math.toRadians(30)) * transLength;
        float dy = (float) Math.sin(Math.toRadians(30)) * transLength;
        canvas.translate(dx,dy);
        paint.setColor(Color.CYAN);
        canvas.drawArc(rectF,0,60,true,paint);
        canvas.restore();

        paint.setColor(Color.MAGENTA);
        canvas.drawArc(rectF,60,60,true,paint);

        paint.setColor(Color.DKGRAY);
        canvas.drawArc(rectF,120,120,true,paint);

        paint.setColor(Color.LTGRAY);
        canvas.drawArc(rectF,240,120,true,paint);
    }
    private static float px2dp(float value) {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value,
                Resources.getSystem().getDisplayMetrics());
    }
}
