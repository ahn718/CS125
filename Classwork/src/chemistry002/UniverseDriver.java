package chemistry002;

public class UniverseDriver {

	public static void main(String[] args) {
		Atom atom1 = new Atom(7.0, 10.0, 5.4, -13.2);
		Atom atom2 = new Atom(8.0, 11.0, 6.2, -15);
		Simulation sim = new Simulation();

		atom1.equals(atom2); // or smashing(atom1, atom2);
		atom1.moving();
		sim.init(100);
		for (int i = 0; i < sim.atoms.length; i++) {
			System.out.println("Atom #" + (i+1) + ": " + sim.atoms[i].toString());;
		}
	}

	public static boolean smashing(Atom a1, Atom a2) {
		return a1.x == a2.x && a1.y == a2.y;		
	}

}
