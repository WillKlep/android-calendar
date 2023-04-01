package com.mobileappdev.androidcalendar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import java.util.*


class CalendarAdapter(private val context: Context, private val days: List<Int>) : BaseAdapter() {
    override fun getCount(): Int {
        return days.size
    }

    override fun getItem(position: Int): Any {
        return days[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.calendar_day_item, parent, false)
        }

        val textView = view!!.findViewById<TextView>(R.id.calendar_day_textview)
        textView.text = days[position].toString()

        return view
    }
}