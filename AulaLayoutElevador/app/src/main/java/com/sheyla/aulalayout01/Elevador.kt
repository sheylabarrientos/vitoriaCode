package com.sheyla.aulalayout01

class Elevador (var numeroPessoas: Int = 0,
                var numeroMaxPessoas: Int = 5) {

    fun adicionarPessoa() : Int { //A função foi setada do tipo "Int".
        if (numeroPessoas < numeroMaxPessoas) { //"Se o "numeroPessoas" (que foi setado inicialmente como "0") for menor que o "numeroMaxPessoas" (setado inicialmente como "5"), então..."
            numeroPessoas++ //"Soma-se "1" ao "numeroPessoas"..."
            return numeroPessoas //"E retorna o resultado de "numeroPessoas"".
        } else {
            return -1 //O "-1" é só uma representação para qualquer coisa que seja diferente da condicional do "if" acima. Ou seja, se o resultado for maior que "5", a função retorna "-1". isso servirá para indicar o erro no "MainActivity".
        }
    }

    fun excluirPessoa() : Int {
        if (numeroPessoas >= 1) { //"Se o "numeroPessoas" (que foi setado inicialmente como "0") for maior ou igual a "1", então..."
            numeroPessoas-- //"Subtrai-se "1" ao "numeroPessoas"..."
            return numeroPessoas //"E retorna o resultado de "numeroPessoas"".
        } else {
            return -1 //O "-1" é só uma representação para qualquer coisa que seja diferente da condicional do "if" acima. Ou seja, se o resultado for menor que "1", a função retorna "-1". isso servirá para indicar o erro no "MainActivity".
        }
    }

}