package com.SEHYUN_PARK.csadprg_mp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class WeeklyActivity : AppCompatActivity() {
    lateinit var monday: TextView
    lateinit var tuesday: TextView
    lateinit var wednesday: TextView
    lateinit var thursday: TextView
    lateinit var friday: TextView
    lateinit var saturday: TextView
    lateinit var sunday: TextView
    lateinit var total: TextView

    lateinit var btn: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.weekly_salary_view)

        monday = findViewById(R.id.first_Salary)
        tuesday = findViewById(R.id.salary_overTime)
        wednesday = findViewById(R.id.third_Salary)
        thursday = findViewById(R.id.fourth_Salary)
        friday = findViewById(R.id.fifth_Salary)
        saturday = findViewById(R.id.sixth_Salary)
        sunday = findViewById(R.id.seventh_Salary)

        total = findViewById(R.id.total_Salary)

        monday.setText(DailySalary.getFirst())
        tuesday.setText((DailySalary.getSecond()))
        wednesday.setText(DailySalary.getThird())
        thursday.setText(DailySalary.getFourth())
        friday.setText(DailySalary.getFifth())
        saturday.setText(DailySalary.getSixth())
        sunday.setText(DailySalary.getSeventh())

        var sum = DailySalary.getFirst().toFloat() + DailySalary.getSecond().toFloat() + DailySalary.getThird().toFloat() + DailySalary.getFourth().toFloat() + DailySalary.getFifth().toFloat() + DailySalary.getSixth().toFloat() + DailySalary.getSeventh().toFloat()
        total.setText(sum.toString())

        btn = findViewById(R.id.weekly_Home_Btn)
        btn.setOnClickListener{
            loadNextScreen()
        }
    }


    private fun loadNextScreen() {
        var intentLoadNextActivity = Intent(this, MainActivity::class.java)
        startActivity(intentLoadNextActivity)

    }
}