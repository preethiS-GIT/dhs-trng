package com.accesshq.tests;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BaseTestSuite {
	
	protected static WebDriver driver;
	public static final int IMPLICIT_TIMEOUT = 3;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", System.getenv("CHROME_DRIVER"));
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(IMPLICIT_TIMEOUT, TimeUnit.SECONDS);
		
				
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		//driver.quit();
	}

	@BeforeEach
	void setUp() throws Exception {
		driver.manage().deleteAllCookies();
		driver.navigate().to("https://d37g04pdxd959c.cloudfront.net/#/");
	}

	
	

}
