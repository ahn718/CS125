package chemistry002;

public class Simulation {

	public Atom[] atoms;
	
	public void init(int nAtoms) {
		atoms = new Atom[nAtoms];
		//-5.0, +5.0 x
		//-1.0, 13 y
		
		for(int i = 0; i < nAtoms; i++) {
			atoms[i] = new Atom(0, 0, 0, 0);
			atoms[i].x = -5.0 + Math.random() * 10; //-5 to 5
			atoms[i].y = -1.0 + Math.random() * 14; //-1 to 13
		}
	}
	
}
