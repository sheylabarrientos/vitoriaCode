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

        val elevador = Elevador() //Aqui se está chamando a classe "Elevador"

        btnEntrar.setOnClickListener { //Ao clicar no botão "entrar", executar o que segue.
            val adicionar = elevador.adicionarPessoa() //Aqui se colocou o RESULTADO da função (e não a função em si) "adicionarPessoa()" da classe "Elevador" dentro de uma variável.
            if (adicionar != -1) { //Aqui se está dizendo "se a função "adicionarPessoa()" (da classe "Elevador") for diferente do erro que ela gera (aqui representado por "-1", que é qualquer coisa acima do número máximo de pessoas ("5")), então..."
                status.setText(adicionar.toString() + "/5") //"Colocar dentro da caixa de texto "pessoasNoElevador" o resultado da função "adicionarPessoa()" (transformada em string) e adicionar o texto subsequente.
            } else {
                Toast.makeText( //Aqui se criou um popup para avisar que o elevador está cheio, caso a condicional do "if" não ocorra.
                    this,
                    "Não cabem mais pessoas no elevador!",
                    Toast.LENGTH_SHORT).show()
            }
        }

        btnSair.setOnClickListener { //Ao clicar no botão "sair", executar o que segue.
            var excluir = elevador.excluirPessoa() //Aqui se colocou o RESULTADO da função (e não a função em si) "excluirPessoa()" da classe "Elevador" dentro de uma variável.
            if (excluir != -1) { //Aqui se está dizendo "se a função "excluirPessoa()" (da classe "Elevador") for diferente do erro que ela gera (aqui representado por "-1", que é qualquer coisa abaixo do número mínimo de pessoas ("1")), então..."
                status.setText(excluir.toString() + "/5") //"Colocar dentro da caixa de texto "pessoasNoElevador" o resultado da função "excluirPessoa()" (transformada em string) e adicionar o texto subsequente.
            } else {
                Toast.makeText( //Aqui se criou um popup para avisar que o elevador está vazio, caso a condicional do "if" não ocorra.
                    this,
                    "Não tem mais ninguém no elevador!",
                    Toast.LENGTH_SHORT).show()
            }
        }

    }








    fun pegaValorAndar(): Int {
        val andar = digitarAndar.text.toString()
        return andar.toInt()
    }

    fun subirElevador(andar: Int) {
//        for (i in 0..andar) {
//            andarAtual.text = i.toString()
//        }
        val recebeAndar = digitarAndar.text.toString()
        when (recebeAndar.toIntOrNull()) { //"Quando algo for digitado em "andar"..."
            in 1..12 -> {
                andarAtual.text =
                    recebeAndar + "˚" //"Se o número for entre "1" e "12" (considerando aqui que se determinou um prédiod e 12 andares), colocar o andar digitado dentro da caixa de texto "andarAtual", junto com o texto subsequente. andarAtual.text = null
                digitarAndar.text = null //Esse comando limpa a caixa de texto do andar.
            }
            else -> { //"Em caso diferente..."
                digitarAndar.error =
                    "Andar inválido!" //"Criar um erro na caixa de texto "digitarAndar" informando que o andar é inválido.
            }
            // return andar.toInt()
        }
    }
}



