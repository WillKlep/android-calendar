package com.mobileappdev.androidcalendar


import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.navigation.NavigationBarView.OnItemSelectedListener


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val monthSpinner = findViewById<Spinner>(R.id.spinner_month)
        val yearSpinner = findViewById<Spinner>(R.id.spinner_year)

        val monthsArray = arrayOf("January", "February", "March", "April", "May", "June",
            "July", "August", "September", "October", "November", "December")

        val arrayStartYear = 2030
        val arrayEndYear = 1970
        val yearsArray = Array(arrayStartYear - arrayEndYear + 1) { i -> arrayStartYear - i }

        val monthArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, monthsArray)
        monthArrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        monthSpinner.adapter = monthArrayAdapter


        monthSpinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                var monthInt = parent?.getItemAtPosition(position);
                Log.d("monthSpinner_output", monthInt.toString());
            }

            override fun onNothingSelected(p0: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }



        val yearArrayAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, yearsArray)
        yearSpinner.adapter = yearArrayAdapter

        fun dayOfWeek(month: Int, day: Int, year: Int): Int {
            var month = month
            var year = year
            if (month == 1) {
                month = 13
                year--
            } else if (month == 2) {
                month = 14
                year--
            }
            val h = (day + (((month + 1) * 26) / 10) + year + (year / 4) + 6
                    * (year / 100) + (year / 400)) % 7
            return h
        }

    }

    private fun getSpinnerPosition(spinner: Spinner) : Int{
        return spinner.selectedItemPosition
    }
}