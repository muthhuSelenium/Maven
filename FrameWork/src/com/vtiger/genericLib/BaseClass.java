package com.vtiger.genericLib;

import org.testng.Assert;
import org.testng.AssertJUnit;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.asserts.SoftAssert;

import com.vtiger.objectRepo.Homepage;
import com.vtiger.objectRepo.Login;

public class BaseClass {
	public FileDataFrameWork d = new FileDataFrameWork();
	public static WebDriver driver= null;
	SoftAssert sa = new SoftAssert();
	public WebDriverCommonLib wlib= new WebDriverCommonLib();	
	
	
	@BeforeSuite
	public void configBS()
	{
		System.out.println("Database connected");
	}
	@org.testng.annotations.BeforeClass
	public void configBC() throws IOException
	{
		System.out.println("Browser launched");
		String browser = d.fetchDataFromProperty("browser");
		if(browser.equals("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if (browser.equals("firefox"))
				{
			driver=new FirefoxDriver();
				}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	@BeforeMethod
	public void configBM() throws Throwable
	{
		System.out.println("Login done");
		driver.get(d.fetchDataFromProperty("url"));
		String login = driver.getTitle();
		String exp= d.fetchDataFromExcel("Sheet1",1 ,6 );
		
		sa.assertEquals(login, exp);
		System.out.println("login validated");
		Login lp = PageFactory.initElements(driver, Login.class);
		/*lp.getUn().sendKeys(d.fetchDataFromExcel("Sheet1", 2,5 ));
		lp.getPwd().sendKeys(d.fetchDataFromExcel("Sheet1", 2, 5));
		lp.getLoginBtn().click();*/
		lp.loginToVtiger(d.fetchDataFromExcel("Sheet1", 2,5 ), d.fetchDataFromExcel("Sheet1", 2, 5));
		String Home = driver.getTitle();
		String exp1= d.fetchDataFromExcel("Sheet1", 2, 6);
		sa.assertEquals(Home, exp1);
		System.out.println("home page validated");
		sa.assertAll();
	}
	@AfterMethod
	public void configAM() throws IOException, Throwable
	{
		System.out.println("Logout done");
		Homepage hp = PageFactory.initElements(driver, Homepage.class);
		hp.signOutFromVtiger();
		 String logout = driver.getTitle();
			String exp= d.fetchDataFromExcel("Sheet1",1 ,6 );
			sa.assertEquals(logout, exp);
			System.out.println("logout validated");
			sa.assertAll();
	}
	@org.testng.annotations.AfterClass
	public void configAC()
	{
		System.out.println("Close browser");
		driver.quit();
	}
	@AfterSuite
	public void configAS()
	{
		System.out.println("Database disconnected");
	}
	
}		
		
		
		
		
		
		
		
		
		
		
		
		

	
	
	
	
	
	
	
	
	
	
	

