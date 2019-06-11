package contraller.command;

import controller.Command;
import controller.command.ConnectToDataBase;
import dataBase.DataBaseInterface;
import dataBase.DataBaseOperations;
import org.junit.Test;

import static org.mockito.Mockito.*;

import org.mockito.Mockito;
import view.InputOutput;

import java.sql.SQLException;
import java.util.ArrayList;
import static junit.framework.TestCase.assertTrue;

public class TestConnectToDataBase {

    private InputOutput view = mock(InputOutput.class);

    private DataBaseInterface dataBase = new DataBaseOperations();
    private DataBaseInterface spyDataBase = Mockito.spy(dataBase);


    @Test
    public void testConnectIsExecutable() {
        //given
        Command command = new ConnectToDataBase(dataBase, view);

        //when
        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("connect");
        boolean executable = command.isExecutable(userCommand);

        //then
        assertTrue(executable);
    }



    @Test
    public void testConnectWrongFormat() {
        //given
        Command command = new ConnectToDataBase(dataBase, view);

        //when
        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("connect");
        command.execute(userCommand);

        //then
        Mockito.verify(view).outputln("Incorrect command format, please type \"help\" for help");
    }


    @Test (expected = SQLException.class)
    public void testConnectException() throws SQLException {
        Command command = new ConnectToDataBase(spyDataBase, view);

        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("connect");
        userCommand.add("table");
        userCommand.add("user");

        when(spyDataBase.connectToDataBase(userCommand.get(1), userCommand.get(2), "password")).thenReturn(true);

        command.execute(userCommand);

        Mockito.verify(view).outputln("");

    }

}
