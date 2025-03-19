package Rahulshetty.Abstractclass;

import java.time.Duration;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import rahulshettyacademy.pageObjectModel.CartPage;
import rahulshettyacademy.pageObjectModel.OrderPage;

public class AbstractComponent {
	WebDriver driver;

	public AbstractComponent(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath="(//button[contains(@routerlink,'dashboard')])[3]")
	WebElement cart;
	@FindBy(xpath="(//button[contains(@routerlink,'dashboard')])[2]")
	WebElement Order;
	
	//driver.findElement(By.xpath("(//button[contains(@routerlink,'dashboard')])[3]")).click();
public void waitForElementtoAppear(By fromproduct)
	
{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(fromproduct));
}
public void waitForWebElementtoAppear(WebElement element)

{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOf(element));
}

public void waitForElementtodisppear(WebElement element)

{
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.invisibilityOf(element));
}
public CartPage gotoCart()
{
	cart.click();
	CartPage cp=new CartPage(driver);
	return cp;
}
public OrderPage goToOrder()
{
	Order.click();
	OrderPage op=new OrderPage(driver);
	return op;
}
}
