package rahulshettyacademy.Test;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;



public class StandaloneTest {
public static void main(String[] args) {
	String productname = "ZARA COAT 3";
	WebDriver driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
	driver.get("https://rahulshettyacademy.com/client");
	driver.findElement(By.id("userEmail")).sendKeys("aniltc1999@gmail.com");
	driver.findElement(By.id("userPassword")).sendKeys("Kumar@1146");
	driver.findElement(By.id("login")).click();
	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".card-body")));
	List<WebElement> elements = driver.findElements(By.cssSelector(".card-body"));
//	or
	// List<WebElement> elements=driver.findElements(By.cssSelector(".mb-3"));
	WebElement data = elements.stream()
			.filter(s -> s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productname)).findFirst()
			.orElse(null);
	data.findElement(By.cssSelector(".card-body button:last-of-type")).click();
	// data.findElement(By.xpath("//b/parent::h5/following-sibling::button[2]")).click();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".toast-container")));
	System.out.println(driver.findElement(By.cssSelector(".toast-container")).getText());
	wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.cssSelector(".ng-animating"))));
	driver.findElement(By.xpath("(//button[contains(@routerlink,'dashboard')])[3]")).click();
	List<WebElement> element1 = driver.findElements(By.cssSelector(".cartSection h3"));
	boolean x = element1.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productname));
	Assert.assertTrue(x);		
	driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("4542 9931 9292 2293");
	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("456");
	driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("HDFC");
	driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("aniltc1999@gmail.com");
//	driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("India");
//	List<WebElement> element2 = driver.findElements(By.xpath("//span[contains(text(),'India')]"));
//	List<WebElement> country = element2.stream().filter(s -> s.getText().trim().equalsIgnoreCase("India"))
//	.collect(Collectors.toList());
//	country.get(0).click();
	//using Action class
	Actions a=new Actions(driver);
	a.sendKeys(driver.findElement(By.xpath("//input[@placeholder='Select Country']")),"India").build().perform();
	wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results.list-group.ng-star-inserted")));
	driver.findElement(By.cssSelector(".ta-item.list-group-item.ng-star-inserted:nth-child(3)")).click();
	a.moveToElement(driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted"))).click().build().perform();
	String EndMessage=driver.findElement(By.cssSelector(".hero-primary")).getText();
	Assert.assertTrue(EndMessage.equalsIgnoreCase("Thankyou for the order."));
}
}
