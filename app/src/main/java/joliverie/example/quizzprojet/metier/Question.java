package joliverie.example.quizzprojet.metier;

import java.util.ArrayList;

public class Question {
    protected int id_question;
    protected String text_question;
    protected int id_lieu;

    public Question(String text_question, int id_lieu) {
        this.text_question = text_question;
        this.id_lieu = id_lieu;
    }

    public int getId_question() {
        return id_question;
    }

    public String getText_question() {
        return text_question;
    }

    public void setText_question(String text_question) {
        this.text_question = text_question;
    }

    public int getId_lieu() { return id_lieu; }

    public void setId_lieu(int id_lieu) { this.id_lieu = id_lieu; }

}
