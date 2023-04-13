package coen448_project;
import java.util.Scanner;

public class RobotMain {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		Room RobotRoom = new Room(1);
		int n;
		Character c;
		String input;
		do {
			System.out.print("Input a Command: ");
			input = s.next();
			c = input.charAt(0);
			if (c.equals('i') || c.equals('I')){
				try {
					if (input.length() > 1) n = Integer.parseInt(input.substring(1).strip());
					else n = s.nextInt();
					RobotRoom.initialize(n);
					break;
				} catch(Exception e) {
					System.out.println("!!!Invalid Init!!!");
					continue;
				}
			}
			System.out.println("Please init the room before inputing any commands.");
			continue;

		} while(true);

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
							n = Integer.parseInt(input.substring(1).strip());
						else
							n = s.nextInt();
						RobotRoom.moveS(n);
					} catch(Exception e) {
						System.out.println("!!!Goes out of bounds!!!");
						continue;
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
					break;
				case('i'):
				case('I'):
					try {
						if (input.length() > 1) n = Integer.parseInt(input.substring(1).strip());
						else n = s.nextInt();
						RobotRoom.initialize(n);
					} catch(Exception e) {
						System.out.println("!!!Invalid Init!!!");
						continue;
					}
					break;
				case('h'):
				case('H'):
					System.out.println(RobotRoom.replay());
					break;
				default:
					System.out.println("Invalid command.");
			}
		} while( c!='q' && c!='Q');
	}

}
