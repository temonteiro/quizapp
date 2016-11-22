package br.com.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.quizapp.db.DBHelper;
import br.com.quizapp.entidades.PerguntasRespostas;

/**
 * Created by Thalita Monteiro on 21/11/2016.
 */
public class CadastrarPerguntaActivity extends AppCompatActivity {

    EditText pergunta, resposta1, resposta2, resposta3, resposta4;
    Button add;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crud_perguntas);

        pergunta  = (EditText) findViewById(R.id.crud_pergunta1);
        resposta1 = (EditText) findViewById(R.id.crud_resposta1);
        resposta2 = (EditText) findViewById(R.id.crud_resposta2);
        resposta3 = (EditText) findViewById(R.id.crud_resposta3);
        resposta4 = (EditText) findViewById(R.id.crud_resposta4);

        add    = (Button) findViewById(R.id.btAdicionar);
        final DBHelper dbHelper = new DBHelper(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerguntasRespostas perguntasRespostas = new PerguntasRespostas();
                List<String> respostas = new ArrayList<String>();

                perguntasRespostas.setPergunta(pergunta.getText().toString());

                respostas.add(resposta1.getText().toString());
                respostas.add(resposta2.getText().toString());
                respostas.add(resposta3.getText().toString());
                respostas.add(resposta4.getText().toString());

                perguntasRespostas.setRespostas(respostas);

                dbHelper.addPerguntaResposta(perguntasRespostas);
                //Intent recyclerViewIntent = new Intent(CadastrarPerguntaActivity.this, RecyclerViewActivity.class);
                //startActivity(recyclerViewIntent);

            }
        });

    }
}
