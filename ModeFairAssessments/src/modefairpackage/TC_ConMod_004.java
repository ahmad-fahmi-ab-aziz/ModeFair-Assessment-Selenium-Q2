package modefairpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC_ConMod_004 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.xe.com/");

		WebElement amountSymbol = driver.findElement(By.xpath("//span[@class='amount-input']"));
		WebElement fromCurrency = driver.findElement(By.xpath("//div[@id='midmarketFromCurrency-descriptiveText']"));
		WebElement toCurrency = driver.findElement(By.xpath("//div[@id='midmarketToCurrency-descriptiveText']"));

		System.out.println("****Before Swap Currency****");
		System.out.println("Amount Symbol: " + amountSymbol.getText());
		System.out.println("From Currency: " + fromCurrency.getText());
		System.out.println("To Currency:" + toCurrency.getText());
		System.out.println("");

		WebElement swapCurrencyButton = driver.findElement(By.xpath("//button[@aria-label='Swap currencies']"));
		swapCurrencyButton.click();

		System.out.println("****After Swap Currency****");
		System.out.println("Amount Symbol: " + amountSymbol.getText());
		System.out.println("From Currency: " + fromCurrency.getText());
		System.out.println("To Currency:" + toCurrency.getText());

		driver.quit();
	}

}
