package com.junjange.lotto3

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.util.Base64
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.zxing.integration.android.IntentIntegrator
import com.junjange.lotto3.QRcode.QRcodeActivity
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*
import java.lang.Exception
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException


class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.P)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContentView(R.layout.activity_main)
        //탭바 시작
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home,
                R.id.navigation_randomnumber,
                R.id.navigation_news,
                R.id.navigation_mynumber
            )
        )
        setupActionBarWithNavController(navController, appBarConfiguration) // 액션바 이름 설정?
        navView.setupWithNavController(navController)
        //탭바 끝

//        configureBottomNavigation()

    }

    //액션버튼 메뉴 액션바에 띄움.
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
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
                //QR코드 액티비티로 연결
                var qrcord = Intent(this@MainActivity, QRcodeActivity::class.java)
                qrcord.putExtra("QrCordUrl", result.contents)
                startActivity(qrcord)
                //토스트를 띄운다.

                Toast.makeText(this, "scanned" + result.contents, Toast.LENGTH_LONG).show()

            }
            // 결과가 없으면
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.QRcode -> {

                val integrator = IntentIntegrator(this)
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
                integrator.setPrompt("QR 코드를 스캔하여 주세요:)")
                integrator.setCameraId(0)
                integrator.setBeepEnabled(true)
                integrator.setBarcodeImageEnabled(false)
                integrator.initiateScan()
                return super.onOptionsItemSelected(item)

            }

            else -> return super.onOptionsItemSelected(item)
        }
    }

}


