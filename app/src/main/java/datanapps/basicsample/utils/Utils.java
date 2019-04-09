package datanapps.basicsample.utils;

import android.content.Context;
import android.content.Intent;

import datanapps.basicsample.R;

public class Utils {


    /*
     * It will open default share app
     * */
    public static void shareAppDetail(Context context){

        String shareBody = "This is application regarding ." +
                "\n\n\n https://play.google.com/store/apps/details?id=" +context.getPackageName();
        String shareSubject = context.getString(R.string.app_name);

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        context.startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }


    /*
     *
     * Open mail for contact or suggestions
     *
     * */
    public static void sendMail(Context context, String subject){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, "");
        context.startActivity(Intent.createChooser(intent, ""));
    }


}
