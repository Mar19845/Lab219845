package com.example.lab219845

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    //contadores para el boton
    var count=0
    var resta1=10
    var resta2=20
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // variables para utilizar los botones y el texto
        val Vuelta = findViewById<Button>(R.id.Vuelta)
        val Reiniciar = findViewById<Button>(R.id.Reiniciar)
        val Texto = findViewById<TextView>(R.id.Vueltas)
        val toast = Toast.makeText(applicationContext, "Felicidades por lograr tu meta", Toast.LENGTH_LONG)
        val Faltan1 = Toast.makeText(applicationContext, "Faltan "+resta1+" vueltas", Toast.LENGTH_LONG)
        val Faltan2 = Toast.makeText(applicationContext, "Faltan "+resta2+" vueltas", Toast.LENGTH_LONG)
        //click boton que hacer cuando lo cliquea
        Vuelta.setOnClickListener {
            // aumentar contador y cambiar el texto
            count++
            resta1=resta1-count
            resta2=resta1-count
            Texto.text = "" + count
           if(count==10){
                toast.show()
            }
        }
        Vuelta.setOnLongClickListener {
            if(resta1!=0){
                Faltan1.show()
            }
            if(resta1==0){
                Faltan2.show()
            }
            return@setOnLongClickListener true
        }
        Reiniciar.setOnClickListener {
            count=0
            Texto.text="0"
        }
    }
}
