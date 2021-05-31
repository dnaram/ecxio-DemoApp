package ecx.io.demo.domain.catalog;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import lombok.Data;

@Data
public class Book {
    @JacksonXmlProperty(isAttribute = true)
    private String id;
    private String author;
    private String title;
    private String genre;
    private Double price;
    private String publish_date;
    private String description;

    private User owner;

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", author='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                ", price=" + price +
                ", publish_date='" + publish_date + '\'' +
                ", description='" + description + '\'' +
                ", userID='" + owner + '\'' +
                '}';
    }

    public boolean isAvailable() {
        return owner == null;
    }

    public User getOwner() {
        return owner;
    }

    public String getId() {
        return id;
    }

    public Long getUserID() {
        return owner==null ? null : owner.getUserID();
    }
}
