package practice;

public class GenericMethoodPractice {

	public static void main(String[] args) {

		add(4, 6);
		System.out.println(add(4, 6));
		sub(10, 8);
		sub1(100,30);
		System.out.println(sub1(100,30));
		

		int sum = (add(10, 20));
		System.out.println(sum);
		int data = sum + 10;
		System.out.println(data);

	}

	public static int add(int a, int b) {
		int c = (a + b);
		return c;
	}

	public static void sub(int a, int b) {
		int c = a - b;
		System.out.println(c);
	}

	public static int sub1(int a, int b) {
		int c = b - a;
		return c;

	}

}
