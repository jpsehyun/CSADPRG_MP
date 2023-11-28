package com.SEHYUN_PARK.csadprg_mp

class Computation {
    var dailyRate: Float = 0f
    var overTime: Float = 0f
    var nightOverTime: Float = 0f

    constructor(Day: String){
        if (Day.equals("Normal Day")){
            this.dailyRate = 1f
            this.overTime = 1.25f
            this.nightOverTime = 1.375f
        }
        else if (Day.equals("Rest Day") || Day.equals("SNWD")){
            this.dailyRate = 1.3f
            this.overTime = 1.69f
            this.nightOverTime = 1.859f
        }
        else if (Day.equals("SNWD + Rest Day")){
            this.dailyRate = 1.5f
            this.overTime = 1.95f
            this.nightOverTime = 2.145f
        }
        else if (Day.equals("Regular Holiday")){
            this.dailyRate = 2f
            this.overTime = 2.6f
            this.nightOverTime = 2.86f
        }
        else{
            this.dailyRate = 2.6f
            this.overTime = 3.38f
            this.nightOverTime = 3.718f
        }
    }

    companion object{
        private var dailySalary = 500f
        private var numWorkhour = 8f
        private var defaultIn = "0900"
        private var defaultOut = "1800"

        fun setDailySalary(x: Float){
            dailySalary = x
        }

        fun setNumWorkHour(x: Float){
            numWorkhour = x
        }

        fun setDefaultIn(x: String){
            defaultIn = x
        }

        fun setDefaultOut(x: String){
            defaultOut = x
        }

        fun getDailySalary(): Float{
            return dailySalary
        }

        fun getNumWorkHour(): Float{
            return numWorkhour
        }

        fun getDefaultIn(): String{
            return defaultIn
        }

        fun getDefaultOut(): String{
            return defaultOut
        }
    }

}