package com.vtiger.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VendorsPage {
	@FindBy(linkText="Create Filter")
	private WebElement createFilterBtn;
	@FindBy(linkText="Vendors")
	private WebElement VendorPageTitle;
	
	
	public WebElement getvendorPageTitle()
	{
		return VendorPageTitle;
		
	}
	public WebElement getcreateFilterBtn()
	{
		return createFilterBtn;
		
	}
	public void createFilter()
	{
		getcreateFilterBtn().click();
	}
	
}
