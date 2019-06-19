package com.example.montante

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import java.text.DecimalFormat
import java.text.Format
import java.text.NumberFormat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val but = findViewById(R.id.button) as Button
        val vi = findViewById(R.id.vi) as EditText
        val tj = findViewById(R.id.tj) as EditText
        val pt = findViewById(R.id.pt) as EditText
        val mf = findViewById(R.id.mf) as TextView
        but.setOnClickListener {
            val c = vi.text.toString().toDoubleOrNull()
            val i = tj.text.toString().toDoubleOrNull()
            val t = pt.text.toString().toDoubleOrNull()
            var m = 0.0

            if ((c != null) && (i != null) && (t != null)) {
                m = vi.text.toString().toDouble() * ((1 + (tj.text.toString().toDouble()/100)).pow(pt.text.toString().toDouble()))
                mf.setText(DecimalFormat("0.00").format(m))
            } else {
                Toast.makeText(
                    applicationContext,
                    "Uma das entradas não está preenchida com um número",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}
