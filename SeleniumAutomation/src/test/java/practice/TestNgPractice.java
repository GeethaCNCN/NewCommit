package practice;

import org.testng.annotations.Test;

public class TestNgPractice {

	 @Test
	public void abc() {
		System.out.println("abc");
	}

	@Test(invocationCount = 0)
	public void ABC() {
		System.out.println("ABC");
	}

	@Test(enabled = false)
	public void $abc_12() {
		System.out.println("abc_12");
	}

	@Test(priority = 3)
	public void hello() {
		System.out.println("Hello...");
	}
	
	@Test(dependsOnMethods = "abc")
	public void bye() {
		System.out.println("bye.....");
	}

}
