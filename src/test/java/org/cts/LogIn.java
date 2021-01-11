package org.cts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LogIn extends Base {
	public LogIn() {
		PageFactory.initElements(driver, this);
	}

	@FindAll({ @FindBy(id = "email"), @FindBy(xpath = "//input[@type='text']") })
	private WebElement logId;
	@FindAll({ @FindBy(id = "password"), @FindBy(xpath = "//input[@type='password']") })
	private WebElement passWord;
	@FindAll({ @FindBy(id = "//input[@type='password']"), @FindBy(xpath = "//button[@type='submit']") })
	private WebElement logInBtn;

	public WebElement getLogId() {
		return logId;
	}

	public WebElement getPassWord() {
		return passWord;
	}

	public WebElement getLogInBtn() {
		return logInBtn;
	}

}
