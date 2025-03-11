package com.example.prueba

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
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

        val myArray = arrayOf("jabon","pasta","sacate","shampo","espejo")
        Log.e("prueba1", myArray[4].toString())
        myArray[4] = "papel"
        Log.e("prueba1", myArray[4].toString())
        Log.e("prueba1", myArray[4].first().toString())
        Log.e("prueba1", myArray.first().toString())
        Log.e("prueba1", myArray[4].last().toString())
        Log.e("prueba1", myArray.last().toString())

        myArray.forEach {
            if(it.first()=='j'){
                Log.e("prueba1", "encontre la j")
            } else{
                Log.e("prueba1", "este valor no tiene j")
            }

        }



        binding.btnGuardar.setOnClickListener {
            val label = binding.etProducto.text.toString().trim()
            if (label.isNotEmpty()) {
                binding.tvTitulo.text = label
            }
        }
    }
}
