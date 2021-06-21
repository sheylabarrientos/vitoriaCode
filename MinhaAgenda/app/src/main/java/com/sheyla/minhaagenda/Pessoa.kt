package com.sheyla.minhaagenda

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pessoa( val nome: String, val telefone: String, val referencia: String
): Parcelable {

    @JvmName("getNome1")
    fun getNome() = nome
    fun getNumber() = telefone
    fun getRef() = referencia

    fun exibirTodos(): String {
        return "$nome - $telefone, $referencia"
    }

}