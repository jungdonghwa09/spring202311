package exam04;

import java.io.Serializable;

public class Book implements Serializable {
    public static final long serialVersionUid=1L;
    private String titles;
    private String author;
    private String publisher;

    private String str;

    public Book(String titles, String author, String publisher) {
        this.titles = titles;
        this.author = author;
        this.publisher = publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "titles='" + titles + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                '}';
    }
}
