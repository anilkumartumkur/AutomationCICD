package rahulshettyacademy.Test;

import java.io.File;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import rahulshettyacademy.TestComponent.BaseTest;
import rahulshettyacademy.pageObjectModel.CartPage;
import rahulshettyacademy.pageObjectModel.ConfirmationPage;
import rahulshettyacademy.pageObjectModel.LandingPage;
import rahulshettyacademy.pageObjectModel.OrderPage;
import rahulshettyacademy.pageObjectModel.Placeingorder;
import rahulshettyacademy.pageObjectModel.ProductCatalogue;

public class SubmitOrderTest extends BaseTest{
	String productname = "ZARA COAT 3";
	@Test(dataProvider="getData",groups ={"Purchase"})
	public void Submiorder(HashMap<String,String> input) throws IOException {
	    ProductCatalogue pc =landingpage.Loginappliaction(input.get("email"),input.get("password"));
		List<WebElement> products = pc.getProduct();
		pc.addProducttoCart(input.get("product"));
		CartPage cp = pc.gotoCart();
		boolean match = cp.compareingselecteddata(input.get("product"));
		Assert.assertTrue(match);
		Placeingorder po = cp.checkout();
		po.addingdetails("4325 2568 5268 5896", "322", "HDFC",input.get("email"));
		po.selectingCountry("India");
		ConfirmationPage conf = po.placeorder();
		String Endmessage = conf.sucessfull();
		Assert.assertTrue(Endmessage.equalsIgnoreCase("Thankyou for the order."));
		System.out.println("SubmitOrderpage");
		
	}
	@Test(dependsOnMethods={"Submiorder"})
	public void orderHistoryTest()
	{
		  ProductCatalogue pc =landingpage.Loginappliaction("aniltc1999@gmail.com", "Kumar@1146");
		 OrderPage op= pc.goToOrder();
		 Assert.assertTrue(op.VerifyOrderHistorty(productname));
		
	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
		
		
		List<HashMap<String,String>> data=getJsonDataintoMap(System.getProperty("user.dir")+"\\src\\test\\java\\rahulshettyacademy\\Data\\PurchaseOrder.json");
		return new Object[][] {{data.get(0)},{data.get(1)}};
		
//		HashMap<String,String> map=new HashMap<String,String>();
//		map.put("email","aniltc1999@gmail.com");
//		map.put("password","Kumar@1146");
//		map.put("product","ZARA COAT 3");
//		
//		HashMap<String,String> map1=new HashMap<String,String>();
//		map1.put("email","aniltc1998@gmail.com");
//		map1.put("password","Kumar@1147");
//		map1.put("product","ADIDAS ORIGINAL");
		
	}
	
	
	
//	@DataProvider
//	public Object[][] getData()
//	{
//		return new Object[][] {{"aniltc1999@gmail.com","Kumar@1146","ZARA COAT 3"},
//			{"aniltc1998@gmail.com","Kumar@1147","ADIDAS ORIGINAL"}};
//	}
}
