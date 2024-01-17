package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
private WebDriver driver;

public LoginPage(WebDriver driver) {
	this.driver=driver;
}

public void clickOnMyAccount() {
	driver.findElement(By.xpath("//a[@title=\"My Account\"]")).click();
}
public void selectLogin() {
	driver.findElement(By.linkText("Login")).click();
}
public void enterUserName(String username) {
	driver.findElement(By.id("input-email")).sendKeys(username);
}

public void enterPassword(String password) {
	driver.findElement(By.id("input-password")).sendKeys(password);
}
 
public void clickLoginButton() {
	driver.findElement(By.xpath("//input[@type=\"submit\"]")).click();

}

public void clickOnLogout() {
	driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")).click();
}

}
