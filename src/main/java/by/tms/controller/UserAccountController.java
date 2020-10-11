package by.tms.controller;

import by.tms.services.OperationService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping (path = "/home")
public class UserAccountController {

    private OperationService operationService;

    public UserAccountController(OperationService operationService) {
        this.operationService = operationService;
    }


    @GetMapping(path = "/account")
    public ModelAndView account(ModelAndView modelAndView){
        modelAndView.addObject("operationsList", operationService.getAll());
        modelAndView.addObject("message", "Operations history is empty");
        modelAndView.setViewName("account");
        return modelAndView;
    }

}
