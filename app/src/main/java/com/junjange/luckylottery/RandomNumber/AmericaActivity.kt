package com.junjange.luckylottery.RandomNumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import com.junjange.luckylottery.R
import kotlinx.android.synthetic.main.activity_america.*
import kotlinx.android.synthetic.main.activity_lotto645.number1
import kotlinx.android.synthetic.main.activity_lotto645.number2
import kotlinx.android.synthetic.main.activity_lotto645.number3
import kotlinx.android.synthetic.main.activity_lotto645.number4
import kotlinx.android.synthetic.main.activity_lotto645.number5

class AmericaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_america)

        // 타이틀 바 뒤로가기 생성
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        //메가 밀리언 랜덤 번호 생성
        val lottoNumbers = arrayListOf(number1, number2, number3, number4, number5)

        // 메가 볼 생성
        val megaNumber = arrayListOf(number7)

        // 랜덤하게 일정시간 이후에 번호를 생성
        val countDownTimer = object : CountDownTimer(3000, 100) {
            override fun onTick(p0: Long) {
                lottoNumbers.forEach {
                    val randomNumber = (Math.random() * 70 + 1).toInt()
                    it.text = "$randomNumber"
                }
                megaNumber.forEach {
                    val randomNumber = (Math.random() * 25 + 1).toInt()
                    it.text = "$randomNumber"
                }
            }
            override fun onFinish() {
            }
        }

        // 랜덤 번호 버튼을 눌렀을 때 실행되고 한번 더 누르게되면 멈춘다.
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

    // 타이틀 바 뒤로가기 했을 때 작동
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