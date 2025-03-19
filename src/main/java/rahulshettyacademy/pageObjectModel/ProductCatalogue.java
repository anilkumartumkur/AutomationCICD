package rahulshettyacademy.pageObjectModel;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshetty.Abstractclass.AbstractComponent;

public class ProductCatalogue extends AbstractComponent{

	WebDriver driver;
	public ProductCatalogue(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(css=".mb-3")
	List<WebElement> products;
	//driver.findElement(By.xpath("(//button[contains(@routerlink,'dashboard')])[3]"));
	By byproduct=By.cssSelector(".mb-3");
	By addToCart=By.cssSelector(".card-body button:last-of-type");
	By toMessage=By.cssSelector(".toast-container");
	//driver.findElement(By.cssSelector(".ng-animating"));
	@FindBy(css=".ng-animating")
	WebElement Spinner;
	
	public List<WebElement> getProduct()
	{
		waitForElementtoAppear(byproduct);
		return products;
	}
	public  WebElement getProductByName(String productname)
	{
		WebElement data = getProduct().stream()
				.filter(s -> s.findElement(By.cssSelector("b")).getText().equalsIgnoreCase(productname)).findFirst()
				.orElse(null);
		return data;
}
	public void addProducttoCart(String productname)
	{
		getProductByName(productname).findElement(addToCart).click();
		waitForElementtoAppear(toMessage);
		waitForElementtodisppear(Spinner);
		
	}
	
}
