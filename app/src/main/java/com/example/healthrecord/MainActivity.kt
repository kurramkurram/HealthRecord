package com.example.healthrecord

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import androidx.appcompat.app.AppCompatActivity
import java.math.BigDecimal
import java.util.*

class MainActivity : AppCompatActivity(), DatePickerDialog.OnDateSetListener {

    private lateinit var dateBtn: Button
    private var cal = Calendar.getInstance()
    private var weight: BigDecimal = BigDecimal("50.0")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        dateBtn = findViewById(R.id.button_show_date)
        val dateAddBtn = findViewById<Button>(R.id.button_add_date)
        val dateReduceBtn = findViewById<Button>(R.id.button_reduce_date)

        val weightAddBtn = findViewById<Button>(R.id.button_add_weight)
        val weightReduceBtn = findViewById<Button>(R.id.button_reduce_weight)

        val saveBtn = findViewById<Button>(R.id.button_save)
        val settingBtn = findViewById<Button>(R.id.button_setting)

        dateBtn.setOnClickListener { onDateButtonTapped(it) }
        dateAddBtn.setOnClickListener { onDateButtonChangedTapped(it) }
        dateReduceBtn.setOnClickListener { onDateButtonChangedTapped(it) }
        weightAddBtn.setOnClickListener { onWeightButtonChangedTapped(it) }
        weightReduceBtn.setOnClickListener { onWeightButtonChangedTapped(it) }
        saveBtn.setOnClickListener { onSavedButtonTapped(it) }
        settingBtn.setOnClickListener { onSettingButtonTapped() }

        showData()
    }

    private fun onSavedButtonTapped(view: View) {
        val dialog = MainDialogFragment()
        dialog.show(supportFragmentManager, "MainDialogFragment")
    }

    private fun onDateButtonTapped(view: View) {
        val dialog = DatePickerFragment()
        dialog.show(supportFragmentManager, "DatePickerFragment")
    }

    override fun onDateSet(view: DatePicker?, year: Int, month: Int, dayOfMonth: Int) {
        cal.set(year, month, dayOfMonth)
        showData()
    }

    private fun onDateButtonChangedTapped(view: View) {
        when (view.id) {
            R.id.button_add_date -> cal.add(Calendar.DATE, 1)
            R.id.button_reduce_date -> cal.add(Calendar.DATE, -1)
        }
        showData()
    }

    private fun onWeightButtonChangedTapped(view: View) {
        when (view.id) {
            R.id.button_add_weight -> weight += BigDecimal("0.1")
            R.id.button_reduce_weight -> weight += BigDecimal("-0.1")
        }
        showData()
    }

    @SuppressLint("SetTextI18n")
    private fun showData() {
        val weightBtn = findViewById<Button>(R.id.button_show_weight)
        weightBtn.text = weight.toString()

        dateBtn.text = getToday()
    }

    private fun getToday(): String {
        return cal.get(Calendar.YEAR).toString()
            .plus("/")
            .plus((cal.get(Calendar.MONTH) + 1).toString())
            .plus("/")
            .plus(cal.get(Calendar.DATE))
    }

    private fun onSettingButtonTapped() {
        val intent = Intent(this, SettingActivity::class.java)
        startActivity(intent)
    }
}
