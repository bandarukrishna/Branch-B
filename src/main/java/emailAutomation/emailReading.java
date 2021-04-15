package emailAutomation;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.qa.base.TestBase;
import com.qa.util.TestUtil;
public class emailReading extends TestBase {

    @FindBy(xpath = "//input[@type='email']")
    WebElement useridField;
    @FindBy(xpath = "//div[@class='VfPpkd-RLmnJb']")
    WebElement NextButton;
    @FindBy(xpath = "//input[@name='password']")
    WebElement password;
    @FindBy(xpath = "//*[@class='gb_Xe']")
    WebElement viewbox;
    //frame
    @FindBy(xpath = "//iframe[@role='presentation']")
    WebElement viewframae;
    @FindBy(xpath = "//span[text()='Gmail']")
    WebElement gMailOpt;
    //mail inbox properties
    @FindBy(xpath = "//table[starts-with(@id,':2k')]")
    WebElement table;

    public emailReading() {
        PageFactory.initElements(driver, this);
    }
    public void loginEmail(String userNameValue, String passwordValue) throws InterruptedException {
        useridField.sendKeys(userNameValue);
        NextButton.click();
        Thread.sleep(10000);
        password.sendKeys(passwordValue);
        NextButton.click();
        Thread.sleep(10000);
        driver.navigate().to("https://mail.google.com/mail/u/0/#inbox");
        //TestUtil.readingtable("Google Community Te.",table);//reading tablw with for loop
    	TestUtil.readingWebtable1("Bhavani Krishna",table); //reading with advanced for loop
    }

}