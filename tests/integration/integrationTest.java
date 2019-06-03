package integration;

import controller.Main;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.OutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertEquals;

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
        in.addInput("help");
        in.addInput("exit");
        in.addInput("Y");

        //when
        Main.main(new String[0]);


        //then

        //assertEquals("", out.getData());

    }
}
