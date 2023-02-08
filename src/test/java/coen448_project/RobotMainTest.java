package coen448_project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotMainTest {

    @Test
    void PenUpShouldSetPenPostionUp(){
        var penPosition = new Room(5);
        penPosition.penUp();
    }
}