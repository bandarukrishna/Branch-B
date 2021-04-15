package com.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.base.TestBase;

public class LandingPage extends TestBase {


@FindBy(xpath="//a[text()='REGISTER']")
@CacheLookup
WebElement register;

public LandingPage() {
	PageFactory.initElements(driver, this);
}


public void click_on_register_button()
{
register.click();
}

}
