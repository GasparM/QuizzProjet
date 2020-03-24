package joliverie.example.quizzprojet;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import joliverie.example.quizzprojet.metier.Lieu;
import joliverie.example.quizzprojet.metier.Plan;
import joliverie.example.quizzprojet.metier.Question;
import joliverie.example.quizzprojet.metier.Reponse;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BDAdapter bd = new BDAdapter(this);
        bd.open();


        Lieu unLieu = new Lieu( "Nantes", 1);
        Lieu unLieu2 = new Lieu( "Paris", 2);
        Lieu unLieu3 = new Lieu( "Lyon",3);
        Lieu unLieu4 = new Lieu( "Marseille",4);

        Question uneQuestion = new Question ("Quel animal as tu ? ", 2);
        Question uneQuestion2 = new Question ("Quel age as-tu", 3);
        Question uneQuestion3 = new Question ("Quel taille fait-tu ?", 1);
        Question uneQuestion4 = new Question ("Date de sortie de Iron Man", 2);

        Reponse uneReponse = new Reponse("chat", 1, 1 );
        Reponse uneReponse2 = new Reponse("chien", 0, 1 );
        Reponse uneReponse3 = new Reponse("poule", 0, 1 );
        Reponse uneReponse4 = new Reponse("dinausore", 0, 1 );
        Reponse uneReponse5 = new Reponse("2 ans", 1, 2 );
        Reponse uneReponse6 = new Reponse("3 ans", 0, 2 );
        Reponse uneReponse7 = new Reponse("19 ans", 0, 2 );
        Reponse uneReponse8 = new Reponse("2765 ans", 0, 2 );
        Reponse uneReponse9 = new Reponse("1m30", 1, 3 );
        Reponse uneReponse10 = new Reponse("3 pommes", 0, 3 );
        Reponse uneReponse11 = new Reponse("1m70", 0, 3 );
        Reponse uneReponse12 = new Reponse("Tu touches les étoiles", 0, 3 );
        Reponse uneReponse13 = new Reponse("2003", 1, 4 );
        Reponse uneReponse14 = new Reponse("1999", 0, 4 );
        Reponse uneReponse15 = new Reponse("-457", 0, 4 );
        Reponse uneReponse16 = new Reponse("2009", 0, 4 );



        Plan unPlan = new Plan("urlNantes");
        Plan unPlan2 = new Plan("urlParis");
        Plan unPlan3 = new Plan("urlLyon");
        Plan unPlan4 = new Plan("urlMarseille");


        Log.d(TAG, "logtest : " + unLieu.toString());

        bd.insererLieu(unLieu);
        bd.insererLieu(unLieu2);
        bd.insererLieu(unLieu3);
        bd.insererLieu(unLieu4);

        bd.insererQuestion(uneQuestion);
        bd.insererQuestion(uneQuestion2);
        bd.insererQuestion(uneQuestion3);
        bd.insererQuestion(uneQuestion4);

        bd. insererReponse(uneReponse);
        bd. insererReponse(uneReponse2);
        bd. insererReponse(uneReponse3);
        bd. insererReponse(uneReponse4);
        bd. insererReponse(uneReponse5);
        bd. insererReponse(uneReponse6);
        bd. insererReponse(uneReponse7);
        bd. insererReponse(uneReponse8);
        bd. insererReponse(uneReponse9);
        bd. insererReponse(uneReponse10);
        bd. insererReponse(uneReponse11);
        bd. insererReponse(uneReponse12);
        bd. insererReponse(uneReponse13);
        bd. insererReponse(uneReponse14);
        bd. insererReponse(uneReponse15);
        bd. insererReponse(uneReponse16);

        bd.insererPlan(unPlan);
        bd.insererPlan(unPlan2);
        bd.insererPlan(unPlan3);
        bd.insererPlan(unPlan4);

        bd.close();

        ListView listViewArticles = (ListView) findViewById(R.id.listViewTest);
        bd = new BDAdapter(this);
        //On ouvre la base de données pour écrire dedans
        bd.open();
        /*
        Cursor c = bd.getDataLieu();
        Toast.makeText(getApplicationContext(), "il y a " + String.valueOf(c.getCount()) + " articles dans la BD", Toast.LENGTH_LONG).show();
        // colonnes à afficher
        String[] columns = new String[]{BDAdapter.COL_ID, BDAdapter.COL_LIEU_LIBELLE};
        // champs dans lesquelles afficher les colonnes
        int[] to = new int[]{R.id.TextViewIdLieu, R.id.TextViewLibLieu};
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.activity_main, c, columns, to,0);
        // Assign adapter to ListView
        listViewArticles.setAdapter(dataAdapter);
        */

        Cursor c = bd.getQuestionWithLieu(2);
        // colonnes à afficher
        String[] columns = new String[]{BDAdapter.COL_ID, BDAdapter.COL_TEXT_QUESTION, BDAdapter.COL_ID_LIEU};
        // champs dans lesquelles afficher les colonnes
        int[] to = new int[]{R.id.TextViewIdQuestion, R.id.TextViewTextQuestion, R.id.TextViewidLieuQuestion};
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.activity_main, c, columns, to,0);
        // Assign adapter to ListView
        listViewArticles.setAdapter(dataAdapter);
        bd.close();

    }
}