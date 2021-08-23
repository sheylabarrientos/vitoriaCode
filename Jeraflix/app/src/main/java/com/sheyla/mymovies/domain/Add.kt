package com.sheyla.mymovies.domain

class Add (
    var numberProfiles: Int = 0,
    var numberMaxProfiles: Int = 4
) {

    fun subscribeProfile(): Int { //A função foi setada do tipo "Int".
        return if (numberProfiles < numberMaxProfiles) { //"Se o "numeroPessoas" (que foi setado inicialmente como "0") for menor que o "numeroMaxPessoas" (setado inicialmente como "5"), então..."
            numberProfiles++ //"Soma-se "1" ao "numeroPessoas"..."
            numberProfiles //"E retorna o resultado de "numeroPessoas"".
        } else {
            -1 //O "-1" é só uma representação para qualquer coisa que seja diferente da condicional do "if" acima. Ou seja, se o resultado for maior que "5", a função retorna "-1". isso servirá para indicar o erro no "MainActivity".
        }
    }

    fun unsubscribeProfile(): Int {
        return if (numberProfiles >= 1) { //"Se o "numeroPessoas" (que foi setado inicialmente como "0") for maior ou igual a "1", então..."
            numberProfiles-- //"Subtrai-se "1" ao "numeroPessoas"..."
            numberProfiles //"E retorna o resultado de "numeroPessoas"".
        } else {
            -1 //O "-1" é só uma representação para qualquer coisa que seja diferente da condicional do "if" acima. Ou seja, se o resultado for menor que "1", a função retorna "-1". isso servirá para indicar o erro no "MainActivity".
        }
    }

}