package joliverie.example.quizzprojet.metier;

public class Plan {
    protected int id_plan;
    protected String url_photo;
    protected int id_lieu;

    public Plan( String url_photo, int id_lieu){
        this.url_photo = url_photo;
        this.id_lieu = id_lieu;
    }

    public int getId_plan() {
        return id_plan;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }

    public int getId_lieu() { return id_lieu; }

    public void setId_lieu(int id_lieu) { this.id_lieu = id_lieu; }
}
