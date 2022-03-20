package com.example.listaexercicios_1obimestre_ex6

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editDecimal: EditText = findViewById(R.id.editDecimal)
        val button: Button = findViewById(R.id.button)
        val viewBinario: TextView = findViewById(R.id.viewBinario)
        val numeroBinario = ArrayList<Int>()
        val numBinarioString = StringBuilder()

        button.setOnClickListener {
            var numero = (editDecimal.text.toString()).toInt()
            viewBinario.text = ""
            numeroBinario.clear()
            numBinarioString.clear()

            if(numero == 0) {
                numeroBinario.add(0)
            }else{
                while (numero > 1) {
                    numeroBinario.add(numero % 2)
                    numero /= 2
                }

                numeroBinario.add(1)
            }

            for(c in numeroBinario.size - 1 downTo 0 step 1) {
                numBinarioString.append(numeroBinario[c].toString())
            }

            viewBinario.text = "O número em binário é: " + numBinarioString
        }
    }
}