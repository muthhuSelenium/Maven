package com.vtiger.testscript;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.vtiger.genericLib.BaseClass;
import com.vtiger.genericLib.FileDataFrameWork;
import com.vtiger.objectRepo.CreateFilterPage;
import com.vtiger.objectRepo.Homepage;
import com.vtiger.objectRepo.VendorsPage;
@Listeners(com.vtiger.genericLib.ListenersImplementation.class)
public class CreateFilter extends BaseClass{
	 

	@Test
	public void createFilter() throws IOException, Throwable
	{
		Homepage hp = PageFactory.initElements(driver, Homepage.class);
		VendorsPage vp = PageFactory.initElements(driver, VendorsPage.class);
		CreateFilterPage cf = PageFactory.initElements(driver, CreateFilterPage.class);
		/*WebElement more = hp.getmoreBtn();
		Actions act = new Actions(driver);
				act.moveToElement(more).perform();
				hp.getVendorsBtn().click();*/
				hp.navigateToVendorsPage();
				String title = vp.getvendorPageTitle().getText();
				String f1 = d.fetchDataFromExcel("Sheet1", 4, 6);
				org.testng.Assert.assertEquals(title, f1);
				System.out.println("Vendor page validated");
				vp.getcreateFilterBtn().click();
				String create = cf.getCreateFilterPageTitle().getText();
				String f2 = d.fetchDataFromExcel("Sheet1", 4, 6);
				org.testng.Assert.assertTrue(create.contains(f2));
				System.out.println("Create filter page validated");
			
				
				//cf.getVendorName().sendKeys(d.fetchDataFromExcel("Sheet1", 6,5 ));
				cf.createFilterWithMandatoryField(d.fetchDataFromExcel("Sheet1", 6,5 ));
				cf.getSaveBtn().click();
				WebElement List = cf.getFilterListBox();
				Select s = new Select(List);
				java.util.List<WebElement> options = s.getOptions();
				boolean flag=false;
				for(WebElement wb:options)
				{	
					String ActText = wb.getText();
					
					if(ActText.equals(d.fetchDataFromExcel("Sheet1", 6,5 )))
					{
						flag = true;
						break;
					}
					
				}
				Assert.assertTrue(flag);	
				System.out.println("Filter Created Successfully");
				
	}
}
