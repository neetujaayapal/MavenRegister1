package www.learnmaven.MavenRegister1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Register {

	WebDriver driver;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\neetu\\Drivers\\Chrome Driver\\chromedriver.exe");

		driver = new ChromeDriver();

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		driver.manage().window().maximize();

	}

	@Test
	public void sendKeysTest() {

		WebElement firstNameInputField = driver
				.findElement(By.cssSelector("fieldset#account>div:nth-of-type(2) input"));
		firstNameInputField.sendKeys("Neetu");
		WebElement lastNameInputField = driver.findElement(By.cssSelector("fieldset#account>div:nth-of-type(3) input"));
		lastNameInputField.sendKeys("Jayapalan");
		WebElement emailInputField = driver.findElement(By.cssSelector("fieldset#account>div:nth-of-type(4) input"));
		emailInputField.sendKeys("neetujaya@gmail.com");
		WebElement telephoneInputField = driver
				.findElement(By.cssSelector("fieldset#account>div:nth-of-type(5) input"));
		telephoneInputField.sendKeys("343842324");
		WebElement passwordInputField = driver
				.findElement(By.cssSelector("div#content form fieldset:nth-of-type(2)>div:nth-of-type(1) input"));
		passwordInputField.sendKeys("Naveenlab");

		WebElement confirmPasswordInputField = driver
				.findElement(By.cssSelector("div#content form fieldset:nth-of-type(2)>div:nth-of-type(2) input"));
		confirmPasswordInputField.sendKeys("Naveenlab");

//		 Assert.assertEquals(passwordInputField, confirmPasswordInputField ,"Password
//		 confirmation does not match password!");

//		WebElement agreeBtn = driver.findElement(By.cssSelector("div.buttons input:nth-of-type(1)"));
//		agreeBtn.click();

		WebElement continueBtn = driver.findElement(By.cssSelector("div.buttons input:nth-of-type(2)"));
		continueBtn.click();

		WebElement alert = driver.findElement(By.cssSelector("div#account-register>div:nth-of-type(1)"));
		String alertText = alert.getText();
		System.out.println(alertText);
		Assert.assertEquals(alertText, "Warning: You must agree to the Privacy Policy!", "text is not matching");

//		WebElement accountAlert = driver.findElement(By.cssSelector("div#content h1"));
//		String accountAlertText = accountAlert.getText();
//		System.out.println(accountAlertText);
//		Assert.assertEquals(accountAlertText, "Your Account Has Been Created!", "text is not matching");

	}

	public void tearDown() {

		driver.close();
	}

}
