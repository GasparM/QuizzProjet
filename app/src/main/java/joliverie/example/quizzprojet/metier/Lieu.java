package joliverie.example.quizzprojet.metier;

import java.util.ArrayList;

public class Lieu {
    protected int id_lieu;
    protected String lib_lieu;
    protected int id_plan;

    public  Lieu (String lieu, int id_plan){
        this.lib_lieu=lieu;
        this.id_plan=id_plan;
    }

    public int getId_plan() { return id_plan; }

    public int getId_lieu() {
        return id_lieu;
    }

    public String getLib_Lieu() {
        return lib_lieu;
    }

    public void setLib_Lieu(String lieu) {
        this.lib_lieu = lieu;
    }

    public void setId_plan(int id_plan) { this.id_plan = id_plan;}

    @Override
    public String toString() {
        return "Lieu{" +
                "id_lieu=" + id_lieu +
                ", lieu='" + lib_lieu + '\'' +
                '}';
    }
}
