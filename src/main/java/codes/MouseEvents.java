package codes;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

/**
 * 
 * @author Biswajit
 * @date 12/04/2020
 * 
 */

public class MouseEvents 
{

	private WebDriver driver;
	
	public MouseEvents(WebDriver driver)
	{
		this.driver=driver;
	}
	
	
	public void mouseClick(WebElement element)
	{
		Actions builder= new Actions(driver);
		builder.click(element).build().perform();
	}
	
	public void mouseDoubleClick(WebElement element)
	{
		Actions builder= new Actions(driver);
		builder.doubleClick(element).build().perform();
	}
	
	public void mouseContextClick(WebElement element)
	{
		Actions builder= new Actions(driver);
		builder.contextClick(element).build().perform();
	}
	
	public void mouseClickAndHold(WebElement element)
	{
		Actions builder= new Actions(driver);
		builder.clickAndHold(element).build().perform();
	}
	
	public void mouseButtonRelease(WebElement element)
	{
		Actions builder= new Actions(driver);
		builder.release(element).build().perform();
	}
	
	public void mouseHover(WebElement element)
	{
		Actions builder= new Actions(driver);
		builder.moveToElement(element).build().perform();
	}
	
	public void mouseDragAndDrop(WebElement source, WebElement target)
	{
		Actions builder= new Actions(driver);
		builder.dragAndDrop(source, target).build().perform();
	}
	
	public void dragAndDropByCoord(WebElement element,int xaxis,int yaxis)
	{
		Actions builder= new Actions(driver);
		builder.dragAndDropBy(element, xaxis,yaxis).build().perform();
	}

	
}
