package com.junjange.lotto3.MyNumber

import android.app.Application
import android.app.Dialog
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import com.junjange.lotto3.Lotto645Room.Lotto645Entity
import com.junjange.lotto3.MainViewModel
import com.junjange.lotto3.R
import kotlinx.android.synthetic.main.lotto645_dialog.*
import java.util.*

class Lotto645Dialog(mContext: Context) : Dialog(mContext) {
    private val viewModel: MainViewModel = MainViewModel(mContext.applicationContext as Application)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lotto645_dialog)

        // 다이얼로그의 배경을 투명으로 만든다.
        Objects.requireNonNull(window)?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))



        // 버튼 리스너 설정
        button645_save.setOnClickListener {
            // '확인' 버튼 클릭시 data insert
            viewModel.insert(
                Lotto645Entity(0,
                    dialog645ball1.text.toString(),
                    dialog645ball2.text.toString(),
                    dialog645ball3.text.toString(),
                    dialog645ball4.text.toString(),
                    dialog645ball5.text.toString(),
                    dialog645ball6.text.toString() )
            )
            // Custom Dialog 종료
            dismiss()
        }
        button645_cancel.setOnClickListener {
            // '취소' 버튼 클릭시
            // Custom Dialog 종료
            dismiss()
        }

    }

}