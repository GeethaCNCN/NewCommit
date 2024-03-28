package practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	@Test
	public void Sample() {

		/*
		 * String s = "hello"; Reporter.log("Step 1", true); Reporter.log("Step 2",
		 * true); Reporter.log("Step 3", true);
		 * 
		 * // Assert.assertEquals(1, 0); // Assert.assertTrue(s.contains("e")); //
		 * Assert.assertTrue(s.contains("gg"), "Fail"); //
		 * Assert.assertTrue(s.equalsIgnoreCase("mello"), "Pass");
		 * //Assert.assertTrue(s.isBlank(), "Fail");; //
		 * Assert.assertTrue(s.matches("hello"), "Pass"); //
		 * Assert.assertTrue(s.matches("hel"), "Fail");;
		 * Assert.assertTrue(s.startsWith("e"), "PASS"); Reporter.log("Step 4", true);
		 * Reporter.log("Step 5", true);
		 */

		SoftAssert ap = new SoftAssert();
		String s="Geetha";
		Reporter.log("Step 1", true);
		Reporter.log("Step 2", true);
		Reporter.log("Step 3", true);
		Reporter.log("Step 4", true);
		
		ap.assertTrue(s.contains("klm"), "Fail");
		ap.assertAll();
		
		
	
	
	}

}
