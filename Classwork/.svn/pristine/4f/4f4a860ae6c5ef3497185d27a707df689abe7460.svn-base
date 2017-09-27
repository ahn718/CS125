package labPractice;

public class lab02Maze {
	public static void main(String[] args) {

		while (isFinished() == false) {
			turnRight();
			while (canMove() == false) {
				turnLeft();
			}
			move();
		}

	}

	public static boolean isFinished() {
		return true;
	}

	public static void turnRight() {
	}

	public static void turnLeft() {
	}

	public static boolean canMove() {
		return true;
	}

	public static void move() {
	}

	public static void s1() {
		while (isFinished() == false) {
			if (canMove()) {
				move();
			} else {
				turnRight();
				if (canMove() == false) {
					turnLeft();
					turnLeft();
					if (canMove() == false) {
						turnLeft();
					}
				}
			}
		}
	}

	public static void randomCheck() {
		while (isFinished() == false) {
			int directionsAvailableCW = 0;
			int randomDirCW = 0;
			for (int i = 0; i < 4; i++) {
				if (canMove()) {
					directionsAvailableCW++;
					turnRight();
				}
				randomDirCW = (int) Math.random() * directionsAvailableCW;
				directionsAvailableCW = 0;
				for (int t = 0; t < randomDirCW; t++) {
					turnRight();
				}
			}
		}
	}
}
