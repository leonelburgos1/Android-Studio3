package com.example.myfirstproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        val dbHelper = IMCDatabaseHelper(this)

        Handler(Looper.getMainLooper()).postDelayed({
            if (dbHelper.obtenerRegistros().isEmpty()) {
                // Si la base de datos está vacía → ir a registro
                startActivity(Intent(this, registro::class.java))
            } else {
                // Si hay datos → ir a MainActivity
                startActivity(Intent(this, MainActivity::class.java))
            }
            finish() // Evita volver al splash con "back"
        }, 4000) // 4 segundos
    }
}
