package com.junjange.lotto3.RandomNumber

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.junjange.lotto3.Lotto720Room.Lotto720Entity
import com.junjange.lotto3.MainViewModel
import com.junjange.lotto3.R
import com.junjange.lotto3.databinding.ActivityLotto720Binding
import kotlinx.android.synthetic.main.activity_lotto645.*
import kotlinx.android.synthetic.main.activity_lotto645.number1
import kotlinx.android.synthetic.main.activity_lotto645.number2
import kotlinx.android.synthetic.main.activity_lotto645.number3
import kotlinx.android.synthetic.main.activity_lotto645.number4
import kotlinx.android.synthetic.main.activity_lotto645.number5
import kotlinx.android.synthetic.main.activity_lotto645.number6
import kotlinx.android.synthetic.main.activity_lotto720.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Lotto720Activity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLotto720Binding>(this, R.layout.activity_lotto720)
        binding.viewModel2 = viewModel

        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        baner6.loadAd(adRequest)

        // 타이틀 바 뒤로가기 생성
        supportActionBar?.setDisplayHomeAsUpEnabled(true)



        //lotto 720 랜덤 번호 생성
        val lottoNumbers = arrayListOf(number1, number2, number3, number4, number5, number6)

        val lottoJo = arrayListOf(number0)


        val countDownTimer = object : CountDownTimer(3000, 100) {
            override fun onTick(p0: Long) {
                lottoNumbers.forEach {
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

        Lotto720Button.setOnClickListener {
            if (Lotto720Button.isAnimating) {
                Lotto720Button.cancelAnimation()
                countDownTimer.cancel()
            } else {
                Lotto720Button.playAnimation()
                countDownTimer.start()

            }


        }


        Lotto720saveButton.setOnClickListener {
            Toast.makeText(this, "행운의 번호가 저장되었습니다.", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(
                    Lotto720Entity(
                        0,
                        lottoJo[0].text.toString(),
                        lottoNumbers[0].text.toString(),
                        lottoNumbers[1].text.toString(),
                        lottoNumbers[2].text.toString(),
                        lottoNumbers[3].text.toString(),
                        lottoNumbers[4].text.toString(),
                        lottoNumbers[5].text.toString(),

                        )
                )
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

