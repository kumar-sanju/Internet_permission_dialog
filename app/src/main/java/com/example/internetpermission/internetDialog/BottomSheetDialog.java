package com.example.internetpermission.internetDialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

import com.example.internetpermission.R;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheetDialog extends BottomSheetDialogFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.bottom_sheet_layout, container, false);

        TextView closeBtn = v.findViewById(R.id.closeBtn);

        closeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                Toast.makeText(getActivity(), "Closed", Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });
        return v;
    }
}
