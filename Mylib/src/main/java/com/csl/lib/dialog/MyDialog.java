package com.csl.lib.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import com.csl.lib.R;

public abstract class MyDialog extends Dialog {


    public abstract int setLayoutRes();

    public abstract boolean isCancleable();


    public MyDialog(@NonNull Context context) {
        super(context, R.style.alert_dialog);
        setCancelable(isCancleable());
        setCanceledOnTouchOutside(false);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayoutRes());
    }
}
