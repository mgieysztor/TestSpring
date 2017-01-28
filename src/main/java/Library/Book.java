package Library;

/**
 * Created by RENT on 2017-01-28.
 */
public class Book {
    private String name;
    private String author;
    private String type;
    private int year;
    private String id;

    public Book() {
    }

    public Book(String name, String author, String type, int year, String id) {
        this.name = name;
        this.author = author;
        this.type = type;
        this.year = year;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Książka{" +
                "name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", type='" + type + '\'' +
                ", year=" + year +
                ", id='" + id + '\'' +
                '}';
    }
}
