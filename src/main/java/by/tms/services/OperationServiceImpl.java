package by.tms.services;

import by.tms.DAO.OperationDao;
import by.tms.entity.Operation;
import by.tms.exceptions.NoOperationException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationServiceImpl implements OperationService{

    private OperationDao operationDao;

    public OperationServiceImpl(OperationDao operationDao) {
        this.operationDao = operationDao;
    }


    @Override
    public void createOperation(Operation operation) {
        operationDao.createOperation(operation);
    }

    @Override
    public Operation getOperationById(long id) {
        if (operationDao.containsOperationById(id)) {
            return operationDao.getOperationById(id);
        }
        throw new NoOperationException();
    }

    @Override
    public List<Operation> getAll() {
        return operationDao.showAll();
    }

    @Override
    public boolean containsOperationById(long id) {
        if (operationDao.containsOperationById(id)) {
            return true;
        }
        return false;
    }

}
