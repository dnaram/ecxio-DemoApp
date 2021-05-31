package ecx.io.demo.controller;

import ecx.io.demo.utility.Database;
import ecx.io.demo.domain.catalog.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @GetMapping("")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("home");
        return mv;
    }

    @PostMapping("")
    public ModelAndView loginHome(@RequestParam("uname") String username, @RequestParam("psw") String password) {
        ModelAndView mv = new ModelAndView();
        User user = Database.successfulLogin(username, password);

        if (user == null) {
            mv.setViewName("home");
            mv.addObject("message", "Password or username incorrect.");
        } else {
            mv.setViewName("myBooks");
            mv.addObject("user", user);
        }

        return mv;
    }
}
