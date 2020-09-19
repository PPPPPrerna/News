package quick.NewFeatures;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;


public class NeTest {

	@Test
	public void cdf() throws IOException {
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Dr Pramod Pandey\\Desktop\\Chrome driver\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://rahulshettyacademy.com/angularpractice/");
		
		//driver.findElement(withTagName("label").above("//input[@name='name']"));
		
		driver.switchTo().newWindow(WindowType.TAB);
		
		Set<String> handles=driver.getWindowHandles();
		
		Iterator<String> it =handles.iterator();
		
		String parentWindow = it.next();
		
		String childWindow=it.next();
		driver.switchTo().window(childWindow);
		
		driver.get("https://rahulshettyacademy.com/#/index");
		
	String web	=driver.findElements(By.xpath("//div[@class='upper-box']/h2")).get(0).getText();
	
	driver.switchTo().window(parentWindow);
	
         WebElement name = driver.findElement(By.xpath("//div[@class='form-group']/input"));
         
         name.sendKeys(web);
	
	File file=name.getScreenshotAs(OutputType.FILE);
	
	FileUtils.copyFile(file, new File("logo.png"));
	
		
		
		

		
	}
}
