package joliverie.example.quizzprojet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import joliverie.example.quizzprojet.metier.Lieu;
import joliverie.example.quizzprojet.metier.Plan;
import joliverie.example.quizzprojet.metier.Question;
import joliverie.example.quizzprojet.metier.Reponse;

public class BDAdapter {
    private static final String TAG = "BDAdapter";

    static final int VERSION_BDD = 51;
    private static final String NOM_BDD = "quizz_database";
    static final String TABLE_QUESTION = "table_question";
    static final String TABLE_REPONSE = "table_reponse";
    static final String TABLE_LIEU = "table_lieu";
    static final String TABLE_PLAN = "table_plan";

    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;

    static final String COL_TEXT_QUESTION = "text_question";
    static final int NUM_COL_TEXT_QUESTION = 1;

    static final String COL_TEXT_REPONSE = "text_reponse";
    static final int NUM_COL_TEXT_REPONSE = 2;

    static final String COL_REP_VALIDE = "reponse_valide";
    static final int NUM_COL_REP_VALIDATE = 3;

    static final String COL_LIEU_LIBELLE = "lieu_libelle";
    static final int NUM_LIEU_LIBELLE = 4;

    static final String COL_PLAN_LIBELLE = "plan_libelle";
    static final int NUM_COL_LIB_PLAN = 5;

    static final String COL_ID_LIEU = "id_lieu";
    static final int NUM_COL_ID_LIEU = 5;

    static final String COL_ID_QUESTION = "id_question";
    static final int NUM_COL_ID_QUESTION = 5;



    private CreateBDQuizz bdQuizz;
    private Context context;
    private SQLiteDatabase db;

    //le constructeur
    public BDAdapter (Context context){
        this.context = context;
        bdQuizz = new CreateBDQuizz(context, NOM_BDD, null, VERSION_BDD);
    }

    //si la base n’existe pas, l’objet SQLiteOpenHelper exécute la méthode onCreate
    // si la version de la base a changé, la méthode onUpgrade sera lancée
    // dans les 2 cas l’appel à getWritableDatabase ou getReadableDatabase renverra  la base
    // de données en cache, nouvellement ouverte, nouvellement créée ou mise à jour

    //les méthodes d'instance
    public BDAdapter  open(){
        db = bdQuizz.getWritableDatabase();
        return this;
    }
    public BDAdapter  close(){
        db.close();
        return null;
    }

    public long insererQuestion (Question uneQuestion){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_TEXT_QUESTION, uneQuestion.getText_question());
        values.put(COL_ID_LIEU, uneQuestion.getId_lieu());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_QUESTION, null, values);
    }

    public long insererReponse (Reponse uneReponse){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_TEXT_REPONSE, uneReponse.getText_rep());
        values.put(COL_ID_QUESTION, uneReponse.getId_question());
        values.put(COL_REP_VALIDE, uneReponse.getValide());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_REPONSE, null, values);
    }

    public long insererLieu (Lieu unLieu){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_LIEU_LIBELLE, unLieu.getLib_Lieu());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_LIEU, null, values);
    }

    public long insererPlan (Plan unPlan){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_PLAN_LIBELLE, unPlan.getUrl_photo());
        values.put(COL_ID_LIEU, unPlan.getId_lieu());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_PLAN, null, values);
    }

    public Cursor getDataLieu(){
        return db.rawQuery("SELECT * FROM TABLE_LIEU", null);
    }
    public Cursor getDataPlan(){
        return db.rawQuery("SELECT * FROM TABLE_PLAN", null);
    }
    public Cursor getDataQuestion(){ return db.rawQuery("SELECT * FROM TABLE_QUESTION", null); }
    public Cursor getDataReponse(){
        return db.rawQuery("SELECT * FROM TABLE_REPONSE", null);
    }

    public Cursor getPlanWithLieu(int id_lieu){
        return db.rawQuery("SELECT * FROM "+ TABLE_PLAN +" WHERE " + COL_ID_LIEU + " = " + id_lieu +";", null);
    }

    public Cursor getQuestionWithLieu(int id_lieu){
        return db.rawQuery("SELECT * FROM "+ TABLE_QUESTION +" WHERE " + COL_ID_LIEU + " = " + id_lieu +";", null);
    }

    public Cursor getReponseWithQuestion(int id_question){
        return db.rawQuery("SELECT * FROM "+ TABLE_REPONSE +" WHERE " + COL_ID_QUESTION + " = " + id_question +";", null);
    }

    public Cursor getNbQuestion(){
        return db.rawQuery("SELECT COUNT(*) FROM "+ TABLE_QUESTION +" ;", null);
    }

    public Cursor getNbQuestionByLieu(int id_lieu){
        return db.rawQuery("SELECT COUNT(*) FROM "+ TABLE_QUESTION +" WHERE " + COL_ID_LIEU + " = "+id_lieu +";", null );
    }

    public Cursor getLastLieu(){
        return db.rawQuery("SELECT MAX(_id) FROM "+ TABLE_LIEU +";",null);
    }

    public Cursor getVraiOuFaux(String text_rep, String text_question){
        return db.rawQuery("SELECT reponse_valide FROM "+ TABLE_REPONSE+" WHERE "+ COL_TEXT_REPONSE +" = \""+ text_rep +"\" AND "+ COL_ID_QUESTION +" = (SELECT "+ COL_ID+" FROM "+ TABLE_QUESTION+ " WHERE "+COL_TEXT_QUESTION+" = \""+ text_question+"\");",null);
    }

    public void cleartable() {
        db.execSQL("DELETE FROM " + TABLE_LIEU + ";");
        db.execSQL("DELETE FROM " + TABLE_PLAN + ";");
        db.execSQL("DELETE FROM " + TABLE_QUESTION + ";");
        db.execSQL("DELETE FROM " + TABLE_REPONSE + ";");
    }
}
