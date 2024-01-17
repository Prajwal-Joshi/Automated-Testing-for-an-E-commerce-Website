package tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.google.common.base.Verify;

import pages.LoginPage;
import pages.SearchAndAddProductToCartPage;
import utils.BaseClass;

public class SearchAnd_AddingProductToCart extends BaseClass{
	@Test
public void searchAndAddingProductToTheCart() throws Throwable {
	webdriverutils.implicitwait(driver);
	LoginPage loginpage= new LoginPage(driver);
	
    SearchAndAddProductToCartPage searchaddprodcart= new SearchAndAddProductToCartPage(driver);
    
    //Step1: Login to the user account
	loginpage.clickOnMyAccount();
	
	loginpage.selectLogin();
	
	loginpage.enterUserName(fileutils.readDataFromProprtyFile("username"));
	
	loginpage.enterPassword(fileutils.readDataFromProprtyFile("password"));
	
	loginpage.clickLoginButton();
	
	//step2:enter the productname and search
	
	searchaddprodcart.typeProductName("phone");
	
	//Scroll the webpage
	
	webdriverutils.scrollToTop(driver);
	
	// Step3:click on displayed product
	
	searchaddprodcart.clickOnItem();
	
	//step4:click on add to cart
	
	searchaddprodcart.addtocart();
	Thread.sleep(3000);
	
	//step5:click on shoppingcart from top menu option
	searchaddprodcart.clickOnShoppingCart();
	Thread.sleep(3000);

	// step6:check for displayed product in the cart
	searchaddprodcart.checkproduct().isDisplayed();
	
	Verify.verify(true, null, searchaddprodcart.checkproduct().isDisplayed());
	
	//Logout
	loginpage.clickOnMyAccount();
	Thread.sleep(2000);
	loginpage.clickOnLogout();
	
	
}
}
