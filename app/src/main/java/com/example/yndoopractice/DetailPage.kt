package com.example.yndoopractice

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import android.webkit.WebChromeClient
import android.webkit.WebViewClient
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_detail_page.*
import kotlinx.android.synthetic.main.activity_main.*

class DetailPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_page)


        val forTitle = arrayOf(
                itemList(intent.getStringExtra("title").toString(), intent.getStringExtra("dday").toString(), intent.getStringExtra("heart").toString(), intent.getStringExtra("tags").toString())
        )

        rv_forTitle.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        rv_forTitle.adapter = listAdapter(forTitle)
        rv_forTitle.setHasFixedSize(true)



        wv_detail.settings.javaScriptEnabled = true       // 자바 스크립트 허용

        /* 웹뷰에서 새 창이 뜨지 않도록 하는 구문 */
        wv_detail.webViewClient = WebViewClient()
        wv_detail.webChromeClient = WebChromeClient()
        /* 웹뷰에서 새 창이 뜨지 않도록 하는 구문 */

        wv_detail.loadUrl("https://www.naver.com")       // 링크 주소를 로드함

    }
}