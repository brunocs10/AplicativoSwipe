package com.bruno.appquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout tela;
    private TextView tvPergunta,tvNumero,tvSim,tvNao,tvResposta;
    private int contador ,acertou;

    Pergunta perguntas[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        contador =-1;
        acertou=0;
        tvResposta = findViewById(R.id.tvresposta);
        tvSim=findViewById(R.id.tvsim);
        tvNao=findViewById(R.id.tvnao);
        tvPergunta = findViewById(R.id.tvPergunta);
        tvNumero = findViewById(R.id.tvnumero);
        tela = findViewById(R.id.tela);

        perguntas = new Pergunta[5];

         Pergunta pergunta = new Pergunta("Brasil é um país da America?",true);

        perguntas[0]=pergunta;

        Pergunta pergunta1 = new Pergunta("Brasil ganhou a última Copa do Mundo?",false);

        perguntas[1]=pergunta1;

        Pergunta pergunta2 = new Pergunta("Gato é um mamífero?",true);

        perguntas[2]=pergunta2;

        Pergunta pergunta3 = new Pergunta("São Paulo é um Estado do Sul?",false);

        perguntas[3]=pergunta3;

        Pergunta pergunta4 = new Pergunta("EUA é o maior campeão das Olimpiadas?",true);

        perguntas[4]=pergunta4;



        tela.setOnTouchListener(new OnSwipeTouchListener(this){

            @Override
            public void onSwipeBottom() {

                super.onSwipeBottom();

                perguntas[contador].setResposta(false);
                tvNao.setText("Não");
                tvSim.setText("");

            }

            @Override
            public void onSwipeTop() {

                super.onSwipeTop();



                perguntas[contador].setResposta(true);

                tvSim.setText("Sim");
                tvNao.setText("");
            }

            @Override
            public void onSwipeLeft() {

                super.onSwipeLeft();
                if(contador<4){
                    contador++;
                }else{

                    tvPergunta.setText("");
                    tvNao.setText("");
                    tvSim.setText("");
                    for (int i=0 ;i<4;i++){
                        if (perguntas[i].getRespostacerta()==perguntas[i].getResposta()){
                            acertou++;


                    }
                    }
                    tvResposta.setText("Você acertou "+acertou);

                    acertou=0;

                }
                tvNumero.setText(String.valueOf(contador));
                tvPergunta.setText(perguntas[contador].getPergunta());
                tvNao.setText("");
                tvSim.setText("");


            }

            @Override
            public void onSwipeRight() {


                super.onSwipeRight();
                if(contador>0){
                    contador--;
                }

                tvNumero.setText(String.valueOf(contador));
                tvPergunta.setText(perguntas[contador].getPergunta());
                tvNao.setText("");
                tvSim.setText("");

            }
        });
    }

}
