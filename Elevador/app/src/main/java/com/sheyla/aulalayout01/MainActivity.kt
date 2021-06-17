package com.sheyla.aulalayout01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    lateinit var andarAtual: TextView
    lateinit var digitarAndar: EditText
    lateinit var btnAndar: Button
    lateinit var btnEntrar: Button
    lateinit var btnSair: Button
    lateinit var status: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        andarAtual = findViewById(R.id.andarAtual)
        digitarAndar = findViewById(R.id.digitarAndar)
        btnAndar = findViewById(R.id.btnAndar)
        btnEntrar = findViewById(R.id.btnEntrar)
        btnSair = findViewById(R.id.btnSair)
        status = findViewById(R.id.status)

        btnAndar.setOnClickListener {
            subirElevador(pegaValorAndar())
        }

        val elevador = Elevador() //Chamando a classe "Elevador"

        btnEntrar.setOnClickListener { //Botao Entrar
            val adicionar = elevador.adicionarPessoa() 
            if (adicionar != -1) { 
                status.setText(adicionar.toString() + "/5")te.
            } else {
                Toast.makeText(
                    this,
                    "Não cabem mais pessoas no elevador!",
                    Toast.LENGTH_SHORT).show()
            }
        }

        btnSair.setOnClickListener { //Botao Sair
            val excluir = elevador.excluirPessoa() 
            if (excluir != -1) {
                status.setText(excluir.toString() + "/5") 
            } else {
                Toast.makeText(
                    this,
                    "Não tem mais ninguém no elevador!",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }


    fun subirElevador(andar: Int) { //Subir Andares
        val recebeAndar = digitarAndar.text.toString()
        when (recebeAndar.toIntOrNull()) { 
            in 1..12 -> {
                andarAtual.text =
                    recebeAndar + "˚" 
            }
            else -> { 
                digitarAndar.error =
                    "Andar inválido!" 
            }
            // return andar.toInt()
        }
    }
}



