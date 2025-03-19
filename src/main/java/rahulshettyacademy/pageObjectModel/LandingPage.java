package rahulshettyacademy.pageObjectModel;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Rahulshetty.Abstractclass.AbstractComponent;

public class LandingPage extends AbstractComponent{

	WebDriver driver;
	public LandingPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	//WebElement username=driver.findElement(By.id("#userEmail"));
	@FindBy(id="userEmail")
	WebElement Useremail;
	@FindBy(id="userPassword")
	WebElement userPassword;
	@FindBy(id="login")
	WebElement login;
	@FindBy(css="[class*='flyInOut']")
	WebElement erroMessage;
	
	//div[@class='ng-tns-c4-33 ng-star-inserted ng-trigger ng-trigger-flyInOut
			// ngx-toastr toast-error ng-animating']
	
	public ProductCatalogue Loginappliaction(String email,String passowrd)
	{
		Useremail.sendKeys(email);
		userPassword.sendKeys(passowrd);
		login.click();
		ProductCatalogue pc=new ProductCatalogue(driver);
		return pc;
		
	}
	public void gotologin()
	{
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String getErrorMessage()
	{
		waitForWebElementtoAppear(erroMessage);
		//System.out.println(erroMessage.getText());
		return erroMessage.getText();
		
	}
	
}
