package week2.assignment;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.chrome.ChromeDriver;

public class MergeLead {

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
    driver.findElementByLinkText("Create Lead").click();
    driver.findElementByLinkText("Merge Leads").click();
    driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[1]").click();
    
    Set<String> windowHandles = driver.getWindowHandles();
    List<String> allwindow = new ArrayList<String>(windowHandles);  
    driver.switchTo().window(allwindow.get(1));   
    driver.findElementByName("firstName").sendKeys("a");
    driver.findElementByXPath("//button[text()='Find Leads']").click();
    Thread.sleep(2000);
    String FromLead=driver.findElementByXPath("(//a[@class='linktext'])[1]").getText();
    driver.findElementByXPath("(//a[@class='linktext'])[1]").click();   
    driver.switchTo().window(allwindow.get(0));
    
    driver.findElementByXPath("(//img[@src='/images/fieldlookup.gif'])[2]").click();
    
    
    Set<String> windowHandles1 = driver.getWindowHandles();
    List<String> allwindow1 = new ArrayList<String>(windowHandles1);
    driver.switchTo().window(allwindow1.get(1));
    driver.findElementByName("firstName").sendKeys("v");
    driver.findElementByXPath("//button[text()='Find Leads']").click();
    Thread.sleep(2000);
    driver.findElementByXPath("(//a[@class='linktext'])[1]").click();
    driver.switchTo().window(allwindow.get(0));
    
    driver.findElementByLinkText("Merge").click();
    Alert alert = driver.switchTo().alert();
    alert.accept();
    
    driver.findElementByLinkText("Find Leads").click();
    driver.findElementByName("id").sendKeys(FromLead);
    driver.findElementByXPath("//button[text()='Find Leads']").click();
    Thread.sleep(2000);
    String text = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
	System.out.println(text);
    if(text.equals("No records to display"))
	{
		System.out.println("Test Passed");
	}
	else
	{
		System.out.println("Test Failed");
	}
	
	}

}
