package com.junjange.luckylottery

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.junjange.luckylottery.RandomNumber.AmericaActivity
import com.junjange.luckylottery.RandomNumber.Lotto645Activity
import com.junjange.luckylottery.RandomNumber.Lotto720Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // 로또6/45 연결
        Lotto645.setOnClickListener {

                val intent = Intent(this, Lotto645Activity::class.java)

                startActivity(intent)

        }

        // 연금복권 720+ 연결
        Lotto720.setOnClickListener {

                val intent = Intent(this, Lotto720Activity::class.java)

                startActivity(intent)

        }

        // 메가밀리언 연결
        America.setOnClickListener {

                val intent = Intent(this, AmericaActivity::class.java)

                startActivity(intent)

        }
    }
}