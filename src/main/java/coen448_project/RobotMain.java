package coen448_project;
import java.util.Scanner;

public class RobotMain {

	public static void main(String[] args) {
		Boolean running  = true;
		Scanner s = new Scanner(System.in);
		int n;
		char c;
		String input;
		System.out.print("Input Size of Room: ");
		n = s.nextInt();
		Room RobotRoom = new Room(n);
		do {
			System.out.print("Input a Command: ");
			input = s.next();
			c = input.charAt(0);
			switch(c) {
				case('u'):
				case('U'):
					RobotRoom.penUp();
					break;
				case('d'):
				case('D'):
					RobotRoom.penDown();
					break;
				case('r'):
				case('R'):
					RobotRoom.turnRight();
					break;
				case('l'):
				case('L'):
					RobotRoom.turnLeft();
					break;
				case('m'):
				case('M'):
					try {
						if (input.length() > 1)
							n = Character.getNumericValue(input.charAt(1));
						else
							n = s.nextInt();
						RobotRoom.moveS(n);
					} catch(Exception e) {
						System.out.println("!!!Goes out of bounds!!!");
					}
					break;
				case('p'):
				case('P'):
					System.out.println(RobotRoom.printRoom());
					break;
				case('c'):
				case('C'):
					System.out.println(RobotRoom.printCurrentPosition());
					break;
				case('q'):
				case('Q'):
					running = RobotRoom.stop();
					break;
				case('i'):
				case('I'):
					try {
						if (input.length() > 1) n = Character.getNumericValue(input.charAt(1));
						else n = s.nextInt();
						RobotRoom.initialize(n);
					} catch(Exception e) {
						System.out.println("!!!Goes out of bounds!!!");
					}
					break;
				default:
					System.out.println("Invalid command.");
			}
		} while(running);
	}
}
