package sample;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
 * @date 12/04/2020
 *
 */

public class MultipleSelect 
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
		driver.get("https://jqueryui.com/selectable/");
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		System.out.println("The J Query site opened successfully");
	}

	@Test
	public void testMultipleSelect()
	{
		//Locate the web elements
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		WebElement item3 = driver.findElement(By.xpath("//li[text()='Item 3']"));
		WebElement item5 = driver.findElement(By.xpath("//li[text()='Item 5']"));

		//press the control key & click on items.
		Actions builder = new Actions(driver);
		builder.keyDown(Keys.CONTROL).click(item1)
		.click(item2)
		.click(item3)
		.click(item5)
		.keyUp(Keys.CONTROL)
		.build()
		.perform();
	}

	@AfterClass
	public void tearDown()
	{
		//driver.quit();
	}

}
