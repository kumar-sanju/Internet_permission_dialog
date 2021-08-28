package com.example.internetpermission.internetDialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.internetpermission.R;

public class InternetDialogActivity extends AppCompatActivity {

    @Override
    protected void onStart() {
        super.onStart();
        isNetworkConnectionAvailable();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_internet_dialog);

    }

    public void checkNetworkConnection(){

        AlertDialog.Builder builder =new AlertDialog.Builder(this);
        builder.setIcon(android.R.drawable.ic_dialog_alert);
        builder.setTitle("No internet Connection");
        builder.setMessage("Please turn on internet connection to continue");
        builder.setNegativeButton("close", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    public boolean isNetworkConnectionAvailable() {
        ConnectivityManager cm = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnected();
        if(isConnected) {
            Toast.makeText(InternetDialogActivity.this, "Welcome", Toast.LENGTH_LONG).show();
            Log.d("Network", "Connected");
            return true;
        }
        else{
            BottomSheetDialog bottomSheet = new BottomSheetDialog();
            bottomSheet.show(getSupportFragmentManager(), "ModalBottomSheet");

//            checkNetworkConnection();
            Log.d("Network","Not Connected");
            return false;
        }
    }

}