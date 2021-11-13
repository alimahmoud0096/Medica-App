package com.elprog.midica.CustomViews.AlertDilaogWithAction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.elprog.midica.CustomViews.C1650R;

import butterknife.ButterKnife;


public class AlertDialog extends DialogFragment implements View.OnClickListener {
    private ImageView imageView;
    private AlertDialogLisenter lisnter;
    private TextView messageTv;
    private TextView titleTv;
    private View view;

    public static AlertDialog newInstance(String str, String str2, int i) {
        AlertDialog alertDialog = new AlertDialog();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("message", str2);
        bundle.putInt("img", i);
        alertDialog.setArguments(bundle);
        return alertDialog;
    }

    @SuppressLint("WrongConstant")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, C1650R.style.DialogStyle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.view == null) {
            View inflate = layoutInflater.inflate(C1650R.layout.alert_dialog, viewGroup, false);
            this.view = inflate;
            ButterKnife.bind((Object) this, inflate);
            init();
        }
        return this.view;
    }

    @SuppressLint("ResourceType")
    private void init() {
        if (!(getDialog() == null || getDialog().getWindow() == null || !isAdded())) {
            getDialog().getWindow().setBackgroundDrawableResource(17170445);
            getDialog().setCanceledOnTouchOutside(true);
        }
        this.imageView = (ImageView) this.view.findViewById(C1650R.C1653id.img);
        this.titleTv = (TextView) this.view.findViewById(C1650R.C1653id.title_tv);
        this.messageTv = (TextView) this.view.findViewById(C1650R.C1653id.message_tv);
        ((Button) this.view.findViewById(C1650R.C1653id.dismiss_btn)).setOnClickListener(this);
        ((Button) this.view.findViewById(C1650R.C1653id.okay_btn)).setOnClickListener(this);
        checkArgs();
    }

    private void setData(String str, String str2, int i) {
        try {
            this.titleTv.setText(str);
            this.messageTv.setText(str2);
            this.imageView.setImageDrawable(getResources().getDrawable(i));
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }

    private void checkArgs() {
        if (getArguments() != null && getArguments().containsKey("message") && getArguments().containsKey("title")) {
            setData(getArguments().getString("title"), getArguments().getString("message"), getArguments().getInt("img"));
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.lisnter = (AlertDialogLisenter) getTargetFragment();
        } catch (ClassCastException e) {
            e.getMessage();
        }
    }

    public void onDetach() {
        super.onDetach();
        this.lisnter = null;
    }

    public void onClick(View view2) {
        if (getDialog() != null) {
            getDialog().dismiss();
        }
        if (view2.getId() == C1650R.C1653id.okay_btn) {
            this.lisnter.onAlertDialogActionOk();
        }
        if (view2.getId() == C1650R.C1653id.dismiss_btn) {
            this.lisnter.onAlertDialogActionDismiss();
        }
    }
}
