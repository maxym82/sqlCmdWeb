package dataBase;

import java.util.List;

public interface DataBaseInterface {

    boolean isDBexist(String dbName);

    String getDataBaseName();

    boolean createDB();

    boolean connectToDataBase(String dataBaseName, String username, String password);

    List<String> printTables();

    boolean clearTable(String tableName);

    boolean dropTable();

    boolean isConnected ();


    boolean createTable();

    boolean findTable(String tableName);

    boolean insertROW();

    boolean updateValue();

    boolean deleteValue();

    void help();

    boolean closeConnection();

}
