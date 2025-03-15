package com.example.prueba

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.prueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


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

        val myArray = arrayOf("jabon", "pasta", "sacate", "shampo", "espejo")
        Log.e("prueba1", myArray[4].toString())
        myArray[4] = "papel"
        Log.e("prueba1", myArray[4].toString())
        Log.e("prueba1", myArray[4].first().toString())
        Log.e("prueba1", myArray.first().toString())
        Log.e("prueba1", myArray[4].last().toString())
        Log.e("prueba1", myArray.last().toString())

        myArray.forEach { coso ->
            if (coso.first() == 'j') {
                Log.e("prueba1", "encontre la j")
            } else {
                Log.e("prueba1", "este valor no tiene j")
            }
        }

        val mainArray: Array<String> =
            arrayOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo","hola")

        val mainList: List<String> =
            listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

        val mainMutableList: MutableList<String> = mutableListOf("Manzana", "Pera", "Durazno", "Platano", "Mango")

        // Array
        val myArray2 = mainArray
        Log.e("prueba", "Esta es mi Array: ${mainArray.joinToString()}")
        myArray2[4] = "Nvidia"
        Log.e("prueba", "Esta es mi Array: ${mainArray}")
        Log.e("prueba", "Esta es mi Array: ${myArray2.joinToString("+")}")
        myArray2.forEach { item ->
            Log.e("myarray", item)
        }

        // List
        val myList = mainList
        Log.e("prueba", "Esta es mi lista: ${myList.joinToString()}")

        // Lista mutable
        val myMutableList = mainMutableList

        myMutableList.add("Cacahuate")
        myMutableList.removeAt(3)
        myMutableList.remove("Pera")

        myMutableList[2] = "Lenovo"

        Log.e("prueba", myMutableList.joinToString())

        binding.btnGuardar.setOnClickListener {
            val label = binding.etProducto.text.toString().trim()
            if (label.isNotEmpty()) {
                binding.tvTitulo.text = label
            }
        }
    }
}
