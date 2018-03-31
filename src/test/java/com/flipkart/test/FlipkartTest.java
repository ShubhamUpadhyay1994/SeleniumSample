package com.flipkart.test;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.flipkart.pages.FlipkartPage;

public class FlipkartTest {
	
	@BeforeMethod
	public static void beforeFlipkartMethod(){
		System.out.println("Method started execution");
	}
	
	@AfterMethod
	public static void afterFlipkartMethod(){
		System.out.println("Method execution completed");
	}
	
	@Test(alwaysRun=true)
	@Parameters({"url"})
	public static void testlaunchUrl(String url){
		FlipkartPage.setProperty(url);
		FlipkartPage.waitForFlipKart();
	//	FlipkartPage.clickOnLogin();
	}
	
	@Test(dependsOnMethods="testlaunchUrl")
	@Parameters({"user","pass"})
	public static void enterCredentials(String user,String pass){
		FlipkartPage.enterCredentials(user, pass);
		FlipkartPage.waitForFlipKartAfterLogin();
	}
	

}
