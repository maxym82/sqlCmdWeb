package ua.com.maksym82.service;

import ua.com.maksym82.dataBase.DataBaseInterface;
import ua.com.maksym82.dataBase.DataBaseOperations;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Service  implements ServiceInterface{


    @Override
    public Object commandsList() {
        return Arrays.asList("menu", "connect", "list_tables", "find", "help", "create_db", "create_table", "delete_value", "drop_table",
                "drop_db", "insert_row", "update_value", "close_connection");
    }

    @Override
    public DataBaseInterface connect(String databaseName, String userName, String password){
        DataBaseInterface dataBase = new DataBaseOperations();
        dataBase.connectToDataBase(databaseName, userName, password);
        return dataBase;
    }

    @Override
    public List<List<String>> find(DataBaseOperations dataBase, String tableName){
        return dataBase.findTable(tableName);
    }

    @Override
    public List<String> list(DataBaseOperations dataBase) {
        return dataBase.listTables();
    }

    public void closeConnection(DataBaseInterface dataBase) {
        dataBase.closeConnection();
    }

    @Override
    public  void createDb(DataBaseOperations dbManager, String dbName) {
        dbManager.createDB(dbName);
    }

    @Override
    public void dropDB(DataBaseOperations dbManager, String dbName) {
        dbManager.dropDB(dbName);
    }

    @Override
    public void createTable(DataBaseOperations dbManager, String tableName, Map<String, Object> table) {
        dbManager.createTable(tableName, table);
    }

    @Override
    public void deleteTable(DataBaseOperations dbManager, String tableName) {
        dbManager.dropTable(tableName);
    }
}
