package com.elprog.midica.CustomViews.AlertDilaogWithAction;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.elprog.midica.CustomViews.C1650R;

import butterknife.Unbinder;
import butterknife.internal.DebouncingOnClickListener;
import butterknife.internal.Utils;


public class AlertDialogWithAction_ViewBindingg implements Unbinder {
    private AlertDialogWithAction target;
    private View view7f090099;
    private View view7f090155;
    private View view7f09024c;

    public AlertDialogWithAction_ViewBindingg(final AlertDialogWithAction alertDialogWithAction, View view) {
        this.target = alertDialogWithAction;
        alertDialogWithAction.titleTv = (TextView) Utils.findRequiredViewAsType(view, C1650R.C1653id.title_tv, "field 'titleTv'", TextView.class);
        alertDialogWithAction.messageTv = (TextView) Utils.findRequiredViewAsType(view, C1650R.C1653id.message_tv, "field 'messageTv'", TextView.class);
        View findRequiredView = Utils.findRequiredView(view, C1650R.C1653id.camera_btn, "field 'yesBtn' and method 'onViewClicked'");
        alertDialogWithAction.yesBtn = (Button) Utils.castView(findRequiredView, C1650R.C1653id.camera_btn, "field 'yesBtn'", Button.class);
        this.view7f090099 = findRequiredView;
        findRequiredView.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                alertDialogWithAction.onViewClicked(view);
            }
        });
        View findRequiredView2 = Utils.findRequiredView(view, C1650R.C1653id.gallery_btn, "field 'noBtn' and method 'onViewClicked'");
        alertDialogWithAction.noBtn = (Button) Utils.castView(findRequiredView2, C1650R.C1653id.gallery_btn, "field 'noBtn'", Button.class);
        this.view7f090155 = findRequiredView2;
        findRequiredView2.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                alertDialogWithAction.onViewClicked(view);
            }
        });
        View findRequiredView3 = Utils.findRequiredView(view, C1650R.C1653id.pdf_btn, "field 'pdfBtn' and method 'onViewClicked'");
        alertDialogWithAction.pdfBtn = (Button) Utils.castView(findRequiredView3, C1650R.C1653id.pdf_btn, "field 'pdfBtn'", Button.class);
        this.view7f09024c = findRequiredView3;
        findRequiredView3.setOnClickListener(new DebouncingOnClickListener() {
            public void doClick(View view) {
                alertDialogWithAction.onViewClicked(view);
            }
        });
    }

    public void unbind() {
        AlertDialogWithAction alertDialogWithAction = this.target;
        if (alertDialogWithAction != null) {
            this.target = null;
            alertDialogWithAction.titleTv = null;
            alertDialogWithAction.messageTv = null;
            alertDialogWithAction.yesBtn = null;
            alertDialogWithAction.noBtn = null;
            alertDialogWithAction.pdfBtn = null;
            this.view7f090099.setOnClickListener((View.OnClickListener) null);
            this.view7f090099 = null;
            this.view7f090155.setOnClickListener((View.OnClickListener) null);
            this.view7f090155 = null;
            this.view7f09024c.setOnClickListener((View.OnClickListener) null);
            this.view7f09024c = null;
            return;
        }
        throw new IllegalStateException("Bindings already cleared.");
    }
}
