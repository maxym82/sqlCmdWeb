package contraller.command;

import contraller.TestView;
import controller.Command;
import controller.command.CloseConnection;
import dataBase.DataBaseInterface;
import dataBase.DataBaseOperations;
import org.junit.Test;
import org.mockito.Mockito;
import view.View;

import java.sql.SQLException;
import java.util.ArrayList;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class TestClose {

    private View view = Mockito.mock(View.class);

    private DataBaseInterface dataBase = new DataBaseOperations();


    @Test
    public void testExit () {
        //given
        Command command = new CloseConnection(dataBase, view);

        //when
        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("close");
        boolean executable = command.isExecutable(userCommand);

        //then
        assertTrue(executable);
    }

    @Test
    public void testExitWrong () {
        //given
        Command command = new CloseConnection(dataBase, view);

        //when
        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("close1");
        boolean executable = command.isExecutable(userCommand);

        //then
        assertFalse(executable);
    }

    @Test (expected = SQLException.class)
    public void testExitRunBeforeConnect () {
        //given
        Command command = new CloseConnection(dataBase, view);

        //when

        ArrayList<String> userCommand = new ArrayList<>();
        userCommand.add("close");

        command.execute(userCommand);

        //then

    }

}
