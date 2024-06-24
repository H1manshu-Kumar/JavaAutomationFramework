package SeleniumBasics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdown {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		Thread.sleep(3000);
		WebElement CurrencyStaticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		Select CurrencyDD = new Select(CurrencyStaticDropdown);
		
		CurrencyDD.selectByValue("AED");		
		String SelectValue = CurrencyDD.getFirstSelectedOption().getText();
		System.out.println(SelectValue);
		
		CurrencyDD.selectByIndex(3);
		String SelectValue1 = CurrencyDD.getFirstSelectedOption().getText();
		System.out.println(SelectValue1);
		Thread.sleep(2500);
		
		CurrencyDD.selectByVisibleText("INR");
		String SelectValue2 = CurrencyDD.getFirstSelectedOption().getText();
		System.out.println(SelectValue2);
		Thread.sleep(2500);
		
		driver.quit();
	}

}
