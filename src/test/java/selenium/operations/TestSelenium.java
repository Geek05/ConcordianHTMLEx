package selenium.operations;

import org.concordion.api.ConcordionResources;
import org.concordion.integration.junit4.ConcordionRunner;
import org.demo.selenium.WebDriverService;
import org.demo.selenium.WebDriverService.BROWSER;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.selenium.pom.LoginPage;

@RunWith(ConcordionRunner.class)
@ConcordionResources( { "/concordion.css" , "/customstyles.*"})
public class TestSelenium {
	
	WebDriver driver = WebDriverService.getInstance(BROWSER.DRIVERLESS);

	class Result{
		public String status;
		public String welcomeMessage;
	}
	
	public Result webPageLogin(String userName , String password) {
		Result result = new Result();
		LoginPage loginPage = new LoginPage(driver);
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		loginPage.setCredentials(userName, password);
		loginPage.login();
		System.out.println("Page Title after login"+driver.getTitle());
		verifyLogin(userName, result);
		tearDown();		
		return result;		
	}

	private void verifyLogin(String userName, Result result) {
		if(getWelcomeMessage(result).equalsIgnoreCase("Welcome "+userName)) {
			result.status= "Success";
		}else {
			result.status = "failure";
		}	
	}

	private String getWelcomeMessage(Result result) {
		result.welcomeMessage = driver.findElement(By.id("welcome")).getText(); 
		return result.welcomeMessage; 
	}

	private void tearDown() {
		WebDriverService.deConstructDriver(driver);
	}
}
