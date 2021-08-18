package com.sheyla.mymovies

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.sheyla.mymovies.databinding.ActivityFormLoginBinding

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        verifyUserConnected()

        binding.txtScreenInscribe.setOnClickListener{

            val intent = Intent(this, FormSubscribe::class.java)
            startActivity(intent)
        }

        binding.btnEntrar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val password = binding.editSenha.text.toString()
            val message_error = binding.messageErro

            if(email.isEmpty() || password.isEmpty()){
                message_error.setText("Preencha todos os campos!")
            }else{
                userAuthentication()
            }
        }
    }

    private fun userAuthentication() {

        val email = binding.editEmail.text.toString()
        val password = binding.editSenha.text.toString()
        val message_error = binding.messageErro

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(this, "Login efetuado com Sucesso!", Toast.LENGTH_SHORT).show()
                goToScreenMovie()
            }
        }.addOnFailureListener {
            var erro = it

            when{
                erro is FirebaseAuthWeakPasswordException -> message_error.setText("Digite uma senha com no mínimo 6 caracteres")
                erro is FirebaseAuthUserCollisionException -> message_error.setText("Esta conta já foi cadastrada")
                erro is FirebaseNetworkException -> message_error.setText("Sem conexão com a internet")
                else -> message_error.setText("Erro ao cadastrar usuário")
            }
        }
    }

    private fun verifyUserConnected(){
        val userConnected = FirebaseAuth.getInstance().currentUser

        if (userConnected != null){
            goToScreenMovie()
        }
    }

    private fun goToScreenMovie() {
        val intent = Intent(this, ListOfMovies::class.java)
        startActivity(intent)
        finish()
    }
}