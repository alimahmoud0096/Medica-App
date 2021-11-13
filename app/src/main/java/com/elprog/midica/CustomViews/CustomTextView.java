package com.elprog.midica.CustomViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class CustomTextView extends TextView {
    public boolean addStrike = false;
    public Paint paint;

    public CustomTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public CustomTextView(Context context) {
        super(context);
        init(context);
    }

    public CustomTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    private void init(Context context) {
        Paint paint2 = new Paint();
        this.paint = paint2;
        paint2.setColor(context.getResources().getColor(C1650R.C1651color.dodger_blue));
        this.paint.setStrokeWidth(getResources().getDisplayMetrics().density * 1.0f);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.addStrike) {
            canvas.drawLine(0.0f, (float) (getHeight() / 2), (float) getWidth(), (float) (getHeight() / 2), this.paint);
        }
    }
}
