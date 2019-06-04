package integration;

import controller.Main;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class integrationTest {


    private static testInputStream in;
    private static testOutputStream out;

    @BeforeClass
    public static void setup () {
        in = new testInputStream();
        out = new testOutputStream();

        System.setIn(in);
        System.setOut(new PrintStream(out));
    }

    @Test
    public void testExit () {
        //given
        in.addInput("exit");
        in.addInput("Y");
        //when
        Main.main(new String[0]);
        //then
        String outputPattern = "nullWelcome to sqlCmd.\n" +
                "For list of commands available type help.\n" +
                "For help on a particular command type command following by \"?\"\n" +
                "You are on an unconnected mode.\n" +
                "Type your commend here\n" +
                "sqlCmd_> You are about to close the progran, please confirm (Y/N): Programm successfully closed\n";

        assertEquals(outputPattern, out.getData());
    }

    @Test
    public void testHelp () {
        //given
        in.addInput("help");
        in.addInput("exit");
        in.addInput("Y");
        //when
        Main.main(new String[0]);
        //then
        String outputPattern = "nullWelcome to sqlCmd.\n" +
                "For list of commands available type help.\n" +
                "For help on a particular command type command following by \"?\"\n" +
                "You are on an unconnected mode.\n" +
                "Type your commend here\n" +
                "sqlCmd_> You are about to close the progran, please confirm (Y/N): Programm successfully closed\n" +
                "Welcome to sqlCmd.\n" +
                "For list of commands available type help.\n" +
                "For help on a particular command type command following by \"?\"\n" +
                "You are on an unconnected mode.\n" +
                "Type your commend here\n" +
                "sqlCmd_> On unconnected mode you can use following commands:\n" +
                "1. help. For help\n" +
                "2. connect. To connect to database\n" +
                "      Format: connect [database_name]\n" +
                "3. exit. To exit from the program\n" +
                "You are on an unconnected mode.\n" +
                "Type your commend here\n" +
                "sqlCmd_> You are about to close the progran, please confirm (Y/N): Programm successfully closed\n";

        assertEquals(outputPattern, out.getData());
    }

    @Test
    public void testClearWithoutConnect () {
        //given
        in.addInput("clear anyTable");
        in.addInput("exit");
        in.addInput("Y");
        //when
        Main.main(new String[0]);
        //then
        String outputPattern = "nullWelcome to sqlCmd.\n" +
                "For list of commands available type help.\n" +
                "For help on a particular command type command following by \"?\"\n" +
                "You are on an unconnected mode.\n" +
                "Type your commend here\n" +
                "sqlCmd_> This command is not supported on this mode, please type help for \"help\"\n" +
                "You are on an unconnected mode.\n" +
                "Type your commend here\n" +
                "sqlCmd_> You are about to close the progran, please confirm (Y/N): Programm successfully closed\n";

        assertEquals(outputPattern, out.getData());
    }


}
