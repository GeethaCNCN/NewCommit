package practice;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

public class RetryAnalyserPractice {

	@Test(retryAnalyzer = genericUtilities.RetryAnalyserImplementation.class)

	public void sample() {

		Assert.fail();
		Reporter.log("Hi", true);
		;

	}

}



/*Default suite
Total tests run: 4, Passes: 0, Failures: 1, Skips: 0, Retries: 3
Total tests run: 4 (retry count 3+ one real run)

*/

