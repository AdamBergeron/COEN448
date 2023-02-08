package coen448_project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void penUp() {
        Room room = new Room(10);
        room.penUp();
        assertEquals( penPosition.UP, room.robot.getCurPenPosition());

    }

    @Test
    void penDown() {
        Room room = new Room(10);
        room.penDown();
        assertEquals( penPosition.DOWN, room.robot.getCurPenPosition());
    }

    @Test
    void turnRight() {
        Room room = new Room(10);
        room.robot.setCurDirection(direction.SOUTH);
        room.turnRight();
        assertEquals(direction.WEST, room.robot.getCurDirection());
        room.turnRight();
        assertEquals(direction.NORTH, room.robot.getCurDirection());
        room.turnRight();
        assertEquals(direction.EAST, room.robot.getCurDirection());
        room.turnRight();
        assertEquals(direction.SOUTH, room.robot.getCurDirection());
    }

    @Test
    void turnLeft() {
        Room room = new Room(10);
        room.robot.setCurDirection(direction.SOUTH);
        room.turnLeft();
        assertEquals(direction.EAST, room.robot.getCurDirection());
        room.turnLeft();
        assertEquals(direction.NORTH, room.robot.getCurDirection());
        room.turnLeft();
        assertEquals(direction.WEST, room.robot.getCurDirection());
        room.turnLeft();
        assertEquals(direction.SOUTH, room.robot.getCurDirection());
    }

    @Test
    void moveS() throws Exception {
        Room room = new Room(10);
        room.robot.setCurDirection(direction.NORTH);
        room.robot.setCurX(1);
        room.robot.setCurX(1);



    }

    @Test
    void printRoom() {
    }

    @Test
    void printCurrentPosition() {
    }

    @Test
    void stop() {
    }

    @Test
    void initialize() {
    }
}