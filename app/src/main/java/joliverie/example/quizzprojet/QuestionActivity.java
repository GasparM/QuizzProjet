package joliverie.example.quizzprojet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import joliverie.example.quizzprojet.metier.Question;
import joliverie.example.quizzprojet.metier.Reponse;


public class QuestionActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);
        getSupportActionBar().hide();
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        final int id_lieu = pref.getInt("ID_LIEU", -1);
        int id_question_actif = getIntent().getIntExtra("ID_QUESTION_ACTIF",0);
        Button nextQuestionRouge = (Button) findViewById(R.id.buttonRouge);
        Button nextQuestionVert = (Button) findViewById(R.id.buttonVert);
        Button nextQuestionCyan = (Button) findViewById(R.id.buttonCyan);
        Button nextQuestionViolet = (Button) findViewById(R.id.buttonViolet);

        BDAdapter bd = new BDAdapter(this);
        bd.open();
        Cursor cursor = bd.getNbQuestionByLieu(id_lieu);
        cursor.moveToFirst();
        int nbQuestion = cursor.getInt(0);
        Cursor c = bd.getQuestionWithLieu(id_lieu);
        ArrayList<Question> lesQuestions = new ArrayList<Question>();
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Question uneQuestion = new Question(c.getString(1),c.getInt(2));
            int id_question = Integer.parseInt(c.getString(0));
            uneQuestion.setId_question(id_question);
            lesQuestions.add(uneQuestion);
        }

        ((TextView)findViewById(R.id.nbQuestion)).setText("Question "+ (id_question_actif+1)+"/"+nbQuestion+":");
        ((TextView)findViewById(R.id.question)).setText(lesQuestions.get(id_question_actif).getText_question());

        ArrayList<Reponse> lesReponses = new ArrayList<Reponse>();
        Cursor repCursor=bd.getReponseWithQuestion(lesQuestions.get(id_question_actif).getId_question());
        for(repCursor.moveToFirst(); !repCursor.isAfterLast(); repCursor.moveToNext()) {
            Reponse uneReponse = new Reponse(repCursor.getString(1),repCursor.getInt(2),lesQuestions.get(id_question_actif).getId_question());
            uneReponse.setId_reponse(Integer.parseInt(repCursor.getString(0)));
            lesReponses.add(uneReponse);
        }

        nextQuestionRouge.setText(lesReponses.get(0).getText_rep());
        nextQuestionVert.setText(lesReponses.get(1).getText_rep());
        nextQuestionCyan.setText(lesReponses.get(2).getText_rep());
        nextQuestionViolet.setText(lesReponses.get(3).getText_rep());

        nextQuestionRouge.setOnClickListener(this);
        nextQuestionVert.setOnClickListener(this);
        nextQuestionCyan.setOnClickListener(this);
        nextQuestionViolet.setOnClickListener(this);
        bd.close();
    }

    @Override
    public void onClick(View v) {
        String text_rep_choisi = null;
        switch(v.getId()){
            case R.id.buttonRouge:
                text_rep_choisi = (((Button)findViewById(R.id.buttonRouge)).getText().toString()) ;
                break;
            case R.id.buttonVert:
                text_rep_choisi = (((Button)findViewById(R.id.buttonVert)).getText().toString()) ;
                break;
            case R.id.buttonCyan:
                text_rep_choisi = (((Button)findViewById(R.id.buttonCyan)).getText().toString()) ;
                break;
            case R.id.buttonViolet:
                text_rep_choisi = (((Button)findViewById(R.id.buttonViolet)).getText().toString()) ;
                break;
        }
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref", 0);
        Editor editor = pref.edit();
        String textQuestion = ((TextView)findViewById(R.id.question)).getText().toString();
        int id_question_actif = getIntent().getIntExtra("ID_QUESTION_ACTIF", 0);
        final int id_lieu = pref.getInt("ID_LIEU", -1);
        BDAdapter bd = new BDAdapter(this);
        bd.open();
        Cursor c = bd.getNbQuestionByLieu(id_lieu);
        c.moveToFirst();
        int nbQuestion = c.getInt(0);
        Cursor c1 = bd.getLastLieu();
        c1.moveToFirst();
        int lastLieu = c1.getInt(0);
        Cursor c2 = bd.getVraiOuFaux(text_rep_choisi,textQuestion);
        c2.moveToFirst();
        int valid = c2.getInt(0);


        if (valid == 1){
            editor.putInt("BONNE_REPONSE", pref.getInt("BONNE_REPONSE",-1)+1);
            editor.commit();
        }

        Log.d("Bonne Reponse", ":"+valid);
        Log.d("text_rep", ":"+text_rep_choisi);
        Log.d("id_lieu", ":"+id_lieu);
        Log.d("lastLieu", ":"+lastLieu);
        if (id_question_actif+1 != nbQuestion){
                Intent myIntent = new Intent(v.getContext(), QuestionActivity.class);
                myIntent.putExtra("ID_QUESTION_ACTIF", id_question_actif + 1);
                startActivityForResult(myIntent, 0);
        }else {
            if(id_lieu == lastLieu){
                Intent myIntent = new Intent(v.getContext(), ScoreActivity.class);
                startActivityForResult(myIntent, 0);
            }else {
                Intent myIntent = new Intent(v.getContext(), MapActivity.class);
                startActivityForResult(myIntent, 0);
            }
        }
    }

    @Override
    public void onBackPressed(){

    }
}