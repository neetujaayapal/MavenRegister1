package www.learnmaven.MavenRegister1;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Purchase {

	WebDriver driver;
	
	Actions ac ;

	@BeforeMethod
	public void setup() {

		System.setProperty("webdriver.chrome.driver", "C:\\Users\\neetu\\Drivers\\Chrome Driver\\chromedriver.exe");

		driver = new ChromeDriver();
		
		ac = new Actions(driver);

		driver.get("https://www.google.com/");

		
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		

		driver.manage().window().maximize();
		
		driver.manage().timeouts().setScriptTimeout(60, TimeUnit.SECONDS);
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

	}

	@Test(priority = 1)
	public void registerTest() {

		driver.get("https://naveenautomationlabs.com/opencart/index.php?route=account/register");

		WebElement firstNameInputField = driver
				.findElement(By.cssSelector("fieldset#account>div:nth-of-type(2) input"));
		firstNameInputField.sendKeys("Neetu");
		WebElement lastNameInputField = driver.findElement(By.cssSelector("fieldset#account>div:nth-of-type(3) input"));
		lastNameInputField.sendKeys("Jayapalan");
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder string1 = new StringBuilder();
		Random rnd = new Random();
		while (string1.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * characters.length());
			string1.append(characters.charAt(index));
		}
		String string2 = string1.toString();

		WebElement emailInputField = driver.findElement(By.cssSelector("fieldset#account>div:nth-of-type(4) input"));
		emailInputField.sendKeys(string2 + "@gmail.com");
		WebElement telephoneInputField = driver
				.findElement(By.cssSelector("fieldset#account>div:nth-of-type(5) input"));
		telephoneInputField.sendKeys("343842324");
		WebElement passwordInputField = driver
				.findElement(By.cssSelector("div#content form fieldset:nth-of-type(2)>div:nth-of-type(1) input"));
		passwordInputField.sendKeys("Naveenlab");

		WebElement confirmPasswordInputField = driver
				.findElement(By.cssSelector("div#content form fieldset:nth-of-type(2)>div:nth-of-type(2) input"));
		confirmPasswordInputField.sendKeys("Naveenlab");

		WebElement agreeBtn = driver.findElement(By.cssSelector("div.buttons input:nth-of-type(1)"));
		agreeBtn.click();

		WebElement continueBtn = driver.findElement(By.cssSelector("div.buttons input:nth-of-type(2)"));
		continueBtn.click();

		WebElement accountAlert = driver.findElement(By.cssSelector("div#content h1"));
		String accountAlertText = accountAlert.getText();
		System.out.println(accountAlertText);

		sleep();
		//Assert.assertEquals(accountAlertText, "Your Account Has Been Created!", "text is not matching");
		//sleep();
	}

	@Test(priority = 2)
	public void loginTest() {

		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=account/login");

		WebElement emailAddressInputField = driver.findElement(By.cssSelector(
				"div#account-login div#content>div>div:nth-of-type(2) div.well form div:nth-of-type(1) input"));

		emailAddressInputField.sendKeys("neja11@gmail.com");

		WebElement passwordInputField = driver.findElement(By.cssSelector(
				"div#account-login div#content>div>div:nth-of-type(2) div.well form div:nth-of-type(2) input"));

		passwordInputField.sendKeys("1234");

		WebElement loginBtnField = driver.findElement(
				By.cssSelector("div#account-login div#content>div>div:nth-of-type(2) div.well form>input"));

		ac.click(loginBtnField).perform();
		//loginBtnField.click();

		sleep();

		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=common/home");

		WebElement itemCategoryElement = driver.findElement(By.cssSelector("ul.nav.navbar-nav>li:nth-of-type(6) a"));

		itemCategoryElement.click();

		driver.navigate().to("https://naveenautomationlabs.com/opencart/index.php?route=product/category&path=24");

		WebElement addToCartElement = driver
				.findElement(By.cssSelector("div#content>div:nth-of-type(2)>div:nth-of-type(2) div.button-group span"));

		ac.moveToElement(addToCartElement).click().perform();
		//addToCartElement.click();

		WebElement itemInCartButton = driver
				.findElement(By.cssSelector("header div.container div.row div.col-sm-3 button.btn.btn-inverse"));

		itemInCartButton.click();

		WebElement checkOutBtn = driver.findElement(By.cssSelector("ul.list-inline>li:nth-of-type(5) span"));

		checkOutBtn.click();

		sleep();
		
		WebElement newAddressBtn = driver.findElement(By.cssSelector("div.panel-group>div:nth-of-type(2)>div:nth-of-type(2) div:nth-of-type(1) form.form-horizontal>div:nth-of-type(3) input"));

		newAddressBtn.click();

		sleep();
		
		
		WebElement firstNameInputField = driver.findElement(By.cssSelector("#input-payment-firstname"));

		firstNameInputField.sendKeys("Neetu");

		sleep();

		WebElement lastNameInputField = driver.findElement(By.cssSelector("#input-payment-lastname"));

		lastNameInputField.sendKeys("Jayapalan");

		WebElement address1InputField = driver.findElement(By.cssSelector("#input-payment-address-1"));

		address1InputField.sendKeys("Mcmurchy");

		WebElement cityInputField = driver.findElement(By.cssSelector("#input-payment-city"));

		cityInputField.sendKeys("Brampton");

		WebElement postalCodeInputField = driver.findElement(By.cssSelector("#input-payment-postcode"));

		postalCodeInputField.sendKeys("L6X1X7");

		Select sc = new Select(driver.findElement(By.cssSelector("#input-payment-country")));

		sc.selectByVisibleText("Canada");

		sleep();

		Select sc2 = new Select(driver.findElement(By.cssSelector("#input-payment-zone")));

		sc2.selectByVisibleText("Ontario");

		WebElement continueBtn = driver.findElement(By.cssSelector("div.buttons.clearfix input"));

		continueBtn.click();

		sleep();

		WebElement deliveryContinueBtn = driver.findElement(
				By.cssSelector("div.panel-group>div:nth-of-type(3)>div:nth-of-type(2) form>div:nth-of-type(5) input"));

		boolean check = deliveryContinueBtn.isEnabled();

		System.out.println(check);

		deliveryContinueBtn.click();

		sleep();

		WebElement deliveryMethodContinueBtn = driver
				.findElement(By.cssSelector("div#collapse-shipping-method>div>div:nth-of-type(2) input"));

		deliveryMethodContinueBtn.click();

		sleep();

		WebElement paymentMethodAgreeBtn = driver.findElement(By.cssSelector(
				"div.panel-group>div:nth-of-type(5)>div:nth-of-type(2)>div>div.buttons div.pull-right input:nth-of-type(1)"));

		paymentMethodAgreeBtn.click();

		sleep();

		WebElement paymentMethodContinueBtn = driver.findElement(By.cssSelector(
				"div.panel-group>div:nth-of-type(5)>div:nth-of-type(2)>div>div.buttons div.pull-right input:nth-of-type(2)"));

		paymentMethodContinueBtn.click();

		sleep();

		WebElement confirmOrderContinueBtn = driver
				.findElement(By.cssSelector("div#collapse-checkout-confirm div.panel-body>div:nth-of-type(2) input"));

		confirmOrderContinueBtn.click();

		sleep();

		WebElement orderPlacedMessageElement = driver.findElement(By.cssSelector("div#content h1"));

		String messagePlacedText = orderPlacedMessageElement.getText();

		Assert.assertEquals(messagePlacedText, "Your order has been placed!", "Message not matching");

		WebElement myAccountElement = driver
				.findElement(By.cssSelector("ul.list-inline li.dropdown span:nth-of-type(1)"));

		myAccountElement.click();

		WebElement logOutElement = driver
				.findElement(By.cssSelector("ul.dropdown-menu.dropdown-menu-right>li:nth-of-type(5) a"));

		logOutElement.click();
		
		WebElement logOutMessageElement = driver.findElement(By.cssSelector("div#content h1"));
		
		String logOutMessage = logOutMessageElement.getText();
		
		System.out.println(logOutMessage);
		
		Assert.assertEquals(logOutMessage, "Account Logout","Message not matching");
		
		

	}

	@AfterMethod
	public void tearDown() {

		driver.close();
	}

	public void sleep() {
		try {
			Thread.sleep(5000); // milliseconds
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
