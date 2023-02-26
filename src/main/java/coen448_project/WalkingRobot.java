package coen448_project;
public class WalkingRobot {

	private int curX, curY = 0;
	private int maxX, maxY;
	private direction curDirection = direction.NORTH;
	private penPosition curPenPosition = penPosition.UP;
	
	// constructor
	public WalkingRobot(int maxX, int maxY) {
		this.maxX = maxX;
		this.maxY = maxY;
	}
	
	
	// getter setters
	public int getCurX() {
		return curX;
	}
	public void setCurX(int curX) throws Exception {
		if (curX >= this.maxX) {
			throw new Exception("curX cannot be greater than maxX");
		}
		this.curX = curX;
	}
	public int getCurY() {
		return curY;
	}
	public void setCurY(int curY) throws Exception {
		if (curY >= this.maxY) {
			throw new Exception("curY cannot be greater than maxY");
		}
		this.curY = curY;
	}	
	public int getMaxX() {
		return maxX;
	}
	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}
	public int getMaxY() {
		return maxY;
	}
	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	public direction getCurDirection() {
		return curDirection;
	}
	public void setCurDirection(direction curDirection) {
		this.curDirection = curDirection;
	}
	public penPosition getCurPenPosition() {
		return curPenPosition;
	}
	public void setCurPenPosition(penPosition curPenPosition) {
		this.curPenPosition = curPenPosition;
	}
	
	
}


