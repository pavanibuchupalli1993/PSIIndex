package com.example.psiindex.model.dialogmodel;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;

import com.example.psiindex.R;

/**
 * App Dialogs Model
 */
public class DialogModel {

    private AlertDialog dialog;

    public void displayProgressDialog(Context context, boolean isShow) {
        if (null == dialog) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setView(View.inflate(context, R.layout.progress_dialog_view, null));
            alertDialogBuilder.setCancelable(false);
            dialog = alertDialogBuilder.create();
        }
        if (isShow) {
            dialog.show();
        } else {
            dialog.dismiss();
        }
    }

    public void displayAlertDialog(Context context, String text) {

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle("Info");
        alertDialogBuilder.setMessage(text);
        alertDialogBuilder.setCancelable(true);
        alertDialogBuilder.setPositiveButton(context.getString(R.string.app_ok), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });
        alertDialogBuilder.create().show();


    }
}
