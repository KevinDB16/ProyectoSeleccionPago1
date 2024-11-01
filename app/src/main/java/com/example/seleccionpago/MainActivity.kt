package com.example.seleccionpago

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnNext = findViewById<Button>(R.id.btnNext)
        val btnAddProduct = findViewById<Button>(R.id.btnAddProduct)
        val btnListProducts = findViewById<Button>(R.id.btnListProducts)

        btnNext.setOnClickListener {
            val intent = Intent(this, PantallaDos::class.java)
            startActivity(intent)
        }
        btnAddProduct.setOnClickListener {
            val intent = Intent(this, NewProduct::class.java)
            startActivity(intent)
        }
        btnListProducts.setOnClickListener {
            val intent = Intent(this, ListProducts::class.java)
            startActivity(intent)
        }
    }
}