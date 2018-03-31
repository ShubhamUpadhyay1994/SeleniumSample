package com.flipkart.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FlipkartPage {

	
	static WebDriver driver;
	static WebElement login;

	public static void setProperty(String url) {
		System.out.println("Hello World!");

		System.setProperty("webdriver.chrome.driver", "C:/Automation/chromedriver_win32/chromedriver.exe");

		driver = new ChromeDriver();
		// driver = new FirefoxDriver();
		driver.navigate().to(url);
		driver.manage().window().maximize();
	}
	
	public static void waitForFlipKart(){
		driver.findElement(By.name("q")).isDisplayed();
		 login=driver.findElement(By.partialLinkText("Login & Signup"));
	}
	
	public static void clickOnLogin(){
		login.click();
	}
	
	public static void enterCredentials(String user,String pass){
		WebElement username= driver.findElement(By.xpath(".//*[@class='_39M2dM']/input[1]"));
		username.sendKeys(user);
		WebElement password= driver.findElement(By.xpath("//*[contains(@type,'password')]"));
		password.sendKeys(pass);
		WebElement loginBtn=driver.findElement(By.xpath("//*[contains(@class,'_2AkmmA _1LctnI _7UHT_c')]"));
		loginBtn.click();
	}
	public static void waitForFlipKartAfterLogin(){
		driver.findElement(By.name("q")).isDisplayed();
		 login=driver.findElement(By.xpath("//div[@class='_20yN1P qt4LQw']"));
	}
}
