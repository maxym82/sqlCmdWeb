package ua.com.maksym82.service;

import ua.com.maksym82.dataBase.DataBaseInterface;
import ua.com.maksym82.dataBase.DataBaseOperations;

import java.lang.reflect.Array;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Service  implements ServiceInterface{

    private DataBaseInterface dataBase;

    public Service () {
        dataBase = new DataBaseOperations();
    }

    @Override
    public Object commandsList() {
        return Arrays.asList("help", "menu", "connect", "find");
    }

    @Override
    public void connect(String databaseName, String userName, String password) throws SQLException {
        dataBase.connectToDataBase(databaseName, userName, password);
    }
}
