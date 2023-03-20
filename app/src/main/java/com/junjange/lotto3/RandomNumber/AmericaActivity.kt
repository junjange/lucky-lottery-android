package com.junjange.lotto3.RandomNumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.junjange.lotto3.R
import kotlinx.android.synthetic.main.activity_america.*
import kotlinx.android.synthetic.main.activity_lotto645.*
import kotlinx.android.synthetic.main.activity_lotto645.number1
import kotlinx.android.synthetic.main.activity_lotto645.number2
import kotlinx.android.synthetic.main.activity_lotto645.number3
import kotlinx.android.synthetic.main.activity_lotto645.number4
import kotlinx.android.synthetic.main.activity_lotto645.number5
import kotlinx.android.synthetic.main.activity_lotto720.*

class AmericaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_america)
        // 타이틀 바 뒤로가기 생성
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        baner5.loadAd(adRequest)

        //메가 밀리언 랜덤 번호 생성
        val lottoNumbers = arrayListOf(number1, number2, number3, number4, number5)

        val lottoJo = arrayListOf(number7)


        val countDownTimer = object : CountDownTimer(3000, 100) {
            override fun onTick(p0: Long) {
                lottoNumbers.forEach {
                    val randomNumber = (Math.random() * 70 + 1).toInt()
                    it.text = "$randomNumber"
                }
                lottoJo.forEach {
                    val randomNumber = (Math.random() * 25 + 1).toInt()
                    it.text = "$randomNumber"
                }
            }
            override fun onFinish() {
            }
        }

        AmericaButton.setOnClickListener {
            if (AmericaButton.isAnimating) {
                AmericaButton.cancelAnimation()
                countDownTimer.cancel()
            } else {
                AmericaButton.playAnimation()
                countDownTimer.start()

            }


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
}