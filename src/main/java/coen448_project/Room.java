package coen448_project;

public class Room {
	private boolean[][] room;
	private WalkingRobot robot;
	
	public Room(int roomSize) {
		this.room = new boolean[roomSize][roomSize];
		this.robot = new WalkingRobot(roomSize, roomSize);
	}
	
	public void penUp() {
		this.robot.setCurPenPosition(penPosition.UP);
	}
	
	public void penDown() {
		this.robot.setCurPenPosition(penPosition.DOWN);
	}
	
	public void turnRight() {
		direction curDirection = robot.getCurDirection();
		if (curDirection == direction.NORTH) robot.setCurDirection(direction.EAST);
		else if (curDirection == direction.EAST) robot.setCurDirection(direction.SOUTH);
		else if (curDirection == direction.SOUTH) robot.setCurDirection(direction.WEST);
		else if (curDirection == direction.WEST) robot.setCurDirection(direction.NORTH);
	}
	
	public void turnLeft() {
		direction curDirection = robot.getCurDirection();
		if (curDirection == direction.NORTH) robot.setCurDirection(direction.WEST);
		else if (curDirection == direction.EAST) robot.setCurDirection(direction.NORTH);
		else if (curDirection == direction.SOUTH) robot.setCurDirection(direction.EAST);
		else if (curDirection == direction.WEST) robot.setCurDirection(direction.SOUTH);
		
	}
	
	public void moveS(int s) throws Exception {
		penPosition penPos = this.robot.getCurPenPosition();
		direction curDirection = this.robot.getCurDirection();

		int oldX = this.robot.getCurX();
		int oldY = this.robot.getCurY();

		switch(curDirection){
			case EAST:
				this.robot.setCurX(oldX+s);
				break;
			case WEST:
				this.robot.setCurX(oldX+-s);
				break;
			case NORTH:
				this.robot.setCurY(oldY+s);
				break;
			case SOUTH:
				this.robot.setCurY(oldY-s);
				break;
		}
		if(penPos == penPosition.DOWN){
			switch(curDirection) {
				case EAST:
					for (int i = oldX; i < robot.getCurX(); i++) room[oldY][i] = true;
					break;
				case WEST:
					for(int i=oldX; i>robot.getCurX(); i--) room[oldY][i] = true;
					break;
				case NORTH:
					for(int i=oldY; i<robot.getCurY(); i++) room[i][oldX] = true;
					break;
				case SOUTH:
					for(int i=oldY; i>robot.getCurY(); i--) room[i][oldX] = true;
					break;
			}
		}


	}
	public String printRoom() {
		int maxX = robot.getMaxX();
		int maxY = robot.getMaxY();
		StringBuilder roomString = new StringBuilder();

		for(int i=maxY-1; i >= 0; i--) {
			roomString.append(i+" ");
			for(int j=0; j < maxX; j++) {
				boolean penned = this.room[i][j];
				if (penned) roomString.append("* ");
				else roomString.append("  ");
			}
			roomString.append("\n"); // new line
		}

		roomString.append(" ");
		for(int k=0; k<maxX; k++) {
			roomString.append(" ");
			roomString.append(k);
		}

		roomString.append("\n"); // new line

		return roomString.toString();
	}

	public String printCurrentPosition() {
		return String.format(
				"Position: %d, %d - Pen: %s – Facing: %s",
				this.robot.getCurX(),
				this.robot.getCurY(),
				this.robot.getCurPenPosition(),
				this.robot.getCurDirection()
			);
	}
	
	public void stop() {
		// Might not be needed
	}
	
	public void initialize(int n) throws Exception {
		this.robot.setCurDirection(direction.NORTH);
		this.robot.setCurPenPosition(penPosition.UP);
		this.robot.setCurX(0);
		this.robot.setCurY(0);
		this.robot.setMaxX(n);
		this.robot.setMaxY(n);
		this.room = new boolean[n][n];
	}
}
