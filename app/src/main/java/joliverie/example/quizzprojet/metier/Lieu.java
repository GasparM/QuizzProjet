package joliverie.example.quizzprojet.metier;

public class Lieu {
    protected int id_lieu;
    protected String lieu;

    public  Lieu (int id_lieu, String lieu){
        this.id_lieu=id_lieu;
        this.lieu=lieu;
    }

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
