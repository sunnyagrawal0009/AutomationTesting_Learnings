package com.sun.NaveenAutomationPractice;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestAutomation {

	public static void main(String[] args) {
		/*
		 * task2(); task3();
		 */
		task_6_1();
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

	public static void task2() {

		WebDriverManager.chromedriver().setup();

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.google.com");
		driver.findElement(By.className("gLFyf")).sendKeys("pentagon");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement searchBtn = wait.until(ExpectedConditions.elementToBeClickable(By.name("btnK")));
		searchBtn.click();
		String title = driver.getTitle();
		if (title.equalsIgnoreCase("pentagon")) {
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

		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.name("username")).sendKeys("student");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		String message = driver.findElement(By.className("post-title")).getText();

		System.out.println("Resultant message1 is:-" + message);

		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.name("username")).sendKeys("incorrectUser");
		driver.findElement(By.name("password")).sendKeys("Password123");
		driver.findElement(By.id("submit")).click();
		String message2 = driver.findElement(By.id("error")).getText();
		System.out.println("Resultant message2 is:-" + message2);

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
		WebDriver driver = new ChromeDriver();
		driver.get("https://practicetestautomation.com/practice-test-login/");
		driver.findElement(By.xpath("//a[text()='Contact']")).click();

		String currentUrl = driver.getCurrentUrl();
		String expectedURl = "https://practicetestautomation.com/contact/";

		Assert.assertEquals(currentUrl, expectedURl, "Navigation URL mismatch");

	}

	public static void task5() {

		// checkbox
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/checkbox");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		WebElement icon = driver.findElement(By.cssSelector(".rct-checkbox svg"));
		String iconClass = icon.getAttribute("class");

		if (iconClass.contains("rct-icon-uncheck")) {
		    icon.click();
		}
		driver.close();
	}

	public static void task5_1() {

		// radio buttons
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/radio-button");
		
		WebElement yesLabel = driver.findElement(By.cssSelector("label[for='yesRadio']"));
		yesLabel.click();
		
		driver.quit();
		
	}
	
	public static void task_6() {
		
		System.out.println("test-0");
		WebDriverManager.chromedriver().setup();
		System.out.println("test-1");
		WebDriver driver=new ChromeDriver();
		System.out.println("test-2");
		driver.get("https://demoqa.com/alerts");
		System.out.println("test-3");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15000));
		System.out.println("test-4");
		wait.until(ExpectedConditions.elementToBeClickable(By.id("alertButton")));
		System.out.println("test-5");
		WebElement element=driver.findElement(By.id("alertButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		System.out.println("test-6");
		/* element.click(); */
		System.out.println("test-7");
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1=driver.switchTo().alert();
		System.out.println("test3");
		alert1.accept();
		System.out.println("test4");
		driver.quit();
	}
	
	public static void task_6_1() {
		
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15000));
		wait.until(ExpectedConditions.elementToBeClickable(By.id("promtButton")));
		WebElement element=driver.findElement(By.id("promtButton"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1=driver.switchTo().alert();
		System.out.println("test3");
		alert1.accept();
		System.out.println("test4");
		driver.quit();
		
	}
	
	public static void task6() {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demoqa.com/alerts");
		
		//Trigger the alert
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(15000));
		System.out.println("test-1");
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("timerAlertButton")));
		System.out.println("test0");
		WebElement element=driver.findElement(By.id("timerAlertButton"));
		System.out.println("test1");
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", element);
		/* element.click(); */
		System.out.println("test2");
		//Accept/dismiss the alert
		wait.until(ExpectedConditions.alertIsPresent());
		Alert alert1=driver.switchTo().alert();
		System.out.println("test3");
		alert1.accept();
		System.out.println("test4");
		driver.quit();
	}

}
