package datanapps.basicsample.ui.splash;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import datanapps.basicsample.R;
import datanapps.basicsample.ui.home.HomeActivity;
import datanapps.basicsample.ui.login.LoginActivity;
import datanapps.basicsample.utils.Constants;
import datanapps.basicsample.utils.DNASharedPreferenceUtils;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        waitAndNavigate();
    }



    private void waitAndNavigate(){
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(DNASharedPreferenceUtils.getBoolean(Constants.IS_USER_LOGIN)) {
                    startActivity(new Intent(SplashActivity.this, HomeActivity.class));
                }
                else{
                    startActivity(new Intent(SplashActivity.this, LoginActivity.class));
                }
                finish();
            }
        }, 2000);
    }
}
