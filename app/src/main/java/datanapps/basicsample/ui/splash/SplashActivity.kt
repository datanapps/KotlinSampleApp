package datanapps.basicsample.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import datanapps.basicsample.R
import datanapps.basicsample.ui.BaseActivity
import datanapps.basicsample.ui.home.HomeActivity
import datanapps.basicsample.ui.login.LoginActivity
import datanapps.basicsample.utils.Constants
import datanapps.basicsample.utils.DNASharedPreferenceUtils

class SplashActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        waitAndNavigate()
    }


    private fun waitAndNavigate() {
        Handler().postDelayed({
            if (DNASharedPreferenceUtils.getBoolean(Constants.IS_USER_LOGIN)) {
                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            } else {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            }
            finish()
        }, 2000)
    }
}
