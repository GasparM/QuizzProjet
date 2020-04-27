package joliverie.example.quizzprojet;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.os.Bundle;
import android.preference.PreferenceManager;
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
        final int id_lieu = 1;

        Button next = (Button) findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);
                Editor editor = pref.edit();
                Intent myIntent = new Intent(view.getContext(), QuestionActivity.class);
                if(pref.getInt("ID_LIEU", -1) == -1) {
                    editor.putInt("ID_LIEU", id_lieu);
                }else{
                    editor.putInt("ID_LIEU", pref.getInt("ID_LIEU",-1)+1);
                }
                editor.commit();
                startActivityForResult(myIntent, 0);
            }

        });

        BDAdapter bd = new BDAdapter(this);
        bd.open();

        image = (ImageView) findViewById(R.id.imageView4);
        Cursor c = bd.getPlanWithLieu(id_lieu);

        for(c.moveToFirst(); !c.isAfterLast(); c.moveToNext()) {
            //was working, doesn't work anymore for unknown reasons
            /*
            Log.d(TAG, "Plan affiché : " + c.getString(1));

            int id = getResources().getIdentifier(c.getString(1), "drawable", getPackageName());
            image.setImageResource(id);
            //image.setImageResource(R.drawable.plan1);
            */
            Log.d(TAG, "Plan affiché : " + c.getString(1));
            if (c.getString(1).equals("R.drawable.plan1")){
                image.setImageResource(R.drawable.plan1);
            }
            else if (c.getString(1).equals("R.drawable.plan2")){
                image.setImageResource(R.drawable.plan2);
            }
            else if (c.getString(1).equals("R.drawable.plan3")){
                image.setImageResource(R.drawable.plan3);
            }
            else if (c.getString(1).equals("R.drawable.plan4")){
                image.setImageResource(R.drawable.plan4);
            }
        }
        bd.close();
    }
    }

    @Override
    public void onBackPressed(){}
}