package joliverie.example.quizzprojet;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import joliverie.example.quizzprojet.metier.Lieu;
import joliverie.example.quizzprojet.metier.Plan;
import joliverie.example.quizzprojet.metier.Question;
import joliverie.example.quizzprojet.metier.Reponse;

public class BDAdapter {
    private static final String TAG = "BDAdapter";

    static final int VERSION_BDD = 2;
    private static final String NOM_BDD = "quizz.db";
    static final String TABLE_QUESTION = "table_question";
    static final String TABLE_REPONSE = "table_reponse";
    static final String TABLE_LIEU = "table_lieu";
    static final String TABLE_PLAN = "table_plan";

    static final String COL_ID = "_id";
    static final int NUM_COL_ID = 0;
    static final String COL_TEXT_Q = "TXT_Q";
    static final int NUM_COL_TEXT_Q = 1;
    static final String COL_TEXT_R = "TXT_R";
    static final int NUM_COL_TEXT_R = 2;
    static final String COL_REP_V = "REP_V";
    static final int NUM_COL_REP_V = 3;
    static final String COL_LIEU_LIBELLE = "lieu_libelle";
    static final int NUM_LIEU_LIBELLE = 4;
    static final String COL_LIB_PLAN = "LIB_PLAN";
    static final int NUM_COL_LIB_PLAN = 5;

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
        values.put(COL_TEXT_Q, uneQuestion.getText_question());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_QUESTION, null, values);
    }

    public long insererReponse (Reponse uneReponse){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_TEXT_R, uneReponse.getText_rep());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_REPONSE, null, values);
    }

    public long insererLieu (Lieu unLieu){
        Log.d(TAG, "récupération du lieu dans insererLieu : " + unLieu);
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_LIEU_LIBELLE, unLieu.getLib_Lieu());
        Log.d(TAG, "values : " + values.toString());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_LIEU, null, values);
    }

    public long insererPlan (Plan unPlan){
        //Création d'un ContentValues (fonctionne comme une HashMap)
        ContentValues values = new ContentValues();
        //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne où on veut mettre la valeur)
        values.put(COL_LIB_PLAN, unPlan.getUrl_photo());
        //on insère l'objet dans la BDD via le ContentValues
        return db.insert(TABLE_PLAN, null, values);
    }


/*
    private Article cursorToArticle(Cursor c){ //Cette méthode permet de convertir un cursor en un article
        //si aucun élément n'a été retourné dans la requête, on renvoie null
        if (c.getCount() == 0)
            return null;
        //Sinon
        c.moveToFirst();   //on se place sur le premier élément
        Article unArticle = new Article(null,null,null,null);  //On créé un article
        //on lui affecte toutes les infos grâce aux infos contenues dans le Cursor
        unArticle.setReference(c.getString(NUM_COL_REF));
        unArticle.setDesignation(c.getString(NUM_COL_DES));
        unArticle.setPrixUnitHT(c.getString(NUM_COL_PU));
        unArticle.setQuantite(c.getString(NUM_COL_QTE));
        c.close();     //On ferme le cursor
        return unArticle;  //On retourne l'article
    }


    public Article getArticleWithDesignation(String designation){
        //Récupère dans un Cursor les valeurs correspondant à un article grâce à sa designation)
        Cursor c = db.query(TABLE_ARTICLES, new String[] {COL_ID,COL_REF, COL_DES, COL_PU, COL_QTE}, COL_DES + " LIKE \"" + designation +"\"", null, null, null, null);
        return cursorToArticle(c);
    }

    public int updateArticle(String ref, Article unArticle){
        //La mise à jour d'un article dans la BDD fonctionne plus ou moins comme une insertion
        //il faut simple préciser quel article on doit mettre à jour grâce à sa référence
        ContentValues values = new ContentValues();
        values.put(COL_DES, unArticle.getDesignation());
        values.put(COL_PU, unArticle.getPrixUnitHT());
        values.put(COL_QTE, unArticle.getQuantite());
        return db.update(TABLE_ARTICLES, values, COL_REF + " = \"" +ref+"\"", null);
    }
    public int removeArticleWithRef(String ref){
        //Suppression d'un article de la BDD grâce à sa référence
        return db.delete(TABLE_ARTICLES, COL_REF + " = \"" +ref+"\"", null);
    }
*/
    public Cursor getDataLieu(){
        return db.rawQuery("SELECT * FROM TABLE_LIEU", null);
    }


}
