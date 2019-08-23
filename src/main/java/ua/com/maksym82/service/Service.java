package ua.com.maksym82.service;

import ua.com.maksym82.dataBase.DataBaseInterface;
import ua.com.maksym82.dataBase.DataBaseOperations;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Service  implements ServiceInterface{


    @Override
    public Object commandsList() {
        return Arrays.asList("menu", "connect", "find", "help", "create_db", "create_table", "delete_value", "drop_table",
                "drop_db", "insert_row", "list_tables", "update_value", "close_connection");
    }

    @Override
    public DataBaseInterface connect(String databaseName, String userName, String password){
        DataBaseInterface dataBase = new DataBaseOperations();
        dataBase.connectToDataBase(databaseName, userName, password);
        return dataBase;
    }

    public List<List<String>> find(DataBaseOperations dataBase, String tableName){
        return dataBase.findTable(tableName);
    }

    public void closeConnection(DataBaseInterface dataBase) {
        dataBase.closeConnection();
    }
}
