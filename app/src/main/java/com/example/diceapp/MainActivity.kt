package com.example.diceapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    lateinit var displayedNum: TextView
    lateinit var editTextNum : EditText
    lateinit var diceImageView: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        displayedNum = findViewById(R.id.textView)

        var sides: Int?
        var latestDiceThrow = 0
        editTextNum  = findViewById(R.id.editText)
        //hides the edit text view
        editTextNum.setVisibility(View.GONE)
        //displayedNum.setVisibility(View.GONE)

        diceImageView = findViewById(R.id.imageView)


        var button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            sides = editTextNum.text.toString().toIntOrNull()
            if (sides == null) {
                sides = 6
            }
            var diceThrow: Int = Random.nextInt(1, sides!! + 1)
            displayDiceResult(diceThrow, latestDiceThrow)
            latestDiceThrow = diceThrow
        }


    }

    fun displayDiceResult(diceThrow: Int, latestDiceThrow: Int) {
        if (diceThrow == latestDiceThrow) {
            displayedNum.text = "You rolled $diceThrow... again"
        } else {
            displayedNum.text = "You rolled $diceThrow"
        }
        //displayedNum.text = "Result: $diceThrow"
        when (diceThrow) {
            1 -> diceImageView.setImageResource(R.drawable.dice1)
            2 -> diceImageView.setImageResource(R.drawable.dice2)
            3 -> diceImageView.setImageResource(R.drawable.dice3)
            4 -> diceImageView.setImageResource(R.drawable.dice4)
            5 -> diceImageView.setImageResource(R.drawable.dice5)
            6 -> diceImageView.setImageResource(R.drawable.dice6)
        }
    }
}
