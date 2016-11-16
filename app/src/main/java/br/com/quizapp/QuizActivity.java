package br.com.quizapp;


import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Thalita Monteiro on 15/11/2016.
 */
public class QuizActivity extends AppCompatActivity {

        Button resposta1;
        Button resposta2;
        Button resposta3;
        Button resposta4;

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.quiz_app_view);

            resposta1 = (Button) findViewById(R.id.resposta1);
            resposta2 = (Button) findViewById(R.id.resposta2);
            resposta3 = (Button) findViewById(R.id.resposta3);
            resposta4 = (Button) findViewById(R.id.resposta4);

            final String nomeDoUsuario = getIntent().getStringExtra("nomeUsuario");

            resposta1.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "Você errou!", Toast.LENGTH_LONG).show();

                            int countResposta = 0;
                            Intent pergunta2 = new Intent(QuizActivity.this, QuizAppQuestion2Activity.class);
                            pergunta2.putExtra("qtdAcertos", String.valueOf(countResposta));
                            pergunta2.putExtra("nomeUsuario", nomeDoUsuario);

                            startActivity(pergunta2);

                        }
                    }
            );
            resposta2.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "Você acertou!", Toast.LENGTH_LONG).show();

                            int countResposta = 1;
                            Intent pergunta2 = new Intent(QuizActivity.this, QuizAppQuestion2Activity.class);
                            pergunta2.putExtra("qtdAcertos", String.valueOf(countResposta));
                            pergunta2.putExtra("nomeUsuario", nomeDoUsuario);
                            startActivity(pergunta2);
                        }
                    }
            );
            resposta3.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "Você errou!", Toast.LENGTH_LONG).show();

                            int countResposta = 0;
                            Intent pergunta2 = new Intent(QuizActivity.this, QuizAppQuestion2Activity.class);
                            pergunta2.putExtra("qtdAcertos", String.valueOf(countResposta));
                            pergunta2.putExtra("nomeUsuario", nomeDoUsuario);

                            startActivity(pergunta2);
                        }
                    }
            );
            resposta4.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            Toast.makeText(getApplicationContext(), "Você errou!", Toast.LENGTH_LONG).show();

                            int countResposta = 0;
                            Intent pergunta2 = new Intent(QuizActivity.this, QuizAppQuestion2Activity.class);
                            pergunta2.putExtra("qtdAcertos", String.valueOf(countResposta));
                            pergunta2.putExtra("nomeUsuario", nomeDoUsuario);

                            startActivity(pergunta2);
                        }
                    }
            );

    }
}
