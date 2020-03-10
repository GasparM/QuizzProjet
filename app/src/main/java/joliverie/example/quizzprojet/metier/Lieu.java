package joliverie.example.quizzprojet.metier;

import java.util.ArrayList;

public class Lieu {
    protected int id_lieu;
    protected String lieu;
    protected ArrayList<Question> lesQuestions;
    protected Lieu leLieu;

    public  Lieu (int id_lieu, String lieu){
        this.id_lieu=id_lieu;
        this.lieu=lieu;
    }

    public Lieu getLeLieu() { return leLieu; }

    public void setLeLieu(Lieu leLieu) { this.leLieu = leLieu; }

    public ArrayList<Question> getLesQuestions() {return lesQuestions;}

    public void setLesQuestions(ArrayList<Question> lesQuestions) {this.lesQuestions = lesQuestions;}

    public int getId_lieu() {
        return id_lieu;
    }

    public void setId_lieu(int id_lieu) {
        this.id_lieu = id_lieu;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

}
