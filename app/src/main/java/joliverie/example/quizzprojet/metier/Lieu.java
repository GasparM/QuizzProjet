package joliverie.example.quizzprojet.metier;

public class Lieu {
    protected int id_lieu;
    protected String lieu;

    public  Lieu (String lieu){
        this.lieu=lieu;
    }

    public int getId_lieu() {
        return id_lieu;
    }

    public String getLib_Lieu() {
        return lieu;
    }

    public void setLib_Lieu(String lieu) {
        this.lieu = lieu;
    }

    @Override
    public String toString() {
        return "Lieu{" +
                "id_lieu=" + id_lieu +
                ", lieu='" + lieu + '\'' +
                '}';
    }
}
