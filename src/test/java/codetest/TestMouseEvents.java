package codetest;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import codes.MouseEvents;

/**
 * 
 * @author Biswajit
 * @date 12/04/2020
 * 
 */

public class TestMouseEvents 
{

	private WebDriver driver;
	private MouseEvents mouseEvents;

	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Biswajit\\Documents\\lib\\drivers\\chromedriver.exe");
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		mouseEvents= new MouseEvents(driver);
	}


	public void pause()
	{
		try{
			Thread.sleep(3000);
		}
		catch(Exception e){

		}
	}

	//@Test
	public void testClick() 
	{
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_onclick");
		driver.switchTo().frame("iframeResult");
		WebElement ele = driver.findElement(By.xpath("//button[text()='Click me']"));
		mouseEvents.mouseClick(ele);
		pause();
	}


	//@Test
	public void testDoubleClick()
	{
		driver.get("https://www.w3schools.com/jquery/tryit.asp?filename=tryjquery_event_dblclick");
		driver.switchTo().frame("iframeResult");
		WebElement ele = driver.findElement(By.xpath("//p[text()='Double-click on this paragraph.']"));
		mouseEvents.mouseDoubleClick(ele);
		pause();
	}

	//@Test
	public void testContextClick()
	{
		driver.get("https://www.w3schools.com/jsref/tryit.asp?filename=tryjsref_oncontextmenu");
		driver.switchTo().frame("iframeResult");
		WebElement ele = driver.findElement(By.xpath("//p[contains(text(),'Right-click inside this box to see the context menu!')]"));
		mouseEvents.mouseContextClick(ele);
		pause();
	}

	//@Test
	public void testClickAndHold()
	{
		driver.get("https://www.kirupa.com/html5/press_and_hold.htm");
		JavascriptExecutor js= (JavascriptExecutor) driver;
		WebElement ele = driver.findElement(By.xpath("//div[@id='item']"));
		js.executeScript("arguments[0].scrollIntoView(true);",ele);
		mouseEvents.mouseClickAndHold(ele);
		pause();
	}

	//@Test
	public void testMouseHover()
	{
		driver.get("https://www.w3schools.com/howto/tryit.asp?filename=tryhow_css_js_dropdown_hover");
		WebElement ele = driver.findElement(By.xpath("//button[@class='dropbtn']"));
		mouseEvents.mouseHover(ele);
		pause();
	}

	//@Test
	public void testDragAndDrop()
	{
		driver.get("https://jqueryui.com/droppable/");
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);

		WebElement draggable = driver.findElement(By.id("draggable"));
		WebElement droppable = driver.findElement(By.id("droppable"));

		mouseEvents.mouseDragAndDrop(draggable, droppable);
		pause();
	}

	@Test
	public void testDragAndDropBy()
	{
		driver.get("https://jqueryui.com/draggable/");
		WebElement frame = driver.findElement(By.className("demo-frame"));
		driver.switchTo().frame(frame);

		WebElement element = driver.findElement(By.xpath("//p[text()='Drag me around']"));

		mouseEvents.dragAndDropByCoord(element, 100, 100);
		pause();
	}

	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
