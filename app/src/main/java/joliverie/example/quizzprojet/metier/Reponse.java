package joliverie.example.quizzprojet.metier;

public class Reponse {
    protected int id_reponse;
    protected String text_rep;
    protected int id_question;
    protected int valide;

    public Reponse(String text_rep, int valide) {
        this.text_rep = text_rep;
        this.valide = valide;
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public String getText_rep() {
        return text_rep;
    }

    public void setText_rep(String text_rep) {
        this.text_rep = text_rep;
    }

    public int getId_question() { return id_question; }

    public void setId_question(int id_question) { this.id_question = id_question; }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }
}
