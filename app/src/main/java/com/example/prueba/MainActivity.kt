package com.example.prueba

import android.os.Bundle
import android.util.Log
import android.widget.SearchView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.prueba.databinding.ActivityMainBinding
import com.example.prueba.doglist.APIService
import com.example.prueba.doglist.DogAdapter
import com.example.prueba.doglist.DogsResponse
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity(), SearchView.OnQueryTextListener {
    private val queso: String = "vaka"

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: DogAdapter
    private val dogImages = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.svDogs.setOnQueryTextListener(this)
        initRecyclerView()

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

        myArray.forEach { coso ->
            if (coso.first() == 'j') {
                Log.e("prueba1", "encontre la j")
            } else {
                Log.e("prueba1", "este valor no tiene j")
            }
        }

        val mainArray: Array<String> =
            arrayOf(
                "Lunes",
                "Martes",
                "Miercoles",
                "Jueves",
                "Viernes",
                "Sabado",
                "Domingo, sabadaba"
            )

        val mainList: List<String> =
            listOf("Lunes", "Martes", "Miercoles", "Jueves", "Viernes", "Sabado", "Domingo")

        val mainMutableList: MutableList<String> =
            mutableListOf("Manzana", "Pera", "Durazno", "Platano", "Mango")

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

    private fun initRecyclerView() {
        adapter = DogAdapter(dogImages)
        binding.rvDogs.layoutManager = LinearLayoutManager(this)
        binding.rvDogs.adapter = adapter
    }

    private fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://dog.ceo/api/breed/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    private fun searchByName(query: String) {
        CoroutineScope(Dispatchers.IO).launch {
            val call = getRetrofit().create(APIService::class.java).getDogsByBreeds("$query/images")
            val puppies: DogsResponse? = call.body()

            runOnUiThread {
                if (call.isSuccessful) {
                    // Show RecyclerView
                    val images = puppies?.images ?: emptyList()
                    dogImages.clear()
                    dogImages.addAll(images)
                    adapter.notifyDataSetChanged()
                } else {
                    // Show error
                    showError()
                }
            }
        }
    }

    private fun showError() {
        Toast.makeText(this, "Ha ocurrido un error", Toast.LENGTH_SHORT).show()
    }

    override fun onQueryTextSubmit(query: String?): Boolean {
        if (!query.isNullOrEmpty()) {
            searchByName(query.lowercase())
        }
        return true
    }

    override fun onQueryTextChange(newText: String?): Boolean {
        return true
    }


}