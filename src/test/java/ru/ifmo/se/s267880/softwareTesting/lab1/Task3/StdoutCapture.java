package ru.ifmo.se.s267880.softwareTesting.lab1.Task3;

import static org.junit.Assert.*;
import org.junit.Before;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

public class StdoutCapture {
    private ByteArrayOutputStream baos = new ByteArrayOutputStream();
    private PrintStream ps = new PrintStream(baos);

    @Before
    public void clearStreamBeforeTest() {
        clearStream();
        System.setOut(ps);
    }

    public void clearStream() {
        ps.flush();
        baos.reset();
    }

    public String getCurrentStdout() {
        try {
            ps.flush();
            return baos.toString("UTF-8");
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

    public String getCurrentStdoutThenReset() {
        String res = getCurrentStdout();
        clearStream();
        return res;
    }

    public void assertCurrentStdout(String content) {
        assertEquals(content, getCurrentStdout());
    }

    public void assertCurrentStdoutThenReset(String content) {
        assertEquals(content, getCurrentStdoutThenReset());
    }
}
