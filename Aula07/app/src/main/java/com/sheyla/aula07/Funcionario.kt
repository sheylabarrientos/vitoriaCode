package com.sheyla.aula07

data class Funcionario(private val nome: String,
                       private val credencial: String,
                       private var setor: Int){

    fun getCredencial() : String = credencial

    fun exibirRegistro() : String{
        return "$nome - $credencial do setor $setor"
    }
}