package com.elprog.midica;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.DialogFragment;

import com.elprog.midica.current.AppController;

import de.hdodenhof.circleimageview.CircleImageView;

public class FullScreenDialog extends DialogFragment {

    public static final String TAG = "FullScreenDialog";
    ImageView exit;
    Button logout_btn,online_doc_btn;
    TextView user_name_tv, user_email_tv;
    Button edit_profile_btn;
    CircleImageView user_view_sidebar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_FRAME, R.style.FullScreenDialogStyle);
    }

    @Override
    public void onStart() {
        super.onStart();

        Dialog dialog = getDialog();
        if (dialog != null) {
            int width = ViewGroup.LayoutParams.MATCH_PARENT;
            int height = ViewGroup.LayoutParams.MATCH_PARENT;
            dialog.getWindow().setLayout(width, height);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle state) {
        super.onCreateView(inflater, parent, state);

        View view = getActivity().getLayoutInflater().inflate(R.layout.dash_board_menu, parent, false);
        exit = view.findViewById(R.id.exit);
        logout_btn = view.findViewById(R.id.logout_btn);
        online_doc_btn= view.findViewById(R.id.online_doc_btn);
        online_doc_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivity().finish();
                startActivity(new Intent(getContext(), OnlineDoctorsActivity.class));
            }
        });
        user_view_sidebar= view.findViewById(R.id.user_view_sidebar);
        user_name_tv = view.findViewById(R.id.user_name_tv);
        user_email_tv = view.findViewById(R.id.user_email_tv);
        edit_profile_btn = view.findViewById(R.id.edit_profile_btn);
        edit_profile_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        logout_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (AppController.getInstance().isLoggedIn()) {
                    getActivity().finish();
                    startActivity(new Intent(getContext(), Activity_login.class));
                    AppController.getInstance().logout();
                }else{
                    getActivity().finish();
                    startActivity(new Intent(getContext(), Activity_login.class));

                }

            }
        });
        if (AppController.getInstance().isLoggedIn()) {
            logout_btn.setText("log out");
            user_name_tv.setVisibility(View.VISIBLE);
            user_name_tv.setText(AppController.getInstance().getUserName());
            user_email_tv.setVisibility(View.VISIBLE);
            user_email_tv.setText(AppController.getInstance().getUseremail());
            edit_profile_btn.setVisibility(View.VISIBLE);
            user_view_sidebar.setVisibility(View.VISIBLE);


        } else {

            logout_btn.setText("log in");
            user_view_sidebar.setVisibility(View.GONE);
            user_name_tv.setVisibility(View.GONE);
            user_email_tv.setVisibility(View.GONE);
            edit_profile_btn.setVisibility(View.GONE);

        }


        exit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getDialog().cancel();
            }
        });


        return view;
    }
}