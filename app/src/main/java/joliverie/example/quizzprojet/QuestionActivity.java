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

public class QuestionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        getSupportActionBar().hide();
        final int id_lieu = getIntent().getIntExtra("ID_LIEU",1);

        BDAdapter bd = new BDAdapter(this);
        bd.open();

        ArrayList<Question> lesQuestions = bd.getQuestionWithLieu(id_lieu);
        for (Question uneQuestion: lesQuestions) {
            Log.d("QUESTION", uneQuestion.getText_question()+"   "+uneQuestion.getId_lieu());
        }
    }
}