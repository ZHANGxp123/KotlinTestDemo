package com.ress.kotlindemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import java.util.*

class Main2Activity : AppCompatActivity() {

    private var list = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val extra = intent.getStringExtra("gg")
        toast(extra.toString())

        initData()

        val lm = LinearLayoutManager(this@Main2Activity)

        recycler_view.layoutManager=lm

        val myAdapter = MyAdapter()
        myAdapter.setOnItemClickListener {pos->toast("$pos")}
        recycler_view.adapter= myAdapter

    }

    fun Main2Activity.toast(str: String) {
        Toast.makeText(this@Main2Activity,str,Toast.LENGTH_SHORT).show()
    }

    private fun initData() {
        for (i in 1..20) {
            list.add(i.toString())
        }
    }


    inner class MyViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView){
        var tv: TextView = itemView?.findViewById(R.id.tv_item_main) as TextView
    }


    inner class MyAdapter : RecyclerView.Adapter<MyViewHolder>() {


        var mListener: ((pos: Int) -> Unit)? = null

        fun setOnItemClickListener(listener: ((pos: Int) -> Unit)) {
            mListener = listener
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MyViewHolder {
            val view = layoutInflater.inflate(R.layout.item_main, parent, false)

            val holder = MyViewHolder(view)
            return holder
        }

        override fun onBindViewHolder(holder: MyViewHolder?, position: Int) {
            holder?.tv?.text = list.get(position)
            holder?.itemView?.setOnClickListener { mListener?.invoke(position) }

        }

    }
}
