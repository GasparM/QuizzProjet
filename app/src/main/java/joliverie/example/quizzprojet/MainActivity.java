package joliverie.example.quizzprojet;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import android.database.Cursor;
import android.util.Log;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

import joliverie.example.quizzprojet.metier.Lieu;
import joliverie.example.quizzprojet.BDAdapter;
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
        onCreate(bd);

        Lieu unLieu = new Lieu( "Nantes");
        Lieu unLieu2 = new Lieu( "Paris");
        Lieu unLieu3 = new Lieu( "Lyon");
        Lieu unLieu4 = new Lieu( "Marseille");

        Log.d(TAG, "logtest : " + unLieu.toString());

        bd.insererLieu(unLieu);
        bd.insererLieu(unLieu2);
        bd.insererLieu(unLieu3);
        bd.insererLieu(unLieu4);

        System.out.println("insertion de 2 articles");
        bd.close();

        ListView listViewArticles = (ListView) findViewById(R.id.listViewTest);
        bd = new BDAdapter(this);
        //On ouvre la base de données pour écrire dedans
        bd.open();
        Cursor c = bd.getDataLieu();
        Toast.makeText(getApplicationContext(), "il y a " + String.valueOf(c.getCount()) + " articles dans la BD", Toast.LENGTH_LONG).show();
        // colonnes à afficher
        String[] columns = new String[]{BDAdapter.COL_ID, BDAdapter.COL_LIEU_LIBELLE};
        // champs dans lesquelles afficher les colonnes
        int[] to = new int[]{R.id.textViewIdLieu, R.id.textViewLibLieu};
        SimpleCursorAdapter dataAdapter = new SimpleCursorAdapter(this, R.layout.activity_main, c, columns, to,0);
        // Assign adapter to ListView
        listViewArticles.setAdapter(dataAdapter);
        bd.close();

    }
}