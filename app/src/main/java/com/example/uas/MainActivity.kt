package com.example.uas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    private lateinit var namaAnakEditText: EditText
    private lateinit var tahunEditText: EditText
    private lateinit var bulanEditText: EditText
    private lateinit var resultTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        namaAnakEditText = findViewById(R.id.namaAnakEditText)
        tahunEditText = findViewById(R.id.tahunEditText)
        bulanEditText = findViewById(R.id.bulanEditText)
        resultTextView = findViewById(R.id.resultTextView)
    }

    fun hitungBbIdeal(view: View) {
        val nama = namaAnakEditText.text.toString().trim()
        val tahun = tahunEditText.text.toString().toIntOrNull() ?: 0
        val bulan = bulanEditText.text.toString().toIntOrNull() ?: 0

        if (nama.isNotEmpty()) {
            val umurDalamBulan = tahun * 12 + bulan

            if (tahun <= 5 && umurDalamBulan < 72 && bulan <= 11) {
                val bbIdeal = calculateBbIdeal(tahun, bulan)
                resultTextView.text = "$nama \nUsia $tahun tahun, $bulan bulan \nBerat Badan Idealnya adalah $bbIdeal kg"
            } else {
                Toast.makeText(this, "Umur anak melebihi 5 tahun atau tanggal lebih dari 11 bulan", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(this, "Nama tidak boleh kosong", Toast.LENGTH_SHORT).show()
        }

    }

    private fun calculateBbIdeal(tahun: Int, bulan: Int): Double {
        val ageInMonths = tahun * 12 + bulan
        val rumus =  2*ageInMonths + 8


        return rumus.toDouble()

    }
}