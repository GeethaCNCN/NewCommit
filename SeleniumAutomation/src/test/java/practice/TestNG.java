package practice;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNG {

	@Test()

	public void createCustomer() {
		Assert.fail();
		System.out.println("create");
	}

	@Test(invocationCount = 0)
	public void modifyCustomer() {
		System.out.println("modify");
	}

	@Test(dependsOnMethods = "createCustomer")
	public void deleteCustomer() {
		System.out.println("delete");
	}

}
