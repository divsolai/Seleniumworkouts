package selenium.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Ajio {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver","./drivers1/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://www.ajio.com/shop/women");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Actions act = new Actions(driver);
		WebElement womenele = driver.findElementByXPath("//a[text()='WOMEN']");
		act.moveToElement(womenele).build().perform();
		driver.findElementByXPath("(//a[text()='Kurtas'])[2]").click();
		driver.findElementByXPath("(//span[@class='facet-left-pane-label'])[4]").click();
		driver.findElementByXPath("//label[@class='facet-linkname facet-linkname-brand facet-linkname-AJIO']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//div[@class='filter-dropdown']").click();
		driver.findElementByXPath("//option[text()='Discount']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//div[@class='name']").click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(allWindows);
		String desiredWindow = list.get(1);
		driver.switchTo().window(desiredWindow);
		System.out.println("opened the new window");
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		String error = driver.findElementByXPath("//span[text()='Please select a size']").getText();
		String text1="Please select a size";
		if(error.equals(text1))
		{
			System.out.println("error msg is verified");
		}
		else
		{
			System.out.println("error msg does not match");
		}
		driver.findElementByXPath("(//div[@class='circle size-variant-item size-instock '])[3]").click();
		driver.findElementByXPath("//span[text()='ADD TO BAG']").click();
		Thread.sleep(5000);
		WebElement pincode = driver.findElementByXPath("//span[text()='Enter Pin-code To Know Estimated Delivery Date']");
		new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(pincode)).click();
		driver.findElementByName("pincode").sendKeys("603103");
		driver.findElementByXPath("//button[@class='edd-pincode-modal-submit-btn']").click();
		String deliverydate = driver.findElementByXPath("//div[@class='edd-message-success-container']").getText();
		System.out.println(deliverydate);
		driver.findElementByXPath("//span[text()='GO TO BAG']").click();
		driver.findElementByXPath("//button[@class='rilrtl-button button shipping-button']").click();
		System.out.println("order places successfully");
		driver.quit();

//List<WebElement> items = driver.findElementsByClassName("items");
List<WebElement> brname = driver.findElementsByXPath("//div[@class='brand']");
int size= brname.size();
System.out.println("the size " + size);
List<String> brand = new ArrayList<String>();
List<String> diffbrand = new ArrayList<String>();
for(WebElement ea:brname)
{

	ea.getText();
	String brname1="AJIO";
	if(ea.getText().equals(brname1))
	{
	brand.add(ea.getText());
    }
	else
	{
		diffbrand.add(ea.getText());
	}
	}
System.out.println(brand);
System.out.println(brand.size());
System.out.println(diffbrand);
System.out.println(diffbrand.size());
}
}
