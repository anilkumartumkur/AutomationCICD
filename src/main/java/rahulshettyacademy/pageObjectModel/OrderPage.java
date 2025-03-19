package rahulshettyacademy.pageObjectModel;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Rahulshetty.Abstractclass.AbstractComponent;

public class OrderPage extends AbstractComponent{

	WebDriver driver;
	public OrderPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	@FindBy(css="tr td:nth-child(3)")
	List<WebElement> ordernames;
	public boolean VerifyOrderHistorty(String productname)
	{
		boolean x = ordernames.stream().anyMatch(s -> s.getText().equalsIgnoreCase(productname));
		return x;
	}
	
}
