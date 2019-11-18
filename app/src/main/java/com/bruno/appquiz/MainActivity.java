
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
    private int count,acertos;

    Pergunta perguntas[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        
        tvResposta = findViewById(R.id.tvresposta);
        tvSim=findViewById(R.id.tvsim);
        tvNao=findViewById(R.id.tvnao);
        tvPergunta = findViewById(R.id.tvPergunta);
        tvNumero = findViewById(R.id.tvnumero);
        tela = findViewById(R.id.tela);
	count =-1;
        acertos=0;
              


        perguntas = new Pergunta[5];

        Pergunta pergunta = new Pergunta("Brasil é um país da America?",true);
	Pergunta pergunta1 = new Pergunta("Brasil ganhou a última Copa do Mundo?",false);
	Pergunta pergunta2 = new Pergunta("Gato é um mamífero?",true);
	Pergunta pergunta3 = new Pergunta("São Paulo é um Estado do Sul?",false);
 	Pergunta pergunta4 = new Pergunta("EUA é o maior campeão das Olimpiadas?",true);

        perguntas[0]=pergunta;
	perguntas[1]=pergunta1;
	perguntas[2]=pergunta2;
	perguntas[3]=pergunta3;
	perguntas[4]=pergunta4;



        tela.setOnTouchListener(new OnSwipeTouchListener(this){

            @Override
            public void onSwipeBottom() {

                super.onSwipeBottom();

                perguntas[count].setResposta(false);
                tvNao.setText("Não");
                tvSim.setText("");

            }

            @Override
            public void onSwipeTop() {

                super.onSwipeTop();



                perguntas[count].setResposta(true);

                tvSim.setText("Sim");
                tvNao.setText("");
            }

            @Override
            public void onSwipeLeft() {

                super.onSwipeLeft();

              


                if(count<total_perguntas){
                    count++;
                }else{

                    tvPergunta.setText("");
                    tvNao.setText("");
                    tvSim.setText("");
                    for (int j=0 ;j<total_perguntas;j++){
                        if (perguntas[j].getRespostacerta()==perguntas[j].getResposta()){
                            acertos++;


                    }
                    }
                    tvResposta.setText("Acertos: "+acertos);

                    acertos=0;

                }
                tvNumero.setText(String.valueOf(count));
                tvPergunta.setText(perguntas[count].getPergunta());
                tvNao.setText("");
                tvSim.setText("");


            }

            @Override
            public void onSwipeRight() {


                super.onSwipeRight();
                if(count>0){
                    count--;
                }

                tvNumero.setText(String.valueOf(count));
                tvPergunta.setText(perguntas[count].getPergunta());
                tvNao.setText("");
                tvSim.setText("");

            }
        });
    }

}
