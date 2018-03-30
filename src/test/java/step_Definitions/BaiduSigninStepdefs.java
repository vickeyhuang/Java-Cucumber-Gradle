package step_Definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.PendingException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Iterator;
import java.util.Set;


/**
 * Created by xqhuang on 21/03/2018.
 */

public class BaiduSigninStepdefs {

	WebDriver driver = null;

	public void initializeDriver() {

		driver = new ChromeDriver();
	}

	public void switchparentWindow() {
		String parentWindowHandler = driver.getWindowHandle(); // Store your parent window
		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
		driver.switchTo().window(parentWindowHandler);  // switch back to parent window
	}

	public void switchsubWindow() {

		String subWindowHandler = null;

		Set<String> handles = driver.getWindowHandles(); // get all window handles
		Iterator<String> iterator = handles.iterator();
		while (iterator.hasNext()){
			subWindowHandler = iterator.next();
		}
		driver.switchTo().window(subWindowHandler); // switch to popup window
	}


	@Given("^User open a \"([^\"]*)\"$")
	public void userOpenA(String web_site) throws Throwable {

		initializeDriver();
		driver.get(web_site);
	}

	@And("^Click \"([^\"]*)\"$")
	public void Click(String button) throws Throwable {

		WebElement element = driver.findElement(By.cssSelector("#u1>.lb"));
			assert element.getText().equals(button);
				element.click();

				switchsubWindow();

	}

	@Then("^Click \"([^\"]*)\" and navigate to sign web page$")
	public void Click_and_navigate_to_sign_web_page(String sign_button) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("a.pass-reglink.pass-link")));

		WebElement element = driver.findElement(By.cssSelector("a.pass-reglink.pass-link"));
		assert element.getText().equals(sign_button);
		element.click();
	}

	@And("^Input \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" and selected related policy$")
	public void Input_and_selected_related_policy(String username, String number, String passwrod) throws Throwable {

//		String winHandleBefore = driver.getWindowHandle();

		for(String winHandle : driver.getWindowHandles()){
			driver.switchTo().window(winHandle);
		}

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("userName")));

		WebElement name = driver.findElement(By.name("userName"));
		WebElement phonenumber = driver.findElement(By.cssSelector("#TANGRAM__PSP_3__phone"));
		WebElement password = driver.findElement(By.cssSelector("#TANGRAM__PSP_3__password"));
		WebElement verfiyCode = driver.findElement(By.cssSelector("#TANGRAM__PSP_3__verifyCodeSend"));

		name.sendKeys(username);
		phonenumber.sendKeys(number);
		password.sendKeys(passwrod);
		verfiyCode.click();

        WebElement agree = driver.findElement(By.cssSelector("#TANGRAM__PSP_3__isAgree"));
        agree.click();


	}

	@Then("^Submit sign request to click \"([^\"]*)\"$")
	public void Submit_sign_request_to_click(String submit_button) throws Throwable {

		WebElement element = driver.findElement(By.cssSelector("#TANGRAM__PSP_3__submit"));
		assert element.getText().equals(submit_button);
		element.click();

		closeDriver();
	}

//login feature

	@Then("^Click \"([^\"]*)\" and navigate to login web page$")
	public void clickAndNavigateToLoginWebPage(String login_link) throws Throwable {

		WebDriverWait wait = new WebDriverWait(driver, 5);

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#TANGRAM__PSP_10__footerULoginBtn")));

		WebElement element = driver.findElement(By.cssSelector("#TANGRAM__PSP_10__footerULoginBtn"));
		assert element.getText().equals(login_link);
		element.click();
	}

	@And("^Input \"([^\"]*)\" \"([^\"]*)\" on login page$")
	public void inputOnLoginPage(String user, String password) throws Throwable {

		switchsubWindow();

		WebDriverWait wait = new WebDriverWait(driver, 5);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#TANGRAM__PSP_10__form .pass-form-logo")));

		driver.findElement(By.cssSelector("#TANGRAM__PSP_10__userName")).sendKeys(user);
		driver.findElement(By.cssSelector("#TANGRAM__PSP_10__password")).sendKeys(password);
	}

	@Then("^Submit \"([^\"]*)\"$")
	public void submit(String submit_button) throws Throwable {
		WebElement element = driver.findElement(By.cssSelector("#TANGRAM__PSP_10__submit"));
		if (element.getText().equals(submit_button))
				element.click();
	}

	@And("^Input and send verify code and click button$")
	public void inputAndSendVerifyCodeAndClickButton() throws Throwable {

		switchsubWindow();

		WebElement element = driver.findElement(By.cssSelector("#TANGRAM__36__button_send_mobile"));
		element.click();

		throw new PendingException();
	}

	@And("^User login successfully with \"([^\"]*)\"$")
	public void userLoginSuccessfullyWith(String username) throws Throwable {

		Thread.sleep(20000);

		WebElement element = driver.findElement(By.cssSelector("#s_username_top .user-name"));
		assert element.getText().equals(username);

		closeDriver();
	}

	private void closeDriver() {
		driver.quit();
	}

}
