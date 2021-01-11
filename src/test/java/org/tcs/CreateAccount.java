package org.tcs;

import org.cts.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateAccount extends Base {
	public CreateAccount() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@title='OctoPerf SaaS']")
	private WebElement getStart;

	public WebElement getStart() {
		return getStart;
	}

}
