package com.elprog.midica.CustomViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatCheckBox;

public class MyCheckBox extends AppCompatCheckBox {
    public MyCheckBox(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MyCheckBox(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    @SuppressLint("WrongConstant")
    private void init(Context context, AttributeSet attributeSet) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "Droid-Sans-Arabic.ttf"), 0);
    }
}
