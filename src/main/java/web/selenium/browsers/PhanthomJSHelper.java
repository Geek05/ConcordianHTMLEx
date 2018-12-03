package web.selenium.browsers;

import java.io.File;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;

public class PhanthomJSHelper {
	
	static String PhanthomJSPath = null;
	
	static {
		PhanthomJSPath = System.getProperty("user.dir")+"/Externals/phantomjs.exe";
		System.setProperty("phantomjs.binary.path",PhanthomJSPath);
	}
	
	public static PhantomJSDriver GetPhanthomJSDriver() {
		PhantomJSDriverService driverService = new PhantomJSDriverService.Builder()
				.usingPhantomJSExecutable(new File(PhanthomJSPath))
				.withLogFile(new File(System.getProperty("user.dir")+"/Externals/Logs/phantomjsdriver.log"))
				.build();
		return new PhantomJSDriver(driverService , new DesiredCapabilities());
	}
		

	public static void phanthomJSExample() {
		File file = new File("D:\\Workspaces\\BharathMC_Workspace\\DemoProject\\Externals\\phantomjs.exe");				
        System.setProperty("phantomjs.binary.path", file.getAbsolutePath());		
        WebDriver driver = new PhantomJSDriver();	
        driver.get("http://www.google.com");         
        WebElement element = driver.findElement(By.name("q"));	
        element.sendKeys("Guru99");					
        element.submit();         			
        System.out.println("Page title is: " + driver.getTitle());		
        driver.quit();		
	}

}
