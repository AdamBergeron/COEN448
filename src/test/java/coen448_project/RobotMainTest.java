package coen448_project;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotMainTest {

    @Test
    @DisplayName("U|u")
    void main() {
        assertEquals("UP", penPosition.UP,"Is pen position up");
        assertEquals("DOWN", penPosition.DOWN,"Is pen position down");
    }
}