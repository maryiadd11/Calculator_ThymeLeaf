package by.tms.controller;

import by.tms.entity.AuthorizedUser;
import by.tms.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping (path = "/home")
public class HomeController {

    @GetMapping(path = "/index")
    public ModelAndView homePage(ModelAndView modelAndView){
        modelAndView.setViewName("index");
        return modelAndView;
    }

}
