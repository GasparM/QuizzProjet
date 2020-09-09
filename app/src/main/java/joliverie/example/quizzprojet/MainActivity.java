package joliverie.example.quizzprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;

import android.database.Cursor;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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
        getSupportActionBar().hide();

        SharedPreferences pref = getApplication().getSharedPreferences("MyPref",0);
        Editor editor = pref.edit();
        editor.clear();
        editor.commit();
        Button next = (Button) findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), RulesActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });

        // Insertion pour test
        BDAdapter bd = new BDAdapter(this);
        bd.open();

        SharedPreferences prefBdd = getApplication().getSharedPreferences("MyPrefBdd",MODE_PRIVATE);
        Editor editorBdd = prefBdd.edit();

        if(prefBdd.getInt("data", 0) == 0) {
            Lieu unLieu = new Lieu( "Saint Jospeh", 1);
            Lieu unLieu2 = new Lieu( "Chappelle", 2);
            Lieu unLieu3 = new Lieu( "Joliverie",3);

            Question uneQuestion = new Question ("Quel était le nom du BTS SIO avant 2004 ?", 1);
            Question uneQuestion2 = new Question ("Où se trouvait le service de reprographie avant sa situation actuelle dans le batiment ?", 1);
            Question uneQuestion3 = new Question ("Quelle banque est partenaire de la Joliverie ?", 2);
            Question uneQuestion4 = new Question ("Quelle est l'année de construction de la chapelle actuelle ?", 2);
            Question uneQuestion5 = new Question ("De quelle époque de l'histoire datent les objets les plus anciens retrouvés sur le site de la Joliverie ?",3);
            Question uneQuestion6 = new Question ("En quelle année a été créé le Centre de Formations Apprenti de la Joliverie ? ", 3);
            Question uneQuestion7 = new Question ("Quel est l'établissement qui a fusionné avec la Joliverie en 2020 ?", 3);
            Question uneQuestion8 = new Question ("Le pôle productique du lycée professionnel a été labellisé HTEC en 2015. Que signifie ce signe ?", 1);
            Question uneQuestion9 = new Question ("Quelle est la meilleur performance (en km/l) réalisée par Microjoule depuis son origine lors des courses du Shell EcoMarathon ?", 1);
            Question uneQuestion10 = new Question("En quelle année fût inauguré le nouveau bâtiment C : Pôle des process Industriels ? ", 1);


            Reponse uneReponse = new Reponse("BTS Informatique de Gestion", 1, 1 );
            Reponse uneReponse2 = new Reponse("BTS Développeur", 0, 1);
            Reponse uneReponse3 = new Reponse("BTS Réseaux", 0, 1 );
            Reponse uneReponse4 = new Reponse("BTS Maintenance des PC", 0, 1 );
            Reponse uneReponse5 = new Reponse("CDI Saint-Pierre", 0, 2 );
            Reponse uneReponse6 = new Reponse("Salle du service de comptabilité - Direction générale", 0, 2 );
            Reponse uneReponse7 = new Reponse("Bureau de la vie étudiante", 1, 2 );
            Reponse uneReponse8 = new Reponse("Salle des professeur Saint-Joseph", 0, 2 );
            Reponse uneReponse9 = new Reponse("Crédit agricole", 0, 3 );
            Reponse uneReponse10 = new Reponse("Crédit mutuel", 1, 3 );
            Reponse uneReponse11 = new Reponse("Banque Populaire", 0, 3 );
            Reponse uneReponse12 = new Reponse("La Banque postale", 0, 3 );
            Reponse uneReponse13 = new Reponse("1962", 1, 4 );
            Reponse uneReponse14 = new Reponse("1951", 0, 4 );
            Reponse uneReponse15 = new Reponse("1927", 0, 4 );
            Reponse uneReponse16 = new Reponse("1970", 0, 4 );
            Reponse uneReponse17 = new Reponse("Epoque de la pré-histoire", 0, 5 );
            Reponse uneReponse18 = new Reponse("Epoque de la Renaissance 16ème Siécle", 0, 5 );
            Reponse uneReponse19 = new Reponse("Epoque carolingienne", 0, 5 );
            Reponse uneReponse20 = new Reponse("Epoque Napoléonienne", 1, 5 );
            Reponse uneReponse21 = new Reponse("1972", 0, 6 );
            Reponse uneReponse22 = new Reponse("1988", 1, 6 );
            Reponse uneReponse23 = new Reponse("1978", 0, 6 );
            Reponse uneReponse24 = new Reponse("1982", 0, 6 );
            Reponse uneReponse25 = new Reponse("Notre Dame", 0, 7 );
            Reponse uneReponse26 = new Reponse("Saint Félix", 0, 7 );
            Reponse uneReponse27 = new Reponse("Les Bourdonnières", 0, 7 );
            Reponse uneReponse28 = new Reponse("La Baugerie", 1, 7 );
            Reponse uneReponse29 = new Reponse("Hautes Technologies En Commande numérique", 0, 8 );
            Reponse uneReponse30 = new Reponse("Haute Technologie Environnementale Créative", 0, 8 );
            Reponse uneReponse31 = new Reponse("Haas Technical Education Center", 1, 8 );
            Reponse uneReponse32 = new Reponse("High Tech Engineering Center", 0, 8 );
            Reponse uneReponse33 = new Reponse("2638 km/l", 0, 9 );
            Reponse uneReponse34 = new Reponse("3771 km/l", 1, 9 );
            Reponse uneReponse35 = new Reponse("4522 km/l", 0,9 );
            Reponse uneReponse36 = new Reponse("3224 km/l", 0, 9 );
            Reponse uneReponse37 = new Reponse("1920", 0, 10 );
            Reponse uneReponse38 = new Reponse("1994", 0, 10);
            Reponse uneReponse39 = new Reponse("2014", 0,10);
            Reponse uneReponse40 = new Reponse("2016", 1, 10 );

            Plan unPlan = new Plan("R.drawable.plan1", 1);
            Plan unPlan2 = new Plan("R.drawable.plan2", 2);
            Plan unPlan3 = new Plan("R.drawable.plan3", 3);

            bd.insererLieu(unLieu);
            bd.insererLieu(unLieu2);
            bd.insererLieu(unLieu3);

            bd.insererQuestion(uneQuestion);
            bd.insererQuestion(uneQuestion2);
            bd.insererQuestion(uneQuestion3);
            bd.insererQuestion(uneQuestion4);
            bd.insererQuestion(uneQuestion5);
            bd.insererQuestion(uneQuestion6);
            bd.insererQuestion(uneQuestion7);
            bd.insererQuestion(uneQuestion8);
            bd.insererQuestion(uneQuestion9);
            bd.insererQuestion(uneQuestion10);


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
            bd. insererReponse(uneReponse17);
            bd. insererReponse(uneReponse18);
            bd. insererReponse(uneReponse19);
            bd. insererReponse(uneReponse20);
            bd. insererReponse(uneReponse21);
            bd. insererReponse(uneReponse22);
            bd. insererReponse(uneReponse23);
            bd. insererReponse(uneReponse24);
            bd.insererReponse(uneReponse25);
            bd.insererReponse(uneReponse26);
            bd.insererReponse(uneReponse27);
            bd.insererReponse(uneReponse28);
            bd.insererReponse(uneReponse29);
            bd.insererReponse(uneReponse30);
            bd.insererReponse(uneReponse31);
            bd.insererReponse(uneReponse32);
            bd.insererReponse(uneReponse33);
            bd.insererReponse(uneReponse34);
            bd.insererReponse(uneReponse35);
            bd.insererReponse(uneReponse36);
            bd.insererReponse(uneReponse37);
            bd.insererReponse(uneReponse38);
            bd.insererReponse(uneReponse39);
            bd.insererReponse(uneReponse40);

            bd.insererPlan(unPlan);
            bd.insererPlan(unPlan2);
            bd.insererPlan(unPlan3);

            Log.d(TAG, "data insered");

            editorBdd.putInt("data", 1);
        }
        editorBdd.commit();

        bd.close();
        /*
        ListView listViewArticles = (ListView) findViewById(R.id.listViewTest);
        bd = new BDAdapter(this);
        //On ouvre la base de données pour écrire dedans
        bd.open();

        Cursor c = bd.getDataLieu();
        Toast.makeText(getApplicationContext(), "il y a " + String.valueOf(c.getCount()) + " articles dans la BD", Toast.LENGTH_LONG).show();
        // colonnes à afficher
        String[] columns = new String[]{BDAdapter.COL_ID, BDAdapter.COL_LIEU_LIBELLE};
        // champs dans lesquelles afficher les colonnes
        int[] to = new int[]{R.id.TextViewIdLieu, R.id.TextViewLibLieu};
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.activity_main, c, columns, to,0);
        // Assign adapter to ListView
        listViewArticles.setAdapter(dataAdapter);


        Cursor c = bd.getQuestionWithLieu(2);
        // colonnes à afficher
        String[] columns = new String[]{BDAdapter.COL_ID, BDAdapter.COL_TEXT_QUESTION, BDAdapter.COL_ID_LIEU};
        // champs dans lesquelles afficher les colonnes
        int[] to = new int[]{R.id.TextViewIdQuestion, R.id.TextViewTextQuestion, R.id.TextViewidLieuQuestion};
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.activity_main, c, columns, to,0);
        // Assign adapter to ListView
        listViewArticles.setAdapter(dataAdapter);
        bd.close();
        */
    }
}