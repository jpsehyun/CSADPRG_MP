package com.SEHYUN_PARK.csadprg_mp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    lateinit var btn: Button
    lateinit var btn_set: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        this.btn = findViewById(R.id.main_Salary_Btn)
        this.btn_set = findViewById(R.id.main_Setting_Btn)

        btn.setOnClickListener{
            loadNextScreen()
        }

        btn_set.setOnClickListener{
            loadSettingScreen()
        }

    }

    private fun loadNextScreen() {
        var intentLoadNextActivity = Intent(this, SalaryActivity::class.java)
        startActivity(intentLoadNextActivity)
    }

    private fun loadSettingScreen() {
        var intentLoadNextActivity = Intent(this, SettingActivity::class.java)
        startActivity(intentLoadNextActivity)
    }
}