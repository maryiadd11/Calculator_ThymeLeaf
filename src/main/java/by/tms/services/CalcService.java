package by.tms.services;

import by.tms.entity.Operation;
import org.springframework.stereotype.Service;

@Service
public class CalcService {

    public Operation calc (Operation operation){
        switch (operation.getType()) {
            case "sum" :
                operation.setResult(operation.getNum1() + operation.getNum2());
                return operation;
            case "sub" :
                operation.setResult(operation.getNum1() - operation.getNum2());
                return operation;
            case "mult" :
                operation.setResult(operation.getNum1() * operation.getNum2());
                return operation;
            case "div" :
                operation.setResult(operation.getNum1() / operation.getNum2());
                return operation;
            default:
                throw new UnsupportedOperationException();
        }
    }

}
