package com.example.seleccionpago

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class PantallaDos : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pantalla_dos)

        val rbCash = findViewById<RadioButton>(R.id.rbCash)
        val rbCard = findViewById<RadioButton>(R.id.rbCard)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)

        btnSubmit.setOnClickListener{
            if(rbCash.isChecked) {
                Toast.makeText(this, "Opción: Efectivo", Toast.LENGTH_SHORT).show()
            } else if(rbCard.isChecked){
                Toast.makeText(this, "Opción: Tarjeta", Toast.LENGTH_SHORT).show()
            } else{
                Toast.makeText(this, "Seleccioná por favor una opción", Toast.LENGTH_SHORT).show()
            }
        }
    }
}