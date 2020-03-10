package joliverie.example.quizzprojet;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class CreateBDQuizz extends SQLiteOpenHelper {
    private static final String TAG = "CreateBDQuizz";

    public static String DATABASE_NAME = "quizz_database";
    //tables
    private static final String TABLE_QUESTION = "table_question";
    private static final String TABLE_REPONSE = "table_reponse";
    private static final String TABLE_LIEU = "table_lieu";
    private static final String TABLE_PLAN = "table_plan";
    //commons columns
    private static final String COL_ID = "_id";
    //columns
    private static final String COL_TEXT_QUESTION = "text_question";
    private static final String COL_TEXT_REPONSE = "text_reponse";
    private static final String COL_REP_VALIDE = "reponse_valide";
    private static final String COL_LIEU_LIBELLE = "lieu_libelle";
    private static final String COL_PLAN_LIBELLE = "plan_libelle";

    //table create Statements
    private static final String CREATE_QUESTION_TABLE = "CREATE TABLE " + TABLE_QUESTION + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_TEXT_QUESTION + " TEXT NOT NULL);";
    //private static final String CREATE_REPONSE_TABLE = "CREATE TABLE " + TABLE_REPONSE + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+ COL_TEXT_REPONSE + " TEXT NOT NULL " + COL_REP_VALIDE + " TEXT NOT NULL);";
    private static final String CREATE_LIEU_TABLE = "CREATE TABLE " + TABLE_LIEU + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_LIEU_LIBELLE + " TEXT NOT NULL);";
    private static final String CREATE_PLAN_TABLE = "CREATE TABLE " + TABLE_PLAN + " (" + COL_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"+ COL_PLAN_LIBELLE + " TEXT NOT NULL);";

    //constructeur paramétré
    public CreateBDQuizz(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //méthodes d'instance permettant la gestion de l'objet
    public void onCreate(SQLiteDatabase db){
        Log.d(TAG, "onCreate ... ");

        // appelée lorsqu’aucune base n’existe et que la classe utilitaire doit en créer une
        //on créé la table à partir de la requête écrite dans la variable CREATE_BDD
        db.execSQL(CREATE_QUESTION_TABLE);
        //db.execSQL(CREATE_REPONSE_TABLE);
        db.execSQL(CREATE_LIEU_TABLE);
        db.execSQL(CREATE_PLAN_TABLE);
    }
    // appelée si la version de la base a changé
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade ... ");

        //On peut  supprimer la table et de la recréer
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_QUESTION + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_REPONSE + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LIEU + ";");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PLAN + ";");

        onCreate(db);
    }

}
