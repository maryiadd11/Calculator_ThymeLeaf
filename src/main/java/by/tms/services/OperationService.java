package by.tms.services;

import by.tms.entity.Operation;

import java.util.List;


public interface OperationService {

    void createOperation (Operation operation);
    Operation getOperationById(long id);
    List<Operation> getAll();
    boolean containsOperationById(long id);
}
