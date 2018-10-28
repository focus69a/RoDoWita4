package com.onegday.rodowita4

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.karta_upowaznienia.*
import kotlinx.android.synthetic.main.mnie_upowazniono_item.*

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
        textView_OdID.text = odKogo
        textView_OkresID.text = okres
        textView_ZakresID.text = zakres
        textView_FirmaID.text = firma


        val button_Skasuj_clicked = findViewById(R.id.button_SkasujID) as Button
        button_Skasuj_clicked.setOnClickListener {
            //operacja kasowania upowaznienia...
            val intentResult = Intent()
            intentResult.putExtra("wynikCoSkasowac", dlaKogo)
            setResult(Activity.RESULT_OK, intentResult)


            Toast.makeText(this@KartaUpoznieniaActivity, "nacisniety Kasowanie", Toast.LENGTH_LONG).show()

            finish()
        }


        val button_Udostepnij_clicked = findViewById(R.id.button_UdostepnijID) as Button
        button_Udostepnij_clicked.setOnClickListener {
            //operacja kasowania upowaznienia...
            val intentResult = Intent()
            intentResult.putExtra("wynikCoSkasowac", dlaKogo)
            setResult(Activity.RESULT_OK, intentResult)


            Toast.makeText(this@KartaUpoznieniaActivity, "nacisniety Udostepnianie", Toast.LENGTH_LONG).show()

            finish()
        }
    }

}