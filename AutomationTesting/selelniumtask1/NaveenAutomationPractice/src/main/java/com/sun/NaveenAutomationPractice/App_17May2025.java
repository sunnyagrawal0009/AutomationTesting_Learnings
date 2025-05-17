package com.sun.NaveenAutomationPractice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class App_17May2025 {

	public static void main(String[] args) {

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

}
