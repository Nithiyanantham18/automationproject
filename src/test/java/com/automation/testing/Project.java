package com.automation.testing;

import java.util.concurrent.TimeUnit;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.automation.baseclass.Baseclass;
import com.automation.pom.Addtocart;
import com.automation.pom.Homepage;
import com.automation.pom.Signin;


public class Project extends Baseclass {
	public static WebDriver driver;
	
	//public static void main(String[] args) throws InterruptedException {
	@Test
	public void test() throws Throwable {
		driver = Browser("chrome");
		getUrl("http://automationpractice.com/index.php");
		Homepage hp = new Homepage(driver);
		clickOnElement(hp.getSignin());

		Signin sp = new Signin(driver);
		inputValueElement(sp.getEmail(), "nithi09@gmail.com");
		inputValueElement(sp.getPassword(), "nithi");
		clickOnElement(sp.getSubmit());

		Addtocart ac = new Addtocart(driver);
		actionMethod(ac.getWomen());
		clickOnElement(ac.getCasualdress());
		clickOnElement(ac.getView());
	//	driver.switchTo().frame(0);
		clickOnElement(ac.getCart());
		clickOnElement(ac.getProceed());
		clickOnElement(ac.getCheckout());
		clickOnElement(ac.getProceeds());
		clickOnElement(ac.getCheckboxs1());
		clickOnElement(ac.getShipping());
		clickOnElement(ac.getCheque());
		clickOnElement(ac.getOrder());

	}




	}
