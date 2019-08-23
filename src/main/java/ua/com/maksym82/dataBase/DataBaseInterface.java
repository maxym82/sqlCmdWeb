package ua.com.maksym82.dataBase;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface DataBaseInterface {

    boolean isDBexist(String dbName);

    String getDataBaseName();

    boolean connectToDataBase(String dataBaseName, String username, String password);

    List<String> listTables();

    boolean clearTable(String tableName);

    boolean dropTable(String tableName);

    boolean isConnected ();

    boolean createTable(String tableName, Map<String, Object> newTable);

    List<List<String>> findTable(String tableName, String condition);

    boolean insertROW(String tableName, Map<String, Object> newRow);

    List<List<String>> updateValue(String tableName, String condition, String newValue);

    List<List<String>> deleteValue(String tableName, String lookupValues);

    boolean closeConnection();

    boolean createDB(String dbName);

    boolean dropDB(String dbName);
}
