package com.accesshq.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.accesshq.models.pages.FormsPage;
import com.accesshq.models.pages.HomePage;

class FormsPageTest extends BaseTestSuite {

	@Test
	void test() {
		
		HomePage homePage = new HomePage (driver);
		FormsPage formsPage = homePage.clickFormsPageLink();
		
		//Click Forms page and verify if error messages are displayed to display mandatory fields
		formsPage.clickModernSubmitButton();
		
		//Verify if the mandatory field errors appear
		Assertions.assertEquals("Your name is required", formsPage.getNameErrorText(),"Name field did not display");
		Assertions.assertEquals("Your email is required", formsPage.getEmailError(),"Email field did not display");
		Assertions.assertEquals("You must agree to continue", formsPage.getAgreeError(),"Must agree field did not display");
				
		//Update mandatory fields and verify if warning messages disappear
		formsPage.updateMandatoryFields("bogus", "bogus@email.com", true);
		
		
		formsPage.clickModernSubmitButton();
		formsPage.mandatoryFieldErrorsDisappear();
		formsPage.thankyouPopup();
		
		
		
		/*
		
		Assertions.assertEquals("Your name is required", driver.findElement(By.id("name-err")).getText(),"Name field did not display");
		Assertions.assertEquals("Your email is required", driver.findElement(By.id("email-err")).getText(),"Email field did not display");
		Assertions.assertEquals("You must agree to continue", driver.findElement(By.id("agree-err")).getText(),"Must agree field did not display");
		
		
		driver.findElement(By.id("name")).sendKeys("bogus");
		driver.findElement(By.id("email")).sendKeys("bogus@email.com");
		driver.findElement(By.cssSelector("div[name='agree'] label")).click();
		
		/*Assertions.assertTrue(driver.findElements(By.id("name-err")).size()<1,"name error did not clear");
		Assertions.assertTrue(driver.findElements(By.id("email-err")).size()<1,"email error did not clear");
		Assertions.assertTrue(driver.findElements(By.id("agree-err")).size()<1,"agree error did not clear");
		*/
		
		//Assertions.assertFalse(elementExists(By.id("name-err"),0),"name error did not clear");
		
		
	}

}
