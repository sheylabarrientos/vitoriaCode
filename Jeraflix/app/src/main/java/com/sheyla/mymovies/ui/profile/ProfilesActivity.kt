package com.sheyla.mymovies.ui.profile

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import android.view.MenuItem
import android.widget.Toast
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.HttpMethod
import com.facebook.login.LoginManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.storage.FirebaseStorage
import com.sheyla.mymovies.R
import com.sheyla.mymovies.domain.Profiles
import com.sheyla.mymovies.ui.login.FormLogin
import kotlinx.android.synthetic.main.activity_profiles.*
import java.util.*

class ProfilesActivity : AppCompatActivity() {

    private var SelecionarUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profiles)

        bt_selecionar_foto.setOnClickListener {

            SelecionarFotoDaGaleria()
        }

        btn_add_profile_filho.setOnClickListener {
            SalvarDadosNoFirebase()
            goToProfiles()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == 0) {
            SelecionarUri = data?.data

            val bitmap = MediaStore.Images.Media.getBitmap(contentResolver, SelecionarUri)
            selectImageProfile.setImageBitmap(bitmap)
            bt_selecionar_foto.alpha = 0f
        }
    }

    private fun SelecionarFotoDaGaleria() {

        val intent = Intent(Intent.ACTION_PICK)
        intent.type = "image/*"
        startActivityForResult(intent, 0)
    }

    private fun SalvarDadosNoFirebase() {

        val nomeUsuario = UUID.randomUUID().toString()
        val referencia = FirebaseStorage.getInstance().getReference(
            "/profiles/${nomeUsuario}"
        )

        SelecionarUri?.let {

            referencia.putFile(it)
                .addOnSuccessListener {
                    referencia.downloadUrl.addOnSuccessListener {

                        val url = it.toString()

                        val name = name_profile_filho.text.toString()
                        val uid = FirebaseAuth.getInstance().uid

                        val Profiles = Profiles(name, url)

                        FirebaseFirestore.getInstance().collection("Profiles")
                            .add(Profiles)
                            .addOnSuccessListener {
                                Toast.makeText(
                                    this,
                                    "Usuário cadastrado com sucesso!",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }.addOnFailureListener {
                                Toast.makeText(this, "Tente novamente!", Toast.LENGTH_SHORT).show()
                            }
                    }
                }
        }
    }

    private fun goToProfiles() {
        val intent = Intent(this, SelectProfilesActivity::class.java)
        startActivity(intent)
        finish()
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.disconnect -> {
                FirebaseAuth.getInstance().signOut()
                backScreenLogin()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    private fun backScreenLogin() {
        val intent = Intent(this, FormLogin::class.java)
        startActivity(intent)
        finish()

        if (AccessToken.getCurrentAccessToken() != null) {
            GraphRequest(AccessToken.getCurrentAccessToken(), "/me/permissions/", null, HttpMethod.DELETE, GraphRequest.Callback {
                AccessToken.setCurrentAccessToken(null)
                LoginManager.getInstance().logOut()

                finish()
            }).executeAsync()
        }
    }
}