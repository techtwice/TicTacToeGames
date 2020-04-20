package com.techtwice.tictactoegames

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bt1.setOnClickListener(this)
        bt2.setOnClickListener(this)
        bt3.setOnClickListener(this)
        bt4.setOnClickListener(this)
        bt5.setOnClickListener(this)
        bt6.setOnClickListener(this)
        bt7.setOnClickListener(this)
        bt8.setOnClickListener(this)
        bt9.setOnClickListener(this)


    }

    override fun onClick(view: View) {

        val btSelected = view as Button
        var btCollID = 0

        when (btSelected.id) {
            R.id.bt1 -> btCollID = 1
            R.id.bt2 -> btCollID = 2
            R.id.bt3 -> btCollID = 3
            R.id.bt4 -> btCollID = 4
            R.id.bt5 -> btCollID = 5
            R.id.bt6 -> btCollID = 6
            R.id.bt7 -> btCollID = 7
            R.id.bt8 -> btCollID = 8
            R.id.bt9 -> btCollID = 9
        }

        //   Log.d("btClick:", btSelected.id.toString())
        //   Log.d("btClick: btCollID:", btCollID.toString())
        Toast.makeText(this, "btClick:" + btSelected.id.toString(), Toast.LENGTH_LONG).show()
        Toast.makeText(this, "btClick: btCollID:" + btCollID.toString(), Toast.LENGTH_LONG).show()

    }
}
