package ecx.io.demo.controller;

import ecx.io.demo.domain.catalog.Book;
import ecx.io.demo.utility.Database;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class CatalogController {

    @GetMapping("catalog")
    public ModelAndView getCatalog(@RequestParam("user") String userID) {
        List<Book> books = Database.getCatalog().getBook();
        ModelAndView mv = new ModelAndView();

        mv.addObject("books", books);
        mv.addObject("userID", userID);
        mv.setViewName("catalog");

        return mv;
    }

    @PostMapping("catalog")
    public ModelAndView postCatalog(@RequestParam("filterBy") String filterBy, @RequestParam("searchText") String searchText, @RequestParam("available") String available) {
        ModelAndView mv = new ModelAndView();
        List<Book> filteredBooks = Database.filterBooks(filterBy, searchText, available);

        mv.addObject("books", filteredBooks);
        mv.setViewName("catalog");

        return mv;
    }
}
