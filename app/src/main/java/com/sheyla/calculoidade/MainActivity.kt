package com.sheyla.calculoidade

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import android.view.View


class MainActivity : AppCompatActivity() {

    //DECLARAR VARIAVEIS E COMPONETES
    lateinit var campoDeTexto: EditText
    lateinit var adicionarUsuario: Button //(ENVIAR)
    lateinit var nomeUsuario: EditText //(Insira seu nome)
    lateinit var listaUsuarios: TextView
    lateinit var presenteDesejado: EditText // (Insira o que deseja ganhar)

    var usuariosCadastrados = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        campoDeTexto = findViewById(R.id.edtIdade)
        adicionarUsuario = findViewById(R.id.btnAdd) //(ENVIAR)
        nomeUsuario = findViewById(R.id.edtUsuario) //(Insira seu nome)
        presenteDesejado = findViewById(R.id.edtPresente)
        listaUsuarios = findViewById(R.id.txtResultado) //Mensagem exibida - lista

        adicionarUsuario.setOnClickListener {
            val nome = nomeUsuario.text.toString()
        //INICIALIZAR O COMPONETE
            if (nome.isNotEmpty()) {
                cadastrarUsuario(nome)
            } else {
                nomeUsuario.error = "Digite um nome válido!"
            }
        }


    }

    fun cadastrarUsuario(nome: String) {

        listaUsuarios.visibility = View.VISIBLE

        var exibirUsuarios = ""

        usuariosCadastrados.add(nome)

        for (adicionar in usuariosCadastrados) {
            //some = some + numeroIndividual
                //soma = 0 + 1
                    // soma = 1 + 2
            exibirUsuarios += "Olá, $adicionar, seu próximo aniversário será em... Espero que você ganhe... \n"
        }

        listaUsuarios.text = exibirUsuarios
    }

}

