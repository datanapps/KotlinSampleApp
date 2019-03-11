package datanapps.basicsample.ui.aboutus;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import datanapps.basicsample.BuildConfig;
import datanapps.basicsample.R;


public class AboutUsActivity extends AppCompatActivity implements View.OnClickListener {
    private String PRIVACY_POLICY_URL = "www.google.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aboutus);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(getString(R.string.title_aboutus));
        setSupportActionBar(toolbar);
        // add back arrow to toolbar
        if (getSupportActionBar() != null){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        // set app version and code
        setAppVersion();

        // set all action
        setOtherViewActions();



    }


    /*
     * Set Application Version
     * */
    private void setAppVersion() {
        TextView tvVersion = findViewById(R.id.tv_app_version);
        String version = BuildConfig.VERSION_NAME + "(" + BuildConfig.VERSION_CODE + ")";
        tvVersion.setText(getString(R.string.version, version));

    }


    /*
     * Set all view actions
     * */
    private void setOtherViewActions() {

        findViewById(R.id.tv_share_this_app).setOnClickListener(this);
        findViewById(R.id.tv_rate_this_app).setOnClickListener(this);
        findViewById(R.id.tv_suggestions).setOnClickListener(this);
        findViewById(R.id.tv_contact_us).setOnClickListener(this);
        findViewById(R.id.tv_privacy_policy).setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){

            case R.id.tv_share_this_app : shareAppDetail(); break;

            case R.id.tv_rate_this_app : openPlayStoreForRate(); break;

            case R.id.tv_suggestions : sendMail(getString(R.string.suggestion)); break;
            case R.id.tv_contact_us : sendMail(getString(R.string.contact_us)); break;
            case R.id.tv_privacy_policy : openWebView(PRIVACY_POLICY_URL); break;


        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish(); // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item);
    }

/*
* It will open default share app
* */
    private void shareAppDetail(){

        String shareBody = "This is application regarding ." +
                "\n\n\n https://play.google.com/store/apps/details?id=" +getPackageName();
        String shareSubject = getString(R.string.app_name);

        Intent sharingIntent = new Intent(Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject);
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share via"));
    }

    /*
    *
    * Open playstore link to rate this running application
    * */
    private void openPlayStoreForRate(){
        Uri uri = Uri.parse("market://details?id=" + getPackageName());
        Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
        try {
            startActivity(goToMarket);
        } catch (ActivityNotFoundException e) {
            startActivity(new Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=" + getPackageName())));
        }
    }


    /*
    *
    * Open mail for contact or suggestions
    *
    * */
    private void sendMail(String subject){

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("plain/text");
        intent.putExtra(Intent.EXTRA_SUBJECT, subject);
        intent.putExtra(Intent.EXTRA_TEXT, "");
        startActivity(Intent.createChooser(intent, ""));
    }

    /*
    * open webview for pass link
    *
    * */
    private void openWebView(String url) {
        if (!url.startsWith("http://") && !url.startsWith("https://")){
            url = "http://" + url;
        }
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
        startActivity(browserIntent);
    }





}
