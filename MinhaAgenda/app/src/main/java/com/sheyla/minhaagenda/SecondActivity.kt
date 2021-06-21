package com.sheyla.minhaagenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    private lateinit var campoPesquisa: EditText
    private lateinit var btnPesquisar: ImageButton
    private lateinit var btnExibirTodos: Button
    private lateinit var listaContatos: TextView
    private lateinit var contatosListaRecyclerView: RecyclerView
    private var contatos: MutableList<Pessoa> = mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        bindViews()

        val listaContatosRecebida = intent.extras?.get("contatos")

        listaContatos.text = listaContatosRecebida as CharSequence?

        btnPesquisar.setOnClickListener {
            pesquisarContato()
        }
        btnExibirTodos.setOnClickListener {
            exibirLista()
        }
        Toast.makeText(
            this, "Contato Recebido",
            Toast.LENGTH_LONG
        ).show()
    }

    private fun exibirLista() {
        contatos.sortBy { it.getNome() }
        listaContatos.visibility = View.VISIBLE
        var message = ""
        for (contact in contatos) {
            message += "${contact.getNome()} ${contact.getNumber()}, ${contact.getRef()}\n\n"
        }
        listaContatos.text = message
    }

    private fun bindViews() {
        campoPesquisa = findViewById(R.id.campoPesquisar)
        btnPesquisar = findViewById(R.id.btnPesquisar)
        btnExibirTodos = findViewById(R.id.btnExibirTodos)
        contatosListaRecyclerView = findViewById(R.id.recyclerViewContatos)
        listaContatos = findViewById(R.id.listaContatos)
    }

    private fun pesquisarContato() {
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

companion object {
    //val myContacts: ContatoLista = ContatoLista()
}

}