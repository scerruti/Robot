
public class MainComponent {
	public static void main(String[] args) {
		Robot rob = new Robot();
		rob.setSpeed(3);
		rob.turn(-90);
		rob.move(500);
		rob.turn(180);
		rob.move(500);
	}
}