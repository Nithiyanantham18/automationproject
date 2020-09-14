package com.automation.baseclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Baseclass {
	public static WebDriver driver;

	public static WebDriver Browser(String browserName) {
		try {
			if (browserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver",
						"C:\\Users\\HP\\workspace\\SeleniumProject\\Driver\\chromedriver.exe");
				driver = new ChromeDriver();
			} else if (browserName.equalsIgnoreCase("ie")) {
				System.setProperty("webdriver.ie.driver",
						"C:\\Users\\HP\\workspace\\SeleniumProject\\Driver\\chromedriver.exe");
				driver = new InternetExplorerDriver();
			} else if (browserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver",
						"C:\\Users\\HP\\workspace\\SeleniumProject\\Driver\\chromedriver.exe");
				driver = new FirefoxDriver();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// driver.manage().window().maximize();
		return driver;
	}

	public static void getUrl(String url) {
		driver.get(url);
	}

	public static void currentUrl() {
		driver.getCurrentUrl();

	}

	public static void forward() {
		driver.navigate().forward();
	}

	public static void backward() {
		driver.navigate().back();

	}

	public static void refresh() {
		driver.navigate().refresh();
	}

	public static void close() {
		driver.close();

	}

	public static void quite() {
		driver.quit();
	}

	public static void getTitle() {
		driver.getTitle();
	}

	
	public static void Dropdown(WebElement element, String Option, String value) {
		Select sc = new Select(element);

		try {
			if (Option == "Index") {
				int parseInt = Integer.parseInt(value);
				sc.selectByIndex(parseInt);
			} else if (Option == "Value") {
				sc.selectByValue(value);
			} else if (Option == "VisibleText") {
				sc.selectByVisibleText(value);
			} else {
				System.out.println("Invalid option");
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public static void inputValueElement(WebElement element, String value) throws InterruptedException {
		Thread.sleep(2000);
		element.sendKeys(value);

	}

	public static void clickOnElement(WebElement element) throws InterruptedException {
		Thread.sleep(2000);
		element.click();
	}

	public static void simpleAlert() {
		driver.switchTo().alert().accept();

	}

	public static void confirmAlert(String ok, String cancel) {
		if (ok.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().accept();

		} else if (cancel.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().dismiss();

		}
	}

	public static void promptAlert(String ok, String value, String cancel) {
		if (ok.equalsIgnoreCase("ok")) {
			driver.switchTo().alert().sendKeys(value);
			driver.switchTo().alert().accept();

		} else if (cancel.equalsIgnoreCase("cancel")) {
			driver.switchTo().alert().sendKeys(value);
			driver.switchTo().alert().accept();

		}
	}

	public static void actionMethod(WebElement Element) {
		Actions ac = new Actions(driver);
		ac.contextClick(Element).build().perform();

	}

	public static void dragDrop(WebElement Element, WebElement Element1) {
		Actions ad = new Actions(driver);
		ad.dragAndDrop(Element, Element1).build().perform();

	}

	public static void robotClass() throws AWTException {
		Robot rb = new Robot();
		rb.keyPress(KeyEvent.VK_DOWN);
		rb.keyRelease(KeyEvent.VK_DOWN);
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);

	}

	public void scrollUp(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", element);
	}

	public void scrollDown(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].scrollIntoView();", element);
	}

	 public static void SwitchtoframeusingId(String option, int index){
		    try {
		    	if (option.equals("id")) {
		    		driver.switchTo().frame(index);
		    	}
		    }
		     catch (Exception e) {
		    	 e.printStackTrace();
		     }
		     }
		    public static void SwitchtoframeusingName(String option, String framename, WebElement element){
		        try {
		        	waitElementVisibility(element);
		        	if (option.equals("name")) {
		        		driver.switchTo().frame(framename);
		        	}
		        }
		         catch (Exception e) {
		        	 e.printStackTrace();
		         }
		         }
		    public static void SwitchtoframeusingElement(String option, WebElement element){
		        try {
		    	
		        	if (option.equals("element")) {
		        		driver.switchTo().frame(element);
		        	}
		        }
		         catch (Exception e) {
		        	 e.printStackTrace();
		         }
		         }

	public void elementClear(WebElement element) {
		element.clear();

	}





public static void waitElementVisibility(WebElement element){

    try {
		WebDriverWait wb = new WebDriverWait(driver, 30);
		wb.until(ExpectedConditions.visibilityOf(element));
		
	} catch (Exception e) {
		e.printStackTrace();
	}
	}



public static   WebDriver implicitwait(int number){
	try {
		driver.manage().timeouts().implicitlyWait(number, TimeUnit.SECONDS);
		return driver;
	} catch (Exception e) {
		e.printStackTrace();
	}
	return driver;
}
}