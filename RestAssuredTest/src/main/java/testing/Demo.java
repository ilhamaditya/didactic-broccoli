package testing;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.restassured.http.ContentType;

public class Demo {

	public static void main(String[] args) throws InterruptedException{
		System.setProperty("webdriver.chrome.driver", "/Users/muksidini/SeleniumDrivers/chromedriver");
		WebDriver driver = new ChromeDriver();
		driver.get("https://en.wikipedia.org/wiki/SpaceX");
		WebElement x1 = driver.findElement(By.cssSelector("[title^='Elon Musk']"));
		String name1 = x1.getText();
		System.out.println("CEO of SpaceX stated by Wikipedia" +name1);
		driver.manage().window().maximize();
//		Thread.sleep(3000);
//		driver.navigate().to("https://api.spacex.land/graphql/");	    
//		driver.manage().window().maximize();
		
		driver.close();
	}
	
	

}
