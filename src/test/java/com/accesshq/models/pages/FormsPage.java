package com.accesshq.models.pages;

import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.accesshq.utilities.Utils;

public class FormsPage extends BasePage {

	
	//private 
	
	public FormsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	private By modernFormButtons = By.cssSelector("form.modern > button");
	private By nameErrorLabel = By.id("name-err");
	private By emailErrorLabel = By.id("email-err");
	private By agreeErrorLabel = By.id("agree-err");
	
	public void clickModernSubmitButton()
	{
		clickModernButton("Submit");
	}
	
	public void clickModernClearButton()
	{
		clickModernButton("Clear");
	}
	
	private void clickModernButton(String buttonTitle)
	{
		List<WebElement> buttons = driver.findElements(modernFormButtons);
		for (WebElement button : buttons)
		{
			new WebDriverWait(driver,1).until(ExpectedConditions.visibilityOf(button));
			if(button.getText().equalsIgnoreCase(buttonTitle))
			{
				button.click();
				break;
			}
		}
	}
	
	public String getNameErrorText()
	{
		return Utils.elementExists(driver, nameErrorLabel, 0) ?
				driver.findElement(nameErrorLabel).getText() : "";
	}
	
	public String getEmailError()
	{
		return Utils.elementExists(driver, emailErrorLabel, 0) ?
				driver.findElement(emailErrorLabel).getText() : "";
	}
	
	public String getAgreeError()
	{
		return Utils.elementExists(driver, agreeErrorLabel, 0) ?
				driver.findElement(agreeErrorLabel).getText() : "";
	}
	
	public void mandatoryFieldErrors()
	{
		Assertions.assertEquals("Your name is required", driver.findElement(By.id("name-err")).getText(),"Name field did not display");
		Assertions.assertEquals("Your email is required", driver.findElement(By.id("email-err")).getText(),"Email field did not display");
		Assertions.assertEquals("You must agree to continue", driver.findElement(By.id("agree-err")).getText(),"Must agree field did not display");	
	}
	
	public void updateMandatoryFields(String szName, String email, Boolean bCheck)
	{
		driver.findElement(By.id("name")).sendKeys(szName);
		driver.findElement(By.id("email")).sendKeys(email);
		if (bCheck)
			driver.findElement(By.cssSelector("div[name='agree'] label")).click();
		
	}
	
	public void mandatoryFieldErrorsDisappear()
	{
		//Assertions.assertFalse(elementExists(By.id("name-err"),0),"name error did not clear");
		Assertions.assertTrue(driver.findElements(By.id("name-err")).size()<1,"name error did not clear");
		//Assertions.assertTrue(driver.findElements(By.id("email-err")).size()<1,"email error did not clear");
		//Assertions.assertTrue(driver.findElements(By.id("agree-err")).size()<1,"agree error did not clear");
	}

	
	public void thankyouPopup()
	{
		//driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
		
		new WebDriverWait(driver,60).until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".snackbar.popup-message")));
		//Utils.elementExists(driver, By.cssSelector(""), 60);
		
		/*if(driver.findElement(By.cssSelector(".snackbar.popup-message")).isEnabled())
			System.out.println("success");
		else
			System.out.println("no popup");*/
		System.out.println(driver.findElement(By.cssSelector(".snackbar.popup-message")).getText());
		
		
		Assertions.assertEquals("Thanks for your feedback bogus", driver.findElement(By.cssSelector(".snackbar.popup-message")).getText());
		
;	}
}
