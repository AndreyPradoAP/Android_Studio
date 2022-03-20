package com.example.listaexercicios_1obimestre_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNome: EditText = findViewById(R.id.editNome)
        val button: Button = findViewById(R.id.button)
        val spinnerNomes: Spinner = findViewById(R.id.spinnerNomes)
        val nomes = ArrayList<String>()

        button.setOnClickListener{
            val novoNome = editNome.text.toString()
            
            if (novoNome != "") {
                nomes.add(novoNome)
            }
        }

        spinnerNomes.adapter = ArrayAdapter(this,
            android.R.layout.simple_list_item_1,
            nomes)
    }
}