package ua.com.maksym82.service;

import java.sql.SQLException;

public interface ServiceInterface {
    public Object commandsList();

    void connect(String databaseName, String userName, String password) throws SQLException;
}
