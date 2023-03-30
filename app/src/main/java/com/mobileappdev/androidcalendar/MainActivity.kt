package com.mobileappdev.androidcalendar


import android.os.Bundle
import android.view.View
import android.widget.AdapterView.OnItemClickListener
import android.widget.ArrayAdapter
import android.widget.GridView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

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
}