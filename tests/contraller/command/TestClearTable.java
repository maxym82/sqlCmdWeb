package contraller.command;

import controller.Command;
import controller.command.ClearTable;
import dataBase.DataBaseInterface;
import dataBase.DataBaseOperations;
import org.junit.Test;

import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import view.View;

import java.sql.SQLException;
import java.util.ArrayList;
import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestClearTable {

    private View view = mock(View.class);

    private DataBaseInterface dataBase = new DataBaseOperations();
    private DataBaseInterface spyDataBase = Mockito.spy(dataBase);


    @Test
    public void testClearIsExecutable() {
        //given
        Command command = new ClearTable(dataBase, view);

        //when
        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("clear");
        boolean executable = command.isExecutable(userCommand);

        //then
        assertTrue(executable);
    }

    @Test
    public void testClearIsNotExecutable() {
        //given
        Command command = new ClearTable(dataBase, view);

        //when
        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("clear1");
        boolean executable = command.isExecutable(userCommand);

        //then
        assertFalse(executable);
    }

    @Test
    public void testClearWrongFormat() {
        //given
        Command command = new ClearTable(dataBase, view);

        //when
        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("clear");
        command.execute(userCommand);

        //then
        Mockito.verify(view).outputln("Incorrect format, please type \"help\" for help");
    }



    @Test
    public void testCleartTables() throws SQLException {
        Command command = new ClearTable(spyDataBase, view);

        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("clear");
        userCommand.add("table");


        when(spyDataBase.clearTable(userCommand.get(1))).thenReturn(true);


        command.execute(userCommand);

        Mockito.verify(view).outputln("Table \"table\" has been successfully cleaned!");
    }

    @Test
    public void testClearException() throws SQLException {
        Command command = new ClearTable(spyDataBase, view);

        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("clear");
        userCommand.add("table");

        when(spyDataBase.clearTable(userCommand.get(1))).thenThrow(new SQLException("there is a problem ocure trying to clear table"));

        command.execute(userCommand);

        Mockito.verify(view).outputln("there is a problem ocure trying to clear table");

    }

}
