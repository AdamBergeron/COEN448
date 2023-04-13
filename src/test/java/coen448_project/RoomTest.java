package coen448_project;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RoomTest {

    @Test
    void penUpTest() {
        Room room = new Room(10);
        room.penUp();
        assertEquals( penPosition.UP, room.robot.getCurPenPosition());

    }

    @Test
    void penDownTest() {
        Room room = new Room(10);
        room.penDown();
        assertEquals( penPosition.DOWN, room.robot.getCurPenPosition());
    }

    @Test
    void turnRightTest() {
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
    void turnLeftTest() {
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
    void moveSTest() throws Exception {
        Room room = new Room(10);
        room.robot.setCurDirection(direction.NORTH);
        room.penDown();
        room.robot.setCurX(1);
        room.robot.setCurY(1);

        try{
            room.moveS(5);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(room.printRoom());

        for (int i = 1 ; i < 6 ; i++){
            assertTrue(room.room[i][1]);
        }
        assertEquals(direction.NORTH, room.robot.getCurDirection());
        assertEquals(1,room.robot.getCurX());
        assertEquals(6, room.robot.getCurY());

        room.penUp();
        room.robot.setCurDirection(direction.EAST);
        try{
            room.moveS(5);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }


        for (int i = 1 ; i < 6 ; i++){
            assertFalse(room.room[6][i]);
        }

        assertEquals(direction.EAST, room.robot.getCurDirection());
        assertEquals(6,room.robot.getCurX());
        assertEquals(6, room.robot.getCurY());
    }

    @Test
    void printRoomTest() {
        Room room = new Room(10);
        for (int i =0 ; i<10 ; i++){
            room.room[0][i] = true;
        }
        String finalRoom =  "9                     \n"+ "8                     \n"+ "7                     \n"+
                            "6                     \n"+ "5                     \n"+ "4                     \n"+
                            "3                     \n"+ "2                     \n"+ "1                     \n"+
                            "0 * * * * * * * * * * \n" + "  0 1 2 3 4 5 6 7 8 9\n";

        assertEquals(finalRoom, room.printRoom());
    }


    @Test
    void printCurrentPositionTest() throws Exception {
        Room room = new Room(10);
        try{
            room.robot.setCurX(0);
            room.robot.setCurY(0);
            room.penUp();
            room.robot.setCurDirection(direction.EAST);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        String expectedString = String.format(
                "Position: %d, %d - Pen: %s – Facing: %s",
                room.robot.getCurX(),
                room.robot.getCurY(),
                room.robot.getCurPenPosition(),
                room.robot.getCurDirection()
        );
        assertEquals(expectedString, room.printCurrentPosition());

    }
    @Test
    void initializeTest() throws Exception {
        Room room  = new Room(10);
        try {
            room.initialize(10);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        assertEquals(direction.NORTH, room.robot.getCurDirection());
        assertEquals(penPosition.UP,room.robot.getCurPenPosition());
        assertEquals(0, room.robot.getCurX());
        assertEquals(0, room.robot.getCurY());
        assertEquals(10, room.robot.getMaxX());
        assertEquals(10,room.robot.getMaxY());
    }

    @Test
    void stopTest(){
        Room room = new Room(10);
        Boolean running = room.stop();
        assertFalse(running);
    }

    @Test
    void replayTestNoError() throws Exception {
        Room room = new Room(10);
        String s = "";
        room.turnRight();
        room.turnLeft();
        room.penUp();
        room.penDown();
        room.moveS(4);
        room.printRoom();
        room.printCurrentPosition();
        s += "R | L | U | D | M 4 | P | C | H | ";
        String commands = room.replay();
        assertEquals(s, commands);
    }

    @Test
    void replayTestOutOfBounds(){
        Room room = new Room(10);
        String s = "";
        room.turnLeft();
        try {
            room.moveS(2);
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        String commands = room.replay();
        s += "L | M 2 | H | ";
        assertEquals(s, commands);
    }
}

