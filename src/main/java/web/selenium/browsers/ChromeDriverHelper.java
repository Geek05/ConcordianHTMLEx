package web.selenium.browsers;

import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeDriverHelper {
	
	static {
		final String ChromeDriverPath = System.getProperty("user.dir")+"/Externals/chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
	}
	
	
	public static ChromeDriver GetChromeDriver() {
		return new ChromeDriver();
	}

}
