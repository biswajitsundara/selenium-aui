package codetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import codes.KeyboardEvents;

/**
 * 
 * @author Biswajit
 * @date 12/04/2020
 * 
 */

public class TestKeyboardEvents 
{

	private WebDriver driver;
	private KeyboardEvents keyboardEvents;

	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Biswajit\\Documents\\lib\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		keyboardEvents= new KeyboardEvents(driver);
	}


	public void pause()
	{
		try
		{
			Thread.sleep(3000);
		}
		catch(Exception e)
		{

		}
	}

	
	//@Test
	public void testsendKeys() 
	{
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_event_key_key");
		driver.switchTo().frame("iframeResult");
		WebElement ele = driver.findElement(By.xpath("//input[@type='text']"));
		keyboardEvents.sendKeyAction(ele, "Biswajit");
		pause();
	}


	//@Test
	public void testKeyDown() 
	{
		driver.get("https://jqueryui.com/selectable/");
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		keyboardEvents.keyDownAction(item1);
		
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		item2.click();
		pause();
	}
	
	@Test
	public void testKeyUp() 
	{
		driver.get("https://jqueryui.com/selectable/");
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);
		WebElement item1 = driver.findElement(By.xpath("//li[text()='Item 1']"));
		keyboardEvents.keyUpAction(item1);
		
		WebElement item2 = driver.findElement(By.xpath("//li[text()='Item 2']"));
		item2.click();
		pause();
	}

}
