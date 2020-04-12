package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * 
 * @author Biswajit
 * @date 04/11/2020
 *
 */

public class FlipKart 
{

	private WebDriver driver;

	@BeforeClass
	public void setup()
	{
		//Instantiate WebDriver
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Biswajit\\Documents\\lib\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		//Launch the flipkart site & close the login popup
		driver.get("https://www.flipkart.com/");
		driver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		System.out.println("The flipkart site opened successfully");
	}

	@Test
	public void testFlipkart()
	{
		//Instantiate the action class
		Actions builder = new Actions(driver);

		//Locate the menu & sub menu item
		WebElement electronics = driver.findElement(By.xpath("//span[text()='Electronics']"));
		WebElement appleMenu = driver.findElement(By.xpath("//a[text()='Apple']"));

		//First hover on the fly out menu & then hover on sub menu & click
		builder.moveToElement(electronics)
		.click()
		.moveToElement(appleMenu)
		.click()
		.perform();
	}

	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}


}
