package practice;

public class GenericMethodPractice {

	public static void main(String[] args) {

		/*
		 * int a = 10; int b = 20; int c = (a + b); System.out.println(c);
		 */
		// Calling non-static methos
		/*
		 * GenericMethodPractice g=new GenericMethodPractice(); g.add();
		 */

		System.out.println(sub(10.2, 4.6));
		;
		System.out.println(add(10, 40));

	}

	public static int add(int a, int b) {

		/*
		 * int a = 40; int b = 70;
		 */
		int c = (a + b);
		return c;

		// System.out.println(c);

	}

	public static double sub(double a, double b) {
		/*
		 * int a = 40; int b = 70;
		 */
		double c = (b - a);
		return c;
		// System.out.println(c);
	}

}
