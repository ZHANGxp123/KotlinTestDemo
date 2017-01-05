package com.ress.kotlindemo.activitys

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import com.ress.kotlindemo.Main2Activity
import com.ress.kotlindemo.R
import com.ress.kotlindemo.adapter.MainRecyclerAdapter
import com.ress.kotlindemo.decotaration.MainItemDecoration
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*


class MainActivity : AppCompatActivity() {

    var list = ArrayList<String>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val lm = GridLayoutManager(this, 2)
        rv_main.layoutManager = lm
        val adapter = MainRecyclerAdapter()
        rv_main.adapter = adapter
        val mainItemDecoration = MainItemDecoration()
        val size = resources.getDimensionPixelSize(R.dimen.space)
        mainItemDecoration.setSpace(size)
        mainItemDecoration.setHeight(3)
        rv_main.addItemDecoration(mainItemDecoration)
        for (i in 1..6) {
            list.add(i.toString() + "年级")

        }
        adapter.setList(list)
        adapter.notifyDataSetChanged()
        adapter.setItemClick {
            val intent = Intent(this@MainActivity, Main2Activity::class.java)
            intent.putExtra("gg",it)
            startActivity(intent)

        }
    }
}
