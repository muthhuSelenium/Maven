package com.vtiger.objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CreateFilterPage {
	VendorsPage vp= new VendorsPage();
	@FindBy(className="detailedViewTextBox")
	private WebElement vendorName;
	@FindBy(xpath="//span[@class='lvtHeaderText']")
	private WebElement CreateFilterPageTitle;
	@FindBy(css="input[type='submit']")
	private WebElement saveBtn;
	@FindBy(name="viewname")
	private WebElement filterListBox;
	@FindBy(name="column2")
	private WebElement column2;
	@FindBy(xpath="(//option[contains(text(),'Vendor Name')])[2]")
	private WebElement column2Vendorname;
	@FindBy(xpath="(//option[contains(text(),'Vendor No')])[2]")
	private WebElement column2Vendorno;
	@FindBy(name="setDefault")
	private WebElement setAsDefaultChkBox;
	@FindBy(name="setMetrics")
	private WebElement setAsMetricsChkBox;
	@FindBy(name="setStatus")
	private WebElement setAsPublicChkBox;
	@FindBy(xpath="//input[@id='jscal_field_date_start']")
	private WebElement startDateBox;
	@FindBy(xpath="//input[@id='jscal_field_date_end']")
	private WebElement EndDateBox;
	
	
	
	public WebElement getVendorName()
	{
		return vendorName;
		
	}
	public WebElement getCreateFilterPageTitle()
	{
		return CreateFilterPageTitle;
		
	}
	public WebElement getSaveBtn()
	{
		return saveBtn;
		
	}
	public WebElement getFilterListBox()
	{
		return filterListBox;
		
	}
	public WebElement getColumn2()
	{
		return column2;
		
	}
	public WebElement getColumn2Vendorname()
	{
		return column2Vendorname;
		
	}
	public WebElement getColumn2Vendorno()
	{
		return column2Vendorno;
		
	}
	public WebElement getSetAsDefaultChkBox()
	{
		return setAsDefaultChkBox;
		
	}
	public WebElement getSetAsMetricsChkBox()
	{
		return setAsMetricsChkBox;
		
	}
	public WebElement getSetAsPublicChkBox()
	{
		return setAsPublicChkBox;
		
	}
	public WebElement getStartDateBox()
	{
		return startDateBox;
		
	}
	
	
	public WebElement getEndDateBox()
	{
		return EndDateBox;
		
	}
	public void createFilterWithMandatoryField(String vendorName)
	{
		//vp.getcreateFilterBtn().click();
		getVendorName().sendKeys(vendorName);
		
	}
}
