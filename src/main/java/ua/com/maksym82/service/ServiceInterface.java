package ua.com.maksym82.service;

import ua.com.maksym82.dataBase.DataBaseInterface;
import ua.com.maksym82.dataBase.DataBaseOperations;

import java.sql.SQLException;
import java.util.List;

public interface ServiceInterface {
    public Object commandsList();

    DataBaseInterface connect(String databaseName, String userName, String password);
    List<List<String>> find(DataBaseOperations dataBase, String tableName);
}
