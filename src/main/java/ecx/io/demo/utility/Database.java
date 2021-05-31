package ecx.io.demo.utility;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import ecx.io.demo.domain.catalog.Book;
import ecx.io.demo.domain.catalog.Catalog;
import ecx.io.demo.domain.catalog.User;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Database {

    private static Catalog catalog;
    private static Set<User> users;
    private static Long userIDs = 1L;

    public static void load() throws XMLStreamException, IOException {
        loadBooks();
        loadUsers();
    }

    private static void loadBooks() throws XMLStreamException, IOException {
        InputStream xmlResource = Database.class.getClassLoader().getResourceAsStream("books.xml");
        XMLInputFactory xmlInputFactory = XMLInputFactory.newFactory();
        XMLStreamReader xmlStreamReader = xmlInputFactory.createXMLStreamReader(xmlResource);

        XmlMapper mapper = new XmlMapper();
        catalog = mapper.readValue(xmlStreamReader, Catalog.class);
    }

    public static long generateID() {
        return userIDs++;
    }

    private static void loadUsers() {
        users = new HashSet<>();
        User user1 = new User("john", "doe", "John", "Doe");
        User user2 = new User("dene", "penn", "Dene", "Penn");
        User user3 = new User("alice", "rowe", "Alice", "Rowe");
        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    public static Catalog getCatalog() {
        return catalog;
    }

    public static User successfulLogin(String username, String password) {
        for (var user : users) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }

        return null;
    }

    public static List<Book> filterBooks(String filterBy, String searchText, String available) {
        List<Book> filteredBooks = new ArrayList<>();
        boolean availableSet = available.equals("yes");

        for (var book : catalog.getBook()) {
            if (book.isAvailable() || !availableSet) {
                filteredBooks.add(book);
            }
        }

        switch(filterBy) {
            case "author":
                filteredBooks = filterByAuthor(searchText, filteredBooks);
                break;
            case "title":
                filteredBooks = filterByTitle(searchText, filteredBooks);
                break;
            case "description":
                filteredBooks = filterByDescription(searchText, filteredBooks);
                break;
            case "published_date":
                filteredBooks = filterByPublishedDate(searchText, filteredBooks);
                break;
            default:
                break;
        }

        return filteredBooks;
    }

    private static List<Book> filterByAuthor(String searchText, List<Book> books) {
        List<Book> filteredBooks = new ArrayList<>();
        for (var book : books) {
            if (book.getAuthor().toLowerCase().contains(searchText)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    private static List<Book> filterByTitle(String searchText, List<Book> books) {
        List<Book> filteredBooks = new ArrayList<>();
        for (var book : books) {
            if (book.getTitle().toLowerCase().contains(searchText)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    private static List<Book> filterByDescription(String searchText, List<Book> books) {
        List<Book> filteredBooks = new ArrayList<>();
        for (var book : books) {
            if (book.getDescription().toLowerCase().contains(searchText)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    private static List<Book> filterByPublishedDate(String searchText, List<Book> books) {
        List<Book> filteredBooks = new ArrayList<>();
        for (var book : books) {
            if (book.getPublish_date().toLowerCase().contains(searchText)) {
                filteredBooks.add(book);
            }
        }
        return filteredBooks;
    }

    public static Book getBookByID(String bookID) {
        for (var book : catalog.getBook()) {
            if (book.getId().equals(bookID)) {
                return book;
            }
        }

        return null;
    }

    public static User getUserByID(Long userID) {
        for (var user : users) {
            if (user.getUserID().equals(userID)) {
                return user;
            }
        }

        return null;
    }
}
