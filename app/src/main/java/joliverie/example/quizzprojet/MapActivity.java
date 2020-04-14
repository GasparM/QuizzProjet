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

public class MapActivity extends AppCompatActivity {

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
                myIntent.putExtra("ID_QUESTION_ACTIF", 0 );
                startActivityForResult(myIntent, 0);
            }

        });
        /*
        BDAdapter bd = new BDAdapter(this);
        bd.open();

        Cursor c = bd.getPlanWithLieu(id_lieu);
     */

    }
}