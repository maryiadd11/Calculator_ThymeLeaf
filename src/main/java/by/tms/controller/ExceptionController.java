package by.tms.controller;

import by.tms.exceptions.DuplicateUserException;
import by.tms.exceptions.NoUserException;
import by.tms.exceptions.WrongPasswordException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler(DuplicateUserException.class)
    public String userContains(Model model, DuplicateUserException ex){
        model.addAttribute("message", ex.getMessage());
        return "reg";
    }

    @ExceptionHandler(WrongPasswordException.class)
    public String wrongPassword(Model model, WrongPasswordException ex){
        model.addAttribute("message1", ex.getMessage());
        return "auth";
    }

    @ExceptionHandler(NoUserException.class)
    public String wrongLogin(Model model, NoUserException ex){
        model.addAttribute("message2", ex.getMessage());
        return "auth";
    }
}
