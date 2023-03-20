package com.junjange.lotto3.ui.news

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.GeolocationPermissions
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.junjange.lotto3.R
import kotlinx.android.synthetic.main.fragment_news.*


class NewsFragment : Fragment() {
    private val MY_PERMISSION_REQUEST_LOCATION = 0

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View? {
            return inflater.inflate(R.layout.fragment_news, container, false)

        }

override fun onResume() {
    super.onResume()

            permissionCheck()// 위치권한 체크
            web_view.settings.javaScriptEnabled = true
            web_view.webViewClient = WebViewClient()
            web_view.loadUrl("https://m.map.kakao.com/actions/searchView?q=%EB%B3%B5%EA%B6%8C&lvl=4")

}
    private fun initWebView() {

        web_view.setWebChromeClient(object : WebChromeClient() {
            override fun onGeolocationPermissionsShowPrompt(
                origin: String,
                callback: GeolocationPermissions.Callback

            ) {
                super.onGeolocationPermissionsShowPrompt(origin, callback)

                callback.invoke(origin, true, false)


            }
        })

    }
    private fun permissionCheck() {
        if (activity?.let {
                ContextCompat.checkSelfPermission(
                    it,
                    Manifest.permission.ACCESS_FINE_LOCATION
                )
            } == PackageManager.PERMISSION_GRANTED
        ) {
            //Manifest.permission.ACCESS_FINE_LOCATION 접근 승낙 상태 일때
            initWebView()

        } else {
            //Manifest.permission.ACCESS_FINE_LOCATION 접근 거절 상태 일때
            //사용자에게 접근권한 설정을 요구하는 다이얼로그를 띄운다.
            activity?.let {
                ActivityCompat.requestPermissions(
                    it,
                    arrayOf(Manifest.permission.ACCESS_FINE_LOCATION),
                    MY_PERMISSION_REQUEST_LOCATION
                )
            }
        }
    }
    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String?>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode == MY_PERMISSION_REQUEST_LOCATION) {
            initWebView()
        }
    }
}






