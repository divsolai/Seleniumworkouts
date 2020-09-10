package selenium.assignments;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class Honda {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver","./drivers1/chromedriver.exe");
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.honda2wheelersindia.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.findElementByClassName("close").click();
		Thread.sleep(5000);
		driver.findElementById("link_Scooter").click();
		driver.findElementByXPath("(//div[@class='item']/a)[8]").click();
		driver.findElementByXPath("//a[text()='Specifications']").click();
		Thread.sleep(5000);
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElementByXPath("//a[text()='ENGINE']")).build().perform();
		String value = driver.findElementByXPath("((//ul[@class='tab_content']/li)[12]/span)[2]").getText();
		System.out.println("The Engine displacement value of duo is "+ value);
		driver.findElementById("link_Scooter").click();
		Thread.sleep(5000);
		driver.findElementByXPath("(//div[@class='item']/a)[10]").click();
		driver.findElementByXPath("//a[text()='Specifications']").click();
		Thread.sleep(5000);
		Actions action1 = new Actions(driver);
		action.moveToElement(driver.findElementByXPath("//a[text()='ENGINE']")).build().perform();
		String value1 = driver.findElementByXPath("((//ul[@class='tab_content']/li)[12]/span)[2]").getText();
		System.out.println("The Engine displacement value of Activa125 is "+ value1);
		String text= value1.replaceAll("[^0-9]", "");
		float activa = Float.parseFloat(text);
		System.out.println(activa);
		String text1= value.replaceAll("[^0-9,^.]", "");
		float duo = Float.parseFloat(text1);
		System.out.println(duo);
		if(activa>duo) {
			System.out.println("Activa125 is better compared to duo");
		}else
		{
			System.out.println("Duo is better compared to Activa125");
		}
		driver.findElementByLinkText("FAQ").click();
		driver.findElementByLinkText("Activa 125 BS-VI").click();
		driver.findElementByXPath("//li[@id='li6']").click();
		WebElement drop1 = driver.findElementByName("ModelID");
		Select opt1= new Select(drop1);
		opt1.selectByVisibleText("Activa 125 BS-VI");
		driver.findElementById("submit6").click();
		driver.findElementByLinkText("Click here to know the price of Activa 125 BS-VI.").click();
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> allwindows= new ArrayList<>(windowHandles);
		String newwindow = allwindows.get(1);
		driver.switchTo().window(newwindow);
		WebElement drop2 = driver.findElementById("StateID");
		Select opt2= new Select(drop2);
		opt2.selectByVisibleText("Tamil Nadu");
		WebElement drop3 = driver.findElementById("CityID");
		Select opt3= new Select(drop3);
		opt3.selectByVisibleText("Chennai");
		driver.findElementByXPath("//button[text()='Search']").click();
		WebElement eleTable = driver.findElementById("gvshow");
		List<WebElement> allRows = eleTable.findElements(By.tagName("tr"));
		System.out.println("The total number of rows in the table" + allRows.size());
		for (int i = 1; i < allRows.size(); i++) {
			WebElement eachRow = allRows.get(i);
			List<WebElement> AllCol = eachRow.findElements(By.tagName("td"));
			for (int j = 1; j < AllCol.size(); j++) {
				WebElement cell = AllCol.get(j);
				String textp = cell.getText();
				System.out.println(textp + "\t");
			}
	   // System.out.println(driver.findElementByXPath("//table[@id='gvshow']/tbody/tr/td[2]").getText());
	    //System.out.println(driver.findElementByXPath("//table[@id='gvshow']/tbody/tr/td[3]").getText());
		//driver.quit();
	}
	}
}


