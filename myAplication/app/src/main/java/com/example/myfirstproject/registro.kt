package com.example.myfirstproject

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class registro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.registro)
        val dbHelper = IMCDatabaseHelper(this)

        val nombreEditText = findViewById<EditText>(R.id.nombre)
        val guardarButton = findViewById<Button>(R.id.guardar)
        val regresarButton = findViewById<Button>(R.id.regresar)

        guardarButton.setOnClickListener {
            val nombreTexto = nombreEditText.text.toString().trim()
            if (nombreTexto.isNotEmpty()) {
                dbHelper.insertarNombre(nombreTexto)
                Toast.makeText(this, "Nombre guardado: $nombreTexto", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Por favor ingresa un nombre", Toast.LENGTH_SHORT).show()
            }
        }
        regresarButton.setOnClickListener {
            val intent = Intent(this@registro, MainActivity::class.java)
            startActivity(intent)
        }
    }
}
