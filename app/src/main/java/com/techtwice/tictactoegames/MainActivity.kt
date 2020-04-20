package com.techtwice.tictactoegames

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    var activePlayer = 1

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()

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
        var collId = 0

        when (btSelected.id) {
            R.id.bt1 -> collId = 1
            R.id.bt2 -> collId = 2
            R.id.bt3 -> collId = 3
            R.id.bt4 -> collId = 4
            R.id.bt5 -> collId = 5
            R.id.bt6 -> collId = 6
            R.id.bt7 -> collId = 7
            R.id.bt8 -> collId = 8
            R.id.bt9 -> collId = 9
        }

        // Log.d("btClick:", btSelected.id.toString())
        // Log.d("btClick: collId:", collId.toString())
        // Toast.makeText(this, "btClick:" + btSelected.id.toString(), Toast.LENGTH_LONG).show()
        // Toast.makeText(this, "btClick: collId:" + collId.toString(), Toast.LENGTH_LONG).show()

        playGames(collId, btSelected)

    }

    private fun playGames(collId: Int, btSelected: Button) {

        if (activePlayer == 1) {
            btSelected.text = "X"
            btSelected.setBackgroundResource(R.color.blue)
            player1.add(collId)
            activePlayer = 2
        } else {
            btSelected.text = "O"
            btSelected.setBackgroundResource(R.color.darkGreen)
            player2.add(collId)
            activePlayer = 1
        }

        btSelected.isEnabled = false
    }


}
