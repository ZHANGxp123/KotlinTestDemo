package com.ress.kotlindemo.adapter

import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.ress.kotlindemo.R
import com.ress.kotlindemo.holder.MainViewHolder

/**
 * Created by ress on 2017/1/3.
 */
class MainRecyclerAdapter : RecyclerView.Adapter<MainViewHolder>() {

    private var list: List<String>? = null

    fun setList(list: List<String>) {
        this.list=list
    }

    private var listener: ((pos :String) -> Unit)? = null

    fun setItemClick(listener: (pos: String) -> Unit) {
        this.listener=listener
    }

    override fun getItemCount(): Int {
        return list?.size!!
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): MainViewHolder {
        val view = View.inflate(parent?.context, R.layout.item_main, null)
        val holder = MainViewHolder(view)
        return holder
    }

    override fun onBindViewHolder(holder: MainViewHolder?, position: Int) {
        holder?.tv?.text = list?.get(position)
        holder?.itemView?.setOnClickListener { listener?.invoke(list!!.get(position)) }
    }
}