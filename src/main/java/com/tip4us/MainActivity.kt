package com.tip4us

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.tip4us.databinding.ActivityMainBinding
import android.widget.RadioButton
import androidx.appcompat.widget.Toolbar
import kotlinx.android.synthetic.main.toolbar_layout.*


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var tip = 0.00

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.doneButton.setOnClickListener{
            toastNumber(it)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        return super.onCreateOptionsMenu(menu)
    }

    fun onRadioButtonClicked(v: View) {
        //is the current radio button now checked?
        val checked = (v as RadioButton).isChecked

        //now check which radio button is selected
        //android switch statement
        when (v) {

            binding.poorServiceButton -> {
                if (checked)
                    tip = .10
            }

            binding.goodServiceButton -> {
                if (checked)
                    tip = .15
            }

            binding.excellentServiceButton -> {
                if (checked)
                    tip = .20
            }
        }
    }

    private fun getStateTax(state: String): Double{
        var tax = 0.00
        // State to max potential tax translator
        // Tax is calculated by adding highest local surtax with base sales tax
        when(state){
            "Alabama" -> {
                tax = .11
            }
            "Alaska" -> {
                tax = .075
            }
            "Arizona" ->{
                tax = .0112
            }
            "Arkansas" ->{
                tax =.115
            }
            "California" ->{
                tax = .1025
            }
            "Colorado" ->{
                tax = .112
            }
            "Connecticut" ->{
                tax = .0635
            }
            "Delaware" ->{
                tax = 0.00
            }
            "Florida" ->{
                tax = .08
            }
            "Georgia" ->{
                tax = .09
            }
            "Hawaii" ->{
                tax = .045
            }
            "Idaho" ->{
                tax = .09
            }
            "Illinois" ->{
                tax = .11
            }
            "Indiana" ->{
                tax = .07
            }
            "Iowa" ->{
                tax = .08
            }
            "Kansas" ->{
                tax = .106
            }
            "Kentucky" ->{
                tax = .06
            }
            "Louisiana" ->{
                tax = .1145
            }
            "Maine" ->{
                tax = .055
            }
            "Maryland" ->{
                tax = .06
            }
            "Massachusetts" ->{
                tax = .0625
            }
            "Michigan" ->{
                tax = .06
            }
            "Minnesota" ->{
                tax = .08375
            }
            "Mississippi" ->{
                tax = .08
            }
            "Missouri" ->{
                tax = .101
            }
            "Montana" ->{
                tax = 0.00
            }
            "Nebraska" ->{
                tax = .075
            }
            "Nevada" ->{
                tax = .08265
            }
            "New Hampshire" ->{
                tax = 0.00
            }
            "New Jersey" ->{
                tax = .06625
            }
            "New Mexico" ->{
                tax = .05125
            }
            "New York" ->{
                tax = .08875
            }
            "North Carolina" ->{
                tax = .075
            }
            "North Dakota" ->{
                tax = .085
            }
            "Ohio" ->{
                tax = .08
            }
            "Oklahoma" ->{
                tax = .115
            }
            "Oregon" ->{
                tax = 0.00
            }
            "Pennsylvania" ->{
                tax = .08
            }
            "Rhode Island" ->{
                tax = .07
            }
            "South Carolina" ->{
                tax = .09
            }
            "South Dakota" ->{
                tax = .065
            }
            "Tennessee" ->{
                tax = .1
            }
            "Texas" ->{
                tax = .0825
            }
            "Utah" ->{
                tax = .087
            }
            "Vermont" ->{
                tax = .07
            }
            "Virginia" ->{
                tax = .07
            }
            "Washington" ->{
                tax = .104
            }
            "Washington, DC" ->{
                tax = .06
            }
            "West Virginia" ->{
                tax = .07
            }
            "Wisconsin" ->{
                tax = .056
            }
            "Wyoming" ->{
                tax = .06
            }
        }
        return tax
    }

    private fun toastNumber(view: View){

        val price = binding.priceText.text.toString().toFloat()
        val tax = getStateTax(binding.statesSpinner.selectedItem.toString())
        val finalPrice = price+( price*tax )+( price*tip )

        val num = "%.2f".format(finalPrice)

     //   val spinnerText = binding.spinner.selectedItem.toString()
        val toast = Toast.makeText(applicationContext, num, Toast.LENGTH_SHORT)
        toast.show()


    }

}
