package com.SEHYUN_PARK.csadprg_mp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class SettingActivity : AppCompatActivity() {
    lateinit var btn: Button

    lateinit var dailySalary: EditText
    lateinit var numWorkHour: EditText
    lateinit var defaultIn: EditText
    lateinit var defaultOut: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.settings_view)

        this.btn = findViewById(R.id.setting_Confirm_Btn)
        this.dailySalary = findViewById(R.id.setting_daily_salary)
        this.numWorkHour = findViewById(R.id.setting_workhour)
        this.defaultIn = findViewById(R.id.setting_defaultIn)
        this.defaultOut = findViewById(R.id.setting_defaultOut)

        btn.setOnClickListener{

            var a = dailySalary.getText().toString().toFloat()
            Computation.setDailySalary(a)

            var b = numWorkHour.getText().toString().toFloat()
            Computation.setNumWorkHour(b)

            var c = defaultIn.getText().toString()
            Computation.setDefaultIn(c)

            var d = defaultOut.getText().toString()
            Computation.setDefaultOut(d)

            loadNextScreen()
        }

    }

    private fun loadNextScreen() {
        var intentLoadNextActivity = Intent(this, MainActivity::class.java)
        startActivity(intentLoadNextActivity)
    }
}