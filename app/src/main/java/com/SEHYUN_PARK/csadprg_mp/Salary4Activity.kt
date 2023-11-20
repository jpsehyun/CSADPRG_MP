package com.SEHYUN_PARK.csadprg_mp

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class Salary4Activity : AppCompatActivity() {
    lateinit var selectedDay: String
    lateinit var computeBtn: Button
    lateinit var nextBtn: Button
    lateinit var startEtv: EditText
    lateinit var endEtv: EditText
    lateinit var overtimeTv: TextView
    lateinit var salaryTotal: TextView
    lateinit var nightShift: TextView
    lateinit var dayTv: TextView
    lateinit var dailyRateTv: TextView

    var startTime: Int = 0
    var endTime: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.salary_view)

        computeBtn = findViewById(R.id.weekly_Home_Btn)
        startEtv = findViewById(R.id.salary_Intime_Etv)
        endEtv = findViewById(R.id.salary_Outtime_Etv)
        overtimeTv = findViewById(R.id.salary_overTime)
        salaryTotal = findViewById(R.id.salary_Salary_Tv)
        nightShift = findViewById(R.id.salary_nightShift)
        dailyRateTv = findViewById(R.id.first_Salary)
        dailyRateTv.setText(Computation.getDailySalary().toString())

        nextBtn = findViewById(R.id.salary_Next_Btn)

        startEtv.setText(Computation.getDefaultIn().toString())
        endEtv.setText(Computation.getDefaultOut().toString())

        dayTv = findViewById(R.id.salary_Day_Tv)
        dayTv.setText("Thursday")

        // Reference https://developer.android.com/develop/ui/views/components/spinner
        val spinner = findViewById<Spinner>(R.id.spinner)
        ArrayAdapter.createFromResource(
            this,
            R.array.days,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }

        computeBtn.setOnClickListener{
            selectedDay = spinner.selectedItem.toString()
            startTime = startEtv.getText().toString().toInt()
            endTime = endEtv.getText().toString().toInt()

            var ctr: Int = startTime
            var hours_Worked: Int = 0
            var overTime: Int = 0
            var night_Overtime : Int = 0
            var night_Shift: Int = 0

            if (endTime == 0)
                endTime = 2400

            if (startTime > endTime){
                endTime += 2400
            }

            for (i in startTime .. endTime step 100){

                if (ctr == 2300 || ctr == 2400 || ctr <= 600){
                    if (hours_Worked > Computation.getNumWorkHour() + 1){
                        night_Overtime++
                    }
                    else{
                        night_Shift++
                    }
                }

                if (hours_Worked > Computation.getNumWorkHour() + 1){
                    if (!(ctr == 2300 || ctr == 2400 || ctr <= 600)){
                        overTime++
                    }

                }

                hours_Worked += 1
                ctr += 100
                if (i == 2400)
                    ctr = 0;
            }

            hours_Worked -= 1
            if (startTime == 2300 || startTime == 2400 || startTime == 0 || startTime <= 600){
                night_Shift -= 1
            }

            var dailyRate: Float = Computation.getDailySalary() / Computation.getNumWorkHour()

            var computation =  Computation(selectedDay)
            var OT = dailyRate * overTime * computation.overTime
            var NSOT = dailyRate * night_Overtime * computation.nightOverTime
            var NS: Float = dailyRate * night_Shift * 1.1f
            var baseSalary = Computation.getDailySalary() * computation.dailyRate
            var totalSalary = baseSalary+NS+NSOT+OT

            if (startTime == 900 && endTime == 900){
                if (selectedDay.equals("Rest Day")){
                    totalSalary = Computation.getDailySalary()
                }
                else{
                    totalSalary = 0f
                }
            }

            overtimeTv.setText(overTime.toString() + "(" + night_Overtime.toString() + ")")
            nightShift.setText(night_Shift.toString())
            salaryTotal.setText((totalSalary).toString())

            DailySalary.setFourth((totalSalary).toString())

        }

        nextBtn.setOnClickListener{
            loadNextScreen()
        }

    }


    private fun loadNextScreen() {
        var intentLoadNextActivity = Intent(this, Salary5Activity::class.java)
        startActivity(intentLoadNextActivity)

    }
}