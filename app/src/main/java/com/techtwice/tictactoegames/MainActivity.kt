package com.techtwice.tictactoegames

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import kotlin.collections.ArrayList

open class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var autoPlay = true

    private var activePlayer = 1

    private var player1 = ArrayList<Int>()
    private var player2 = ArrayList<Int>()

    private var player1WinsCounts = 0
    private var player2WinsCounts = 0

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
        btAutoPlay.setOnClickListener(this)

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
            R.id.btAutoPlay -> collId = 100
        }


        // Log.d("btClick:", btSelected.id.toString())
        // Log.d("btClick: collId:", collId.toString())
        // Toast.makeText(this, "btClick:" + btSelected.id.toString(), Toast.LENGTH_LONG).show()
        // Toast.makeText(this, "btClick: collId:" + collId.toString(), Toast.LENGTH_LONG).show()

        if (collId == 100) {
            changeAutoPlay()
            return
        }

        playGames(collId, btSelected)

    }


    private fun changeAutoPlay() {
        if (autoPlay) {
            autoPlay = false
            btAutoPlay.text = "Auto Play ON"
            btAutoPlay.setBackgroundResource(R.color.colorPrimary)
        } else {
            autoPlay = true
            btAutoPlay.text = "Auto Play OFF"
            btAutoPlay.setBackgroundResource(R.color.colorAccent)
        }
    }

    private fun playGames(collId: Int, btSelected: Button) {

        if (activePlayer == 1) {
            btSelected.text = "X"
            btSelected.setBackgroundResource(R.color.blue)
            player1.add(collId)
            activePlayer = 2
            if (autoPlay) {
                autoPlay()
            }

        } else {
            btSelected.text = "O"
            btSelected.setBackgroundResource(R.color.darkGreen)
            player2.add(collId)
            activePlayer = 1
        }

        btSelected.isEnabled = false
        checkWinner()
    }

    private fun autoPlay() {

        val emptyCells = ArrayList<Int>()

        for (collId in 1..9) {

            if (!(player1.contains(collId) || player2.contains(collId))) {
                emptyCells.add(collId)
            }
        }

        if (emptyCells.size == 0) {
            restartGame()
        }

        val r = Random()
        val randIndex = r.nextInt(emptyCells.size)
        val cellId = emptyCells[randIndex]

        val btSelected: Button?
        btSelected = when (cellId) {
            1 -> bt1
            2 -> bt2
            3 -> bt3
            4 -> bt4
            5 -> bt5
            6 -> bt6
            7 -> bt7
            8 -> bt8
            9 -> bt9
            else -> {
                bt1
            }
        }

        playGames(cellId, btSelected)
    }

    private fun checkWinner() {

        var winer = -1

        // row 1
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)) {
            winer = 2
        }

        // row 2
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)) {
            winer = 1
        }
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)) {
            winer = 2
        }

        // row 3
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)) {
            winer = 2
        }

        // col 1
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)) {
            winer = 1
        }
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)) {
            winer = 2
        }

        // col 2
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)) {
            winer = 1
        }
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)) {
            winer = 2
        }

        // col 3
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)) {
            winer = 1
        }
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)) {
            winer = 2
        }

        if (winer == 1) {
            player1WinsCounts += 1
            Toast.makeText(this, "Player 1 win the game", Toast.LENGTH_LONG).show()
            restartGame()
        } else if (winer == 2) {
            player2WinsCounts += 1
            Toast.makeText(this, "Player 2 win the game", Toast.LENGTH_LONG).show()
            restartGame()
        }
    }

    private fun restartGame() {
        activePlayer = 1
        player1.clear()
        player2.clear()

        for (collId in 1..9) {

            val btSelected: Button? = when (collId) {
                1 -> bt1
                2 -> bt2
                3 -> bt3
                4 -> bt4
                5 -> bt5
                6 -> bt6
                7 -> bt7
                8 -> bt8
                9 -> bt9
                else -> {
                    bt1
                }
            }
            btSelected!!.text = ""
            btSelected.setBackgroundResource(R.color.whileBu)
            btSelected.isEnabled = true
        }

        Toast.makeText(
            this,
            "Player1: $player1WinsCounts, Player2: $player2WinsCounts",
            Toast.LENGTH_LONG
        ).show()

    }


}
