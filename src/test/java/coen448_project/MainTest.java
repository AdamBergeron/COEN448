package coen448_project;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class MainTest {

    @Test
    public void testNoInitCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nx\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }
    @Test
    public void testInitialize() {
        // Test valid input
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);

        // Test invalid input
        in = new ByteArrayInputStream("i foo\ni 5\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testPenUp() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nu\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testPenDown() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nd\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testTurnRight() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nr\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testTurnLeft() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nl\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testMoveS() {
        // Test valid input
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nm 2\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);

        // Test invalid input
        in = new ByteArrayInputStream("i 5\nm foo\nm 2\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testPrintRoom() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\np\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testPrintCurrentPosition() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nc\nq\n".getBytes());
        System.setIn(in);
        RobotMain.main(null);
    }

    @Test
    public void testReplayCommand() {
        ByteArrayInputStream in = new ByteArrayInputStream("i 5\nh\nq\n".getBytes());
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