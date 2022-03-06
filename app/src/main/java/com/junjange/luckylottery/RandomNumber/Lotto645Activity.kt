package com.junjange.luckylottery.RandomNumber

import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem

import androidx.appcompat.app.AppCompatActivity
import com.junjange.luckylottery.R

import kotlinx.android.synthetic.main.activity_lotto645.*


class Lotto645Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lotto645)
        // 타이틀 바 뒤로가기 생성
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //Lotto 645 랜덤 번호 생성
        val lotto645Numbers = arrayListOf(number1, number2, number3, number4, number5, number6)

        // 랜덤하게 일정시간 이후에 번호를 생성
        // 단, 중복이 되면 안된다.
        val countDownTimer = object : CountDownTimer(3000, 100) {
            override fun onTick(p0: Long) {

                var i = 0

                while (i < 6){
                    val randomNumber = (Math.random() * 45 + 1).toInt()
                    lotto645Numbers[i].text = "$randomNumber"

                    var j = 0
                    while (j < i){

                        if (lotto645Numbers[j].text == randomNumber.toString())
                        {
                            i--
                        }
                        j++
                    }
                    i++
                }
            }
            override fun onFinish() {
            }
        }

        // 랜덤 번호 버튼을 눌렀을 때 실행되고 한번 더 누르게되면 멈춘다.
        Lotto645Button.setOnClickListener {
            if (Lotto645Button.isAnimating) {
                Lotto645Button.cancelAnimation()
                countDownTimer.cancel()
            } else {
                Lotto645Button.playAnimation()
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

