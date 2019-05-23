package dataBase;

import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;

import static org.junit.Assert.assertArrayEquals;

public class DataBaseOperationsTest {
    private DataBaseOperations operations;

    @Before
    public void setup() throws SQLException {
        operations = new DataBaseOperations();
        operations.connectToDataBase("maksym", "maksym", "password");
    }

    @Test
    public void isDBexistTest() throws SQLException {
    }

    @Test
    public void getDataBaseNameTest() {
    }

    @Test
    public void createDBTest() {
    }

    @Test
    public void connectToDataBaseTest() {
    }

    @Test
    public void listTablesTest() throws SQLException {
        String[] tableNames = operations.listTables().toArray(new String[0]);
        assertArrayEquals(new String[] {"albums", "songs"}, tableNames);
    }

    @Test
    public void clearTableTest() {
    }

    @Test
    public void dropTableTest() {
    }

    @Test
    public void isConnectedTest() {
    }

    @Test
    public void createTableTest() {
    }

    @Test
    public void findTableTest() {
    }

    @Test
    public void insertROWTest() {
    }

    @Test
    public void updateValueTest() {
    }

    @Test
    public void deleteValueTest() {
    }

    @Test
    public void closeConnectionTest() {
    }
}