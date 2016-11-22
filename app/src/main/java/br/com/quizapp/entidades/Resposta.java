package br.com.quizapp.entidades;

/**
 * Created by Thalita Monteiro on 21/11/2016.
 */
public class Resposta {

    private int idAnswer;
    private int idQuestion;
    private String answer;

    public int getIdAnswer() {
        return idAnswer;
    }

    public int getIdQuestion() {
        return idQuestion;
    }

    public String getAnswer() {
        return answer;
    }

    public void setIdAnswer(int idAnswer) {
        this.idAnswer = idAnswer;
    }

    public void setIdQuestion(int idQuestion) {
        this.idQuestion = idQuestion;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }
}
