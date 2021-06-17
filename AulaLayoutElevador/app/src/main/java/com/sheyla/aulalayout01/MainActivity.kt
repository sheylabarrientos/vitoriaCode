package com.sheyla.aulalayout01

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    private lateinit var andarAtual: TextView
    private lateinit var digitarAndar: EditText
    private lateinit var btnAndar: Button
    private lateinit var btnEntrar: Button
    private lateinit var btnSair: Button
    private lateinit var status: TextView
    private val elevador = Elevador() //Aqui se está chamando a classe "Elevador"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initViews()

        btnAndar.setOnClickListener {
            subirElevador()
        }

        btnEntrar.setOnClickListener { //Ao clicar no botão "entrar", executar o que segue.
            adicionaPessoa()
        }

        btnSair.setOnClickListener { //Ao clicar no botão "sair", executar o que segue.
            removePessoa()
        }
    }

    private fun initViews() {
        andarAtual = findViewById(R.id.andarAtual)
        digitarAndar = findViewById(R.id.digitarAndar)
        btnAndar = findViewById(R.id.btnAndar)
        btnEntrar = findViewById(R.id.btnEntrar)
        btnSair = findViewById(R.id.btnSair)
        status = findViewById(R.id.status)
    }

//    fun pegaValorAndar(): Int {
//        val andar = d5igitarAndar.text.toString()
//        return andar.toInt()
//    }

    private fun subirElevador() {
        val recebeAndar = digitarAndar.text.toString()
        when (recebeAndar.toIntOrNull()) { //"Quando algo for digitado em "andar"..."
            in 1..12 -> {
                andarAtual.text =
                    getString(
                        R.string.simbolo_grau_elevador,
                        recebeAndar
                    ) /* "Se o número for entre "1" e "12" (considerando aqui que se determinou um prédiod e 12 andares), colocar o andar digitado dentro da caixa de texto "andarAtual", junto com o texto subsequente. andarAtual.text = null */
                digitarAndar.text = null //Esse comando limpa a caixa de texto do andar.
            }
            else -> { //"Em caso diferente..."
                digitarAndar.error =
                    getString(R.string.andar_invalido) //"Criar um erro na caixa de texto "digitarAndar" informando que o andar é inválido.
            }
        }
    }

    private fun adicionaPessoa() {
        val adicionar =
            elevador.adicionarPessoa() //Aqui se colocou o RESULTADO da função (e não a função em si) "adicionarPessoa()" da classe "Elevador" dentro de uma variável.
        if (adicionar != -1) { //Aqui se está dizendo "se a função "adicionarPessoa()" (da classe "Elevador") for diferente do erro que ela gera (aqui representado por "-1", que é qualquer coisa acima do número máximo de pessoas ("5")), então..."
            status.text = getString(
                R.string.status_andar,
                adicionar.toString()
            ) //"Colocar dentro da caixa de texto "pessoasNoElevador" o resultado da função "adicionarPessoa()" (transformada em string) e adicionar o texto subsequente.
        } else {
            Toast.makeText( //Aqui se criou um popup para avisar que o elevador está cheio, caso a condicional do "if" não ocorra.
                this,
                getString(R.string.elevador_lotado),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun removePessoa() {
        val excluir =
            elevador.excluirPessoa() //Aqui se colocou o RESULTADO da função (e não a função em si) "excluirPessoa()" da classe "Elevador" dentro de uma variável.
        if (excluir != -1) { //Aqui se está dizendo "se a função "excluirPessoa()" (da classe "Elevador") for diferente do erro que ela gera (aqui representado por "-1", que é qualquer coisa abaixo do número mínimo de pessoas ("1")), então..."
            status.text = getString(
                R.string.status_andar,
                excluir.toString()
            )//"Colocar dentro da caixa de texto "pessoasNoElevador" o resultado da função "excluirPessoa()" (transformada em string) e adicionar o texto subsequente.
        } else {
            Toast.makeText( //Aqui se criou um popup para avisar que o elevador está vazio, caso a condicional do "if" não ocorra.
                this,
                getString(R.string.elevador_vazio),
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}




