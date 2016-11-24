package br.com.quizapp.entidades;

import java.util.List;

/**
 * Created by Thalita Monteiro on 21/11/2016.
 */
public class PerguntasRespostas {

    private String pergunta;
    private List<String> respostas;
    private String respostaCerta;

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

    public String getRespostaCerta() {
        return respostaCerta;
    }

    public void setRespostaCerta(String respostaCerta) {
        this.respostaCerta = respostaCerta;
    }
}
