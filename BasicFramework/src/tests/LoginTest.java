package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import data.DataFile;
import pages.LoginPage;
import utilities.Xls_Reader;
public class LoginTest {
	WebDriver driver;
	//LoginPage ip = new LoginPage();
	LoginPage ip = new LoginPage();
	DataFile df = new DataFile();
	
	
  @Test
      public void loginWithwrongEmailPasswordTest() throws InterruptedException {
	 ip.login(df.incorrectEmail, df.incorrectpassword);
	  
	 Assert.assertEquals(ip.readglobalerr(), df.globalerr);
	  //ip.login(incorrectEmail,incorrectpassword);
		//Assert.assertEquals(ip.readglobalerr(),globalerr);
  }
  
  @Test
  public void loginWithInvalidEmailTest() throws InterruptedException {
	 		ip.login(df.invalidemail,df.incorrectpassword);
			
			Assert.assertEquals(ip.readerr(),df.emailspecialcharerr);	
  }
  
  @Test
  public void loginWithEmptyEmailTest() throws InterruptedException {
	 		ip.login("",df.incorrectpassword);
			
			Assert.assertEquals(ip.readerr(),df.emptyemailerr);	
  }
  
  @Test
  public void loginWithEmptyPasswordTest() throws InterruptedException {
	 		ip.login(df.incorrectEmail,"");
	 		
			Assert.assertEquals(ip.readerr(),df.emptypassworderr);
  }
  
  @BeforeMethod
  public void beforeMethod() throws IOException {
	  	ip.openbrowser();
		ip.openscotiabank();
  }
  
  @AfterMethod
  public void afterMethod() {
	  ip.closebrowser();
  }

}
