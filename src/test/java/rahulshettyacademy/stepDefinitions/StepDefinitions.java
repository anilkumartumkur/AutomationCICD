package rahulshettyacademy.stepDefinitions;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageObjectModel.CartPage;
import rahulshettyacademy.pageObjectModel.ConfirmationPage;
import rahulshettyacademy.pageObjectModel.LandingPage;
import rahulshettyacademy.pageObjectModel.Placeingorder;
import rahulshettyacademy.pageObjectModel.ProductCatalogue;

public class StepDefinitions extends BaseTest{
	LandingPage laningpage=null;
	ProductCatalogue pc;
	List<WebElement> products=null;
	CartPage cp=null;
	ConfirmationPage conf=null;
	@Given("I landed on Ecommerce Page")
	public void I_landed_on_Ecommerce_Page() throws IOException
	{
		laningpage=lunchingapplication();
	}
	
	@Given("^Logged in with Username (.+) and password (.+)$")
	public void Logged_in_with_Username_and_password(String username,String password) {
		 pc=landingpage.Loginappliaction(username,password);
	}
	
	@When("^I add product (.+) from Cart$")
	public void I_add_product_from_Cart(String productname)
	{
		products = pc.getProduct();
		pc.addProducttoCart(productname);
	}
	@And("^Checkout (.+) and (.+) submit the order$")
	public void Checkout_and_submit_the_order(String produtname,String username)
	{
		cp= pc.gotoCart();
		boolean match = cp.compareingselecteddata(produtname);
		Assert.assertTrue(match);
		Placeingorder po = cp.checkout();
		po.addingdetails("4325 2568 5268 5896", "322", "HDFC",username);
		po.selectingCountry("India");
		 conf= po.placeorder();
	}
	@Then("{string} message is displayed output")
	public void message_is_displayed_output(String string)
	{
		String Endmessage = conf.sucessfull();
		Assert.assertTrue(Endmessage.equalsIgnoreCase(string));

	}
	@Then("{string} message is displayed")
	public void message_is_displayed(String string)
	{
		Assert.assertEquals(string,landingpage.getErrorMessage());

	}
	}
