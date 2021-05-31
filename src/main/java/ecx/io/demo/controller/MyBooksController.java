package ecx.io.demo.controller;

import ecx.io.demo.domain.catalog.Book;
import ecx.io.demo.utility.Database;
import ecx.io.demo.domain.catalog.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MyBooksController {

    @GetMapping("/myBooks")
    public ModelAndView myBooks(@RequestParam("bookID") String bookID, @RequestParam("userID") Long userID, @RequestParam("return") boolean returning) {
        ModelAndView mv = new ModelAndView();

        User user = null;
        if (returning) {
            Book returningBook = Database.getBookByID(bookID);
            user = Database.getUserByID(userID);

            assert returningBook != null;
            returningBook.setOwner(null);
            assert user != null;
            user.getBooksBorrowed().remove(returningBook);
        } else {
            Book borrowedBook = Database.getBookByID(bookID);
            user = Database.getUserByID(userID);

            assert borrowedBook != null;
            if (borrowedBook.getOwner() == null) {
                borrowedBook.setOwner(user);
                assert user != null;
                user.getBooksBorrowed().add(borrowedBook);
            } else {
                mv.addObject("books", Database.getCatalog().getBook());
                mv.setViewName("catalog");
                return mv;
            }
        }

        mv.setViewName("myBooks");
        mv.addObject("user", user);

        return mv;
    }
}
