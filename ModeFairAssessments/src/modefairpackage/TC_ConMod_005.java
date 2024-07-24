package modefairpackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class TC_ConMod_005 {

	static String amount = "1";
	static String usdCurrency = "USD";
	static String eurCurrency = "EUR";

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.xe.com/");

		WebElement h1Title = driver
				.findElement(By.xpath("//h1[contains(text(),'Trusted Global Currency Converter & Money Transfer')]"));

		System.out.println("***Before Conversion***");
		System.out.println("Title shown: " + h1Title.getText());
		System.out.println("");

		WebElement convertButton = driver.findElement(By.xpath("//button[normalize-space()='Convert']"));
		convertButton.click();

		Thread.sleep(2000);

		h1Title = driver.findElement(By.xpath("//h1[normalize-space()='" + amount + " " + usdCurrency + " to "
				+ eurCurrency + " - Convert US Dollars to Euros']"));
		System.out.println("***After Conversion***");
		System.out.println("Title shown: " + h1Title.getText());

		driver.quit();

	}

}
