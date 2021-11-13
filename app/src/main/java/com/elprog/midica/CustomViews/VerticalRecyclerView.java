package com.elprog.midica.CustomViews;

import android.content.Context;
import android.util.AttributeSet;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class VerticalRecyclerView extends RecyclerView {
    public VerticalRecyclerView(Context context) {
        super(context);
    }

    public VerticalRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public VerticalRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void init(Adapter<ViewHolder> adapter) {
        setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(getContext()));
        setAdapter(adapter);
    }

    public void initReversScroll(Adapter<ViewHolder> adapter) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        linearLayoutManager.setReverseLayout(true);
        linearLayoutManager.setStackFromEnd(false);
        setHasFixedSize(true);
        setLayoutManager(linearLayoutManager);
        setAdapter(adapter);
    }
}
