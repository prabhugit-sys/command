package week2.assignment;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateLead {

	public static void main(String[] args) {
		
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
    driver.findElementById("createLeadForm_companyName").sendKeys("TestLeaf");
    driver.findElementById("createLeadForm_firstName").sendKeys("Nirmal",Keys.TAB,"Raj");
    driver.findElementById("createLeadForm_firstNameLocal").sendKeys("Nirmal",Keys.TAB,"Raj",Keys.TAB,"HELLO");
    WebElement Source = driver.findElementById("createLeadForm_dataSourceId");
    Select dd = new Select(Source);
    dd.selectByVisibleText("Cold Call");
    driver.findElementById("createLeadForm_generalProfTitle").sendKeys("Mr");
    driver.findElementById("createLeadForm_annualRevenue").sendKeys("50000");
    WebElement Industry = driver.findElementById("createLeadForm_industryEnumId");
    Select dd2 = new Select(Industry);
    dd2.selectByIndex(0);
    WebElement owner = driver.findElementById("createLeadForm_ownershipEnumId");
    Select dd3 = new Select(owner);
    dd3.selectByIndex(0);
    driver.findElementById("createLeadForm_sicCode").sendKeys("200");
    driver.findElementById("createLeadForm_description").sendKeys("Selenium Webpage");
    driver.findElementById("createLeadForm_importantNote").sendKeys("Testing");
    driver.findElementById("createLeadForm_primaryPhoneCountryCode").sendKeys("IN");
    driver.findElementById("createLeadForm_primaryPhoneAreaCode").sendKeys("600000");
    driver.findElementById("createLeadForm_primaryPhoneExtension").sendKeys("11");
    driver.findElementById("createLeadForm_departmentName").sendKeys("Testing");
    WebElement currency = driver.findElementById("createLeadForm_currencyUomId");
    Select dd4 = new Select(currency);
    dd4.selectByValue("USD");
    driver.findElementById("createLeadForm_numberEmployees").sendKeys("2");
    driver.findElementById("createLeadForm_tickerSymbol").sendKeys("$");
    driver.findElementById("createLeadForm_primaryPhoneAskForName").sendKeys("Nirmal");
    driver.findElementById("createLeadForm_primaryWebUrl").sendKeys("http://www.google.com");
    driver.findElementById("createLeadForm_generalToName").sendKeys("Nirmal");
    driver.findElementById("createLeadForm_generalAddress1").sendKeys("147 sai nagar",Keys.TAB,"vetri street");
    driver.findElementById("createLeadForm_generalCity").sendKeys("Chennai");
    WebElement state = driver.findElementById("createLeadForm_generalStateProvinceGeoId");
    Select dd5 = new Select(state);
    dd5.selectByValue("TX");
    WebElement country = driver.findElementById("createLeadForm_generalCountryGeoId");
    Select dd6 = new Select(country);
    dd6.selectByValue("IND");
    driver.findElementById("createLeadForm_generalPostalCode").sendKeys("600000");
    driver.findElementByName("generalPostalCodeExt").sendKeys("11");
    WebElement market = driver.findElementById("createLeadForm_marketingCampaignId");
    Select dd7 = new Select(market);
    dd7.selectByValue("CATRQ_AUTOMOBILE");
    driver.findElementById("createLeadForm_primaryPhoneNumber").sendKeys("9999999999");
    driver.findElementById("createLeadForm_primaryEmail").sendKeys("nirmalraj@gmail.com");	
    driver.findElementByXPath("//input[@name='submitButton']").click();
    String firstname = driver.findElementById("viewLead_firstName_sp").getText().toString();
    if (firstname.isEmpty())
    {
    	System.out.println("first name is not verified");
    }
    else
    {
    	System.out.println("firstname is verified");
    }
	}

}
