package mypackage.models;

public class Book {
    private int id;
    private String title;
    private float coast;

    public Book() {
    }

    public Book(int id, String title, float coast) {
        this.id = id;
        this.title = title;
        this.coast = coast;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public float getCoast() {
        return coast;
    }

    public void setCoast(float coast) {
        this.coast = coast;
    }
}
