package joliverie.example.quizzprojet.metier;

public class Plan {
    protected int id_plan;
    protected String url_photo;

    public Plan( String url_photo) {
        this.url_photo = url_photo;
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
}
