package com.sheyla.minhaagenda

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    lateinit var campoNome: EditText
    lateinit var campoCelular: EditText
    lateinit var rdGroup: RadioGroup
    lateinit var rdPessoal: RadioButton
    lateinit var rdTrabalho: RadioButton
    lateinit var campoReferencia: EditText
    //lateinit var btnSalvar: Button

    lateinit var navegar: FloatingActionButton



    var contatos: MutableList<Pessoa> = mutableListOf()

    lateinit var contatosCadastrados: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        campoNome = findViewById(R.id.campoNome)
        campoCelular = findViewById(R.id.campoCelular)
        rdGroup = findViewById(R.id.rdReferencia)
        rdPessoal = findViewById(R.id.rdPessoal)
        rdTrabalho = findViewById(R.id.rdTrabalho)
        campoReferencia = findViewById(R.id.campoReferencia)
        //btnSalvar = findViewById(R.id.btnSalvar)

        contatosCadastrados = findViewById(R.id.contatosCadastrados)


        navegar = findViewById(R.id.navegar)

        navegar.setOnClickListener{

            if (campoNome.text.isEmpty()) {
                campoNome.error = "Digite um nome."
            } else if (campoCelular.text.isEmpty()) {
                campoCelular.error = "Digite um número de telefone."
            } else if (campoReferencia.text.isEmpty()) {
                campoReferencia.error = "Digite uma referência."
            }else {

                val nomeDigitado = campoNome.text.toString()
                val numeroCelular = campoCelular.text.toString()
                val campoReferencia = campoReferencia.text.toString()
                val referenciaSelecionada = rdGroup.checkedRadioButtonId

                referenciaSelecionada.let {
                    cadastrarContato(nomeDigitado, numeroCelular, campoReferencia)
                }

                val intent = Intent(this, SecondActivity::class.java)
                intent.putExtra(NOME_KEY, "salvar")
                startActivity(intent)
            }


        }

    }

//     fun bindViews() {
//        campoNome = findViewById(R.id.campoNome)
//        campoCelular = findViewById(R.id.campoCelular)
//        rdGroup = findViewById(R.id.rdReferencia)
//        rdPessoal = findViewById(R.id.rdPessoal)
//        rdTrabalho = findViewById(R.id.rdTrabalho)
//        campoReferencia = findViewById(R.id.campoReferencia)
//        btnSalvar = findViewById(R.id.btnSalvar)
//
//        contatosCadastrados = findViewById(R.id.contatosCadastrados)
//
//        btnSalvar.setOnClickListener {
//            val nomeDigitado = campoNome.text.toString()
//            val numeroCelular = campoCelular.text.toString()
//            val campoReferencia = campoReferencia.text.toString()
//            val referenciaSelecionada = rdGroup.checkedRadioButtonId
//
//            referenciaSelecionada?.let {
//                cadastrarContato(nomeDigitado, numeroCelular, campoReferencia)
//            }
//
//
//        }
//
//
//    }


    fun cadastrarContato(nome: String, telefone: String, referencia: String) {
        contatos.add(
            Pessoa(nome = nome, telefone = telefone, referencia = referencia)
        )

        Toast.makeText(
            this,
            contatos.last().exibirTodos(),
            Toast.LENGTH_SHORT
        ).show()
    }

    fun MutableList<Pessoa>.exibirContatos() {
        contatos.sortBy { it.getNome() }
        contatosCadastrados.visibility = View.VISIBLE
        var message = ""
        for (contact in contatos) {
            message += "${contact.getNome()} ${contact.getNumber()}, ${contact.getRef()}\n\n"
        }
        contatosCadastrados.text = message
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

//    override fun onResume() {
////        super.onResume()
////        Log.d("MeuAplicativo", "Ciclo de vida onResumo")
// }

    companion object {
        val NOME_KEY = "NOME"
    }
}





