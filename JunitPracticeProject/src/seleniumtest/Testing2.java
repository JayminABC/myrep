package seleniumtest;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.rules.ErrorCollector;
import org.testng.Assert;

public class Testing2 {
	
	ErrorCollector err = new ErrorCollector();
	

	@Test
	public void test4() {
		String expectedmsg = "Jaymin";
		String actualmsg = "Jaymin";
		System.out.println("before assertion");
		Assert.assertEquals(expectedmsg, actualmsg);
		System.out.println("after assertion");
	}
	
	@Test
	public void test5() {
		System.out.println("test 5");
		System.out.println("before assertion");
		try {
			Assert.assertTrue(4<2, "errormsg");
		}catch(Throwable t) {
			err.addError(t);
			System.out.println("i am in first catch");
		}
		System.out.println("after assertion");	
	}
}
