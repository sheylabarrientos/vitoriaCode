package com.sheyla.minhaagenda

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class SecondActivity : AppCompatActivity() {

    private lateinit var campoPesquisa: EditText
    private lateinit var btnPesquisar: ImageButton
    private lateinit var btnExibirTodos: Button
    private lateinit var listaContatos: TextView
    private lateinit var contatosListaRecyclerView: RecyclerView
    private lateinit var adapter: ContatosAdapter
    private var contatos = arrayListOf<Pessoa>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        bindViews()

        val extras = intent.extras
        val contatos = extras?.getParcelableArrayList<Pessoa>("CONTATOS")
        contatos?.let { it1 -> exibirLista(it1) }

        btnPesquisar.setOnClickListener {
            //pesquisarContato()
        }
        btnExibirTodos.setOnClickListener {

        }

    }

    private fun exibirLista(contatos: ArrayList<Pessoa>) {
        adapter = ContatosAdapter(contatos)
        contatosListaRecyclerView.adapter = adapter
        contatosListaRecyclerView.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

//        contatos.sortBy { it.getNome() }
//        listaContatos.visibility = View.VISIBLE
//        var message = ""
//        for (contact in contatos) {
//            message += "${contact.getNome()} ${contact.getNumber()}, ${contact.getRef()}\n\n"
//        }
//        listaContatos.text = message
    }

    private fun bindViews() {
        campoPesquisa = findViewById(R.id.campoPesquisar)
        btnPesquisar = findViewById(R.id.btnPesquisar)
        btnExibirTodos = findViewById(R.id.btnExibirTodos)
        contatosListaRecyclerView = findViewById(R.id.recyclerViewContatos)
        listaContatos = findViewById(R.id.listaContatos)
    }

//    private fun pesquisarContato() {
//        val pesquisa = campoPesquisa.text.toString()
//        val resultado = contatos.find { pessoa ->
//            pessoa.getNome() == pesquisa
//        }
//        if (resultado != null) {
//            Toast.makeText(
//                this,
//                resultado.exibirTodos(),
//                Toast.LENGTH_SHORT
//            ).show()
//        } else {
//            Toast.makeText(
//                this,
//                "Não foi possível encontrar um contato",
//                Toast.LENGTH_SHORT
//            ).show()
//        }
//
//    }

    companion object {
        var contatosList = mutableListOf<Pessoa>()
    }
}