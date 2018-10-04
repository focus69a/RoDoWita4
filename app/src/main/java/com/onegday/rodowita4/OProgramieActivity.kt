package com.onegday.rodowita4

import android.graphics.Bitmap
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebResourceRequest
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_o_programie.*


class OProgramieActivity : Fragment() {
    //private val myUrl = "https://flaskwj1.eu-gb.mybluemix.net/"
    val myUrl ="http://forum.nikoniarze.pl/threads/290931-Nikon-Z6-i-Z7-oficjalnie"
    lateinit var view12: View
    lateinit var myWebView : WebView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        //val settings = webViewID1.settings
        //val settings = webViewID1.settings

        view12 = inflater!!.inflate(R.layout.fragment_o_programie, container, false)

        myWebView = view12.findViewById(R.id.webViewID1)

        myWebView.settings.javaScriptEnabled = true

        //settings.setAppCacheEnabled(true)
        //settings.cacheMode = WebSettings.LOAD_DEFAULT
        //settings.setAppCachePath(cacheDir.path)

        //settings.setSupportZoom(true)
        //settings.builtInZoomControls = true
        //settings.displayZoomControls = true

        //settings.textZoom = 125

        //settings.blockNetworkImage = false
        //settings.loadsImagesAutomatically = true
        //settings.loadWithOverviewMode = true
        //settings.javaScriptCanOpenWindowsAutomatically = true
        //settings.mediaPlaybackRequiresUserGesture = false

        //myWebView.setLayerType(View.LAYER_TYPE_HARDWARE,null)  //akceleracja sprzetowa >19

        //myWebView.setInitialScale(100)


        myWebView.webViewClient = object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
                return super.shouldOverrideUrlLoading(view, request)
            }
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                Toast.makeText(activity,"Page loading.",Toast.LENGTH_SHORT).show()
            }

            override fun onPageFinished(view: WebView, url: String) {
                Toast.makeText(activity,"Page loaded.",Toast.LENGTH_SHORT).show()
            }
        }




        myWebView.loadUrl(myUrl)

        return view12

    }
}