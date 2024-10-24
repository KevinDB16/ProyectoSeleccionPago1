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

        val dbHelper = PaymentDatabaseHelper(this)


        btnSubmit.setOnClickListener {
            var paymentMethod = ""
            if (rbCash.isChecked) {
                paymentMethod = "Efectivo"
                Toast.makeText(this, "Opción: Efectivo", Toast.LENGTH_SHORT).show()
            } else if (rbCard.isChecked) {
                paymentMethod = "Tarjeta"
                Toast.makeText(this, "Opción: Tarjeta", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Seleccioná por favor una opción", Toast.LENGTH_SHORT).show()
            }


            val result = dbHelper.addPaymentMethod(paymentMethod)
            if (result != -1L) {
                Toast.makeText(this, "Método de pago guardado", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Error al guardar el método de pago", Toast.LENGTH_SHORT).show()
            }
        }
    }
}