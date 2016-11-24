package br.com.quizapp.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import br.com.quizapp.entidades.Pergunta;
import br.com.quizapp.entidades.PerguntasRespostas;

/**
 * Created by Thalita Monteiro on 21/11/2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "quizManager";
    private static final String TABLE_NAME = "quiz_perguntas";
    private static final String TABLE_NAME2 = "quiz_respostas";
    private static final String TABLE_NAME3 = "quiz_resposta_certa";

    //CAMPOS DA TABELA PERGUNTAS
    private static final String KEY_ID_QUESTION = "id_question";
    private static final String KEY_QUESTION = "question";

    //CAMPOS DA TABELA RESPOSTAS
    private static final String KEY_ID_ANSWER = "id_answer";
    private static final String KEY_ANSWER = "answer";

    //CAMPOS DA TABELA RESPOSTAS CERTA
    private static final String KEY_ID_RESPOSTA_CERTA = "id_resposta_certa";

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_QUESTION_TABLE = "CREATE TABLE "+TABLE_NAME+"("
                + KEY_ID_QUESTION + " integer primary key autoincrement,"
                + KEY_QUESTION + " text)";
        db.execSQL(CREATE_QUESTION_TABLE);

        String CREATE_ANSWER_TABLE = "CREATE TABLE "+TABLE_NAME2+"("
                + KEY_ID_ANSWER + " integer primary key autoincrement,"
                + KEY_ID_QUESTION + " integer"
                + KEY_ANSWER + " text)";
        db.execSQL(CREATE_ANSWER_TABLE);

        String CREATE_ANSWER_CORRETA_TABLE = "CREATE TABLE "+TABLE_NAME3+"("
                + KEY_ID_RESPOSTA_CERTA + " integer primary key autoincrement,"
                + KEY_ID_ANSWER + " integer)";
        db.execSQL(CREATE_ANSWER_CORRETA_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+ TABLE_NAME3);
        onCreate(db);
    }

    public void addPerguntaResposta(PerguntasRespostas perguntasRespostas){
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(KEY_QUESTION, perguntasRespostas.getPergunta());

        //Adiciona a pergunta
        db.insert(TABLE_NAME, null, values);

        //Recupera o ID da pergunta e salva junto com respostas
        int idQuestion = getQuestionId(perguntasRespostas.getPergunta());

        ContentValues valoresRespostas = new ContentValues();
        values.put(KEY_ID_QUESTION, idQuestion);

        values.put(KEY_ANSWER, perguntasRespostas.getRespostas().get(0));
        values.put(KEY_ANSWER, perguntasRespostas.getRespostas().get(1));
        values.put(KEY_ANSWER, perguntasRespostas.getRespostas().get(2));
        values.put(KEY_ANSWER, perguntasRespostas.getRespostas().get(3));

        db.insert(TABLE_NAME2, null, valoresRespostas);
        db.close();

    }

    private int getQuestionId(String pergunta){
        int idQuestion = 0;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {KEY_ID_QUESTION}, KEY_QUESTION + "=?",
                new String[]{pergunta}, null, null, null);

        if (cursor.moveToFirst()) {
            do {
                idQuestion = cursor.getColumnIndex("id_question");
                // do what ever you want here
            } while (cursor.moveToNext());
        }

        cursor.close();

        return idQuestion;
    }

    public List<PerguntasRespostas> getAllPerguntasRespostas(){
        List<PerguntasRespostas> perguntasRespostasList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        List<Pergunta> perguntas = getAllPerguntas();

        for (int i = 0; i < perguntas.size(); i++){
            PerguntasRespostas perguntasRespostas = new PerguntasRespostas();
            Pergunta pergunta = perguntas.get(i);
            List<String> respostasTudo = new ArrayList<>();

            perguntasRespostas.setPergunta(pergunta.getQuestion());

            Cursor cursor = db.query(TABLE_NAME2, new String[] {KEY_ANSWER}, KEY_ID_QUESTION + "=?",
                    new String[]{String.valueOf(pergunta.getIdQuestion())}, null, null, null);

            if (cursor.moveToFirst()) {
                do {
                    String resposta = cursor.getString(cursor.getColumnIndex("answer"));
                    respostasTudo.add(resposta);
                    // do what ever you want here
                } while (cursor.moveToNext());
            }
            perguntasRespostasList.add(perguntasRespostas);
            cursor.close();

        }

        return perguntasRespostasList;
    }


    private List<Pergunta> getAllPerguntas(){
        List<Pergunta> perguntaList = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor cursor = db.query(TABLE_NAME, new String[] {KEY_ID_QUESTION}, null,
                null, null, null, null);

        if (cursor.moveToFirst()){
            do{
                Pergunta pergunta = new Pergunta();
                pergunta.setIdQuestion(cursor.getColumnIndex("id_question"));
                pergunta.setQuestion(cursor.getString(cursor.getColumnIndex("question")));

                perguntaList.add(pergunta);
                // do what ever you want here
            }while(cursor.moveToNext());
        }

        cursor.close();

        return perguntaList;
    }


}
