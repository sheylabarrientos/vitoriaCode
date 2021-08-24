package com.sheyla.mymovies.ui.login

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.facebook.*
import com.facebook.login.LoginResult
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException
import com.sheyla.mymovies.databinding.ActivityFormLoginBinding
import com.sheyla.mymovies.ui.profile.ProfilesActivity

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding
    private var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        AccessToken.expireCurrentAccessToken()

        configureButtonLoginFacebook()

        supportActionBar!!.hide()
        verifyUserConnected()

        binding.txtScreenInscribe.setOnClickListener {

            val intent = Intent(this, FormSubscribe::class.java)
            startActivity(intent)
        }

        binding.btnEntrar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val password = binding.editSenha.text.toString()
            val message_error = binding.messageErro

            if (email.isEmpty() || password.isEmpty()) {
                message_error.setText("Preencha todos os campos!")
            } else {
                userAuthentication()
            }
        }

    }

    private fun configureButtonLoginFacebook() {
        configureCallBackManager()

        binding.btnLoginFacebook.setPermissions("email")

        binding.btnLoginFacebook.registerCallback(callbackManager, object : FacebookCallback<LoginResult>{
            override fun onSuccess(result: LoginResult?) {
                goToAddProfile()
            }

            override fun onCancel() {
                Log.d("MainActivity", "Facebook onCancel.")
                goToLogin()
            }

            override fun onError(error: FacebookException?) {
                Log.d("MainActivity", "Facebook onError.")
            }

        })

    }

    fun configureCallBackManager() {
        callbackManager = CallbackManager.Factory.create();
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode, resultCode, data)
    }

    private fun userAuthentication() {

        val email = binding.editEmail.text.toString()
        val password = binding.editSenha.text.toString()
        val message_error = binding.messageErro

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    Toast.makeText(this, "Login efetuado com Sucesso!", Toast.LENGTH_SHORT).show()
                    goToAddProfile()
                }
            }.addOnFailureListener {
                val erro = it

                when {
                    erro is FirebaseAuthWeakPasswordException -> message_error.setText("Digite uma senha com no mínimo 6 caracteres")
                    erro is FirebaseAuthUserCollisionException -> message_error.setText("Esta conta já foi cadastrada")
                    erro is FirebaseNetworkException -> message_error.setText("Sem conexão com a internet")
                    else -> message_error.setText("Erro ao logar usuário")
                }
            }
    }

    private fun verifyUserConnected() {
        val userConnected = FirebaseAuth.getInstance().currentUser

        if (userConnected != null) {
            goToAddProfile()
        }
    }

    private fun goToLogin() {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()
    }

    private fun goToAddProfile() {
        val intent = Intent(this, ProfilesActivity::class.java)
        startActivity(intent)
        finish()
    }
}