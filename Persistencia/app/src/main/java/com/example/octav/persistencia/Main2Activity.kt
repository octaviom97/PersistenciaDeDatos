package com.example.octav.persistencia

import android.content.Context
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import java.io.FileInputStream
import java.io.FileNotFoundException
import java.io.FileOutputStream
import java.io.IOException

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        tacos2.findViewById<EditText>(R.id.tacos2)
        button3.setOnClickListener{
            view -> guardarMensaje(view)
        }
        button4.setOnClickListener{
            view -> leerMensaje(view)
        }

    }

    fun guardarMensaje(view: View){
        var mensaje = tacos2.text.toString()
        val ARCHIVO = "NombreArchivo"
        try {
            //Creamos la variable que usará el método openFileOutput
            // con los parámetros de nombre de archivo y su modo
            val fos:FileOutputStream = openFileOutput("ARCHIVO", Context.MODE_PRIVATE)
            //El método write convierte los bytes de la variable mensaje a un arreglo
            fos.write(mensaje.toByteArray())
            //Se cierra el flujo del programa
            fos.close()
            Toast.makeText(this,"Funcionó :D"+filesDir,Toast.LENGTH_LONG).show()

        } catch (e:FileNotFoundException){
            e.printStackTrace()
        } catch (e:IOException){
            e.printStackTrace()
        }
    }

    fun leerMensaje(view: View){
        try {
            var fis = openFileInput("ARCHIVO")
            var barr = ByteArray(fis.available())
            fis.read(barr)
            var str = String(barr)
            gansitos2.text = str
            fis.close()

        } catch (e:FileNotFoundException){
            e.printStackTrace()
        } catch (e:IOException){
            e.printStackTrace()
        }
    }
}
