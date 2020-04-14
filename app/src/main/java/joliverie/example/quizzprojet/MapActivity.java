package joliverie.example.quizzprojet;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import joliverie.example.quizzprojet.metier.Lieu;
import joliverie.example.quizzprojet.metier.Plan;
import joliverie.example.quizzprojet.metier.Question;
import joliverie.example.quizzprojet.metier.Reponse;

import android.widget.ImageView;
import android.util.Log;

public class MapActivity extends AppCompatActivity {
    private static final String TAG = "MapActivity";

    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        getSupportActionBar().hide();
        final int id_lieu = getIntent().getIntExtra("ID_LIEU",1);

        Button next = (Button) findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Intent myIntent = new Intent(view.getContext(), QuestionActivity.class);
                myIntent.putExtra("ID_LIEU", id_lieu);
                startActivityForResult(myIntent, 0);
            }

        });

        BDAdapter bd = new BDAdapter(this);
        bd.open();
        image = (ImageView) findViewById(R.id.imageView4);
        Cursor c = bd.getPlanWithLieu(id_lieu);
        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            Log.d(TAG, "Plan affiché : " + c.getString(1));

            int id = getResources().getIdentifier(c.getString(1), "drawable", getPackageName());
            image.setImageResource(id);
        }

        bd.close();
    }
}