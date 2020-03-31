package joliverie.example.quizzprojet;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;

import joliverie.example.quizzprojet.metier.Question;
import joliverie.example.quizzprojet.metier.Reponse;


public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        getSupportActionBar().hide();
        final int id_lieu = getIntent().getIntExtra("ID_LIEU",1);

        BDAdapter bd = new BDAdapter(this);
        bd.open();
        Cursor c = bd.getQuestionWithLieu(id_lieu);
        ArrayList<Question> lesQuestions = new ArrayList<Question>();
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Question uneQuestion = new Question(c.getString(1),c.getInt(2));
            int id_question = Integer.parseInt(c.getString(0));
            uneQuestion.setId_question(id_question);
            lesQuestions.add(uneQuestion);

        }


        ArrayList<Reponse> lesReponses = new ArrayList<Reponse>();
        for (Question uneQuestion : lesQuestions){
            Cursor repCursor=bd.getReponseWithQuestion(uneQuestion.getId_question());
            for(repCursor.moveToFirst(); !repCursor.isAfterLast(); repCursor.moveToNext()) {
                Reponse uneReponse = new Reponse(repCursor.getString(1),repCursor.getInt(2),uneQuestion.getId_question());
                uneReponse.setId_reponse(Integer.parseInt(repCursor.getString(0)));
                lesReponses.add(uneReponse);
            }
        }

        for (Reponse uneReponse : lesReponses){
            Log.d("une reponse", " text : " + uneReponse.getText_rep() + " validate : " + uneReponse.getValide() + " id_question : " + uneReponse.getId_question() + " id_rep "+ uneReponse.getId_reponse());
        }


        bd.close();

    }
}