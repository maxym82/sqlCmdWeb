package dataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public interface DataBaseInterface {

    boolean isDBexist(String dbName) throws SQLException;

    String getDataBaseName();

    boolean createDB() throws SQLException;

    boolean connectToDataBase(String dataBaseName, String username, String password) throws SQLException;

    List<String> listTables() throws SQLException;

    boolean clearTable(String tableName) throws SQLException;

    boolean dropTable(String tableName) throws SQLException;

    boolean isConnected ();


    boolean createTable(String tableName, ArrayList<String> columns) throws SQLException;

    ArrayList<ArrayList<String>> findTable(String tableName) throws SQLException;

    boolean insertROW() throws SQLException;

    boolean updateValue() throws SQLException;

    boolean deleteValue() throws SQLException;

    void help() throws SQLException;

    boolean closeConnection() throws SQLException;

}
