package com.vtiger.testscript;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import org.testng.Assert;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;
@Listeners(com.vtiger.genericLib.ListenersImplementation.class)
public class CreateFilterWithAdvFilter extends BaseClass {
	@Test
	public void create() throws IOException, Throwable
	{
		WebElement more = driver.findElement(By.linkText("More"));
		Actions act = new Actions(driver);
				act.moveToElement(more).perform();
				driver.findElement(By.name("Vendors")).click();
				String title = driver.findElement(By.linkText("Vendors")).getText();
				System.out.println(title);
				String f1 = d.fetchDataFromExcel("Sheet1", 4, 6);
				System.out.println(f1);
				Assert.assertEquals(title, f1);
				System.out.println("Vendor page validated");
				driver.findElement(By.linkText("Create Filter")).click();
				String create = driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
				System.out.println(create);
				String f2 = d.fetchDataFromExcel("Sheet1", 4, 6);
				System.out.println(f2);
				Assert.assertTrue(create.contains(f2));
				System.out.println("Create filter page validated");
				
				driver.findElement(By.className("detailedViewTextBox")).sendKeys(d.fetchDataFromExcel("Sheet1", 168, 5));
				driver.findElement(By.id("mi")).click();
				String text = driver.findElement(By.id("mi")).getText();
				System.out.println(text);
				String exp = d.fetchDataFromExcel("Sheet1", 170, 6);
				System.out.println(exp);
				Assert.assertTrue(text.contains(exp));
				System.out.println("Advanced search page validated");
				driver.findElement(By.cssSelector("input[value='New Group']")).click();
				WebElement Newgroup = driver.findElement(By.id("conditiongrouptable_2"));
				boolean flag = Newgroup.isDisplayed();
				Assert.assertTrue(flag);
				System.out.println("New group bar is displayed");
			
				driver.findElement(By.cssSelector("input[type='submit']")).click();
				Alert alt = driver.switchTo().alert();
				String Errmsg = alt.getText();
				
				System.out.println(Errmsg);
					alt.accept();
				String exp1= d.fetchDataFromExcel("Sheet1", 172, 6);
				System.out.println(exp1);
				/*if(Errmsg.equals(exp1))
					System.out.println("pass");
				else
					System.out.println("fail");
				driver.switchTo().alert().accept();*/
				
				//driver.switchTo().alert().accept();
				org.testng.Assert.assertTrue(exp1.contains(Errmsg));
				System.out.println("Error message validated");
			
				
				
				

	}
}
