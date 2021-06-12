package com.example.fibonacciseries

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.math.BigInteger

class MainActivity : AppCompatActivity() {
    lateinit var rvNumber: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
       castViews()
        rvNumber.layoutManager = LinearLayoutManager(baseContext)
        var numbers=fibonacci(100)
        var numbersAdapter = FibonacciRecyclerViewAdapter(numbers)
        rvNumber.adapter = numbersAdapter
    }
    fun castViews(){
        rvNumber = findViewById(R.id.rvNumbers)

    }

    fun fibonacci(i:Int):List<BigInteger> {
        var num1=BigInteger.ZERO
        var num2=BigInteger.ONE
        var numsList= MutableList<BigInteger>(i,{BigInteger.ZERO})
        numsList[0]=num1
        numsList[1]=num2
        for (number in 1..i ){
            var sum=num1+num2
            num1=num2
            num2=sum
           numsList[number-1]=num1

        }
        return numsList
    }
}








