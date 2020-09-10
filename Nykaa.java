package selenium.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./drivers1/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(5000);
		Actions act= new Actions(driver);
		WebElement brand = driver.findElementByXPath("//li[@class='menu-dropdown-icon']/a");
		act.moveToElement(brand).build().perform();
		driver.findElementByLinkText("L'Oreal Paris").click();
		String title = driver.getTitle();
		System.out.println(title);
		String desiredtitle="L'Oreal Paris";
		if(title.contains(desiredtitle))
		{
			System.out.println("The window opened is correct");
		}
		else
		{
			System.out.println("the window opened is incorrect");
		}
		driver.findElementByXPath("//span[text()='Sort By : ']").click();
		Thread.sleep(5000);
		driver.findElementByXPath("//span[text()='customer top rated']").click();
		//new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(By.xpath("//div[text()='Category']"))).click();
		Thread.sleep(5000);
		driver.findElementByXPath("//div[text()='Category']").click();
		driver.findElementByXPath("//span[text()='Shampoo (62)']").click();
		String text = driver.findElementByXPath("//ul[@class='pull-left applied-filter-lists']").getText();
		System.out.println(text);
		String chosenvalue="Shampoo";
		if(text.contains(chosenvalue))
		{
			System.out.println("The filter is verified successfully");
		}
		//Thread.sleep(5000);
		Actions a= new Actions(driver);
		//new WebDriverWait(driver, 50).until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@class='m-content__product-list__title'])[6]"))).click();
		WebElement sh = driver.findElementByXPath("(//div[@class='card-img'])[6]");
		a.moveToElement(sh).click().build().perform();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		String desiredwindow = list.get(1);
		driver.switchTo().window(desiredwindow);
		driver.findElementByXPath("//span[@class='size-pallets']").click();
		String text2 = driver.findElementByXPath("//span[@class='post-card__content-price-offer']").getText();
		String price = text2.replaceAll("[^0-9]","");
		int price1 = Integer.parseInt(price);
		System.out.println("The MRP of the product is "+ price1);
		driver.findElementByXPath("//button[text()='ADD TO BAG']").click();
		driver.findElementByClassName("AddBagIcon").click();
		String total = driver.findElementByXPath("//div[@class='value medium-strong']").getText();
		String total1 = total.replaceAll("[^0-9]","");
		System.out.println(total1);
		Thread.sleep(5000);
		driver.findElementByXPath("//button[@class='btn full fill no-radius proceed ']").click();
		driver.findElementByXPath("//button[@class='btn full big']").click();
		String msg = driver.findElementByXPath("//div[@class='layout horizontal center message flex-1']").getText();
		String expectedmsg="Due to COVID, delivery may take longer than usual";
		if(msg.equals(expectedmsg))
		{
			System.out.println("Covid Msg is verified successfully");
		}
		else
		{
			System.out.println("Incorrect msg");
		}
		driver.quit();
	}

}
