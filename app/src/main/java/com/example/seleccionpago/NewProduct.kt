package com.example.seleccionpago

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class NewProduct : AppCompatActivity() {

    private lateinit var dbHelper: PaymentDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_new_product)

        dbHelper = PaymentDatabaseHelper(this)

        val etProductName = findViewById<EditText>(R.id.etProductName)
        val etProductPrice = findViewById<EditText>(R.id.etProductPrice)
        val btnAddProduct = findViewById<Button>(R.id.btnAddProduct)

        btnAddProduct.setOnClickListener{
            val name = etProductName.text.toString();
            val price = etProductPrice.text.toString();

            if(name.isNotEmpty() && price.isNotEmpty()){
                val success = dbHelper.addProduct(name,price)
                if(success > 0){
                    Toast.makeText(this, "Producto agregado correctamente", Toast.LENGTH_SHORT).show()
                    etProductName.text.clear()
                    etProductPrice.text.clear()
                } else {
                    Toast.makeText(this, "Error al agregar producto", Toast.LENGTH_SHORT).show()
                }
            } else{
                Toast.makeText(this, "Los campos no pueden estar vacíos", Toast.LENGTH_SHORT).show()
            }
        }
    }
}