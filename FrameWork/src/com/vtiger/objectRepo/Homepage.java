package com.vtiger.objectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Homepage  {
	@FindBy(xpath="//span[text()=' Administrator']/../following-sibling::td[1]")
	private WebElement mouseOverToSignOut;
	@FindBy(linkText="Sign Out")
	private WebElement signOutBtn;
	@FindBy(linkText="More")
	private WebElement moreBtn;
	@FindBy(name="Vendors")
	private WebElement vendorsBtn;
	
	public WebElement getMouseOverToSignOut()
	{
		return mouseOverToSignOut;
		
	}
	public WebElement getSignOutBtn()
	{
		return signOutBtn;
		
	}
	public WebElement getmoreBtn()
	{
		return moreBtn;
		
	}
	public WebElement getVendorsBtn()
	{
		return vendorsBtn;
		
	}
	
	public void signOutFromVtiger()
	{
		getMouseOverToSignOut().click();
		getSignOutBtn().click();
	}
	
	public void moveMouseToMoreDD()
	{
		moreBtn.click();
	}
	public void navigateToVendorsPage()
	{
		moveMouseToMoreDD();
		getVendorsBtn().click();
		
	}
	
}
