package week2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class DuplicateLead {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
        driver.manage().window().maximize();
    	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
        driver.findElementById("username").sendKeys("DemoSalesManager");
        driver.findElementById("password").sendKeys("crmsfa");
       
        driver.findElementByClassName("decorativeSubmit").click();
        driver.findElementByLinkText("CRM/SFA").click();
        driver.findElementByLinkText("Leads").click();
        driver.findElementByLinkText("Find Leads").click();
        driver.findElementByXPath("//span[text()='Email']").click();
        driver.findElementByXPath("//input[@name='emailAddress']").sendKeys("nirmalraj@gmail.com");
        driver.findElementByXPath("//button[text()='Find Leads']").click();
        Thread.sleep(2000);
        String firstname = driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a[1])[1]").getText().toString();
        System.out.println(firstname);
        driver.findElementByXPath("(//div[@class='x-grid3-cell-inner x-grid3-col-firstName']//a[1])[1]").click();
        driver.findElementByLinkText("Duplicate Lead").click();
        String title = driver.getTitle();
        if(title.startsWith("Duplicate Lead"))
        {
        	System.out.println("verified");
        }
        
        driver.findElementByClassName("smallSubmit").click();
        String text = driver.findElementById("viewLead_firstName_sp").getText();
        
        if(firstname.equals(text))
        {
        	System.out.println("first name created");
        }
        
        
        driver.close();
	}

}
