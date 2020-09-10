package selenium.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Salesforce {

	public static void main(String[] args) throws InterruptedException {
		ChromeOptions options = new ChromeOptions();

		//Add chrome switch to disable notification - "**--disable-notifications**"
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver","./drivers1/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver(options);
		driver.get("https://login.salesforce.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		//Enter UserName and Password Using Id Locator
		driver.findElementById("username").sendKeys("samdavid@testleaf.com");
		driver.findElementById("password").sendKeys("samchennai92");
		driver.findElementById("Login").click();
		
		driver.findElementByXPath("//span[text()='Create']").click();
		driver.findElementByXPath("//a[@title='User']").click();
		WebElement frame1 = driver.findElementByXPath("//iframe[@title='New User ~ Salesforce - Developer Edition']");
        driver.switchTo().frame(frame1);
		driver.findElementById("name_lastName").sendKeys("div");
		driver.findElementById("Alias").sendKeys("sol");
		driver.findElementById("Email").sendKeys("abcde@xyz.com");
		driver.findElementById("Username").clear();
		driver.findElementById("Username").sendKeys("divs@gmail.com");
		driver.findElementById("CommunityNickname").clear();
		driver.findElementById("CommunityNickname").sendKeys("divi");
		/*WebElement drop1 = driver.findElementById("role");
		Select opt1 =new Select (drop1);
		opt1.selectByIndex(5);
		WebElement drop2 = driver.findElementById("role");
		Select opt2 =new Select (drop2);
		opt1.selectByIndex(5);*/
		WebElement drop3 = driver.findElementById("Profile");
		Select opt3 =new Select (drop3);
		opt3.selectByIndex(1);
		driver.findElementByXPath("(//img[@class='lookupIcon'])[3]").click();
		Set<String> allWindows = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(allWindows);
		String desiredWindow = list.get(1);
		driver.switchTo().window(desiredWindow);
		System.out.println("opened the new window");
		driver.switchTo().frame("searchFrame");
		driver.findElementById("lksrch").sendKeys("r");
		driver.findElementByName("go").click();
		driver.switchTo().defaultContent();
		WebElement frame2 = driver.findElementByXPath("//frame[@title='Results']");
		driver.switchTo().frame(frame2);
		driver.findElement(By.xpath("//table//tbody//tr[2]//th//a")).click();
		driver.switchTo().window(list.get(0));
	 	System.out.println("switched back to parent window");
	 	driver.switchTo().frame(frame1);
		driver.findElementByXPath("(//img[@class='lookupIcon'])[4]").click();
		Set<String> allWindows1 = driver.getWindowHandles();
		List<String> list1 = new ArrayList<String>(allWindows1);
		String desiredWindow1 = list1.get(1);
		driver.switchTo().window(desiredWindow1);
		System.out.println("opened the new window");
		WebElement frame3 = driver.findElementByXPath("//frame[@title='Results']");
		driver.switchTo().frame(frame3);
		driver.findElement(By.xpath("//table//tbody//tr[2]//th//a")).click();
		driver.switchTo().window(list1.get(0));
	 	System.out.println("switched back to parent window");
	 	driver.switchTo().frame(frame1);
		driver.findElementByName("save").click();
}
}