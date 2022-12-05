package com.example.bottomsheet;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheet extends BottomSheetDialogFragment {
    Button confirm, cancel;
    EditText et_username, et_password;

    CallBack callBack;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        callBack = (CallBack) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottomsheet, container, false);
        et_password = view.findViewById(R.id.editText2);
        et_username = view.findViewById(R.id.editText);
        cancel = view.findViewById(R.id.cancel_button);
        confirm = view.findViewById(R.id.confirm_button);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dismiss();
            }
        });
        confirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (et_username.length() > 0) {
                    callBack.username(et_username.getText().toString());
                    dismiss();
                }else {
                    Toast.makeText(getContext(), "username cant be empty", Toast.LENGTH_SHORT).show();
                }

            }
        });


        return view;
    }

    public interface CallBack {
        void username(String username);
    }
}
