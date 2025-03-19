package rahulshettyacademy.TestComponent;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import rahulshettyacademy.pageObjectModel.LandingPage;

public class BaseTest {
	public  WebDriver driver;
	public LandingPage landingpage;
	
	public  WebDriver intializer() throws IOException {
		Properties pro=new Properties();
		FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\rahulshettyacademy\\resourse\\GlobalData.properties");
		pro.load(fis);
	    String browsername= System.getProperty("browser")!=null ? System.getProperty("browser"): pro.getProperty("browser");
		//String browsername=pro.getProperty("browser");
		if(browsername.contains("chrome"))
		{
			ChromeOptions options=new ChromeOptions();
			if(browsername.contains("headless"))
			{
			options.addArguments("headless");
			}
			driver=new ChromeDriver(options);
			//it is set beause it is headless mood so that every element has to be visible for back end chrome engine to work
			driver.manage().window().setSize(new Dimension(1440,900));//full screen
		}
		else if(browsername.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else if(browsername.equalsIgnoreCase("edge"))
		{
			driver=new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	@BeforeMethod(alwaysRun =true)
	public LandingPage lunchingapplication() throws IOException
	{
		driver=intializer();
		landingpage=new LandingPage(driver);
		landingpage.gotologin();
		return landingpage;
		
	}
	@AfterMethod(alwaysRun =true)
	public void closewindow()
	{
		driver.close();
	}
	public List<HashMap<String, String>> getJsonDataintoMap(String Filepath) throws IOException
	{
		//json to string
String jsonContent=FileUtils.readFileToString(new File(Filepath),
		StandardCharsets.UTF_8);
	//to Cover the String to Map we have to add the dependeny called JackSon Databind
		ObjectMapper mapper=new ObjectMapper();
	List<HashMap<String,String>> data=mapper.readValue(jsonContent, new 
			TypeReference<List<HashMap<String, String>>>(){});
		return data;		
		
		
	}
	public String getScreenShot(String testCasename,WebDriver driver) throws IOException
	{
		TakesScreenshot screen=(TakesScreenshot)driver;
		File sourcse=screen.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(sourcse,new File(System.getProperty("user.dir")+"//reports//"+testCasename+".png"));
		return System.getProperty("user.dir")+"//reports//"+testCasename+".png";
	}
	
}
