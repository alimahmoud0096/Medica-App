package com.elprog.midica.CustomViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatRadioButton;

public class MyRadioButton extends AppCompatRadioButton {
    public MyRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MyRadioButton(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    @SuppressLint("WrongConstant")
    private void init(Context context, AttributeSet attributeSet) {
        setTypeface(Typeface.createFromAsset(context.getAssets(), "Droid-Sans-Arabic.ttf"), 0);
    }
}
