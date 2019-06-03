package integration;

import java.io.IOException;
import java.io.InputStream;

public class testInputStream extends InputStream {
    private String line;
    @Override
    public int read() throws IOException {
        if (this.line.length() == 0) {return -1;}
        char ch = this.line.charAt(0);
        this.line = this.line.substring(1);
        return (int) ch;
    }


    public void addInput (String line) {
        if (this.line == null) {
            this.line = line;
        } else {
            this.line = this.line + "\n" + line;
        }
    }

    public String toString () {
        return this.line;
    }
}
