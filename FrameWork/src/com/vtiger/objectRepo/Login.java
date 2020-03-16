package com.vtiger.objectRepo;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Login {
	@FindBy(name="user_name")
	private WebElement un;
	@FindBy(name="user_password")
	private WebElement pwd;
	@FindBy(id="submitButton")
	private WebElement loginBtn;
	@FindBy(xpath="//div[contains(text(),'specify a valid username')]")
	private WebElement Errmsg;
	
	public WebElement getUn()
	{
		return un;
	}
	public WebElement getPwd()
	{
		return pwd;
	}
	public WebElement getLoginBtn()
	{
		return loginBtn;
	}
	public WebElement getErrmsg()
	{
		return Errmsg;
		
	}
	public void loginToVtiger(String username,String password)
	{
		un.sendKeys(username);
		pwd.sendKeys(password);
		loginBtn.click();
	}
	
	
}
