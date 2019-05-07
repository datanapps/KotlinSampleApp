package datanapps.basicsample.ui.aboutus

import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.TextView
import datanapps.basicsample.BuildConfig
import datanapps.basicsample.R


class AboutUsActivity : AppCompatActivity(), View.OnClickListener {
    private val PRIVACY_POLICY_URL = "www.google.com"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_aboutus)
        // add back arrow to toolbar
        if (supportActionBar != null) {
            supportActionBar!!.setDisplayHomeAsUpEnabled(true)
            supportActionBar!!.setDisplayShowHomeEnabled(true)
        }

        // set app version and code
        setAppVersion()

        // set all action
        setOtherViewActions()


    }


    /*
     * Set Application Version
     * */
    private fun setAppVersion() {
        val tvVersion = findViewById<TextView>(R.id.tv_app_version)
        val version = BuildConfig.VERSION_NAME + "(" + BuildConfig.VERSION_CODE + ")"
        tvVersion.text = getString(R.string.version, version)

    }


    /*
     * Set all view actions
     * */
    private fun setOtherViewActions() {

        findViewById<View>(R.id.tv_share_this_app).setOnClickListener(this)
        findViewById<View>(R.id.tv_rate_this_app).setOnClickListener(this)
        findViewById<View>(R.id.tv_suggestions).setOnClickListener(this)
        findViewById<View>(R.id.tv_contact_us).setOnClickListener(this)
        findViewById<View>(R.id.tv_privacy_policy).setOnClickListener(this)
    }


    override fun onClick(view: View) {
        when (view.id) {

            R.id.tv_share_this_app -> shareAppDetail()

            R.id.tv_rate_this_app -> openPlayStoreForRate()

            R.id.tv_suggestions -> sendMail(getString(R.string.suggestion))
            R.id.tv_contact_us -> sendMail(getString(R.string.contact_us))
            R.id.tv_privacy_policy -> openWebView(PRIVACY_POLICY_URL)
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // handle arrow click here
        if (item.itemId == android.R.id.home) {
            finish() // close this activity and return to preview activity (if there is any)
        }

        return super.onOptionsItemSelected(item)
    }

    /*
* It will open default share app
* */
    private fun shareAppDetail() {

        val shareBody = "This is application regarding ." +
                "\n\n\n https://play.google.com/store/apps/details?id=" + packageName
        val shareSubject = getString(R.string.app_name)

        val sharingIntent = Intent(Intent.ACTION_SEND)
        sharingIntent.type = "text/plain"
        sharingIntent.putExtra(Intent.EXTRA_SUBJECT, shareSubject)
        sharingIntent.putExtra(Intent.EXTRA_TEXT, shareBody)
        startActivity(Intent.createChooser(sharingIntent, "Share via"))
    }

    /*
    *
    * Open playstore link to rate this running application
    * */
    private fun openPlayStoreForRate() {
        val uri = Uri.parse("market://details?id=$packageName")
        val goToMarket = Intent(Intent.ACTION_VIEW, uri)
        goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY or
                Intent.FLAG_ACTIVITY_NEW_DOCUMENT or
                Intent.FLAG_ACTIVITY_MULTIPLE_TASK)
        try {
            startActivity(goToMarket)
        } catch (e: ActivityNotFoundException) {
            startActivity(Intent(Intent.ACTION_VIEW,
                    Uri.parse("http://play.google.com/store/apps/details?id=$packageName")))
        }

    }


    /*
    *
    * Open mail for contact or suggestions
    *
    * */
    private fun sendMail(subject: String) {

        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "plain/text"
        intent.putExtra(Intent.EXTRA_SUBJECT, subject)
        intent.putExtra(Intent.EXTRA_TEXT, "")
        startActivity(Intent.createChooser(intent, ""))
    }

    /*
    * open webview for pass link
    *
    * */
    private fun openWebView(url: String) {
        var url = url
        if (!url.startsWith("http://") && !url.startsWith("https://")) {
            url = "http://$url"
        }
        val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(browserIntent)
    }


}
