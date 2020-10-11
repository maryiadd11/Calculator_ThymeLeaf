package by.tms.controller;

import by.tms.entity.Operation;
import by.tms.services.CalcService;
import by.tms.services.OperationService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping(path = "/home")
public class CalcController {

    private final CalcService calcService;
    private final OperationService operationService;

    public CalcController(CalcService calcService, OperationService operationService) {
        this.calcService = calcService;
        this.operationService = operationService;
    }

    @GetMapping(path = "/calc")
    public ModelAndView getPage(ModelAndView modelAndView){
        modelAndView.addObject("operation", new Operation());
        modelAndView.setViewName("calc");
        return modelAndView;
    }

    @PostMapping(path = "/calc")
    public ModelAndView calc(@Valid Operation operation, BindingResult bindingResult, ModelAndView modelAndView){
        if (bindingResult.hasErrors()){
            modelAndView.setViewName("calc");
        } else {
            calcService.calc(operation);
            modelAndView.addObject("result", "Result = " + operation.getResult());
            operationService.createOperation(operation);
            modelAndView.setViewName("calc");
        }
        return modelAndView;
    }

}
