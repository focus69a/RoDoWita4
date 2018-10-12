package com.onegday.rodowita4

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.ja_upowaznilem_item.view.*
import kotlinx.android.synthetic.main.mnie_upowazniono_item.view.*
import okhttp3.*
import java.io.IOException


class JestemUpowaznionyActivity : Fragment() {

    lateinit var upowaznieniaRecyclerView: RecyclerView
    var listaUpowaznien: MutableList<Jestem_Upowazniony_Dane> = SupplierJestemUpowazniony.upowaznieniaJestemUpowazniony
    lateinit var v: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_mnie_upowazniono, container, false)   //po inflater byly !!
        upowaznieniaRecyclerView = v.findViewById(R.id.recViewlistaUpowaznienID)
        upowaznieniaRecyclerView?.setHasFixedSize(true)   //to bylo usuniete a dodalem dziala tak samo
        upowaznieniaRecyclerView?.layoutManager = LinearLayoutManager(activity as Context?)   //moze getActivity() zamiast
//        upowaznieniaRecyclerView?.adapter = AdapterJestemUpowazniony(listaUpowaznien, context as Context?)  //moze getContext() zamiast
        return v
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        fetchJson()
    }

    fun fetchJson() {
        println("to jest test json")
        val url = "https://flaskwj1.eu-gb.mybluemix.net/api/upowaznienia"

        val request =Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                val body = response?.body()?.string()
                println(body)

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)


                activity?.runOnUiThread{
                    // !!!!!!!!!!!!!!!!!!! tutaj to trzeba jakos dodac
                    upowaznieniaRecyclerView.adapter = AdapterJestemUpowazniony(homeFeed, context)

                }
            }
            override fun onFailure(call: Call, e: IOException) {
                println("Failure in execute callback WJ")
            }
        })
    }
}

//================================klasa do trzymania jsona ==============================poczatek

//{
//    "dlaKogo": "Anna Jackiewicz",
//    "firma": "PKOBP",
//    "odKogo": "Waldemar Jackiewicz",
//    "okres": "od 2018-09-01 do 2026-12-31",
//    "zakres": "dyspozycje"
//},

class HomeFeed(val results: List<UpowaznieniaJSON>)

class UpowaznieniaJSON(val dlaKogo: String, val firma: String, val odKogo: String, val okres : String, val zakres : String)



//===============================klasa do trzymania jsona ==============================koniec

//========================================================ADAPTER====================================

//class AdapterJestemUpowazniony(val upowaznienia: List<Jestem_Upowazniony_Dane>, val context: Context?) : RecyclerView.Adapter<AdapterJestemUpowazniony.myViewHolder>() {
class AdapterJestemUpowazniony(val homeFeed: HomeFeed, val context: Context?) : RecyclerView.Adapter<AdapterJestemUpowazniony.myViewHolder>() {

    //var upowaznienie = items
    //var nazwyWlasne = items
    //var context = ctx

    // tu mozna nadac wartosci polom tekstowym z karty
    //private val nazwyWlasne = arrayOf(" jeden", "dwa", "trzy", "cztery")
    //private val odKogo = arrayOf("WJ", "AJ", "KJ", "KJ")

    //===================================================

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.mnie_upowazniono_item, parent, false)
        return myViewHolder(view)
    }

    //testowo
    override fun getItemCount(): Int {
      //  return upowaznienia.size
        return homeFeed.results.count()

    }


    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        //funkcja w adapterze nadaje wartosci odpowiednim polom z karty (po lewej),
        // wartosci czytane sa z obiektu po prawej wg kolejnosci...karta po karcie

        //val upowaznienie = upowaznienia[position]
        //holder.nazwaWlasna?.text = upowaznienia[position].nazwa
//        holder.odKogo?.text = upowaznienia[position].odKogo
//        //holder.dlaKogo?.text = upowaznienia[position].dlaKogo
//        holder.okres?.text = upowaznienia[position].okres
//        holder.firma?.text = upowaznienia[position].firma
//        holder.zakres?.text = upowaznienia[position].zakres

        holder.odKogo?.text = homeFeed.results[position].odKogo
        //holder.dlaKogo?.text = upowaznienia[position].dlaKogo
        holder.okres?.text = homeFeed.results[position].okres
        holder.firma?.text = homeFeed.results[position].firma
        holder.zakres?.text = homeFeed.results[position].zakres

//        holder.itemView.textView_NazwaWlasnaID?.text = nazwyWlasne[position]
//        holder.itemView.textViewOdID?.text = odKogo[position]


    }


    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //klasa odpowiada za przypiecie odpowiednich nazw pol jakie uzywamy w programie (po lewej)
        // do tych co są w xml i UI na ekranie (po prawej)
        val odKogo = itemView.textView_OdID2
        //val dlaKogo = itemView.textView_DlaID
        val okres = itemView.textView_OkresID2
        val firma = itemView.textView_FirmaID2
        val zakres = itemView.textView_ZakresID2

        // to tez dziala co ponizej
        // var nazwaWlasna: TextView? = itemView.findViewById(R.id.textView_NazwaWlasnaID)
        // var odKogo : TextView? = itemView.findViewById(R.id.textViewOdID)
        // var dlaKogo: TextView? = itemView.findViewById(R.id.textView_DlaID)
        // var okres: TextView? = itemView.findViewById(R.id.textView_OkresID)
        // var firma: TextView? = itemView.findViewById(R.id.textView_FirmaID)
        // var zakres: TextView? = itemView.findViewById(R.id.textView_ZakresID)
        // var checkBoxFilm: CheckBox? = itemView.findViewById(R.id.checkMovieID)
        // var checkBoxDoc: CheckBox? = itemView.findViewById(R.id.checkDocID)

        init { }
    }
}

