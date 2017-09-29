package lecture;

public class OddArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] oddArray1 = new int[10];
		int[] oddArray2;

		for (int i = 0; i < oddArray1.length; i++) {
			oddArray1[i] = i * 2 + 1;
		} // fills array with first 10 odd numbers;

		oddArray2 = oddArray1; // points to the same address in memory
		oddArray1[4] = -999;
		
		for (int oddNum : oddArray1) { // only works for reading ENTIRE array
			System.out.print(oddNum + " ");
		}
		System.out.println();
		for (int oddNum : oddArray2) { // only works for reading ENTIRE array
			System.out.print(oddNum + " ");
		}
	}

}
