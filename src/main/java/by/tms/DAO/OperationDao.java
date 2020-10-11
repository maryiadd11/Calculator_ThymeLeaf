package by.tms.DAO;

import by.tms.entity.Operation;

import java.util.List;


public interface OperationDao {

    void createOperation(Operation operation);
    Operation getOperationById(long id);
    List<Operation> showAll();
    boolean containsOperationById(long id);
}
