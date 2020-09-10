package selenium.assignments;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Amazon {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver","./drivers1/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementById("twotabsearchtextbox").sendKeys("outslayer",Keys.DOWN,Keys.ENTER);
		//WebDriverWait wait = new WebDriverWait(driver,5);
		//wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//div[@id='suggestions']/div)[1]")))).click();
	    List<WebElement> price = driver.findElementsByXPath("//span[@class='a-price-whole']");
	    List<Integer> newprice = new ArrayList<Integer>();
	    for(WebElement ea:price)
	    {
	    	String text= ea.getText().replaceAll("[^0-9]", "");
	    	newprice.add(Integer.parseInt(text));
	    		
	    	}
	    System.out.println(newprice);
	    //Collections.sort(newprice);
	    System.out.println(newprice);
	    int size = newprice.size();
	    System.out.println("the size of the list is " + size);
	    System.out.println("the maximum price is " + Collections.max(newprice));
	    price.get(newprice.indexOf(Collections.max(newprice))).click();
	    Set<String> allWindows = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(allWindows);
		String desiredWindow = list.get(1);
		driver.switchTo().window(desiredWindow);
		System.out.println("opened the new window");
		driver.findElementById("add-to-cart-button").click();
		driver.findElementById("hlb-ptc-btn-native").click();
		driver.findElementById("continue").click();
		String errormsg = driver.findElementByXPath("(//div[@class='a-alert-content'])[2]").getText();
		String text1= "Enter your email or mobile phone number";
		if(errormsg.equals(text1))
		{
			System.out.println("the error msg is verified successfully");
		}
		else
		{
			System.out.println("oops sorry");
		}
	    }
		
	}



