package com.example.healthrecord

import android.os.Bundle
import android.widget.RadioGroup
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class SettingActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var seekBar: SeekBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_setting)

        radioGroup = findViewById(R.id.gender_radio_group)
        seekBar = findViewById(R.id.seek_bar_height)

        radioGroup.check(
            Preference.getInt(
                applicationContext,
                Preference.PREFERENCE_USER_DATA,
                Preference.KEY_GENDER,
                R.id.radio_button_man
            )
        )

        seekBar.progress = Preference.getInt(
            applicationContext,
            Preference.PREFERENCE_USER_DATA,
            Preference.KEY_HEIGHT,
            160
        )

        seekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                if (fromUser) {
                    showData()
                }
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }

        })
        showData()
    }

    override fun onPause() {
        super.onPause()
        Preference.setInt(
            applicationContext,
            Preference.PREFERENCE_USER_DATA,
            Preference.KEY_GENDER,
            radioGroup.checkedRadioButtonId
        )
        Preference.setInt(
            applicationContext,
            Preference.PREFERENCE_USER_DATA,
            Preference.KEY_HEIGHT,
            seekBar.progress
        )
    }

    private fun showData() {
        val heightText = findViewById<TextView>(R.id.height_text_view)
        heightText.text = seekBar.progress.toString()

    }
}