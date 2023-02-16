/**
*CS646-Lab-1-Pizza Party App
 */
package com.zybooks.pizzaparty

/**
*Import all packages
 */

import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlin.math.ceil

/**
*No. of slices in each pizza
 */
const val SLICES_PER_PIZZA = 8

/**
*Main class to calculate the total no. of pizzas
 */

class MainActivity : AppCompatActivity() {

    private lateinit var numAttendEditText: EditText
    private lateinit var numPizzasTextView: TextView
    private lateinit var howHungryRadioGroup: RadioGroup

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        numAttendEditText = findViewById(R.id.num_attend_edit_text)
        numPizzasTextView = findViewById(R.id.num_pizzas_text_view)
        howHungryRadioGroup = findViewById(R.id.hungry_radio_group)
    }

    fun calculateClick(view: View) {
        /**
        *Get the text into the EditText
        */

        val numAttendStr = numAttendEditText.text.toString()

/**
 *Convert into  integer
 */

        val numAttend = numAttendStr.toInt()

/**
*calculates how many slices each person will eat on an avg
*/

        val slicesPerPerson = when (howHungryRadioGroup.checkedRadioButtonId) {
            R.id.light_radio_button -> 2
            R.id.medium_radio_button -> 3
            else -> 4
        }

/**
*Calculates and displays the number of pizzas needed for the party
 */

        val totalpizza = ceil(numAttend * slicesPerPerson / SLICES_PER_PIZZA.toDouble()).toInt()
        numPizzasTextView.text = "Total pizzas: $totalpizza"
    }
}