package emailAutomation;

import org.testng.annotations.Test;

import com.qa.base.TestBase;

public class emailtest {
	emailReading obj;
@Test()
public void mailTextread() throws InterruptedException {
    
	TestBase.initialization("https://accounts.google.com/signin", "FF");
	obj=new emailReading();
	obj.loginEmail("bandarukrishnatesting@gmail.com", "F3qjt@2252");
	
	//TestBase.close_browser();
}
}
