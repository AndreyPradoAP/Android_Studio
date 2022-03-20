package com.example.listaexercicios_1obimestre_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val inputNumero: EditText = findViewById(R.id.inputNumero)
        val botao: Button = findViewById(R.id.botao)
        val labelTabuada: TextView = findViewById(R.id.labelTabuada)

        botao.setOnClickListener()
        {
            labelTabuada.text = ""
            val numTabuada = inputNumero.text.toString()

            for (c in 1 ..10)
            {
                labelTabuada.text = labelTabuada.getText().toString() + numTabuada + " x " + c + " = " + (numTabuada.toFloat() * c).toString() + "\n"
            }
        }
    }
}