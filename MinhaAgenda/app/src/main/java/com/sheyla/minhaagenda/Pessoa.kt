package com.sheyla.minhaagenda


open class Pessoa(open val nome: String,
                       private var telefone: String,
                       open var referencia: String){


    @JvmName("getNome1")
    fun getNome() = nome
    fun getNumber() = telefone
    fun getRef() = referencia

    open fun exibirTodos(): String {
        return "$nome - $telefone, $referencia"
    }
}