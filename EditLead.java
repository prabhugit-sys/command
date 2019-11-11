package week2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.chrome.ChromeDriver;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		String companyname="accenture";
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("http://leaftaps.com/opentaps");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	    driver.findElementById("username").sendKeys("DemoSalesManager");
	    driver.findElementById("password").sendKeys("crmsfa");	   
	    driver.findElementByClassName("decorativeSubmit").click();
	    driver.findElementByLinkText("CRM/SFA").click();
	    driver.findElementByLinkText("Create Lead").click();
	    driver.findElementByLinkText("Find Leads").click();
	    driver.findElementByXPath("(//div[@class='x-form-element']/input[@name='firstName'])[3]").sendKeys("Nirmal");
	    driver.findElementByXPath("//button[text()='Find Leads']").click();
	    Thread.sleep(2000);
		driver.findElementByXPath("(//td[@class='x-grid3-col x-grid3-cell x-grid3-td-firstName ']//a)[1]").click();
		String string = driver.getTitle().toString();
		if(!string.isEmpty())
		{
			System.out.println("Title is verified\t"+string);
		}
		driver.findElementByLinkText("Edit").click();		
        driver.findElementById("updateLeadForm_companyName").clear();
        driver.findElementById("updateLeadForm_companyName").sendKeys("accenture");
        driver.findElementByXPath("//input[@value='Update']").click();
        String company = driver.findElementById("viewLead_companyName_sp").getText().toString();
        if(company.contains(companyname))
        {
        	System.out.println("Changed name appears correctly");
        }
        
        driver.close();
        
	}

}
