package com.sheyla.minhaagenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    private lateinit var campoNome: EditText
    private lateinit var campoCelular: EditText
    private lateinit var rdGroup: RadioGroup
    private lateinit var rdPessoal: RadioButton
    private lateinit var rdTrabalho: RadioButton
    private lateinit var campoReferencia: EditText
    private lateinit var btnSalvar: Button
    private lateinit var campoPesquisa: EditText
    private lateinit var btnPesquisar: ImageButton
    private lateinit var btnExibirTodos: Button

    lateinit var listaContatos: TextView


    var contatos: MutableList<Pessoa> = mutableListOf()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()
    }

    private fun bindViews() {
        campoNome = findViewById(R.id.campoNome)
        campoCelular = findViewById(R.id.campoCelular)
        rdGroup = findViewById(R.id.rdReferencia)
        rdPessoal = findViewById(R.id.rdPessoal)
        rdTrabalho = findViewById(R.id.rdTrabalho)
        campoReferencia = findViewById(R.id.campoReferencia)
        btnSalvar = findViewById(R.id.btnSalvar)
        campoPesquisa = findViewById(R.id.campoPesquisar)
        btnPesquisar = findViewById(R.id.btnPesquisar)
        btnExibirTodos = findViewById(R.id.btnExibirTodos)
        listaContatos = findViewById(R.id.listaContatos)



        btnSalvar.setOnClickListener {
            val nomeDigitado = campoNome.text.toString()
            val numeroCelular = campoCelular.text.toString()
            val campoReferencia = campoReferencia.text.toString()
            val referenciaSelecionada = rdGroup.checkedRadioButtonId

            referenciaSelecionada?.let {
                cadastrarContato(nomeDigitado, numeroCelular, campoReferencia)
            }
        }

        btnPesquisar.setOnClickListener() {
            val pesquisa = campoPesquisa.text.toString()

            val resultado = contatos.find { pessoa ->
                pessoa.getNome() == pesquisa
            }

            if (resultado != null) {
                Toast.makeText(
                    this,
                    resultado.exibirTodos(),
                    Toast.LENGTH_SHORT
                ).show()
            } else {
                Toast.makeText(
                    this,
                    "Não foi possível encontrar um contato",
                    Toast.LENGTH_SHORT
                ).show()
            }

        }

        btnExibirTodos.setOnClickListener {
            contatos.exibirLista()
            listaContatos.text
    }


    }


    private fun cadastrarContato(nome: String, telefone: String, referencia: String) {
        contatos.add(
            Pessoa(nome = nome, telefone = telefone, referencia = referencia)
        )

        Toast.makeText(
            this,
            contatos.last().exibirTodos(),
            Toast.LENGTH_SHORT
        ).show()
    }


    fun onRadioButtonClicked(view: View) {

        if (view is RadioButton) {

            //Caso especial pra Radio B(urro)utton
            val foiChecado = view.isChecked

            when (view.id) {
                R.id.rdPessoal ->
                    if (foiChecado) {
                        campoReferencia.setHint("Referência")
                    }
                R.id.rdTrabalho -> {
                    if (foiChecado) {
                        campoReferencia.setHint("E-mail")
                    }
                }
            }

        }
    }

    fun MutableList<Pessoa>.exibirLista() {
        contatos.sortBy { it.getNome() }
        listaContatos.visibility = View.VISIBLE
        var message = ""
        for(contact in contatos){
            message += "${contact.getNome()} ${contact.getNumber()}, ${contact.getRef()}\n\n"
        }
        listaContatos.text = message
    }

}


