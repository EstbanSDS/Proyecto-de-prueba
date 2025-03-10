package com.example.prueba

import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.prueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val queso: String = "vaka"

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // vieja forma de acceder a los componentes de la vista
        /*val product : String = findViewById<EditText>(R.id.et_producto).text.toString()
        findViewById<TextView>(R.id.tv_titulo).text = product
        val message : String = findViewById<TextView>(R.id.tv_titulo).text.toString()*/


        binding.btnGuardar.setOnClickListener {
            val label = binding.etProducto.text.toString().trim()
            if (label.isNotEmpty()) {
                binding.tvTitulo.text = label
            }
        }
    }
}
