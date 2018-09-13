package nail.lynxmsk.test.models;

import com.google.gson.annotations.SerializedName;

public class Articles {

    @SerializedName("title")
    private String title;

    @SerializedName("coefficient")
    private String coefficient;

    @SerializedName("time")
    private String time;


    @SerializedName("place")
    private String place;

    @SerializedName("preview")
    private String preview;

    @SerializedName("article")
    private String article;

    public Articles(String title, String coefficient, String time, String place, String preview, String article ){
        this.title = title;
        this.coefficient = coefficient;
        this.time = time;
        this.place = place;
        this.preview = preview;
        this.article = article;
    }

    public String getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(String coefficient) {
        this.coefficient = coefficient;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getArticle() {
        return article;
    }

    public void setArticle(String article) {
        this.article = article;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
