package rahulshettyacademy.pageObjectModel;

import java.util.List;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshetty.Abstractclass.AbstractComponent;

public class CartPage extends AbstractComponent{

	WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css=".cartSection h3")
	List<WebElement> selectedelement;
	//driver.findElements(By.cssSelector(".cartSection h3"));
	@FindBy(xpath="(//button[@type='button'])[2]")
	WebElement checkout;
	//driver.findElement(By.xpath("(//button[@type='button'])[2]")).click();
	public boolean compareingselecteddata(String productname)
	{
		boolean x = selectedelement.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productname));
		return x;
	}
	public Placeingorder checkout()
	{
		checkout.click();
		Placeingorder po=new Placeingorder(driver);
		return po;
	}
	
}
