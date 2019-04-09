package datanapps.basicsample.utils;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.widget.Toast;

public class DNASnackBar {

    public static void show(Activity activity, String snackBarMsg) {

        if (activity != null) {
            Snackbar
                    .make(activity.getWindow().getDecorView().findViewById(android.R.id.content), snackBarMsg, Snackbar.LENGTH_LONG).show();

        }
    }


    /*
     * if you are passing context from some where then it will be show toast because snackbar can show only for activit
     * */
    public static void show(Context activity, String snackBarMsg) {

        if (activity != null) {
            if (activity instanceof Activity) {
                show((Activity) activity, snackBarMsg);
            } else {
                Toast.makeText(activity, snackBarMsg, Toast.LENGTH_LONG).show();
            }
        }
    }

}
