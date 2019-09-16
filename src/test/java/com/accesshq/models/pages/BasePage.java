package com.accesshq.models.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage 
{
	protected WebDriver driver;
	private By formsPageLink = By.cssSelector("nav a[aria-label='forms']");
	private By homePageLink = By.cssSelector("nav a[aria-label='home']");
	
	//constructor
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}

	//Click forms link
	public FormsPage clickFormsPageLink()
	{
		driver.findElement(formsPageLink).click();
		return new FormsPage(driver);
	}
	
	//Click Home link 
	public HomePage clickHomePageLink()
	{
		driver.findElement(homePageLink).click();
		return new HomePage(driver);
	}
	
}
