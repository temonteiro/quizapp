package br.com.quizapp;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Thalita Monteiro on 15/11/2016.
 */
public class QuizAppResultadoActivity extends AppCompatActivity {

    TextView nomeUsuario;
    TextView totalAcertos;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.quiz_app_result_view);

        nomeUsuario = (TextView) findViewById(R.id.nomeDoUsuarioResultado);
        totalAcertos = (TextView) findViewById(R.id.totalAcertos);

        nomeUsuario.setText(getIntent().getStringExtra("nomeUsuario"));
        totalAcertos.setText(getIntent().getStringExtra("qtdAcertos"));
    }
}
