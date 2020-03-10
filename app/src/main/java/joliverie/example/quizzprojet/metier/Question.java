package joliverie.example.quizzprojet.metier;

import java.util.ArrayList;

public class Question {
    protected int id_question;
    protected int text_question;
    protected int difficulte;
    protected ArrayList<Reponse> lesReponses;

    public Question(int id_question, int text_question, int difficulte, ArrayList<Reponse> lesReponses) {
        this.id_question = id_question;
        this.text_question = text_question;
        this.difficulte = difficulte;
        this.lesReponses = lesReponses;
    }

    public ArrayList<Reponse> getLesReponses() {return lesReponses;}

    public void setLesReponses(ArrayList<Reponse> lesReponses) {this.lesReponses = lesReponses;}

    public int getId_question() {
        return id_question;
    }

    public void setId_question(int id_question) {
        this.id_question = id_question;
    }

    public int getText_question() {
        return text_question;
    }

    public void setText_question(int text_question) {
        this.text_question = text_question;
    }

    public int getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(int difficulte) {
        this.difficulte = difficulte;
    }
}
