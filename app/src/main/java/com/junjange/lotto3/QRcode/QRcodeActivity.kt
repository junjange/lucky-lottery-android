package com.junjange.lotto3.QRcode

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.webkit.WebViewClient
import android.widget.Toast
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd
import com.google.android.gms.ads.MobileAds
import com.google.zxing.integration.android.IntentIntegrator
import com.junjange.lotto3.R
import kotlinx.android.synthetic.main.activity_q_rcode.*
import kotlinx.android.synthetic.main.fragment_home.*

class QRcodeActivity : AppCompatActivity() {
    private lateinit var mInterstitialAd: InterstitialAd
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_q_rcode)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-8474199369670344/2488500145"
        mInterstitialAd.loadAd(AdRequest.Builder().build())
        // 타이틀 바 뒤로가기 생성
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        button.setOnClickListener {
            if (mInterstitialAd.isLoaded) {
                mInterstitialAd.show()

            } else {
                Log.d("TAG", "The interstitial wasn't loaded yet.")
            }
            val integrator = IntentIntegrator(this)
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            integrator.setPrompt("QR 코드를 스캔하여 주세요:)")
            integrator.setCameraId(0)
            integrator.setBeepEnabled(true)
            integrator.setBarcodeImageEnabled(false)
            integrator.initiateScan()


        }

        var secondIntent = getIntent();
        var result = secondIntent.getStringExtra("QrCordUrl");



        Toast.makeText(this, "scanned" + result, Toast.LENGTH_LONG).show()

        //웹뷰 설정
        web_view.settings.javaScriptEnabled = true
        web_view.webViewClient = WebViewClient()

        //웹뷰를 띄운다.
        web_view.loadUrl(result.toString())
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        //QR코드를 찍은 결과를 변수에 담는다.
        val result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
        //결과가 있으면
        if (result != null) {
            // 컨텐츠가 없으면
            if (result.contents == null) {
                //토스트를 띄운다.
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show()
            }
            // 컨텐츠가 있으면
            else {
                //토스트를 띄운다.
                Toast.makeText(this, "scanned" + result.contents, Toast.LENGTH_LONG).show()

                //웹뷰 설정
                web_view.settings.javaScriptEnabled = true
                web_view.webViewClient = WebViewClient()

                //웹뷰를 띄운다.
                web_view.loadUrl(result.contents)
            }
            // 결과가 없으면
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    // 타이틀 바 뒤로가기 했을 때 작동하게 하는 코드
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val id = item.itemId
        when (id) {
            android.R.id.home -> {
                finish()
                return true
            }

        }
        return super.onOptionsItemSelected(item)

    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }


}