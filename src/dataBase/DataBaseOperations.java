package dataBase;

import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class DataBaseOperations implements DataBaseInterface {
    private String dataBaseName;
    private String dbURL = "jdbc:postgresql://localhost:5432/";
    private Connection connection = null;
    private String username;
    private String password;

    public DataBaseOperations() {
//        this.dataBaseName = dataBaseName;
//        this.username = username;
//        this.password = password;
//        this.dbURL = this.dbURL + this.dataBaseName;
//        this.connectToDataBase(this.username, this.password);
    }

    @Override
    public boolean isDBexist(String dbName) {
        try{
            ResultSet listOfDb = null;
            if (this.connection != null) {
                listOfDb = connection.getMetaData().getCatalogs();
                while (listOfDb.next()) {
                    String nextDB = listOfDb.getString(1);
                    if(dbName.equals(nextDB)){
                        return true;
                    }
                }
            }
            else{
                System.out.println("unable to create database connection");
            }
            if( listOfDb != null){
                try{
                    listOfDb.close();
                }
                catch(SQLException ex){
                    System.out.println("something went wrong");
//                    ex.printStackTrace();
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String getDataBaseName() {
        return dataBaseName;
    }

    @Override
    public boolean createDB() {
//        todo: implement method to create DB
        return true;
    }

    @Override
    public boolean connectToDataBase(String dataBaseName, String username, String password) {
        this.dataBaseName = dataBaseName;
        this.username = username;
        this.password = password;
        String dbURL = this.dbURL + this.dataBaseName;
        try{
            ResultSet listOfDb = null;
            this.connection = DriverManager.getConnection(dbURL, this.username, this.password);
            if (connection != null) {
                return true;
            }
            else{
                System.out.println("unable to create database connection");
                return false;
            }
        } catch (SQLException e) {
            System.out.println("something went wrong, please check your database name, user name and password");
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public List<String> listTables() {
        List<String> listOfTables = new ArrayList<>();
        if (connection != null) {
            try {
                DatabaseMetaData md = connection.getMetaData();
                ResultSet rs = md.getTables(this.dataBaseName, null, "%", new String[]{"TABLE"});
                while (rs.next()) {
                    listOfTables.add(rs.getString(3));
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return listOfTables;
    }

    @Override
    public boolean clearTable(String tableName) {
        if (connection != null) {
            try {
                Statement stmt = connection.createStatement();
                // Use TRUNCATE
                String sql = "TRUNCATE my_table";
                // Execute deletion
                stmt.executeUpdate(sql);
                stmt.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }
        return false;
    }

    @Override
    public boolean dropTable() {
        if (connection != null) {
            Scanner userInput = new Scanner(System.in);
            System.out.print("Please enter table name to delete: ");
            String tableName = userInput.nextLine();
            String stringStatement = "DROP TABLE " + tableName;
            try {
                Statement statement = connection.createStatement();
                statement.execute(stringStatement);
                statement.close();
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        } else {return false;}
    }

    @Override
    public boolean isConnected () {
        if (connection != null) {
            return true;
        }
        return false;
    }


    @Override
    public boolean createTable(String tableName, ArrayList<String> columns) {
        if (this.connection != null) {
            String statementString = "CREATE TABLE public." + tableName + " (";
            for (int i = 0; i < columns.size() - 1; i++) {
             if (i != columns.size()-1) {
                 statementString = statementString + columns.get(i) + ", ";
             }else {
                 statementString = statementString + columns.get(i) + ")";
             }
            }
            try {
                Statement statement = this.connection.createStatement();
                System.out.println(statementString);
                statement.execute(statementString);
                statement.close();
                return true;
            }
            catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

        }
        else {return false;}
    }

    @Override
    public ArrayList<ArrayList<String>> findTable(String tableName) {
        ResultSet result = null;
        ArrayList<ArrayList<String>> resultTable = new ArrayList<ArrayList<String>>();
        ResultSetMetaData rsmd;
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                result = statement.executeQuery("SELECT  * from " + tableName);
                rsmd = result.getMetaData();
                int columnNumber = rsmd.getColumnCount();
                if (columnNumber == 0) {throw new SQLException("Table \" " + tableName + " \" does not exist");}
                ArrayList<String> row;
                ArrayList<String> header = new ArrayList();
                for (int i = 1; i <= columnNumber; i++) {
                    header.add(rsmd.getColumnName(i));
                }
                resultTable.add(header);
                while (result.next()) {
                    row = new ArrayList<>();
                    for (int i = 1; i <= columnNumber; i++) {
                        if (result.getString(i) != null) {
                            row.add(result.getString(i));
                        }
                    }
                    resultTable.add(row);
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return resultTable;
    }

    @Override
    public boolean insertROW() {
//        todo: this is to insert one row in a table
        return true;
    }

    @Override
    public boolean updateValue() {
//        todo: this is to update the vatue
        return true;
    }

    @Override
    public boolean deleteValue() {

        return true;
    }

    @Override
    public void help() {

    }

    @Override
    public boolean closeConnection() {
        try {
            connection.close();
            connection = null;
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
