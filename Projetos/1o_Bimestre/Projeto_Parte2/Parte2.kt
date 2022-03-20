package com.example.projeto_1obimestre_ex3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editIdade: EditText = findViewById(R.id.editIdade)
        val editPeso: EditText = findViewById(R.id.editPeso)
        val groupPrato: RadioGroup = findViewById(R.id.groupPrato)
        val groupSobremesa: RadioGroup = findViewById(R.id.groupSobremesa)
        val groupBebida: RadioGroup = findViewById(R.id.groupBebida)
        val button: Button = findViewById(R.id.button)
        val viewResultados: TextView = findViewById(R.id.viewResultados)
        var pratoEscolhidoCal: Int
        var sobremesaEscolhidaCal: Int
        var bebidaEscolhidaCal: Int

        button.setOnClickListener {
            viewResultados.text = null

            val idade = verificarTextVazio(editIdade)
            val peso = verificarTextVazio(editPeso)

            if (idade == null || peso == null)
                Toast.makeText(this@MainActivity,"Digite sua idade e seu peso!",Toast.LENGTH_SHORT).show()
            else {
                pratoEscolhidoCal = when (groupPrato.checkedRadioButtonId) {
                    R.id.radioVegetariano -> 180
                    R.id.radioPeixe -> 230
                    R.id.radioFrango -> 250
                    R.id.radioCarne -> 350
                    else -> 0
                }

                sobremesaEscolhidaCal = when (groupSobremesa.checkedRadioButtonId) {
                    R.id.radioAbacaxi -> 75
                    R.id.radioSorvete -> 110
                    R.id.radioMouse -> 170
                    R.id.radioChocolate -> 200
                    else -> 0
                }

                bebidaEscolhidaCal = when (groupBebida.checkedRadioButtonId) {
                    R.id.radioCha -> 75
                    R.id.radioLaranja -> 110
                    R.id.radioMelao -> 170
                    R.id.radioRefrigerante -> 200
                    else -> 0
                }

                if ((idade < 18) && (peso > 75) && (pratoEscolhidoCal == 350) && (bebidaEscolhidaCal == 200))
                    Toast.makeText(this@MainActivity, "Não consuma carne ou refrigerante! Seu peso está muito elevado!", Toast.LENGTH_SHORT).show()
                else if ((idade < 18) && (peso < 50) && (pratoEscolhidoCal == 180) && (bebidaEscolhidaCal == 75))
                    Toast.makeText(this@MainActivity, "Não consuma o prato vegetariano ou chá! Seu peso está muito abaixo do normal!", Toast.LENGTH_SHORT).show()
                else{
                    val totalCalorias = pratoEscolhidoCal + sobremesaEscolhidaCal + bebidaEscolhidaCal

                    if (totalCalorias > 600) {
                        Toast.makeText(this@MainActivity, "Cuidado! Quantidade de calorias consumidas elevada!", Toast.LENGTH_SHORT).show()
                    }
                    viewResultados.text = "Total de calorias consumidas: " + totalCalorias.toString() + " cal"
                }
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