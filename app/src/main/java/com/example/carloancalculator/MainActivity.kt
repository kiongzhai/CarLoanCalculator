package com.example.carloancalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener {
            calculateRepayment()
        }
    }

    private fun calculateRepayment() {
        //TODO get inputs and show outputs
        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }
        val carPrice: Int = editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextDownPayment.text.toString().toInt()
        val loan = carPrice - downPayment

        textViewLoan.setText(getString(R.string.loan) + "${loan}")


        val loanPeriod = editTextLoanPeriod.text.toString().toInt()
        val interestRate = editTextInterestRate.text.toString().toFloat()
        val interest = loan*interestRate/100*loanPeriod

        textViewInterest.setText(getString(R.string.interest_rate) + "${interest}")

        val monthlyRepayment = (loan+interest)/loanPeriod/12

        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "${monthlyRepayment}")

    }

    fun reset(view : View){
        editTextCarPrice.getText().clear()
        editTextDownPayment.getText().clear()
        editTextInterestRate.getText().clear()
        editTextLoanPeriod.getText().clear()
    }
}
