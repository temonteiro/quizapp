package br.com.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Thalita Monteiro on 15/11/2016.
 */
public class QuizAppQuestion5Activity extends AppCompatActivity {

    Button resposta1;
    Button resposta2;
    Button resposta3;
    Button resposta4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_app_question5_view);

        resposta1 = (Button) findViewById(R.id.pergunta5_resposta1);
        resposta2 = (Button) findViewById(R.id.pergunta5_resposta2);
        resposta3 = (Button) findViewById(R.id.pergunta5_resposta3);
        resposta4 = (Button) findViewById(R.id.pergunta5_resposta4);

        final String nomeDoUsuario = getIntent().getStringExtra("nomeUsuario");
        final String countRespostaIntent = getIntent().getStringExtra("qtdAcertos");

        resposta1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        int countResposta = 0 + Integer.parseInt(countRespostaIntent);

                        Intent resultado = new Intent(QuizAppQuestion5Activity.this, QuizAppResultadoActivity.class);
                        resultado.putExtra("qtdAcertos", String.valueOf(countResposta));
                        resultado.putExtra("nomeUsuario", nomeDoUsuario);
                        Toast.makeText(getApplicationContext(), "Você errou!", Toast.LENGTH_LONG).show();
                        startActivity(resultado);
                    }
                }
        );
        resposta2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int countResposta = 1 + Integer.parseInt(countRespostaIntent);
                        Intent resultado = new Intent(QuizAppQuestion5Activity.this, QuizAppResultadoActivity.class);
                        resultado.putExtra("qtdAcertos", String.valueOf(countResposta));
                        resultado.putExtra("nomeUsuario", nomeDoUsuario);
                        Toast.makeText(getApplicationContext(), "Você acertou!", Toast.LENGTH_LONG).show();
                        startActivity(resultado);
                    }
                }
        );
        resposta3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int countResposta = 0 + Integer.parseInt(countRespostaIntent);
                        Intent resultado = new Intent(QuizAppQuestion5Activity.this, QuizAppResultadoActivity.class);
                        resultado.putExtra("qtdAcertos", String.valueOf(countResposta));
                        resultado.putExtra("nomeUsuario", nomeDoUsuario);
                        Toast.makeText(getApplicationContext(), "Você errou!", Toast.LENGTH_LONG).show();
                        startActivity(resultado);
                    }
                }
        );
        resposta4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int countResposta = 0 + Integer.parseInt(countRespostaIntent);
                        Intent resultado = new Intent(QuizAppQuestion5Activity.this, QuizAppResultadoActivity.class);
                        resultado.putExtra("qtdAcertos", String.valueOf(countResposta));
                        resultado.putExtra("nomeUsuario", nomeDoUsuario);
                        Toast.makeText(getApplicationContext(), "Você errou!", Toast.LENGTH_LONG).show();
                        startActivity(resultado);
                    }
                }
        );

    }
}
