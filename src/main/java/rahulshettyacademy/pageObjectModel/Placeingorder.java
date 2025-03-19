package rahulshettyacademy.pageObjectModel;

import java.util.List;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Rahulshetty.Abstractclass.AbstractComponent;
public class Placeingorder extends AbstractComponent {

	WebDriver driver;

	public Placeingorder(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "(//input[@type='text'])[1]")
	WebElement cardnumber;
//	driver.findElement(By.xpath("(//input[@type='text'])[1]")).sendKeys("4542 9931 9292 2293");
	@FindBy(xpath = "(//input[@type='text'])[2]")
	WebElement CVV;
//	driver.findElement(By.xpath("(//input[@type='text'])[2]")).sendKeys("456");
	@FindBy(xpath = "(//input[@type='text'])[3]")
	WebElement BankName;
//	driver.findElement(By.xpath("(//input[@type='text'])[3]")).sendKeys("HDFC");
	@FindBy(xpath = "(//input[@type='text'])[5]")
	WebElement Email;
//	driver.findElement(By.xpath("(//input[@type='text'])[5]")).sendKeys("aniltc1999@gmail.com");

	@FindBy(xpath = "//input[@placeholder='Select Country']")
	WebElement country;
	// driver.findElement(By.xpath("//input[@placeholder='Select Country']")

	@FindBy(css = ".ta-item.list-group-item.ng-star-inserted:nth-child(3)")
	WebElement countryclick;
	// driver.findElement(By.cssSelector(".ta-item.list-group-item.ng-star-inserted:nth-child(3)")).click();
	@FindBy(css=".btnn.action__submit.ng-star-inserted")
	WebElement placeholder;
	//driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted"))
	

	By counrtytoappear = By.cssSelector(".ta-results.list-group.ng-star-inserted");

	public void addingdetails(String cardvalue, String cvvvalue, String bank, String emailID) {
		cardnumber.sendKeys(cardvalue);
		CVV.sendKeys(cvvvalue);
		BankName.sendKeys(bank);
		Email.sendKeys(emailID);
	}

	public void selectingCountry(String countrydata) {
		Actions a = new Actions(driver);
		a.sendKeys(country, countrydata).build().perform();
		waitForElementtoAppear(counrtytoappear);
		countryclick.click();	
	}
	public ConfirmationPage placeorder()
	{
		Actions a=new Actions(driver);
		a.moveToElement(placeholder).click().build().perform();
		ConfirmationPage conf=new ConfirmationPage(driver);
		return conf;
	}
	
	

}