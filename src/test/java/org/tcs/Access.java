package org.tcs;

import org.cts.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Access extends Base {
	public Access() {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//button[@type='button']")
	private WebElement addProject;
	@FindAll({ @FindBy(name = "name"), @FindBy(xpath = "//input[@type='text']") })
	private WebElement name;
	@FindBy(xpath = "//textarea[@name='description']")
	private WebElement description;
	@FindBy(xpath = "//input[@type='search']")
	private WebElement tag;
	@FindBy(xpath = "(//button[@type='submit'])[2]")
	private WebElement save;

	public WebElement getAddProject() {
		return addProject;
	}

	public WebElement getName() {
		return name;
	}

	public WebElement getDescription() {
		return description;
	}

	public WebElement getTag() {
		return tag;
	}

	public WebElement getSave() {
		return save;
	}

}
