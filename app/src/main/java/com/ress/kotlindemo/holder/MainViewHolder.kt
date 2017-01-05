package com.ress.kotlindemo.holder

import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.TextView
import com.ress.kotlindemo.R

/**
 * Created by ress on 2017/1/3.
 */
class MainViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView)
{
    var tv: TextView=itemView?.findViewById(R.id.tv_item_main) as TextView

}