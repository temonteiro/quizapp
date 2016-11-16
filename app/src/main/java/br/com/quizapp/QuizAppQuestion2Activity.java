package br.com.quizapp;



import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import br.com.quizapp.R;

/**
 * Created by Thalita Monteiro on 15/11/2016.
 */
public class QuizAppQuestion2Activity extends AppCompatActivity {

    Button resposta1;
    Button resposta2;
    Button resposta3;
    Button resposta4;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_app_question2_view);

        resposta1 = (Button) findViewById(R.id.pergunta2_resposta1);
        resposta2 = (Button) findViewById(R.id.pergunta2_resposta2);
        resposta3 = (Button) findViewById(R.id.pergunta2_resposta3);
        resposta4 = (Button) findViewById(R.id.pergunta2_resposta4);

        final String nomeDoUsuario = getIntent().getStringExtra("nomeUsuario");
        final String countRespostaIntent = getIntent().getStringExtra("qtdAcertos");
        Log.v("contador Intent", countRespostaIntent);

        resposta1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int count = Integer.parseInt(countRespostaIntent);
                        int countResposta = 1 + count;

                        Intent pergunta3 = new Intent(QuizAppQuestion2Activity.this, QuizAppQuestion3Activity.class);
                        pergunta3.putExtra("qtdAcertos", String.valueOf(countResposta));
                        pergunta3.putExtra("nomeUsuario", nomeDoUsuario);
                        Toast.makeText(getApplicationContext(), "Você acertou!", Toast.LENGTH_LONG).show();
                        startActivity(pergunta3);
                    }
                }
        );
        resposta2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int count = Integer.parseInt(countRespostaIntent);
                        int countResposta = 0 + count;
                        Intent pergunta3 = new Intent(QuizAppQuestion2Activity.this, QuizAppQuestion3Activity.class);
                        pergunta3.putExtra("qtdAcertos", String.valueOf(countResposta));
                        pergunta3.putExtra("nomeUsuario", nomeDoUsuario);
                        Toast.makeText(getApplicationContext(), "Você errou!", Toast.LENGTH_LONG).show();
                        startActivity(pergunta3);
                    }
                }
        );
        resposta3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int count = Integer.parseInt(countRespostaIntent);
                        int countResposta = 0 + count;
                        Intent pergunta3 = new Intent(QuizAppQuestion2Activity.this, QuizAppQuestion3Activity.class);
                        pergunta3.putExtra("qtdAcertos", String.valueOf(countResposta));
                        pergunta3.putExtra("nomeUsuario", nomeDoUsuario);
                        Toast.makeText(getApplicationContext(), "Você errou!", Toast.LENGTH_LONG).show();
                        startActivity(pergunta3);
                    }
                }
        );
        resposta4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int count = Integer.parseInt(countRespostaIntent);
                        int countResposta = 0 + count;
                        Intent pergunta3 = new Intent(QuizAppQuestion2Activity.this, QuizAppQuestion3Activity.class);
                        pergunta3.putExtra("qtdAcertos", String.valueOf(countResposta));
                        pergunta3.putExtra("nomeUsuario", nomeDoUsuario);
                        Toast.makeText(getApplicationContext(), "Você errou!", Toast.LENGTH_LONG).show();
                        startActivity(pergunta3);
                    }
                }
        );

    }


}
