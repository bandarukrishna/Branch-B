package com.qa.pages;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;

public class RegisterPage extends TestBase{

@FindBy(xpath="//*[@name='firstName']")
@CacheLookup
WebElement firstName;

@FindBy(xpath="//*[@name='lastName']")
@CacheLookup
WebElement lastName;

@FindBy(xpath="//*[@name='phone']")
@CacheLookup
WebElement phonenum;

@FindBy(xpath="//*[@name='userName']")
@CacheLookup
WebElement mailid;
@FindBy(xpath="//*[@name='address1']")
@CacheLookup
WebElement address1;

@FindBy(xpath="//*[@name='address2']")
@CacheLookup
WebElement address2;

@FindBy(xpath="//*[@name='city']")
@CacheLookup
WebElement city;

@FindBy(xpath="//*[@name='state']")
@CacheLookup
WebElement state;
@FindBy(xpath="//*[@name='postalCode']")
@CacheLookup
WebElement postalCode;

@FindBy(xpath="//*[@name='email']")
@CacheLookup
WebElement username;
@FindBy(xpath="//*[@name='password']")
@CacheLookup
WebElement password;

@FindBy(xpath="//*[@name='confirmPassword']")
@CacheLookup
WebElement confirmPassword;

@FindBy(xpath="//*[@name='submit']")
@CacheLookup
WebElement submit;

public RegisterPage()
{
PageFactory.initElements(driver, this);	
}

public void enterContactInformation(String firstname, String lastname, String phone, String mail)
{
firstName.sendKeys(firstname);	
lastName.sendKeys(lastname);
phonenum.sendKeys(phone);
mailid.sendKeys(mail);
}
public void enterMailingInformation(String address_1, String City, String State, String PostalCode )
{	
address1.sendKeys(address_1);
//address2.sendKeys(address_2);
city.sendKeys(City);
state.sendKeys(State);
postalCode.sendKeys(PostalCode);
}

public void entersUserInformation(String Username, String Password, String ConfirmPassword)
{
	username.sendKeys(Username);
	password.sendKeys(Password);
	confirmPassword.sendKeys(ConfirmPassword);
	submit.click();
	
}
}
