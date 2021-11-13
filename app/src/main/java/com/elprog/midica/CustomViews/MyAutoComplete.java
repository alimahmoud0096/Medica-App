package com.elprog.midica.CustomViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatAutoCompleteTextView;

public class MyAutoComplete extends AppCompatAutoCompleteTextView {
    public MyAutoComplete(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context, attributeSet);
    }

    public MyAutoComplete(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context, attributeSet);
    }

    @SuppressLint("WrongConstant")
    private void init(Context context, AttributeSet attributeSet) {
        setPadding((int) (context.getResources().getDisplayMetrics().density * 5.0f), 0, (int) (context.getResources().getDisplayMetrics().density * 5.0f), 0);
        setTypeface(Typeface.createFromAsset(context.getAssets(), "Droid-Sans-Arabic.ttf"), 0);
    }
}
