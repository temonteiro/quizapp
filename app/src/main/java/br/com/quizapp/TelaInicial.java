package br.com.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TelaInicial extends AppCompatActivity {

    private EditText nomeUsuario;
    private Button proximoQuizz;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_inicial);

        nomeUsuario = (EditText) findViewById(R.id.nomeDoUsuario);
        proximoQuizz = (Button) findViewById(R.id.proximoTelaInicial);

        proximoQuizz.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentQuizz = new Intent(TelaInicial.this, QuizActivity.class);
                        intentQuizz.putExtra("nomeUsuario", nomeUsuario.getText().toString());
                        startActivity(intentQuizz);
                    }
                }
        );
    }
}
