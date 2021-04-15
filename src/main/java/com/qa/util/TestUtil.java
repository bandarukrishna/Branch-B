package com.qa.util;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import com.google.common.io.Files;
import com.qa.base.TestBase;
public class TestUtil extends TestBase {
    public static long PAGE_LOAD_TIMEOUT = 20;
    public static long IMPLICIT_WAIT = 20;
    public static String TESTDATA_SHEET_PATH = "";
    static Workbook book;
    static Sheet sheet;
    static JavascriptExecutor js;
    
    public void switchToFrame() {
        driver.switchTo().frame("mainpanel");
    }

    public static Object[][] getTestData(String sheetName) {
        FileInputStream file = null;
        try {
            file = new FileInputStream(TESTDATA_SHEET_PATH);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        try {
            book = WorkbookFactory.create(file);
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        sheet = book.getSheet(sheetName);
        Object[][] data = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
        // System.out.println(sheet.getLastRowNum() + "--------" +
        // sheet.getRow(0).getLastCellNum());
        for (int i = 0; i < sheet.getLastRowNum(); i++) {
            for (int k = 0; k < sheet.getRow(0).getLastCellNum(); k++) {
                data[i][k] = sheet.getRow(i + 1).getCell(k).toString();
                // System.out.println(data[i][k]);
            }
        }
        return data;
    }

    public static String takeScreenShot() throws IOException {
        String screenshotloc;
        File sourcePath = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        File destinationPath = new File(System.getProperty("user.dir") + "/screenshots/" + System.currentTimeMillis() + ".png");
        screenshotloc = destinationPath.getAbsolutePath().toString();
        System.out.println("Sslocation: " + screenshotloc.toString());
        Files.copy(sourcePath, destinationPath.getAbsoluteFile());
        return screenshotloc;
    }

    public static void readingWebtable(String searchitem, WebElement table) {
        List < WebElement > rows = table.findElements(By.tagName("tr"));
        for (WebElement row: rows) {
            List < WebElement > cells = row.findElements(By.tagName("td"));
            for (WebElement cell: cells) {
                String k = cell.getText();
                if (k.equals(searchitem)) {
                    System.out.println("Cell: " + cell);
                    System.out.println("Cell value: " + k);
                    cell.click();
                    break;
                }
            }
        }
    }
    public static void readingWebtable1(String searchitem, WebElement table) {
        table.findElements(By.tagName("tr")).stream().collect(Collectors.toList())
            .forEach(x -> x.findElements(By.tagName("td"))
                .stream().filter(y -> y.getText().equals(searchitem)).findFirst().get().click());
    }

    public static void readingtable(String searchitem, WebElement table) {
        List < WebElement > rows = driver.findElements(By.xpath("//table[starts-with(@id,':2')]//tbody//tr"));
        int rowNum = rows.size();
        List < WebElement > cols = driver.findElements(By.xpath("//table[starts-with(@id,':2')]//tbody//tr[1]//td"));
        int colNum = cols.size();
        for (int i = 1; i <= rowNum; i++) {
            String s = driver.findElement(By.xpath("//table[starts-with(@id,':2')]//tbody//tr[" + i + "]//td[4]")).getText();
            System.out.println(s);
            if (s.equals(searchitem)); {
                driver.findElement(By.xpath("//table[starts-with(@id,':2')]//tbody//tr[" + i + "]//td[4]")).click();
                break;
            }
        }
    }
    public static void readingWebtableWrittingIntoExcel(String searchitem, WebElement table) {
        List < WebElement > rows = table.findElements(By.tagName("tr"));
        for (WebElement row: rows) {
            List < WebElement > cells = row.findElements(By.tagName("td"));
            for (WebElement cell: cells) {
                String k = cell.getText();    
            }
        }
    }
    public static void switchToWindow() {
        String s = driver.getWindowHandle();
        Set < String > winhandles = driver.getWindowHandles();
        Iterator < String > itr = winhandles.iterator();
        while (itr.hasNext()) {
            String childWindow = itr.next();
            if (!s.equals(childWindow)); {
                driver.switchTo().window(childWindow);
            }
        }
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