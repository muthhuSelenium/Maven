package com.vtiger.genericLib;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverCommonLib {
	public void waitForElement(WebElement element)
	{
		WebDriverWait wait = new WebDriverWait(BaseClass.driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void MouseOverAction(WebElement element)
	{
		Actions act = new Actions (BaseClass.driver);
		act.moveToElement(element).perform();
	}
	public void alertAccept()
	{
		BaseClass.driver.switchTo().alert().accept();
	}
	public String getAlertText()
	{
		return BaseClass.driver.switchTo().alert().getText();

	}
	public void switchToFrame(WebElement element)
	{
		BaseClass.driver.switchTo().frame(element);
	}
	public void switchToDefaultFrame()
	{
		BaseClass.driver.switchTo().defaultContent();
	}
	public void selectItemFromList(WebElement element , String Itemname)
	{
		Select s = new Select(element);
		s.selectByVisibleText(Itemname);
	}
	
	
}
