package com.example.gasto_viagem

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener { calculate() }

    }

    override fun onClick(view: View) {
        val id = view.id
        if (id == R.id.buttonCalculate) {
            calculate()
        }
    }

    private fun isValid(): Boolean {
        return (editDistance.text.toString() != ""
                && editPrice.text.toString() != ""
                && editAutonomy.text.toString() != ""
                )
    }

    private fun calculate() {
        if (isValid()) {
            val distance = editDistance.text.toString().toFloat()
            val price = editPrice.text.toString().toFloat()
            val autonomy = editAutonomy.text.toString().toFloat()

            val totalValue = (distance * price) / autonomy
            textTotalValue.text = "R$${"%.2f".format(totalValue)}"
        } else {
            Toast.makeText(this, R.string.validation_value, Toast.LENGTH_SHORT).show()
        }
    }
}
