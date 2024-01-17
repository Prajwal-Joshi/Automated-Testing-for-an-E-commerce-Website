package tests;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.BaseClass;

public class LoginTest extends BaseClass{

	@Test
	public void loginToApplication() throws IOException, InterruptedException {
		
		webdriverutils.implicitwait(driver);
		
		LoginPage loginpage= new LoginPage(driver);
		//Step 1:Login with the valid user credentials
		
		//user is on Opencart Page
		
		//Click on my account from the top menu
		loginpage.clickOnMyAccount();
		
		//select Login and click on it
		loginpage.selectLogin();
		
		//Login page displayed
		
		//enter username
		loginpage.enterUserName(fileutils.readDataFromProprtyFile("username"));
		//enter password
		loginpage.enterPassword(fileutils.readDataFromProprtyFile("password"));
		//click on loginbutton
		loginpage.clickLoginButton();
		
		//Verifying registered user enters valid username and password.
		
		//Upon verification user should be redirected to Home page
		Thread.sleep(3000);
		
		//verifying Home page is displaying upon search bar
		driver.findElement(By.xpath("//input[@type=\"text\"]")).isDisplayed();
		
		//verifying Home page is displaying upon URL
		String currentUrl="https://naveenautomationlabs.com/opencart/index.php?route=account/account";
		assertEquals(currentUrl, driver.getCurrentUrl(), "Login Successful");
		
		//Click on my account from the top menu
		
		loginpage.clickOnMyAccount();
		
		//click on Logout option
		loginpage.clickOnLogout();
	
	}
}
