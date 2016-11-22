package br.com.quizapp.entidades;

import java.util.List;

/**
 * Created by Thalita Monteiro on 21/11/2016.
 */
public class PerguntasRespostas {

    private String pergunta;
    private List<String> respostas;

    public String getPergunta() {
        return pergunta;
    }

    public List<String> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<String> respostas) {
        this.respostas = respostas;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }
}
