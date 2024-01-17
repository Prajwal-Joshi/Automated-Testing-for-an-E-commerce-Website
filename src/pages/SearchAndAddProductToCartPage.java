package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class SearchAndAddProductToCartPage {
private WebDriver driver;

public SearchAndAddProductToCartPage(WebDriver driver) {
	this.driver=driver;
}


public void typeProductName(String productname) {
	WebElement searchbar = driver.findElement(By.xpath("//input[@type=\"text\"]"));
	searchbar.click();
	searchbar.sendKeys(productname,Keys.ENTER);
}
public void clickOnItem() {
	WebElement phone = driver.findElement(By.xpath("/html/body/div[2]/div/div/div[3]/div/div/div[1]/a/img"));
	phone.click();
	
}

public void addtoWishlist() {
	driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/div[2]/div[1]/button[1]")).click();
}

public void addtocart() {
	driver.findElement(By.id("button-cart")).click();
}

public void clickOnShoppingCart() {
	 WebElement shoppingcartmenu = driver.findElement(By.xpath("//a[@title=\"Shopping Cart\"]"));
	 shoppingcartmenu.click();
	
}
public WebElement checkproduct() {
	WebElement checkprod = driver.findElement(By.xpath("//*[@id=\"content\"]/form/div/table/tbody/tr[1]/td[2]"));
	return checkprod;
}

}
