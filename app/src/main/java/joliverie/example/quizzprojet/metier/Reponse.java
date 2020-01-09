package joliverie.example.quizzprojet.metier;

public class Reponse {
    protected int id_reponse;
    protected String text_rep;
    protected int valide;

    public Reponse(int id_reponse, String text_rep, int valide) {
        this.id_reponse = id_reponse;
        this.text_rep = text_rep;
        this.valide = valide;
    }

    public int getId_reponse() {
        return id_reponse;
    }

    public void setId_reponse(int id_reponse) {
        this.id_reponse = id_reponse;
    }

    public String getText_rep() {
        return text_rep;
    }

    public void setText_rep(String text_rep) {
        this.text_rep = text_rep;
    }

    public int getValide() {
        return valide;
    }

    public void setValide(int valide) {
        this.valide = valide;
    }
}
