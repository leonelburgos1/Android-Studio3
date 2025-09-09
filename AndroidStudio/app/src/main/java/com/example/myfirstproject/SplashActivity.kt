package com.example.myfirstproject

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler(Looper.getMainLooper()).postDelayed({
            val user = FirebaseAuth.getInstance().currentUser
            if (user != null) {
                // Ya hay usuario autenticado → ir a MainActivity
                startActivity(Intent(this, AuthActivity::class.java))
            } else {
                // No hay usuario → ir a AuthActivity
                startActivity(Intent(this, AuthActivity::class.java))
            }
            finish()
        }, 2000) // 2 segundos
    }
}

