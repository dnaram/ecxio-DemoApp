package ecx.io.demo.domain.catalog;

import ecx.io.demo.utility.Database;

import java.util.ArrayList;
import java.util.List;

public class User {

    private Long userID;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private List<Book> booksBorrowed;

    public User(String username, String password, String firstName, String lastName) {
        this.userID = Database.generateID();
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
        this.booksBorrowed = new ArrayList<>();
    }

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooksBorrowed() {
        return booksBorrowed;
    }

    public void setBooksBorrowed(List<Book> booksBorrowed) {
        this.booksBorrowed = booksBorrowed;
    }
}
