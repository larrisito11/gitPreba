package com.example.hamburguesaszz

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx

    class MainActivity : AppCompatActivity() {

        private var arepasCount = 0
        private var empanadasCount = 0
        private val arepaPrice = 10000
        private val empanadaPrice = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val textViewArepaCount: TextView = findViewById(R.id.textViewArepaCount)
        val textViewEmpanadaCount: TextView = findViewById(R.id.textViewEmpanadaCount)
        val textViewTotal: TextView = findViewById(R.id.textViewTotal)
        val textViewChange: TextView = findViewById(R.id.textViewChange)
        val editTextPaid: EditText = findViewById(R.id.editTextPaid)

        val buttonArepaAdd: Button = findViewById(R.id.buttonArepaAdd)
        val buttonArepaSubtract: Button = findViewById(R.id.buttonArepaSubtract)
        val buttonEmpanadaAdd: Button = findViewById(R.id.buttonEmpanadaAdd)
        val buttonEmpanadaSubtract: Button = findViewById(R.id.buttonEmpanadaSubtract)
        val buttonCalculateChange: Button = findViewById(R.id.buttonCalculateChange)

        buttonArepaAdd.setOnClickListener {
            arepasCount++
            updateCounts(textViewArepaCount, textViewTotal)
        }

        buttonArepaSubtract.setOnClickListener {
            if (arepasCount > 0) {
                arepasCount--
                updateCounts(textViewArepaCount, textViewTotal)
            }
        }

        buttonEmpanadaAdd.setOnClickListener {
            empanadasCount++
            updateCounts(textViewEmpanadaCount, textViewTotal)
        }

        buttonEmpanadaSubtract.setOnClickListener {
            if (empanadasCount > 0) {
                empanadasCount--
                updateCounts(textViewEmpanadaCount, textViewTotal)
            }
        }

        buttonCalculateChange.setOnClickListener {
            val totalAmount = arepasCount * arepaPrice + empanadasCount * empanadaPrice
            val paidAmount = editTextPaid.text.toString().toDoubleOrNull() ?: 0.0
            val change = paidAmount - totalAmount
            textViewChange.text = "Cambio: ${String.format("%.2f", change)} gs"
        }
    }

    private fun updateCounts(arepaTextView: TextView, totalTextView: TextView) {
        arepaTextView.text = arepasCount.toString()
        val totalAmount = arepasCount * arepaPrice + empanadasCount * empanadaPrice
        totalTextView.text = "Total: ${totalAmount} gs"
    }
}
