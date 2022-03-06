package com.junjange.luckylottery.RandomNumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import com.junjange.luckylottery.R
import kotlinx.android.synthetic.main.activity_lotto645.number1
import kotlinx.android.synthetic.main.activity_lotto645.number2
import kotlinx.android.synthetic.main.activity_lotto645.number3
import kotlinx.android.synthetic.main.activity_lotto645.number4
import kotlinx.android.synthetic.main.activity_lotto645.number5
import kotlinx.android.synthetic.main.activity_lotto645.number6
import kotlinx.android.synthetic.main.activity_lotto720.*


class Lotto720Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotto720)

        // 타이틀 바 뒤로가기 생성
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //lotto 720 랜덤 번호 생성
        val lotto720Numbers = arrayListOf(number1, number2, number3, number4, number5, number6)

        // lotto 720 조 번호 생성
        val lottoJo = arrayListOf(number0)

        // 랜덤하게 일정시간 이후에 번호를 생성
        val countDownTimer = object : CountDownTimer(3000, 100) {
            override fun onTick(p0: Long) {
                lotto720Numbers.forEach {
                    val randomNumber = (Math.random() * 9 ).toInt()
                    it.text = "$randomNumber"
                }
                lottoJo.forEach {
                    val randomNumber = (Math.random() * 5 + 1).toInt()
                    it.text = "$randomNumber"
                }
            }
            override fun onFinish() {
            }
        }
        // 랜덤 번호 버튼을 눌렀을 때 실행되고 한번 더 누르게되면 멈춘다.
        Lotto720Button.setOnClickListener {
            if (Lotto720Button.isAnimating) {
                Lotto720Button.cancelAnimation()
                countDownTimer.cancel()
            } else {
                Lotto720Button.playAnimation()
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

