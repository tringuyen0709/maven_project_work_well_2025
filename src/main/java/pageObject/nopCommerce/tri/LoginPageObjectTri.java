package pageObject.nopCommerce.tri;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUIs.nopCommerceTri.LoginPageUITri;

public class LoginPageObjectTri extends BasePage {
	
	WebDriver driver;

	public LoginPageObjectTri(WebDriver _driver) {
		
		driver = _driver;
//		System.out.println("Driver ID at Page Object Class: " + driver.toString());
		
		
	}

	public void enterYourEmail(String emailAddress) {
		waitForElementVisible(driver, LoginPageUITri.EMAIL_TEXTBOX);
		sendKeyToElement(driver, LoginPageUITri.EMAIL_TEXTBOX, emailAddress);
		
	}

	public void enterYourPassword(String password) {
		waitForElementVisible(driver, LoginPageUITri.PASSWORD_TEXTBOX);
		sendKeyToElement(driver, LoginPageUITri.PASSWORD_TEXTBOX, password);
		
	}

	public HomePageObjectTri clickToLogin() {
		waitForElementClickAble(driver, LoginPageUITri.LOGIN_BUTTON);
		clickToElement(driver, LoginPageUITri.LOGIN_BUTTON);
		return new HomePageObjectTri(driver) ;
	}







}
