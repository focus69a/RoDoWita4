package com.onegday.rodowita4

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import kotlinx.android.synthetic.main.ja_upowaznilem_item.view.*
import kotlinx.android.synthetic.main.mnie_upowazniono_item.view.*


class JaUpowaznilemActivity : Fragment() {

    lateinit var upowaznieniaRecyclerView: RecyclerView
    var listaUpowaznien: MutableList<Ja_Upowaznilem_Dane> = SupplierJaUpowaznilem.upowaznieniaJaUpowaznilem
    lateinit var v: View


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        v = inflater.inflate(R.layout.fragment_ja_upowaznilem, container, false)   //po inflater byly !!
        upowaznieniaRecyclerView = v.findViewById(R.id.recViewlistaUpowaznienID)
        upowaznieniaRecyclerView?.setHasFixedSize(true)   //to bylo usuniete a dodalem dziala tak samo
        upowaznieniaRecyclerView?.layoutManager = LinearLayoutManager(activity as Context?)   //moze getActivity() zamiast
        upowaznieniaRecyclerView?.adapter = AdapterJaUpowaznilem(listaUpowaznien, context as Context?)  //moze getContext() zamiast
        return v
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

}
//========================================================ADAPTER====================================

class AdapterJaUpowaznilem(val upowaznienia: List<Ja_Upowaznilem_Dane>, val context: Context?) : RecyclerView.Adapter<AdapterJaUpowaznilem.myViewHolder>() {
    //var upowaznienie = items
    //var nazwyWlasne = items
    //var context = ctx

    // tu mozna nadac wartosci polom tekstowym z karty
    //private val nazwyWlasne = arrayOf(" jeden", "dwa", "trzy", "cztery")
    //private val odKogo = arrayOf("WJ", "AJ", "KJ", "KJ")

    //===================================================

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.ja_upowaznilem_item, parent, false)
        return myViewHolder(view)
    }

    //testowo
    override fun getItemCount(): Int {
        return upowaznienia.size

    }


    override fun onBindViewHolder(holder: myViewHolder, position: Int) {
        //funkcja w adapterze nadaje wartosci odpowiednim polom z karty (po lewej),
        // wartosci czytane sa z obiektu po prawej wg kolejnosci...karta po karcie

        //val upowaznienie = upowaznienia[position]
        //holder.nazwaWlasna?.text = upowaznienia[position].nazwa
        //holder.odKogo?.text = upowaznienia[position].odKogo
        holder.dlaKogo?.text = upowaznienia[position].dlaKogo
        holder.okres?.text = upowaznienia[position].okres
        holder.firma?.text = upowaznienia[position].firma
        holder.zakres?.text = upowaznienia[position].zakres

//        holder.itemView.textView_NazwaWlasnaID?.text = nazwyWlasne[position]
//        holder.itemView.textViewOdID?.text = odKogo[position]
//to dodaje 20181025



    }


    class myViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        //klasa odpowiada za przypiecie odpowiednich nazw pol jakie uzywamy w programie (po lewej)
        // do tych co są w xml i UI na ekranie (po prawej)
        //val odKogo = itemView.textViewOdID
        val dlaKogo = itemView.textView_DlaID
        val okres = itemView.textView_OkresID
        val firma = itemView.textView_FirmaID
        val zakres = itemView.textView_ZakresID

        // to tez dziala co ponizej
        // var nazwaWlasna: TextView? = itemView.findViewById(R.id.textView_NazwaWlasnaID)
        // var odKogo : TextView? = itemView.findViewById(R.id.textViewOdID)
        // var dlaKogo: TextView? = itemView.findViewById(R.id.textView_DlaID)
        // var okres: TextView? = itemView.findViewById(R.id.textView_OkresID)
        // var firma: TextView? = itemView.findViewById(R.id.textView_FirmaID)
        // var zakres: TextView? = itemView.findViewById(R.id.textView_ZakresID)
        // var checkBoxFilm: CheckBox? = itemView.findViewById(R.id.checkMovieID)
        // var checkBoxDoc: CheckBox? = itemView.findViewById(R.id.checkDocID)

        init {
            itemView.setOnClickListener {
                //println("TEST")
                //Toast.makeText(itemView.context, " nowy intent", Toast.LENGTH_LONG).show()
                val intent = Intent(itemView.context, KartaUpoznieniaActivity::class.java)
                intent.putExtra("dlaKogo", dlaKogo.text)
                intent.putExtra("odKogo", "aaa")
                intent.putExtra("zakres", zakres.text)
                intent.putExtra("firma", firma.text)
                intent.putExtra("okres", okres.text)
                itemView.context.startActivity(intent)

            }
        }
    }
}
