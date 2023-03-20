package com.junjange.lotto3.RandomNumber

import android.os.Bundle
import android.os.CountDownTimer
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.lifecycleScope
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.junjange.lotto3.Lotto645Room.Lotto645Entity
import com.junjange.lotto3.MainViewModel
import com.junjange.lotto3.MyNumber.Lotto645Dialog
import com.junjange.lotto3.R
import com.junjange.lotto3.databinding.ActivityLotto645Binding
import kotlinx.android.synthetic.main.activity_lotto645.*
import kotlinx.android.synthetic.main.activity_q_rcode.*
import kotlinx.android.synthetic.main.fragment_lotto645_number.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class Lotto645Activity : AppCompatActivity() {
    private val viewModel: MainViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityLotto645Binding>(this, R.layout.activity_lotto645)
        binding.viewModel = viewModel

        MobileAds.initialize(this) {}
        val adRequest = AdRequest.Builder().build()
        baner4.loadAd(adRequest)

        // 타이틀 바 뒤로가기 생성
        supportActionBar?.setDisplayHomeAsUpEnabled(true)


        //Lotto 645 랜덤 번호 생성
        val lottoNumbers = arrayListOf(number1, number2, number3, number4, number5, number6)


        val countDownTimer = object : CountDownTimer(3000, 100) {
            override fun onTick(p0: Long) {

                var i=0

                while (i<6){
                    val randomNumber = (Math.random() * 45 + 1).toInt()
                    lottoNumbers[i].text = "$randomNumber"

                    var j=0
                    while (j<i){

                        if (lottoNumbers[j].text == randomNumber.toString())
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

        Lotto645Button.setOnClickListener {
            if (Lotto645Button.isAnimating) {
                Lotto645Button.cancelAnimation()
                countDownTimer.cancel()
            } else {
                Lotto645Button.playAnimation()
                countDownTimer.start()

            }


        }

        Lotto645saveButton.setOnClickListener {
            Toast.makeText(this, "행운의 번호가 저장되었습니다.", Toast.LENGTH_SHORT).show()
            lifecycleScope.launch(Dispatchers.IO) {
                viewModel.insert(
                    Lotto645Entity(
                        0,
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

