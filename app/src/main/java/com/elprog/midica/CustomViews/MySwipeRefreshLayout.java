package com.elprog.midica.CustomViews;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;

import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

public class MySwipeRefreshLayout extends SwipeRefreshLayout {
    @SuppressLint("ResourceType")
    public MySwipeRefreshLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setColorSchemeResources(17170444, 17170457, 17170451);
    }

    public void stopRefresh() {
        if (isRefreshing()) {
            setRefreshing(false);
        }
    }

    public void enable() {
        if (!isEnabled()) {
            setEnabled(true);
        }
    }

    public void disable() {
        if (isEnabled()) {
            setEnabled(false);
        }
    }
}
