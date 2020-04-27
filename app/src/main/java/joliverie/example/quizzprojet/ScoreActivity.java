package joliverie.example.quizzprojet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ScoreActivity  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        getSupportActionBar().hide();
        BDAdapter bd = new BDAdapter(this);
        bd.open();
        Cursor cursor = bd.getNbQuestion();
        cursor.moveToFirst();
        int nbQuestion = cursor.getInt(0);
        SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);
        int resultat = pref.getInt("BONNE_REPONSE",-1);
        ((TextView)findViewById(R.id.resultat)).setText(resultat+"/"+nbQuestion);

    }

    @Override
    public void onBackPressed(){}
}
