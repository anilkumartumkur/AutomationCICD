package rahulshettyacademy.TestComponent;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer{

	int c=0;
	int max=1;
	@Override
	public boolean retry(ITestResult result) {
		if(c<max)
		{
			c++;
			return true;
		}
			
		return false;
	}

}
