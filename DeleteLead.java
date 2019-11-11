package week2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteLead {

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
    driver.findElementByXPath("//span[text()='Phone']").click();
    driver.findElementByName("phoneNumber").sendKeys("9999999999");
    driver.findElementByXPath("//button[text()='Find Leads']").click();
    Thread.sleep(2000);
    String text = driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a").getText();
    driver.findElementByXPath("//div[@class='x-grid3-cell-inner x-grid3-col-partyId']//a").click();
driver.findElementByXPath("//a[text()='Delete']").click();
driver.findElementByLinkText("Find Leads").click();
driver.findElementByName("id").sendKeys(text);
driver.findElementByXPath("//button[text()='Find Leads']").click();
Thread.sleep(2000);
String text1 = driver.findElementByXPath("//div[@class='x-paging-info']").getText();
System.out.println(text1);
if(text1.equals("No records to display"))
{
	System.out.println("Test Passed");
}
else
{
	System.out.println("Test Failed");
}
driver.close();

}
	}


