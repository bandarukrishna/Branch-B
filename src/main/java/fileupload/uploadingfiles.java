package fileupload;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class uploadingfiles {

    public static void main(String[] args) throws InterruptedException, AWTException {
        // TODO Auto-generated method stub
        WebDriverManager.firefoxdriver().setup();
        WebDriver drv = new FirefoxDriver(); // starting Firefox browser
        drv.manage().window().maximize(); // maximizing window
        drv.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS); //for page load
        drv.get("https://www.grammarly.com/plagiarism-checker"); //open testing website
        drv.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // for Implicit wait

        JavascriptExecutor js = (JavascriptExecutor) drv; // Scroll operation using Js Executor
        js.executeScript("window.scrollBy(0,200)"); // Scroll Down(+ve) upto browse option
        Thread.sleep(2000); // suspending execution for specified time period

        WebElement browse = drv.findElement(By.xpath("//*[contains(text(),'Upload a file')]"));
        // using linkText, to click on browse element 
        browse.click();
        fileUploadRobot("C:\\Users\\krish\\Downloads\\third_party_declaration_insured.doc");
    }
    public static void fileUploadRobot(String file) throws AWTException {
        StringSelection str = new StringSelection(file);
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(str, null);
        Robot rb = new Robot();
        rb.keyPress(KeyEvent.VK_CONTROL);
        rb.keyPress(KeyEvent.VK_V);
        rb.keyRelease(KeyEvent.VK_CONTROL);
        rb.keyRelease(KeyEvent.VK_V);
        // for pressing and releasing Enter
        rb.keyPress(KeyEvent.VK_ENTER);
        rb.keyRelease(KeyEvent.VK_ENTER);
        System.out.println("file uploaded");
    }
}