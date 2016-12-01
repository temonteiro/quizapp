package br.com.quizapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.com.quizapp.db.DBHelper;
import br.com.quizapp.entidades.PerguntasRespostas;

/**
 * Created by Thalita Monteiro on 21/11/2016.
 */
public class CadastrarPerguntaActivity extends AppCompatActivity {

    EditText pergunta, resposta1, resposta2, resposta3, resposta4;
    RadioButton checkResposta1,checkResposta2, checkResposta3, checkResposta4;
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

        checkResposta1 = (RadioButton) findViewById(R.id.check_resposta1);
        checkResposta2 = (RadioButton) findViewById(R.id.check_resposta2);
        checkResposta3 = (RadioButton) findViewById(R.id.check_resposta3);
        checkResposta4 = (RadioButton) findViewById(R.id.check_resposta4);

        add    = (Button) findViewById(R.id.btAdicionar);
        final DBHelper dbHelper = new DBHelper(this);



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PerguntasRespostas perguntasRespostas = new PerguntasRespostas();
                List<String> respostas = new ArrayList<String>();
                List<Boolean> checkRespostas = new ArrayList<Boolean>();

                perguntasRespostas.setPergunta(pergunta.getText().toString());

                respostas.add(resposta1.getText().toString());
                respostas.add(resposta2.getText().toString());
                respostas.add(resposta3.getText().toString());
                respostas.add(resposta4.getText().toString());

                perguntasRespostas.setOpcoes(respostas);

                checkRespostas.add(checkResposta1.isChecked());
                checkRespostas.add(checkResposta2.isChecked());
                checkRespostas.add(checkResposta3.isChecked());
                checkRespostas.add(checkResposta4.isChecked());

                perguntasRespostas.setRespostas(checkRespostas);

                dbHelper.addPerguntaResposta(perguntasRespostas);

                Toast.makeText(getApplicationContext(), "Pergunta cadastrada com sucesso", Toast.LENGTH_SHORT).show();

                Intent voltarTelaInicial = new Intent(CadastrarPerguntaActivity.this, TelaInicial.class);
                startActivity(voltarTelaInicial);

            }
        });

    }
}
