package com.sun.NaveenAutomationPractice;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App {
	
	static WebDriver driver;

	public static void main(String[] args) {

		/* Stale element exception error */
		/*
		 * WebDriverManager.chromedriver().setup(); // auto-downloads correct version
		 * ChromeOptions options = new ChromeOptions();
		 * options.addArguments("--remote-allow-origins=*"); WebDriver driver = new
		 * ChromeDriver(options);
		 * 
		 * driver.get("https://www.worldometers.info/world-population/"); boolean ind =
		 * true; int count = 0; while (ind) {
		 * 
		 * List<WebElement> elementList = driver.findElements( By.
		 * xpath("//div[@class='font-bold text-4xl md:text-6xl text-center text-zinc-500']/span/span"
		 * ));
		 * 
		 * System.out.println(elementList); count = count + 1; for (WebElement e :
		 * elementList) { System.out.println(e.getText()); } if (count > 100000) { ind =
		 * false; } elementList = driver.findElements( By.
		 * xpath("//div[@class='font-bold text-4xl md:text-6xl text-center text-zinc-500']/span/span"
		 * )); }
		 * 
		 * driver.quit();
		 */
		App t =new App();
		t.handellingStaleException();
		
	}

	public void handellingStaleException() {
		WebDriverManager.chromedriver().setup(); // auto-downloads correct version
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.get("https://www.worldometers.info/world-population/");
		//printPopulationData("//div[@class='font-bold text-4xl md:text-6xl text-center text-zinc-500']/span[@class='rts-counter']");
		printTodayData("//div[text()='Today']//parent::div//span[@class='rts-counter text-2x1 font-bold'];");
	}
	
	public void printPopulationData(String locator) {
		boolean ind = true;
		int count = 0;
		while (ind) {

			List<WebElement> elementList = driver.findElements(By.xpath(locator));

			/* System.out.println(elementList); */
			count = count + 1;
			for (WebElement e : elementList) {
				System.out.println(e.getText()+"---");
			}
			if (count > 100000) {
				ind = false;
			}

		}
		
		
	}
	
	public void printTodayData(String locator) {
		
		boolean ind = true;
		int count = 0;
		while (ind) {

			List<WebElement> elementList = driver.findElements(By.xpath(locator));

			/* System.out.println(elementList); */
			count = count + 1;
			for (WebElement e : elementList) {
				System.out.println(e.getText()+"---");
			}
			if (count > 100000) {
				ind = false;
			}

		}
		
	}

}
