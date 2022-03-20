package com.example.listaexerccios_1obimestre_ex5

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import java.io.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editNome: EditText = findViewById(R.id.editNome)
        val radioFeminino: RadioButton = findViewById(R.id.radioFeminino)
        val viewDados: TextView = findViewById(R.id.viewDados)
        val botaoSalvar: Button = findViewById(R.id.botaoSalvar)
        val botaoExcluir: Button = findViewById(R.id.botaoExcluir)
        var sexo: String
        var nome: String

        var dados = LerArquivo()
        viewDados.text = dados

        botaoSalvar.setOnClickListener {
            sexo = if (radioFeminino.isChecked){
                "FEMININO"
            }else{
                "MASCULINO"
            }

            nome = editNome.text.toString().uppercase()

            GravarArquivo(nome, sexo)
            dados = LerArquivo()

            viewDados.text = dados
        }

        botaoExcluir.setOnClickListener(){
            GravarArquivo("", "")
            dados = LerArquivo()

            viewDados.text = dados
        }
    }

    fun GravarArquivo(nome: String, sexo: String){
        val fileOutputStream: FileOutputStream

        try {
            fileOutputStream = openFileOutput("dadosUser", Context.MODE_PRIVATE)
            fileOutputStream.write("Nome: ".toByteArray() + nome.toByteArray() + "; Sexo: ".toByteArray() + sexo.toByteArray())
        }catch (e: FileNotFoundException){
            e.printStackTrace()
        }
    }

    fun LerArquivo(): String{
        var fileInputStream: FileInputStream? = null
        fileInputStream = openFileInput("dadosUser")
        val inputStreamReader = InputStreamReader(fileInputStream)
        val bufferedReader = BufferedReader(inputStreamReader)
        val stringBuilder = StringBuilder()
        var text: String? = null

        while (run {
                text = bufferedReader.readLine()
                text
            } != null){
            stringBuilder.append(text)
        }

        return stringBuilder.toString()
    }
}
