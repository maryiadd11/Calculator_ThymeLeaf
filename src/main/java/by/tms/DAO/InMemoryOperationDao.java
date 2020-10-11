package by.tms.DAO;

import by.tms.entity.Operation;
import by.tms.exceptions.NoOperationException;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryOperationDao implements OperationDao{

    private List<Operation> operations = new ArrayList<>();

    @Override
    public void createOperation(Operation operation) {
        operations.add(operation);
    }

    @Override
    public Operation getOperationById(long id) {
        for (Operation operation : operations){
            if (operation.getId() == id){
                return operation;
            }
        }
        throw new NoOperationException();
    }

    @Override
    public List<Operation> showAll() {
        return operations;
    }

    @Override
    public boolean containsOperationById(long id) {
        for (Operation operation : operations){
            if (operation.getId() == id)
                return true;
        }
        return false;
    }

}
