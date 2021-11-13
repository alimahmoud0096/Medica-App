package com.elprog.midica.CustomViews.map;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;

import com.google.android.gms.maps.GoogleMapOptions;
import com.google.android.gms.maps.MapView;

public class CustomMap extends MapView {
    private boolean canInvalidate = false;
    private ViewParent mViewParent;

    public CustomMap(Context context) {
        super(context);
    }

    public CustomMap(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CustomMap(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public CustomMap(Context context, GoogleMapOptions googleMapOptions) {
        super(context, googleMapOptions);
    }

    public void setViewParent(ViewParent viewParent) {
        this.mViewParent = viewParent;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            ViewParent viewParent = this.mViewParent;
            if (viewParent == null) {
                getParent().requestDisallowInterceptTouchEvent(true);
            } else {
                viewParent.requestDisallowInterceptTouchEvent(true);
            }
        } else if (action == 1) {
            ViewParent viewParent2 = this.mViewParent;
            if (viewParent2 == null) {
                getParent().requestDisallowInterceptTouchEvent(false);
            } else {
                viewParent2.requestDisallowInterceptTouchEvent(false);
            }
        }
        return super.onInterceptTouchEvent(motionEvent);
    }
}
