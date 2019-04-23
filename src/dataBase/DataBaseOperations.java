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
    public List<String> printTables() {
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
    public boolean createTable() {
        String[] dataTypes = new String [] {"BOOL", "CHAR", "VARCHAR", "TEXT", "SMALLINT", "INT", "SERIAL", "float", "DATE",
                "TIME", "TIMESTAMP", "INTERVAL", "UUID", "Array", "JSON", "hstore"};
        if (this.connection != null) {
            Scanner userInput = new Scanner(System.in);
            System.out.println("In order to create table please enter table Name and required fields with their types");
            System.out.println("Please select type from that list:");
            for (int i = 0; i < dataTypes.length; i++) {
                System.out.print(dataTypes[i] + " ");
            }
            System.out.println("");
            System.out.print("Please enter TABLE name: ");
            String tableName = userInput.nextLine();
            String statementString = "CREATE TABLE " + tableName + " (";
            System.out.print("How many columns do you want: ");
            int columnQtty = userInput.nextInt();
            userInput.nextLine();
            System.out.println("Table with " + columnQtty + " columns will be created");
            String[] columns = new String[columnQtty];
            String[] columnsTypes = new String[columnQtty];
            for (int i = 0; i < columnQtty; i++) {
                System.out.print("Please enter column number " + (i + 1) + " name: ");
                columns[i] = userInput.nextLine();
                System.out.println("You entered name: " + columns[i]);
                statementString += columns[i] + " ";
                while (true) {
                    System.out.print("Please enter column number " + (i + 1) + " type: ");
                    columnsTypes[i] = userInput.nextLine();
                    if (Arrays.stream(dataTypes).noneMatch(columnsTypes[i]::equals)) {
                        System.out.println("This type of data is not supported, please re Enter!");
                    } else if (columnsTypes[i].equals("float")) {
                        System.out.println("Plese enter floating point: ");
                        String fp = userInput.nextLine();
                        columnsTypes[i] += "(" + fp + ")";
                        if (i != columnQtty-1) {
                            statementString += columnsTypes[i] + ", ";
                            break;
                        } else {
                            statementString += columnsTypes[i] + ")";
                            break;
                        }
                    }
                    else {
                        if (i != columnQtty-1) {
                        statementString += columnsTypes[i] + ", ";
                        break;
                        } else {
                            statementString += columnsTypes[i] + ")";
                            break;
                        }
                    }
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
    public boolean findTable(String tableName) {
        if (connection != null) {
            try {
                Statement statement = connection.createStatement();
                ResultSet result = statement.executeQuery("SELECT  * from " + tableName);
                ResultSetMetaData rsmd = result.getMetaData();
                int columnNumber = rsmd.getColumnCount();
                while (result.next()){
                    for (int i = 1; i <= columnNumber ; i++) {
                        System.out.print(rsmd.getColumnName(i) + "  ");
                    }
                    System.out.println();
                    for (int i = 1; i <= columnNumber; i++) {
                        System.out.print(result.getString(i) + "  ");
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return true;
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
            return  true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

}
