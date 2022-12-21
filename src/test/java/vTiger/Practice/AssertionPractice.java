package vTiger.Practice;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionPractice {
	
@Test
public void assertionPractice()
{
	SoftAssert sa = new SoftAssert();
	System.out.println("step 1");
	System.out.println("step 2");
	System.out.println("step 3");
	//Assert.assertEquals(false, true);
	System.out.println("step 4");
	sa.assertTrue(false);
	System.out.println("step 5");
	System.out.println("step 6");
	sa.assertAll();
}

}
