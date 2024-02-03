package genericUtilities;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility {

	WebDriver driver;
	
	public WebDriver launchrBrowserAndMaximize(String browser) {
		
		switch (browser) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
			driver = new ChromeDriver();
			break;
		case"firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new FirefoxDriver();
			break;
		case "edge":
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		break;
		default:
			System.out.println("Invalid browser info");
		}
		driver.manage().window().maximize();
		return driver;
		
			
		}
	public void navigateToApp(String url) {
		driver.get(url);
	}
	public void waitTillElementFound(long time) {
		driver.manage().timeouts().implicitlyWait(time,  TimeUnit.SECONDS);
	}
	public WebElement explicitWait(webElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver,time);
		return wait.until(ExpectedCondition.elementToBeClicked(element));
		
	}
	public Boolean explicitWait(long time, String title) {
		WebDriverWait wait = new WebDriverWait(driver, time);
		return Wait.until(ExpectedConditions.titleContains(title));	
	}
	public void mouseHoverToElement() {
		Actions action = new Actions(driver);
		action.contextClick(element).perform();
	}
	public void dragAndDropAnElement(WebElement element, WebElement target) {
		Actions action = new Actions(driver);
		action.dragAndDrop(element, target).perform();
	}
	public void switchToFrame(int index) {
		driver.switchTo().frame(index);
	}
	public void switchtToFrame(String idOrName) {
		driver.switchTo().frame(idOrName);
	}
	public void switchToFrame(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}
	public void switchBackFromFrame() {
		driver.switchTo().defaultContent();
	}
	public void selectFromDropdown(WebElement element, int index) {
		Select select = new Select(element);
		select.selectByIndex(index);
	}
	public void selectFromDropdown(WebElement element, String value) {
		Select select = new Select(element);
		select.selectByValue(value);
	}
	public void selectFromDropdown(String text, WebElement element) {
		Select select = new Select(element);
		select.selectByVisibleText(text);
	}
 public List<WebElement> getDropdownList(WebElement element){
	Select select = new Select(element);
	return select.getOptions();
 
 }
 public void captureScreenshot(WebDriver driver, JavaUtility jutil, String className) {
	 TakesScreenshot ts = (TakesScreenshot)driver;
	 File src = ts.getScreenshotAs(OutputType.FILE);
	 File dest = new File("./Screenshot/"+className+"_"+jutil.getCurrentTime()+".png");
	 try {
		 FileUtils.copyFile(src, dest);
	 } catch (IOException e) {
		 e.printStackTrace();
	 }
 }
public void quitAllWindows() {
	// TODO Auto-generated method stub
	
}
}