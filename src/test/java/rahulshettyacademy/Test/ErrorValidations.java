package rahulshettyacademy.Test;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.sun.net.httpserver.Authenticator.Retry;

import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageObjectModel.CartPage;
import rahulshettyacademy.pageObjectModel.ConfirmationPage;
import rahulshettyacademy.pageObjectModel.LandingPage;
import rahulshettyacademy.pageObjectModel.Placeingorder;
import rahulshettyacademy.pageObjectModel.ProductCatalogue;

public class ErrorValidations extends BaseTest {

	@Test(groups = "ErrorValidation",retryAnalyzer = rahulshettyacademy.TestComponent.Retry.class)
	public void loginErroValidation() throws IOException {
		landingpage.Loginappliaction("aniltc1999@gmail.com","Kumar@11467");
		Assert.assertEquals("Incorrect  or password.",landingpage.getErrorMessage());

	}
	@Test
	public void productErrorValidation() throws IOException {
		String productname = "ZARA COAT 3";
	    ProductCatalogue pc =landingpage.Loginappliaction("aniltc1999@gmail.com", "Kumar@1146");
		List<WebElement> products = pc.getProduct();
		pc.addProducttoCart(productname);
		CartPage cp = pc.gotoCart();
		boolean match = cp.compareingselecteddata("ZARA COAT 33");
		Assert.assertFalse(match);
	}
}
