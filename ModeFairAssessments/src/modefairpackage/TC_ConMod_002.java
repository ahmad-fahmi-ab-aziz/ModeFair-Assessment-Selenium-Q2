package modefairpackage;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TC_ConMod_002 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ChromeOptions options = new ChromeOptions();
		options.addArguments("--start-maximized");

		WebDriver driver = new ChromeDriver(options);
		driver.get("https://www.xe.com/");

		WebElement amtInput = driver.findElement(By.id("amount"));
		amtInput.sendKeys("0");

		WebElement zeroAmountMsg = driver
				.findElement(By.xpath("//div[normalize-space()='Please enter an amount greater than 0']"));

		Wait<WebDriver> wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(d -> zeroAmountMsg.isDisplayed());

		boolean isZeroMsgTrue = zeroAmountMsg.getText().equals("Please enter an amount greater than 0");

		System.out.println("Invalid Message 'Please enter an amount greater than 0' is displayed: " + isZeroMsgTrue);

		driver.quit();

	}

}
