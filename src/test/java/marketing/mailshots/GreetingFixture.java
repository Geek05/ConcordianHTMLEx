package marketing.mailshots;

import org.concordion.integration.junit4.ConcordionRunner;
import org.junit.runner.RunWith;

@RunWith(ConcordionRunner.class)
public class GreetingFixture {
	
	public String greet(String name) {
		String finalGreeting = "Hello "+name+"!";
		System.out.println(finalGreeting);
		return finalGreeting;
	}
	
	public String wellcome(String name) {
		String finalGreeting = "Wellcome "+name+"!";
		System.out.println(finalGreeting);
		return finalGreeting;
	}
}
