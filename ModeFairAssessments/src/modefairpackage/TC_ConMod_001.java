package modefairpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_ConMod_001 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.xe.com/");

		WebElement amtInput = driver.findElement(By.id("amount"));
		amtInput.sendKeys("@");

		WebElement invalidAmountMsg = driver
				.findElement(By.xpath("//div[normalize-space()='Please enter a valid amount']"));

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> invalidAmountMsg.isDisplayed());

		boolean isInvalidMsgTrue = invalidAmountMsg.getText().equals("Please enter a valid amount");

		System.out.println("Invalid Message 'Please enter a valid amount' is displayed: " + isInvalidMsgTrue);

		driver.quit();
	}

}
