package dataBase;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public interface DataBaseInterface {

    boolean isDBexist(String dbName);

    String getDataBaseName();

    boolean createDB();

    boolean connectToDataBase(String dataBaseName, String username, String password);

    List<String> listTables();

    boolean clearTable(String tableName);

    boolean dropTable();

    boolean isConnected ();


    boolean createTable(String tableName, ArrayList<String> columns);

    ArrayList<ArrayList<String>> findTable(String tableName);

    boolean insertROW();

    boolean updateValue();

    boolean deleteValue();

    void help();

    boolean closeConnection();

}
