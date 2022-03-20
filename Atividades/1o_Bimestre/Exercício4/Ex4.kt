package com.example.listaexercicios_1obimestre_ex4

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    var player1 = ArrayList<Int>()
    var player2 = ArrayList<Int>()
    var turnoJogo = 1

    fun buttonClick(view: View){
        val buttonSelecionado = view as Button
        var buttonID = 0

        when(buttonSelecionado.id){
            R.id.botao1 -> buttonID = 1
            R.id.botao2 -> buttonID = 2
            R.id.botao3 -> buttonID = 3
            R.id.botao4 -> buttonID = 4
            R.id.botao5 -> buttonID = 5
            R.id.botao6 -> buttonID = 6
            R.id.botao7 -> buttonID = 7
            R.id.botao8 -> buttonID = 8
            R.id.botao9 -> buttonID = 9
        }

        jogar(buttonID, buttonSelecionado)
    }

    fun jogar(buttonID:Int, buttonSelecionado:Button){
        if(turnoJogo == 1){
            buttonSelecionado.text = "X"
            buttonSelecionado.setBackgroundColor(Color.GREEN)
            player1.add(buttonID)
            turnoJogo = 2
        }else{
            buttonSelecionado.text = "O"
            buttonSelecionado.setBackgroundColor(Color.RED)
            player2.add(buttonID)
            turnoJogo = 1
        }

        buttonSelecionado.isEnabled = false
    }
}