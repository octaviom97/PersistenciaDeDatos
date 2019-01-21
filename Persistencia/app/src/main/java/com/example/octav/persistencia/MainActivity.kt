package com.example.octav.persistencia

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        button.findViewById<Button>(R.id.button)
////        Forma de asignar el evento onCLick al componente botón
//        button.setOnClickListener{
//            view -> escribirDatos(view)
//        }
    }

    fun guardarDatos(view: View) {

        //Verificamos si la variable está vacía
        if (tacos.text.isEmpty()){
            //Utlizamos el método error y le asignamos un valor
            tacos.error = "Introduce un usuario"
            return
        }
        //Verificamos si la variable está vacía
        if (quesadillas.text.isEmpty()){
            //Utlizamos el método error y le asignamos un valor
            quesadillas.error = "Introduce la contraseña"
            return
        }

        /*Declaramos variable y le asignamos el método de preferencias con sus parámetros
        nombre del archivo y su modo*/
        val mipreferencia = getSharedPreferences("lawea", Context.MODE_PRIVATE)
        //Asiganmos método edit a una nueva variable
        val editor = mipreferencia.edit()
        //Utilizamos el método putString con los parámetros de clave y su valor correspondiente
        editor.putString("user",tacos.text.toString())
        editor.putString("pass",quesadillas.text.toString())
        //El método apply "aplica" las instrucciones
        editor.apply()
        //Inicializamos nuestros valores en cero
        tacos.setText("")
        quesadillas.setText("")
        Toast.makeText(this,"Si funcionó la wea",Toast.LENGTH_SHORT).show()
    }

    fun cargarDatos(view: View){
        val mipreferencia = getSharedPreferences("lawea", Context.MODE_PRIVATE)
        //Obtenemos los valores a través de la llave
        val usuario = mipreferencia.getString("user","No hay datos guardados")
        val password = mipreferencia.getString("pass","No hay datos guardados")

        gansitos.text = usuario+"\n"+password
    }

    fun cambiarActividad(view: View){
        val i = Intent(this,Main2Activity::class.java)
        startActivity(i)
    }
}










