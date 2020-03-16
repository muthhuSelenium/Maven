package com.vtiger.testscript;



import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import com.vtiger.genericLib.FileDataFrameWork;

public class CreateCampaign {
	public static void main(String[] args) throws Throwable {
		FileDataFrameWork d=new FileDataFrameWork();
		WebDriver driver=null;
		String browser = d.fetchDataFromProperty("browser");
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(browser.equals("firefox"))
		{
			driver =new FirefoxDriver();
		}
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.get(d.fetchDataFromProperty("url"));
		driver.manage().window().maximize();
		driver.findElement(By.name("user_name")).sendKeys(d.fetchDataFromProperty("username"));
		driver.findElement(By.name("user_password")).sendKeys(d.fetchDataFromProperty("password"),Keys.ENTER);
		
		WebElement more = driver.findElement(By.linkText("More"));
		Actions act = new Actions(driver);
				act.moveToElement(more).perform();
				driver.findElement(By.linkText("Campaigns")).click();
				driver.findElement(By.cssSelector("img[title='Create Campaign...']")).click();
				driver.findElement(By.name("campaignname")).sendKeys(d.fetchDataFromExcel("TestCase", 2, 2));
				driver.findElement(By.cssSelector("img[title='Select']")).click();
				String MainID = driver.getWindowHandle();
				Set<String> allId = driver.getWindowHandles();
				for(String s:allId)
				{
					if(!MainID.equals(s))
					driver.switchTo().window(s);
				}
				
				driver.findElement(By.linkText("Vtiger Single User Pack")).click();
				driver.switchTo().window(MainID);
				driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
				String Created = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				System.out.println(Created);
				if(Created.contains(d.fetchDataFromExcel("TestCase", 2, 2)))
						{
							System.out.println("Campaign Created Succesfully");
						}
				else {
					System.out.println("Campaign not created");
				}
				driver.findElement(By.linkText("Campaigns")).click();
				
				
				driver.findElement(By.name("search_text")).sendKeys(d.fetchDataFromExcel("TestCase", 2, 2));
				driver.findElement(By.id("bas_searchfield")).click();
				driver.findElement(By.xpath("//div[@id='basicsearchcolumns_real']/select/option[2]")).click();
				driver.findElement(By.name("submit"));
				driver.findElement(By.cssSelector("input[type='checkbox']")).click();
				driver.findElement(By.xpath("//input[@class='crmbutton small delete']")).click();
				driver.switchTo().alert().accept();
				String ActTitle = driver.findElement(By.xpath("//span[contains(text(),'Campaign ')]")).getText();
				System.out.println("ActTitlee is :" +ActTitle);
				String fetchDataFromExcel = d.fetchDataFromExcel("TestCase", 7, 3);
				System.out.println(fetchDataFromExcel);
				if(ActTitle.contains(fetchDataFromExcel))
				{
					System.out.println("Campaign Deleted succesfully");
				}
				else {
					System.out.println("Campaign not deleted");
				}
						
				
				
			
	}
}
