package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import androidx.appcompat.app.AlertDialog


class AuthActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.auth_activity)
        FirebaseAuth.getInstance().signOut()
        title = "Autenticación"
        val btregistrar=findViewById<Button>(R.id.SignUp)
        val btlogin=findViewById<Button>(R.id.Login)
        val email=findViewById<EditText>(R.id.editTextEmail)
        val password=findViewById<EditText>(R.id.editTextPassword)
        val intent = Intent(this, MainActivity::class.java)


        btregistrar.setOnClickListener {
            //toca inicializar una variable y llamar para poder sacar el valor que trae dentro la variable.
            if (email.text.isNotEmpty() && password.text.isNotEmpty()){
                FirebaseAuth.getInstance().createUserWithEmailAndPassword(email.text.toString(),
                    password.text.toString()).addOnCompleteListener {
                        if (it.isSuccessful){
                            startActivity(intent)
                        } else {
                            showAlert()
                        }
                }
            }
        }
        btlogin.setOnClickListener {
            if (email.text.isNotEmpty() && password.text.isNotEmpty()){
                FirebaseAuth.getInstance().signInWithEmailAndPassword(email.text.toString(),
                    password.text.toString()).addOnCompleteListener {
                    if (it.isSuccessful){
                        startActivity(intent)
                    }
                }
            }

        }

    }
    fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("Se ha producido un error registrando al usuario")
        builder.setPositiveButton("Aceptar", null)

        val dialog: AlertDialog = builder.create()
        dialog.show()
    }


}
