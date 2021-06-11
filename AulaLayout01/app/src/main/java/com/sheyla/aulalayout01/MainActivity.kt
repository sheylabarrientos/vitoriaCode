package com.sheyla.aulalayout01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var andarAtual: TextView
    lateinit var digitarAndar: EditText
    lateinit var btnAndar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        andarAtual = findViewById(R.id.andarAtual)
        digitarAndar = findViewById(R.id.digitarAndar)
        btnAndar = findViewById(R.id.btnAndar)

        btnAndar.setOnClickListener {
            subirElevador(pegaValorAndar())
        }

    }


    fun pegaValorAndar(): Int {
        val andar = digitarAndar.text.toString()
        return andar.toInt()
    }

    fun subirElevador(andar: Int) {
        for (i in 0..andar) {
            andarAtual.text = i.toString()
        }
    }
}



