package contraller.command;

import controller.Command;
import controller.command.ConnectToDataBase;
import controller.command.CreateDB;
import dataBase.DataBaseInterface;
import dataBase.DataBaseOperations;
import org.junit.Test;

import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import view.InputOutput;
import view.View;

import java.sql.SQLException;
import java.util.ArrayList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestCreateDB {

    private View view = mock(InputOutput.class);

    private DataBaseInterface dataBase = new DataBaseOperations();
    private DataBaseInterface spyDataBase = Mockito.spy(dataBase);


    @Test
    public void testCreateDBIsExecutable() {
        //given
        Command command = new CreateDB(dataBase, view);

        //when
        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("make");
        boolean executable = command.isExecutable(userCommand);

        //then
        assertTrue(executable);
    }

    @Test
    public void testCreateDBIsNotExecutable() {
        //given
        Command command = new CreateDB(dataBase, view);

        //when
        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("make1");
        boolean executable = command.isExecutable(userCommand);

        //then
        assertFalse(executable);
    }



    @Test
    public void testCreateDBWrongFormat() {
        //given
        Command command = new CreateDB(dataBase, view);

        //when
        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("make");
        command.execute(userCommand);

        //then
        Mockito.verify(view).outputln("Command format is wrong... Pleae type 'help' for help");
    }

    @Test
    public void testCreateDB() throws SQLException {
        Command command = new CreateDB(dataBase, view);

        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("make");
        userCommand.add("newDB");

        when(spyDataBase.createDB("newDB")).thenReturn(true);

        command.execute(userCommand);

        Mockito.verify(view).outputln("Data Base 'newDB' has been created");

    }




    @Test
    public void testCreateDBException() throws SQLException {
        Command command = new CreateDB(spyDataBase, view);

        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("make");
        userCommand.add("newDataBase");


        when(spyDataBase.createDB(userCommand.get(1))).thenThrow(new SQLException("there is a problem ocure trying to create DataBase"));

        command.execute(userCommand);

        Mockito.verify(view).outputln("java.sql.SQLException: there is a problem ocure trying to create DataBase");
    }

}