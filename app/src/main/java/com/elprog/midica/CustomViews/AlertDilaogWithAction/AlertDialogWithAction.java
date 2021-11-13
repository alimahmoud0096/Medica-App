package com.elprog.midica.CustomViews.AlertDilaogWithAction;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.elprog.midica.CustomViews.C1650R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


public class AlertDialogWithAction extends DialogFragment {
    private String message;
    @SuppressLint("ResourceType")
    @BindView(2131296714)
    TextView messageTv;
    @SuppressLint("ResourceType")
    @BindView(2131296597)
    Button noBtn;
    private OnActionListner onActionListner;
    @SuppressLint("ResourceType")
    @BindView(2131296844)
    Button pdfBtn;
    private int position;
    private String title;
    @SuppressLint("ResourceType")
    @BindView(2131297108)
    TextView titleTv;
    private View view;
    @SuppressLint("ResourceType")
    @BindView(2131296409)
    Button yesBtn;

    public static AlertDialogWithAction newInstance(String str, String str2, int i) {
        AlertDialogWithAction alertDialogWithAction = new AlertDialogWithAction();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("message", str2);
        bundle.putInt("position", i);
        alertDialogWithAction.setArguments(bundle);
        return alertDialogWithAction;
    }

    @SuppressLint("WrongConstant")
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, C1650R.style.DialogStyle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        if (this.view == null) {
            View inflate = layoutInflater.inflate(C1650R.layout.open_file_selector_dialog, viewGroup, false);
            this.view = inflate;
            ButterKnife.bind((Object) this, inflate);
            init();
        }
        ButterKnife.bind((Object) this, this.view);
        return this.view;
    }

    @SuppressLint("ResourceType")
    private void init() {
        if (!(getDialog() == null || getDialog().getWindow() == null || !isAdded())) {
            getDialog().getWindow().setBackgroundDrawableResource(17170445);
            getDialog().setCanceledOnTouchOutside(false);
        }
        this.pdfBtn.setVisibility(8);
        this.yesBtn.setText(getResources().getString(C1650R.string.yes_));
        this.noBtn.setText(getResources().getString(C1650R.string.f183no));
        if (getArguments() != null && getArguments().containsKey("title")) {
            this.title = getArguments().getString("title");
            this.message = getArguments().getString("message");
            this.position = getArguments().getInt("position");
        }
        this.titleTv.setText(this.title);
        this.messageTv.setText(this.message);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            this.onActionListner = (OnActionListner) getTargetFragment();
        } catch (ClassCastException e) {
            e.getMessage();
        }
    }

    @OnClick({2131296409, 2131296597, 2131296844})
    public void onViewClicked(View view2) {
        if (getDialog() != null) {
            int id = view2.getId();
            if (id == C1650R.C1653id.camera_btn) {
                this.onActionListner.onAction(this.position, false, false, true);
                getDialog().dismiss();
            } else if (id == C1650R.C1653id.gallery_btn) {
                getDialog().dismiss();
            }
        }
    }
}
