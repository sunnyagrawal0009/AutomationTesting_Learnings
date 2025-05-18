package com.sun.NaveenAutomationPractice;

import static org.testng.Assert.assertEquals;

import java.time.Duration;
import org.testng.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAutomation {

	public static void main(String[] args) {
		/*
		 * task2(); task3();
		 */
		task4();
	}

	public static void task1() {

		// Automatically manage drivers
		WebDriverManager.chromedriver().setup();

		/*
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*");
		 */

		/* WebDriver driver = new ChromeDriver(options); */
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		System.out.println("Title: " + driver.getTitle());
		driver.quit();

	}

	public static void task2()  {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.className("gLFyf")).sendKeys("pentagon");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
        searchBtn.click();
        String title=driver.getTitle();
        if(title.equalsIgnoreCase("pentagon")) {
        	System.out.println("Assertion is true");
        }
        try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		driver.quit();

	}
	
	public static void task3() {
		
		WebDriverManager.chromedriver().setup();
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.name("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		String message=driver.findElement(By.className("post-title")).getText();
		
		System.out.println("Resultant message1 is:-"+message);
		
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.name("username")).sendKeys("incorrectUser");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		String message2=driver.findElement(By.id("error")).getText();
		System.out.println("Resultant message2 is:-"+message2);
		
		driver.close();
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		driver.quit();
		
		
		
	}
	
	public static void task4() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.xpath("//a[text()='Contact']")).click();
		
		String currentUrl=driver.getCurrentUrl();
		String expectedURl="https://practicetestautomation.com/contact/";
	
	     Assert.assertEquals(currentUrl, expectedURl,"Navigation URL mismatch");
	    
		
	}

}
