package com.junjange.lotto3.ui.home


import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.junjange.lotto3.MainViewModel
import com.junjange.lotto3.R
import kotlinx.android.synthetic.main.fragment_home.*
import org.json.JSONObject
import org.jsoup.Jsoup
import org.jsoup.select.Elements
import java.text.SimpleDateFormat
import java.time.format.DateTimeFormatter
import java.util.*


var data645= ""
var data720= ""
//로또 볼
var ball645 = mutableListOf<String>()
// 로또 크롤링 초기값

// 연금복권 1등 볼
var ball720= mutableListOf<String>()

// 연금복권 보너스 볼
var bball720= mutableListOf<String>()

var pages645 = "" // lotto645 페이지 초기값
var round= " "
var a = 0
@Suppress("COMPATIBILITY_WARNING")
class HomeFragment : Fragment() {


    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        MobileAds.initialize(context) {}
        val adRequest = AdRequest.Builder().build()
        baner.loadAd(adRequest)

    }
    private val viewModel: MainViewModel by viewModels()
    private lateinit var homeViewModel: HomeViewModel

    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
            ViewModelProviders.of(this).get(HomeViewModel::class.java)


// lotto645 최초 Url
        var lottobaseUrl = "https://www.dhlottery.co.kr/gameResult.do?method=byWin"
// lotto645 Url
        var lotto645baseUrl = "https://www.dhlottery.co.kr/common.do?method=getLottoNumber&drwNo="
//      연금복권720 Url
        var lotto720baseUrl = "https://www.dhlottery.co.kr/gameResult.do?method=win720&Round="


        if (a == 0) {

            var url645 = Thread(UrlRun645(lotto645baseUrl, lottobaseUrl))
            url645.start()
            url645.join() // 멀티 작업 안되게 하려면 start후 join 입력하기

            var url720 = Thread(UrlRun720(lotto720baseUrl))
            url720.start()
            url720.join() // 멀티 작업 안되게 하려면 start후 join 입력하기

            a++

//            lifecycleScope.launch(Dispatchers.IO) {
//                viewModel.insert(
//                    Home645Entity(
//                        0,
//                        ball645[7],
//                        ball645[8],
//                        ball645[0],
//                        ball645[1],
//                        ball645[2],
//                        ball645[3],
//                        ball645[4],
//                        ball645[5],
//                        ball645[6]
//                    ))
//
//            }

        }

        var sf = SimpleDateFormat("yyyy-MM-dd")
        var date645 = sf.parse(data645)
        var today = Calendar.getInstance()
        var calcuDate645 = (today.time.time - date645.time) / (60 * 60 * 24 * 1000)

        // 로또 날짜 최신화
        if(a>=1 && calcuDate645 >= 7){

            var url645 = Thread(UrlRun645(lotto645baseUrl, lottobaseUrl))
            url645.start()
            url645.join() // 멀티 작업 안되게 하려면 start후 join 입력하기

            var url720 = Thread(UrlRun720(lotto720baseUrl))
            url720.start()
            url720.join() // 멀티 작업 안되게 하려면 start후 join 입력하기

//            lifecycleScope.launch(Dispatchers.IO) {
//                viewModel.insert(
//                    Home645Entity(
//                        0,
//                        ball645[7],
//                        ball645[8],
//                        ball645[0],
//                        ball645[1],
//                        ball645[2],
//                        ball645[3],
//                        ball645[4],
//                        ball645[5],
//                        ball645[6]
//                    )) }
        }

        var date720 = sf.parse(data720)
        var calcuDate720 = (today.time.time - date720.time) / (60 * 60 * 24 * 1000)


        // 연금복권 날짜 최신화
        if(a>=1 && calcuDate720 >= 7){

            var url645 = Thread(UrlRun645(lotto645baseUrl, lottobaseUrl))
            url645.start()
            url645.join() // 멀티 작업 안되게 하려면 start후 join 입력하기

            var url720 = Thread(UrlRun720(lotto720baseUrl))
            url720.start()
            url720.join() // 멀티 작업 안되게 하려면 start후 join 입력하기

        }

        //로또645
        val root = inflater.inflate(R.layout.fragment_home, container, false)
        val lotto645_layout: List<TextView> =
            listOf(
                root.findViewById(R.id.drwtno645_0),
                root.findViewById(R.id.drwtno645_1),
                root.findViewById(R.id.drwtno645_2),
                root.findViewById(R.id.drwtno645_3),
                root.findViewById(R.id.drwtno645_4),
                root.findViewById(R.id.drwtno645_5),
                root.findViewById(R.id.bnusNo645),
                root.findViewById(R.id.drwNo645),
                root.findViewById(R.id.drwNoDate645)
            )

        //연금복권720 1등
        var lotto720 = mutableListOf<TextView>()
        lotto720.add(root.findViewById(R.id.drwtno720_0))
        lotto720.add(root.findViewById(R.id.drwtno720_1))
        lotto720.add(root.findViewById(R.id.drwtno720_2))
        lotto720.add(root.findViewById(R.id.drwtno720_3))
        lotto720.add(root.findViewById(R.id.drwtno720_4))
        lotto720.add(root.findViewById(R.id.drwtno720_5))
        lotto720.add(root.findViewById(R.id.drwtno720_6))
        lotto720.add(root.findViewById(R.id.drwNo720))
        lotto720.add(root.findViewById(R.id.drwNoDate720))


        // 연금복권720 보너스
        var lottob720 = mutableListOf<TextView>()
        lottob720.add(root.findViewById(R.id.drwtno720b_1))
        lottob720.add(root.findViewById(R.id.drwtno720b_2))
        lottob720.add(root.findViewById(R.id.drwtno720b_3))
        lottob720.add(root.findViewById(R.id.drwtno720b_4))
        lottob720.add(root.findViewById(R.id.drwtno720b_5))
        lottob720.add(root.findViewById(R.id.drwtno720b_6))

        homeViewModel.text.observe(viewLifecycleOwner) {

            // 로또 볼 xml에 삽입
            for (i in 0..8) {
                lotto645_layout[i].text = ball645[i]
            }

            // 연금복권 1등 볼 xml에 삽입
            for (i in 0..8) {
                lotto720[i].text = ball720[i]
            }

            // 연금복권 보너스 볼 xml에 삽입
            for (i in 0..5) {
                lottob720[i].text = bball720[i]
            }
        }
        return root
    }
}

class UrlRun645(
    var lotto645baseUrl: String,
    var lottobaseUrl: String
) :
    Runnable {
    lateinit var elements645_drwno: Elements
    lateinit var elements645: Elements

    @RequiresApi(Build.VERSION_CODES.Q)
    @Synchronized
    override fun run() {
        try {
            // 로또 pages 가져오기
            var doc = Jsoup.connect(lottobaseUrl).get()
            elements645_drwno = doc.select("div[class='win_result '] h4 strong")
            var win645_first = elements645_drwno.text().split("회")[0]
            pages645 = win645_first

            // 로또 api
            var doc645 = Jsoup.connect(lotto645baseUrl + pages645).get()
            elements645 = doc645.select("body")
            val jObject = JSONObject(elements645.text())
            val drwNoDate645 = jObject.getString("drwNoDate")
            val drwNo645: List<String> = listOf(
                jObject.getString("drwtNo1"),
                jObject.getString("drwtNo2"),
                jObject.getString("drwtNo3"),
                jObject.getString("drwtNo4"),
                jObject.getString("drwtNo5"),
                jObject.getString("drwtNo6"),
                jObject.getString("bnusNo"),
                jObject.getString("drwNo")+"회 당첨결과",
                "(" + drwNoDate645.split("-")[0] + "년 " + drwNoDate645.split("-")[1] + "월 " + drwNoDate645.split("-")[2] + "일 추첨)")
            //날짜 최신화를 위해 저장
            data645 = drwNoDate645

            for (i in 0..8){
                ball645.add(drwNo645[i])
            }
        } catch (e: Exception) {
            Log.d("TTT", "로또"+e.toString())
        }
    }
}

class UrlRun720(
        var lotto720baseUrl: String
) :

    Runnable {
    lateinit var elements720_drwno: Elements
    lateinit var elements720_win: Elements
    lateinit var elements720_drwnoDate: Elements

    @RequiresApi(Build.VERSION_CODES.Q)
    @Synchronized
    override fun run() {
        try {

            var doc720 = Jsoup.connect(lotto720baseUrl ).get()
             // elements720 = doc720.select("div.win_num_wrap")
             elements720_drwno = doc720.select("div[class='win_result al720'] h4 strong")
             elements720_drwnoDate = doc720.select("div[class='win_result al720'] p")
             elements720_win = doc720.select("div[class='win_result al720'] span span")

             var win720_first = elements720_win.text().split(" 각 ")[0].split(" ")

             // 연금복권720 1등 볼 for문으로 가져오기
             for (i in 0..6) {
                 ball720.add(win720_first[i])
             }
             ball720.add( elements720_drwno.text().toString()+" 당첨결과")
             ball720.add( elements720_drwnoDate.text().toString())

             // 연금 복권 최신화를 위해 저장
             data720 = elements720_drwnoDate.text().toString().split("(")[1].split("년")[0]+"-"+
                     elements720_drwnoDate.text().toString().split("(")[1].split("년 ")[1].split("월")[0]+"-"+
                     elements720_drwnoDate.text().toString().split("(")[1].split("년 ")[1].split("월 ")[1].split("일")[0]

             var win720_bonus = elements720_win.text().split(" 각 ")[1].split(" ")


             // 연금복권720 보너스 볼 for문으로 가져오기
             for (i in 0..5) {
                 bball720.add(win720_bonus[i])
             }
        } catch (e: Exception) {
            Log.d("TTT", "연금"+e.toString())
        }
    }
}










