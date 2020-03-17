package joliverie.example.quizzprojet.metier;

import java.util.ArrayList;

public class Lieu {
    protected int id_lieu;
    protected String lib_lieu;


    public  Lieu (String lieu){
        this.lib_lieu=lieu;
    }

    public int getId_lieu() {
        return id_lieu;
    }

    public String getLib_Lieu() {
        return lib_lieu;
    }

    public void setLib_Lieu(String lieu) {
        this.lib_lieu = lieu;
    }


    @Override
    public String toString() {
        return "Lieu{" +
                "id_lieu=" + id_lieu +
                ", lieu='" + lib_lieu + '\'' +
                '}';
    }
}
