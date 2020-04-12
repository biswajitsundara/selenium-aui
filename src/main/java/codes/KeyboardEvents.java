package codes;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 * @author Biswajit
 * @date 12/04/2020
 * 
 */

public class KeyboardEvents 
{

	private WebDriver driver;
	
	public KeyboardEvents(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void sendKeyAction(WebElement element, String text)
	{
		Actions builder= new Actions(driver);
		builder.sendKeys(element, text).build().perform();
	}
	
	public void keyDownAction(WebElement element1)
	{
		Actions builder= new Actions(driver);
		builder.keyDown(element1,Keys.CONTROL).build().perform();
	}
	
	public void keyUpAction(WebElement element1)
	{
		Actions builder= new Actions(driver);
		builder.keyDown(element1, Keys.CONTROL)
		       .keyUp(Keys.CONTROL)
		       .build().perform();
	}
	
	
}
