package com.example.myuca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.myuca.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONObject
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var txtNombre: EditText? = null
    var txtApellidos: EditText? = null
    var txtCarrera: EditText? = null
    var txtAnio: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        txtNombre = binding.txtNombre
        txtApellidos = binding.txtApellido
        txtCarrera = binding.txtCarrera
        txtAnio = binding.txtAnio

binding.btnInsertar.setOnClickListener() {
    val url = "http://192.168.1.20/ClasePractica/insertarestudiante.php"
    val queue = Volley.newRequestQueue(this)
    var resultadoPost = object : StringRequest(Request.Method.POST, url,
        Response.Listener<String> { response ->
            Toast.makeText(this, "Se insertó correctamente", Toast.LENGTH_LONG).show()
        }, Response.ErrorListener { error ->
            Toast.makeText(this, "Error$error", Toast.LENGTH_LONG).show()
        }) {
        override fun getParams(): MutableMap<String, String>? {
            val parametros = HashMap<String, String>()
            parametros.put("nombres", txtNombre?.text.toString())
            parametros.put("apellidos", txtApellidos?.text.toString())
            parametros.put("carrera", txtCarrera?.text.toString())
            parametros.put("año", txtAnio?.text.toString())
            return parametros

        }
    }
    queue.add(resultadoPost)

}


 }


    }







