package com.accesshq.utilities;

import java.util.concurrent.TimeUnit;
import com.accesshq.tests.BaseTestSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utils {
	
	public static Boolean elementExists(WebDriver driver,By locator, int timeout)
	{
		try
		{
			driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
			new WebDriverWait(driver,timeout).until(ExpectedConditions.visibilityOfElementLocated(locator));
			driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
			return true;
		}
		catch (Exception e)
		{
			driver.manage().timeouts().implicitlyWait(BaseTestSuite.IMPLICIT_TIMEOUT, TimeUnit.SECONDS);	
			return false;
		}
	}

}
