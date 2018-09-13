package nail.lynxmsk.test.models;

public class Category {
    private String name;
    private String url_name;

    public Category(String name, String url_name) {
        this.name = name;
        this.url_name = url_name;
    }

    public String getUrl_name() {
        return url_name;
    }

    public void setUrl_name(String url_name) {
        this.url_name = url_name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
