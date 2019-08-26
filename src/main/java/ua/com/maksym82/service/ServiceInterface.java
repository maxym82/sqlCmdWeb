package ua.com.maksym82.service;

import ua.com.maksym82.dataBase.DataBaseInterface;
import ua.com.maksym82.dataBase.DataBaseOperations;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface ServiceInterface {
    public Object commandsList();

    DataBaseInterface connect(String databaseName, String userName, String password);

    List<List<String>> find(DataBaseOperations dataBase, String tableName);

    void closeConnection(DataBaseInterface dbManager);

    List<String> list(DataBaseOperations dbManager);

    void createDb(DataBaseOperations dbManager, String dbName);

    void dropDB(DataBaseOperations dbManager, String dbName);

    void createTable(DataBaseOperations dbManager, String tableName, Map<String, Object> table);

    void deleteTable(DataBaseOperations dbManager, String tableName);
}
