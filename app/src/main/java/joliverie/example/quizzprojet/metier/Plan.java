package joliverie.example.quizzprojet.metier;

public class Plan {
    protected int id_plan;
    protected String url_photo;

    public Plan(int id_plan, String url_photo) {
        this.id_plan = id_plan;
        this.url_photo = url_photo;
    }

    public int getId_plan() {
        return id_plan;
    }

    public void setId_plan(int id_plan) {
        this.id_plan = id_plan;
    }

    public String getUrl_photo() {
        return url_photo;
    }

    public void setUrl_photo(String url_photo) {
        this.url_photo = url_photo;
    }
}
