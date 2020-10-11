package by.tms.controller;

import by.tms.entity.AuthorizedUser;
import by.tms.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;


@Controller
@RequestMapping(path = "/home")
public class AuthorizationController {

    private final String USER_NOT_FOUND = "Wrong login or password";

    private UserService userService;

    public AuthorizationController (UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/auth")
    public ModelAndView authorization(ModelAndView modelAndView){
        modelAndView.addObject("authUser", new AuthorizedUser());
        modelAndView.setViewName("auth");
        return modelAndView;
    }

    @PostMapping(path = "/auth")
    public ModelAndView addAuthorization(@Valid AuthorizedUser user, BindingResult bindingResult, HttpSession httpSession, ModelAndView modelAndView) {
        if (bindingResult.hasErrors()) {
            modelAndView.setViewName("auth");
        } else {
            if (userService.containsUserByLogin(user.getLogin()) && userService.containsUserByPassword(user.getPassword())) {
                modelAndView.setViewName("redirect:/home/index");
                httpSession.setAttribute("authorized", user);
            } else {
                modelAndView.addObject("error", USER_NOT_FOUND);
                modelAndView.setViewName("auth");
            }
        }
        return modelAndView;
    }

}
