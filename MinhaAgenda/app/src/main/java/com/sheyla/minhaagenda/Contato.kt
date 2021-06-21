package com.sheyla.minhaagenda

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
open class Contato (open val nome: String, open val telefone: String, open val referencia: String = ""): Parcelable {

    open fun exibirContato(): String {
        return "$nome - $telefone, $referencia"
    }
}