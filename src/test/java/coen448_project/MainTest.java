package coen448_project;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest {

    @Test
    public void testNoInitCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 0\nI 0\ni 5\nx\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);

        in = new ByteArrayInputStream("x\ni0\ni 5\nx\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }
    @Test
    public void testInitialize() {
        // Test valid input
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\ni5\nI5\nI 5\ni -1\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);

        // Test invalid input
        in = new ByteArrayInputStream("i foo\ni 5\ni5\nI5\nI 5\nQ\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testPenUp() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nu\nU\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testPenDown() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nd\nD\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testTurnRight() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nr\nR\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testTurnLeft() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nl\nL\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testMoveS() {
        // Test valid input
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nm 2\nM 2\nm 20\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);

        // Test invalid input
        in = new ByteArrayInputStream("i 5\nm foo\nm 2\nM2\nMfoo\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testPrintRoom() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\np\nP\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testPrintCurrentPosition() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nc\nC\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testReplayCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nh\nH\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testInvalidCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nx\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }


}