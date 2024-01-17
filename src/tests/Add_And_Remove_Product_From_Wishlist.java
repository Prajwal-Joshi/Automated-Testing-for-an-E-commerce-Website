package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.LoginPage;
import pages.SearchAndAddProductToCartPage;
import pages.WishlistPage;
import utils.BaseClass;

public class Add_And_Remove_Product_From_Wishlist extends BaseClass{
@Test
	public void addAndRemoveProductFromWishlist() throws Throwable  {
         webdriverutils.implicitwait(driver);
		
		LoginPage loginpage= new LoginPage(driver);
		
	    SearchAndAddProductToCartPage searchaddprodcart= new SearchAndAddProductToCartPage(driver);
	    WishlistPage whishlist=new WishlistPage(driver);

		//Step 1: Login to the application
		loginpage.clickOnMyAccount();
		
		loginpage.selectLogin();
		
		loginpage.enterUserName(fileutils.readDataFromProprtyFile("username"));
		
		loginpage.enterPassword(fileutils.readDataFromProprtyFile("password"));
		
		loginpage.clickLoginButton();
		
		// Step 2:search for product

		searchaddprodcart.typeProductName("phone");
		
				
		webdriverutils.scrollToTop(driver);
		
		//Step 3: Click on searched product
		
		searchaddprodcart.clickOnItem();
		
		//step4:click on add to wishlist for the particular product
		
		searchaddprodcart.addtoWishlist();
		
		// Step 5: Click on wishlist from the Top Menu
		
		whishlist.wishlistMenu();
		
		// verify the added product
		
		Assert.assertTrue(whishlist.addedItem().isDisplayed(), "Product is Succesfully added to wishlist");
		
		// Step 6: Click on cancel button to remove the product
		whishlist.cancelItemButton();
		
		// Verify the product is removed
		
		Assert.assertTrue(whishlist.addedItem().isDisplayed(), "Product is Succesfully removed from wishlist");

		// Step 7: Logout
		
		loginpage.clickOnMyAccount();
		
		loginpage.clickOnLogout();
		
	}
}
