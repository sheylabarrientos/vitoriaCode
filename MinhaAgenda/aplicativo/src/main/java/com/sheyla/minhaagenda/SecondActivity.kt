package com.sheyla.minhaagenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*

class SecondActivity : AppCompatActivity() {


     lateinit var campoPesquisa: EditText
     lateinit var btnPesquisar: ImageButton
     lateinit var btnExibirTodos: Button

    lateinit var listaContatos: TextView

    var contatos: MutableList<Pessoa> = mutableListOf()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        bindViews()

        val nomeRecebido = intent.getStringExtra("salvar")

        Toast.makeText(this, "Contato: $nomeRecebido",
          Toast.LENGTH_LONG).show()

    }

    fun bindViews() {
        campoPesquisa = findViewById(R.id.campoPesquisar)
        btnPesquisar = findViewById(R.id.btnPesquisar)
        btnExibirTodos = findViewById(R.id.btnExibirTodos)


        listaContatos = findViewById(R.id.listaContatos)


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

    open fun MutableList<Pessoa>.exibirLista() {
        contatos.sortBy { it.getNome() }
        listaContatos.visibility = View.VISIBLE
        var message = ""
        for (contact in contatos) {
            message += "${contact.getNome()} ${contact.getNumber()}, ${contact.getRef()}\n\n"
        }
        listaContatos.text = message
    }

        override fun onResume() {
        super.onResume()
//        Log.d("MeuAplicativo", "Ciclo de vida onResumo")
 }

}