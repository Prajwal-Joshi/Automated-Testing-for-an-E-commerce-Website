package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WishlistPage {
	private WebDriver driver;
	
	public WishlistPage(WebDriver driver) {
		this.driver=driver;
	}
	
	public void wishlistMenu() {
		driver.findElement(By.id("wishlist-total")).click();
	}
	
	public WebElement addedItem() {
		WebElement item = driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[2]/a"));
		return item;
	}
	
	public void cancelItemButton() {
		driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/table/tbody/tr/td[6]/a"));
	}
}
