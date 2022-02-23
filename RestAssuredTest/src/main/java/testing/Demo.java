package testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;

public class Demo {
	
	Demo demo;
	Query query;
	
	public static WebDriver driverC;
	public static WebElement x1;
	public static String name1;
	
	public static WebDriver driverF;
	public static WebElement x2;
	public static String name2;
	
	String newLine = System.getProperty("line.separator");

	public static void main(String[] args) throws InterruptedException{
//	public static void test() throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "/Users/muksidini/SeleniumDrivers/chromedriver");
		driverC = new ChromeDriver();
				
		driverC.get("https://en.wikipedia.org/wiki/SpaceX");
		x1 = driverC.findElement(By.cssSelector("[title^='Elon Musk']"));
		name1 = x1.getText();
		System.out.println("CEO of SpaceX stated by Wikipedia Chrome: " +name1);
		driverC.manage().window().maximize();
		
//		Thread.sleep(3000);
//		driver.navigate().to("https://api.spacex.land/graphql/");	    
//		driver.manage().window().maximize();
		driverC.close();
		
		
		
		System.setProperty("webdriver.gecko.driver", "/Users/muksidini/SeleniumDrivers/geckodriver");
		driverF = new FirefoxDriver();
		
		driverF.get("https://en.wikipedia.org/wiki/SpaceX");
		x2 = driverF.findElement(By.cssSelector("[title^='Elon Musk']"));
		name2 = x2.getText();
		System.out.println("CEO of SpaceX stated by Wikipedia Firefox: " +name2);
//		driverF.manage().window().maximize();
		driverF.close();
		
		
//		System.out.println("Chrome: " +name1+ ", Firefox: " +name2);
		Assert.assertEquals(name1, name2);
		
		
		
		Assert.assertEquals(name1,name2);
		
	}
	
	@Test
	public static void ceoNameFromWiki() throws InterruptedException {
		Demo.main(null);
	}
	
	@Test
	public static void ceoNameFromGraphql() throws InterruptedException {
		Query.isCEONameMatch();
	}

	
	
	@Test
	void checkCeoName() {
		System.out.println("chrome say: " +name1);
		System.out.println("firefox say: " +name2);
		System.out.println("graphQL say: " +Query.response.path("data.company.ceo").toString() +newLine);
		
	}
	
	@Test
	void checkCeoNameMatched() {
		Assert.assertEquals(name1,Query.response.path("data.company.ceo").toString());
		Assert.assertEquals(name2,Query.response.path("data.company.ceo").toString());
		
	}
	
	
}
