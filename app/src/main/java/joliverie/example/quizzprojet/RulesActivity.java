package joliverie.example.quizzprojet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
        getSupportActionBar().hide();

        Button next = (Button) findViewById(R.id.button);
        next.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                SharedPreferences pref = getApplicationContext().getSharedPreferences("MyPref",0);
                Editor editor = pref.edit();
                editor.putInt("BONNE_REPONSE", 0);
                editor.commit();
                Intent myIntent = new Intent(view.getContext(), MapActivity.class);
                startActivityForResult(myIntent, 0);
            }

        });

    }
}
