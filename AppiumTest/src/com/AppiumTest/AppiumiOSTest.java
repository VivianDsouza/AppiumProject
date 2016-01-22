package com.AppiumTest;

import io.appium.java_client.ios.IOSDriver;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class AppiumiOSTest {
	
	private IOSDriver driver;
	
	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "iOS");
		caps.setCapability("platformVersion", "8.4.1"); //Replace this with your iOS version
		//caps.setCapability("deviceName", "RTPL-iPhone6S-247"); //Replace this with your simulator/device version
		caps.setCapability("deviceName", "Winston-iPad2-332"); //Replace this with your simulator/device version
		caps.setCapability("app", "/Users/vivian/Downloads/HP WallArt Robosoft.ipa"); //Replace this with app path in your system
		caps.setCapability("autoAcceptAlerts",true);
		driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), caps);
	}
	
	/*@Test(priority=0)
	public void latexToGo() throws InterruptedException {
		//driver.findElement(By.name("OK")).click();
		System.out.println("Done 1");
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAButton[2]")).click();
		System.out.println("Done 2");
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")).sendKeys("latex100@yopmail.com");
		System.out.println("Done 3");
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]")).click();
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASecureTextField[1]")).sendKeys("qwerty");
		System.out.println("Done 4");
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]")).click();
		Thread.sleep(10000);
		System.out.println("Done 5");
		
		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[3]/UIAButton[7]")).click();//Tapping on Balck Ink
		//Thread.sleep(10000);
		//System.out.println("Done 6");

		//driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIACollectionView[1]/UIACollectionCell[2]")).click();//Tapping on Jobs Tab
		//driver.findElement(By.name("Jobs")).click();
		driver.tap(1,134,526,1);

		System.out.println("Done 7");


		//driver.findElement(By.name("Back")).click();
	}*/

	
	@Test(priority=1)
	public void wallArt() throws InterruptedException {
		WebDriverWait myWaitVAr = new WebDriverWait(driver, 20);
		Thread.sleep(10000);
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]")).click();//Do not show dialog used in video
		System.out.println("Done 1");
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[2]")).click();//Do not show dialog tap close button used in video
		System.out.println("Done 2");
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[5]")).click();// Tap continue from informative dialog about PSP
		System.out.println("Done 3");
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATableView[1]/UIATableCell[1]")).click();//Tap on Demo PSP label
		System.out.println("Done 5");
		
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[4]")).click();//Tap on OK button from select PSP button.
		System.out.println("Done 6");

		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[1]")).click();//Tap on Create new design.
		System.out.println("Done 7");
		
		//Settings dialog
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")).click();//Provide name in settings dialog.
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")).sendKeys("vivian");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]")).click();//Provide emailID in settings dialog.
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[2]")).sendKeys("vivian@test.com");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[3]")).click();//Click OK from settings dialog.
		System.out.println("Done 8");
		
		//Wait designer to load
		try{
			myWaitVAr.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAStaticText[4]")));
			} catch (TimeoutException toe) { 
				System.out.println(toe.toString());
				}
		//Initiate design
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[12]")).click();//Click on WallPoster option
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")).click();//provide design name
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[1]")).sendKeys("MyNewAutomatedDesign");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[2]/UIAKeyboard[1]/UIAButton[6]")).click();//Remove keyboard
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[15]")).click();//Click on done button from initiate dialog
		Thread.sleep(10000);
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[10]")).click();//Click on continue button from success dialog
		System.out.println("Done 10");

		/*//Update size
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[3]")).click();//Click on Width Field
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[3]")).clear();//Click on Width Field

		List<WebElement> datePicker = driver.findElements(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAPicker[1]/UIAPickerWheel[1]"));
			datePicker.get(0).sendKeys("40");
		
			driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[5]")).click();//Click on Width Field
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIATextField[5]")).clear();//Clear on Width Field
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAPicker[1]/UIAPickerWheel[1]")).sendKeys("40");
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[22]")).click();//Click on Update Field
		System.out.println("Done 11");*/

		//Change Wall Color
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[28]")).click();//Click on Update Field
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[21]")).click();//Click on Select color drop down
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAPopover[1]/UIAButton[21]")).click();//Click on More color drop down
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[11]")).click();//Click on side button in More color drop down
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASlider[3]")).click();//Click on B slider button in More color drop down
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIASlider[3]")).sendKeys("50");//Click on B slider button in More color drop down
		driver.findElement(By.xpath("//UIAApplication[1]/UIAWindow[1]/UIAScrollView[1]/UIAButton[13]")).click();//Click on Add button in More color drop down
		System.out.println("Done 12");

		


	}
	@AfterMethod
	public void tearDown() {
		//driver.quit();
	}
	
}