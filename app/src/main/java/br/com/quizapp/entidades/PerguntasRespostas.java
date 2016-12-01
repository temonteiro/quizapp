package br.com.quizapp.entidades;

import java.util.List;

/**
 * Created by Thalita Monteiro on 21/11/2016.
 */
public class PerguntasRespostas {

    private String pergunta;
    private List<String> opcoes;
    private List<Boolean> respostas;

    public String getPergunta() {
        return pergunta;
    }

    public List<String> getOpcoes() {
        return opcoes;
    }

    public void setOpcoes(List<String> opcoes) {
        this.opcoes = opcoes;
    }

    public void setPergunta(String pergunta) {
        this.pergunta = pergunta;
    }

    public List<Boolean> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<Boolean> respostas) {
        this.respostas = respostas;
    }
}
