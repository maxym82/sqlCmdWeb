package ua.com.maksym82.service;

public interface ServiceInterface {
    public Object commandsList();

    void connect(String databaseName, String userName, String password);
}
