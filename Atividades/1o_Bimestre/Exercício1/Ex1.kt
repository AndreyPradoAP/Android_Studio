package com.example.listaexercicios_1obimestre_ex1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val InputNumero1: EditText = findViewById(R.id.InputNumero1)
        val InputNumero2: EditText = findViewById(R.id.InputNumero2)
        val botao1: Button = findViewById(R.id.botao1)
        val LabelMedia: TextView = findViewById(R.id.LabelMedia)
        val LabelSituacaoAluno: TextView = findViewById(R.id.LabelSitacaoAluno)

        botao1.setOnClickListener{
            val num1 = InputNumero1.text.toString()
            val num2 = InputNumero2.text.toString()
            val media = (num1.toFloat() + num2.toFloat()) / 2

            LabelMedia.text = "Média do aluno: $media"

            if (media < 6)
                LabelSituacaoAluno.text = "Situação do aluno: REPROVADO"
            else
                LabelSituacaoAluno.text = "Situação do aluno: APROVADO"
        }
    }
}