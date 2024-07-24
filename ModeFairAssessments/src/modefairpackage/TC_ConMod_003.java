package modefairpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_ConMod_003 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.xe.com/");

		WebElement amtInput = driver.findElement(By.id("amount"));
		amtInput.sendKeys("3");

		WebElement divFromCurrency = driver.findElement(By.id("midmarketFromCurrency"));
		divFromCurrency.click();

		WebElement spanFromCurrency = driver.findElement(
				By.xpath("(//ul[@id='midmarketFromCurrency-listbox']/li/div)[.='MYR – Malaysian Ringgit']"));

		Wait<WebDriver> waitFromCurrency = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitFromCurrency.until(d -> spanFromCurrency.isDisplayed());

		spanFromCurrency.click();

		WebElement divToCurrency = driver.findElement(By.id("midmarketToCurrency"));
		divToCurrency.click();

		WebElement spanToCurrency = driver
				.findElement(By.xpath("(//ul[@id='midmarketToCurrency-listbox']/li/div)[.='SGD – Singapore Dollar']"));

		Wait<WebDriver> waitToCurrency = new WebDriverWait(driver, Duration.ofSeconds(10));
		waitToCurrency.until(d -> spanToCurrency.isDisplayed());

		spanToCurrency.click();

		WebElement convertButton = driver.findElement(By.xpath("//button[normalize-space()='Convert']"));
		convertButton.click();
		
		Thread.sleep(2000);

		WebElement convertedCurrencyAmt = driver
				.findElement(By.xpath("//p[contains(.,'0.86') and contains(.,'Singapore Dollars')]"));

		Wait<WebDriver> waitConversion = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(3))
				.pollingEvery(Duration.ofMillis(300)).ignoring(ElementNotInteractableException.class);
		
		waitConversion.until(d ->{
			convertedCurrencyAmt.isDisplayed();
			return true;
		});

		System.out.println("The converted currency amount is : " + convertedCurrencyAmt.getText());

		driver.quit();
	}

}
