package com.junjange.lotto3.MyNumber

import android.app.Application
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.widget.Toast
import com.junjange.lotto3.Lotto720Room.Lotto720Entity

import com.junjange.lotto3.MainViewModel
import com.junjange.lotto3.R
import kotlinx.android.synthetic.main.lotto720_dialog.*
import java.util.*

class Lotto720Dialog(mContext: Context) : Dialog(mContext) {
    private val viewModel: MainViewModel = MainViewModel(mContext.applicationContext as Application)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lotto720_dialog)

        // 다이얼로그의 배경을 투명으로 만든다.
        Objects.requireNonNull(window)?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        //        버튼 리스너 설정
        button720_save.setOnClickListener {
            // '확인' 버튼 클릭시 data insert
            viewModel.insert(

                Lotto720Entity(0,
                    dialog720ball0.text.toString(),
                    dialog720ball1.text.toString(),
                    dialog720ball2.text.toString(),
                    dialog720ball3.text.toString(),
                    dialog720ball4.text.toString(),
                    dialog720ball5.text.toString(),
                    dialog720ball6.text.toString() )
            )

            // Custom Dialog 종료
            dismiss()

        }
        button720_cancel.setOnClickListener {
            // '취소' 버튼 클릭시
            // Custom Dialog 종료
            dismiss()
        }

    }

}