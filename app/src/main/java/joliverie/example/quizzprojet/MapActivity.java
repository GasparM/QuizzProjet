package joliverie.example.quizzprojet;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MapActivity extends AppCompatActivity {

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
        /*
        BDAdapter bd = new BDAdapter(this);
        bd.open();

        Cursor c = bd.getPlanWithLieu(id_lieu);
     */

    }
}