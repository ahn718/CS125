package lecture;

public class QuadraticSolver {
	
	final static double ERROR_VAL = -99999;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//This program will solve equations of the form
		//ax^2 + bx + c = 0 using the quadratic equation
		
		solve(1,2,1);
	}

	public static double solve(double a, double b, double c) {
		double result = 0;
		double determinant = b*b-4*a*c;
		if(a == 0) {
			System.out.println("DIVIDE BY ZERO");
			return ERROR_VAL;
		} if(determinant < 0) {
			System.out.println("IMAGINARY SOLUTION");
			return ERROR_VAL;
		}
		
		return result;
	}
	
}
