package com.elprog.midica.CustomViews;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class CounterView {
    private ImageView addIc;
    private int counter;
    private TextView counterTv;
    private ImageView minusIc;

    public CounterView(int i, TextView textView, ImageView imageView, ImageView imageView2) {
        this.counter = i;
        this.counterTv = textView;
        this.addIc = imageView;
        this.minusIc = imageView2;
    }

    public CounterView addOnClickListener() {
        this.addIc.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CounterView.this.lambda$addOnClickListener$0$CounterView(view);
            }
        });
        this.minusIc.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CounterView.this.lambda$addOnClickListener$1$CounterView(view);
            }
        });
        return this;
    }

    public /* synthetic */ void lambda$addOnClickListener$0$CounterView(View view) {
        handlePlus();
    }

    public /* synthetic */ void lambda$addOnClickListener$1$CounterView(View view) {
        handleMinus();
    }

    private void handleMinus() {
        if (isZero()) {
            this.counter--;
            updateCounter();
        }
    }

    private void handlePlus() {
        int i = this.counter;
        if (i != 100) {
            this.counter = i + 1;
            updateCounter();
        }
    }

    private boolean isZero() {
        return this.counter > 0;
    }

    private void updateCounter() {
        this.counterTv.setText(String.valueOf(this.counter));
    }

    public void clear() {
        this.counter = 0;
        this.counterTv = null;
        this.addIc = null;
        this.minusIc = null;
    }

    public int getCounter() {
        return this.counter;
    }

    public void setCounter(int i) {
        this.counter = i;
        updateCounter();
    }
}
