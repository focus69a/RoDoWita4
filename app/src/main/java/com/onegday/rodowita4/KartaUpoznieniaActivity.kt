package com.onegday.rodowita4

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.android.synthetic.main.karta_upowaznienia.*

class KartaUpoznieniaActivity: AppCompatActivity() {
    val tag: String = "KartaActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.karta_upowaznienia)
        Log.d(tag, "onCreate: started.")


        val extras = intent.extras ?: return

        val dlaKogo = extras.getString("dlaKogo", "brak")
        val odKogo = extras.getString("odKogo", "brak")
        val okres = extras.getString("okres", "brak")
        val zakres = extras.getString("zakres","brak")
        val firma = extras.getString("firma","brak")

        textView_DlaID.text = dlaKogo
        textView_OkresID.text = okres
        textView_ZakresID.text = zakres
        textView_FirmaID.text = firma


    }

}