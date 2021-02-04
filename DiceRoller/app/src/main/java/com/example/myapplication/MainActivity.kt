package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var diceImage: ImageView
    private lateinit var dice2Image: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        diceImage = findViewById(R.id.dice_image)
        dice2Image = findViewById(R.id.dice2_image)

        val rollButton: Button = findViewById(R.id.roll_button)

        rollButton.setOnClickListener {
            diceImage.setImageResource(drawableResource(rollDice()))
            dice2Image.setImageResource(drawableResource(rollDice()))
        }
    }

    private fun drawableResource(randomNumber: Int): Int = when (randomNumber) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }

    private fun rollDice(): Int {
        Toast.makeText(this, "Rolled", Toast.LENGTH_SHORT).show()

        return (1..6).random()
    }
}
