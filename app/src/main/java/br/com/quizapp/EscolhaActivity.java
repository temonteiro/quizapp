package br.com.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Thalita Monteiro on 21/11/2016.
 */
public class EscolhaActivity extends AppCompatActivity {

    Button addPergunta, iniciarJogo, listarPerguntas;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.escolha_view);

        addPergunta = (Button) findViewById(R.id.addPergunta);
        iniciarJogo = (Button) findViewById(R.id.iniciarJogo);
        listarPerguntas = (Button) findViewById(R.id.listarPerguntas);

        addPergunta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addPergunta = new Intent(EscolhaActivity.this, CadastrarPerguntaActivity.class);
                startActivity(addPergunta);
            }
        });

        iniciarJogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iniciarJogo = new Intent(EscolhaActivity.this, TelaInicial.class);
                startActivity(iniciarJogo);
            }
        });


    }
}
