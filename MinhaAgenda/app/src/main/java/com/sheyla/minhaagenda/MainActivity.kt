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
    lateinit var navegar: FloatingActionButton

    var contatos = arrayListOf<Pessoa>() //lista de contatos declaração
    lateinit var contatosCadastrados: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        bindViews()

        navegar.setOnClickListener {
        irParaSecondActivity()
        }
 }

    private fun irParaSecondActivity() {
        salvarContato() //função salvar contato
        val intent = Intent(this, SecondActivity::class.java)
        intent.putParcelableArrayListExtra("CONTATOS", contatos)
        startActivity(intent)
    }

    private fun bindViews() {
        campoNome = findViewById(R.id.campoNome)
        campoCelular = findViewById(R.id.campoCelular)
        rdGroup = findViewById(R.id.rdReferencia)
        rdPessoal = findViewById(R.id.rdPessoal)
        rdTrabalho = findViewById(R.id.rdTrabalho)
        campoReferencia = findViewById(R.id.campoReferencia)
        contatosCadastrados = findViewById(R.id.contatosCadastrados)
        navegar = findViewById(R.id.navegar)
    }

    private fun salvarContato(): List<Pessoa> {

        if (campoNome.text.isEmpty()) {
            campoNome.error = "Digite um nome."
        } else if (campoCelular.text.isEmpty()) {
            campoCelular.error = "Digite um número de telefone."
        } else if (campoReferencia.text.isEmpty()) {
            campoReferencia.error = "Digite uma referência."
        } else {
            val nomeDigitado = campoNome.text.toString()
            val numeroCelular = campoCelular.text.toString()
            val campoReferencia = campoReferencia.text.toString()
            val referenciaSelecionada = rdGroup.checkedRadioButtonId
//            referenciaSelecionada.let {
//                cadastrarContato(nomeDigitado, numeroCelular, campoReferencia)
//            }
            contatos.add(Pessoa(nomeDigitado, numeroCelular, campoReferencia))
        }
        return contatos
    }

//    fun cadastrarContato(nome: String, telefone: String, referencia: String): Pessoa{
//        (Pessoa(nome = nome, telefone = telefone, referencia = referencia))
//    }

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

//    override fun setOnDeleteListener() {
//        Toast.makeText(this, "Item deletado", Toast.LENGTH_LONG).show()
//    }

}








