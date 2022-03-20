package com.example.projeto_1obimestre_ex2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.TextView
import com.example.projeto_1obimestre_ex.R
import java.text.DecimalFormat
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val radioMasculino: RadioButton = findViewById(R.id.radioMasculino)
        val radioFeminino: RadioButton = findViewById(R.id.radioFeminino)
        val editPeso: EditText = findViewById(R.id.editPeso)
        val editAltura: EditText = findViewById(R.id.editAltura)
        val editIdade: EditText = findViewById(R.id.editIdade)
        val buttonCalcular: Button = findViewById(R.id.buttonCalcular)
        val viewResultado: TextView = findViewById(R.id.viewResultado)
        val df = DecimalFormat("#.##")

        buttonCalcular.setOnClickListener{
            val peso = verificarTextVazio(editPeso)
            val altura = verificarTextVazio(editAltura)
            val idade = verificarTextVazio(editIdade)
            val sexo = when {
                radioMasculino.isChecked -> 1
                radioFeminino.isChecked -> 0
                else -> null
            }

            if (peso == null || altura == null || idade == null || sexo == null)
                viewResultado.text = "Dados requridos não específicados! Digite os dados acimas de maneira correta"
            else{
                val indiceGordura = 1.2 * (peso / altura.pow(2)) + 0.23 * idade - 10.8 * sexo - 5.4

                viewResultado.text = "O seu indíce de massa corporal é = " + df.format(indiceGordura)
            }
        }
    }

    fun verificarTextVazio(editString: EditText): Float? {
        return if (editString.text.isEmpty())
            null
        else
            editString.text.toString().toFloat()
    }
}