package pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class LoginPage {

	WebDriver driver;
	
	public void openbrowser() throws IOException {
		//System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
		//driver = new FirefoxDriver();
		
		FileInputStream f = new FileInputStream("C:\\Testing\\prop.properties");
		Properties prop = new Properties();              // call data from properties file
		prop.load(f);
		
		String browser = prop.getProperty("browser") ; // This Value We'll read from data Files...excel,properties...
		if(browser.equals("Firefox")) {
			System.setProperty("webdriver.gecko.driver", "C:\\SeleniumJars\\geckodriver.exe");
			driver = new FirefoxDriver();	
		} else if (browser.equals("Chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\SeleniumJars\\chromedriver.exe");
			driver = new ChromeDriver();	
		} else {
			System.setProperty("webdriver.ie.driver", "C:\\SeleniumJars\\iedriver.exe");
			driver = new InternetExplorerDriver();	
		}
		
	}
	
	public void openscotiabank() {
		driver.get("https://auth.scotiaonline.scotiabank.com/online?oauth_key=aRNgZ6ohE5c&oauth_key_signature=eyJraWQiOiJrUFVqdlNhT25GWUVDakpjMmV1MXJvNGxnb2VFeXJJb2tCbU1oX3BiZXNVIiwidHlwIjoiSldUIiwiYWxnIjoiUlMyNTYifQ.eyJyZWZlcmVyIjoiaHR0cHM6XC9cL3d3dy5zY290aWFiYW5rLmNvbVwvIiwib2F1dGhfa2V5IjoiYVJOZ1o2b2hFNWMiLCJjb25zZW50X3JlcXVpcmVkIjpmYWxzZSwicmVkaXJlY3RfdXJpIjoiaHR0cHM6XC9cL3d3dy5zY290aWFvbmxpbmUuc2NvdGlhYmFuay5jb21cL29ubGluZVwvbGFuZGluZ1wvb2F1dGhsYW5kaW5nLmJucyIsImV4cCI6MTYyMDU3NDAzOCwiaWF0IjoxNjIwNTcyODM4LCJqdGkiOiJlODk1YWJiZi00OWRkLTRiNTQtODY4OS1hYjVlMmI0YzFjMjgiLCJjbGllbnRfaWQiOiI4ZWU5MGMzOS0xYzUyLTRmZjQtOGFlNi1hN2I1NGM1Mzk5MzMiLCJjbGllbnRfbWV0YWRhdGEiOnsiQ2hhbm5lbElEIjoiU09MIiwiQXBwbGljYXRpb25Db2RlIjoiSDcifSwiaXNzdWVyIjoiaHR0cHM6XC9cL3Bhc3Nwb3J0LnNjb3RpYWJhbmsuY29tIn0.LlRUimwxKMml2eG882huW_M00_rcTETt9WOneGO6F1rS0HcpFX-Kwyl96uGxLkc01uD0Ey1qAYYY-4_XMlAFkuVH1iAqWwBZXAyUguf4pkxu1Fju7PNcF6hKxbRhHe2PO39wag5NoBURbTrkKauOFSxaltHKD7K09GqEb-DzXvoXsZD-NFn7X_YSkz5QfG4dCN_eD9sbBn73YR2a3PvEVrQ90FP-7NRpXI-HBD9xw3X3YLpo6hENsfO8a7OidRYvhYXxOX4dIGsPENC1tYpdbZIPGsfEFT-kRM73nq-T8jwxAXQLz_XGfxjWA2aYnxJVPunnA_sNyoF0wm45RVXXiw&preferred_environment=");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
	}
	
	public void closebrowser() {
		driver.quit();
	}
	
	public void login(String email, String Password) throws InterruptedException {
		driver.findElement(By.id("usernameInput-input")).sendKeys(email);
		driver.findElement(By.name("password")).sendKeys(Password);
		driver.findElement(By.id("signIn")).click();
		
		Thread.sleep(2000);
	}
	
	
	public String readglobalerr() {
		String actualerr = driver.findElement(By.id("globalError")).getText();
		System.out.println(actualerr);
		return actualerr;
		
	}
	
	public String readerr() {
		String actualerr = driver.findElement(By.className("Error__text")).getText();
		System.out.println(actualerr);
		return actualerr;
	}
}
