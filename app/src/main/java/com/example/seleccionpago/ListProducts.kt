package com.example.seleccionpago

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ListProducts : AppCompatActivity() {
    private lateinit var lvProductList: ListView
    private lateinit var databaseHelper: PaymentDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_products)

        lvProductList = findViewById(R.id.lvProductList)
        databaseHelper = PaymentDatabaseHelper(this)

        //Ejecutamos la función del helper y guardamos lo que trae
        val productList = databaseHelper.getAllProductsAsString()

        //Guardamos lo que viene en productList, con un layout de ArrayAdapter
        val productAdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, productList)

        //Conectamos lo que viene del back con el front, utilizando adapter
        lvProductList.adapter = productAdapter
    }
}