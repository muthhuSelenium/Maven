package com.vtiger.testscript;

import java.io.IOException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.objectRepo.CreateFilterPage;
import com.vtiger.objectRepo.Homepage;
import com.vtiger.objectRepo.VendorsPage;

public class CreateFilterWithEndDate extends BaseClass {
		@Test
		public void create() throws IOException, Throwable
		{
			Homepage hp = PageFactory.initElements(driver, Homepage.class);
			VendorsPage vp = PageFactory.initElements(driver, VendorsPage.class);
			CreateFilterPage cf = PageFactory.initElements(driver, CreateFilterPage.class);
			WebElement more = hp.getmoreBtn();
			Actions act = new Actions(driver);
					act.moveToElement(more).perform();
					hp.getVendorsBtn().click();
					String title = vp.getvendorPageTitle().getText();
					System.out.println(title);
					String f1 = d.fetchDataFromExcel("Sheet1", 4, 6);
					System.out.println(f1);
					org.testng.Assert.assertEquals(title, f1);
					System.out.println("Vendor page validated");
					
					vp.getcreateFilterBtn().click();
					String create = cf.getCreateFilterPageTitle().getText();
					System.out.println(create);
					String f2 = d.fetchDataFromExcel("Sheet1", 4, 6);
					System.out.println(f2);
					org.testng.Assert.assertTrue(create.contains(f2));
					System.out.println("Create filter page validated");
					/*if(create.contains("Vendors"))
					{
						System.out.println("Create Filter page is displayed");
					}
					else
					{
						System.out.println(" Create Filter not displayed");
					}*/
		cf.getVendorName().sendKeys(d.fetchDataFromExcel("Sheet1", 6,5 ));
		cf.getEndDateBox().sendKeys(d.fetchDataFromExcel("Sheet1",117 ,5 ));
		driver.findElement(By.cssSelector("input[type='submit']")).click();
		Alert alt = driver.switchTo().alert();
		
		String Errmsg = alt.getText();
		System.out.println(Errmsg);
		String exp = d.fetchDataFromExcel("Sheet1", 132, 6);
		Assert.assertTrue(Errmsg.contains(exp));
		System.out.println("Error message validated");
		/*if(Errmsg.contains(d.fetchDataFromExcel("Sheet1", 132, 6)))
			
		{
			System.out.println("Error Message displayed");
		}
		else
		{
			System.out.println("Error Message Not displayed");
		}
*/		driver.switchTo().alert().accept();

		}
}
