package Groupidpro.artifacttes;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class capstoneassignment {
  
	 WebDriver driver;
	@Test
  public void Logintest()
  {
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();
		String ExpectedUrl="https://www.saucedemo.com/inventory.html";
		String ActualUrl=driver.getCurrentUrl();
		Assert.assertEquals(ActualUrl,ExpectedUrl);
	  
  }
	@Test
	  public void Calculator()
	  {
			driver.get("https://testpages.herokuapp.com/styled/calculator");
			driver.findElement(By.id("number1")).sendKeys("100");
			driver.findElement(By.id("number2")).sendKeys("10");
			WebElement ele1=driver.findElement(By.id("calculate"));
			WebElement ele=driver.findElement(By.id("function"));
			Select se=new Select(ele);
			se.selectByValue("plus");
			ele1.click();
			String ExpectedOutput="110";
			String ActualOutput=driver.findElement(By.id("answer")).getText();
			Assert.assertEquals(ActualOutput,ExpectedOutput);
		  
	  }
	@Test
	public void FileUpload()
	  {
		driver.get("https://webdriveruniversity.com/File-Upload/index.html");
        if((driver.getTitle()).equals("File Upload"))
        {
        
        	driver.findElement(By.id("myFile")).sendKeys("D:\\Micheal\\Capstone\\pic.jfif");
        	driver.findElement(By.id("submit-button")).click();
        	WebDriverWait wait =new WebDriverWait(driver, Duration.ofSeconds(5));
      
        	Alert a=wait.until(ExpectedConditions.alertIsPresent());
			String Expected="Your file has now been uploaded!";
			String Actual=a.getText();
			a.accept();
			Assert.assertEquals(Actual,Expected);
        }
	  }
	@Test
	public void MultiSelection()
	  {
		driver.get("https://omayo.blogspot.com/");
		WebElement element1=driver.findElement(By.id("multiselect1"));
		Select se=new Select(element1);
		se.selectByIndex(0);
		se.selectByIndex(1);
		se.selectByIndex(2);		
		
        
	  }
	@Test
	  public void DatePicker()
	  {
		String date="10";
		String Monthyear="July 2023";
		String currentMonthyear;
		String ActualDate = "";
		driver.get("https://webdriveruniversity.com/Datepicker/index.html");
		driver.findElement(By.id("datepicker")).click();
			
		/// month and year selection
		while(true)
		{
			currentMonthyear=driver.findElement(By.xpath("//table[@class=' table-condensed']//tr//th[@class='datepicker-switch']")).getText();
			if(currentMonthyear.equals(Monthyear))
			{	
				break;
			}
			
			driver.findElement(By.xpath("//table[@class=' table-condensed']//th[@class='prev']")).click();		
		}
	//Date Selection		
		List <WebElement> alldates=driver.findElements(By.xpath("//table[@class=' table-condensed']//tbody//tr//td"));
		for(WebElement dt:alldates)
		{
			if((dt.getText()).equals(date))
			{
				ActualDate=dt.getText();
				dt.click();
				break;
				
			}
		}
			
			
			Assert.assertEquals(ActualDate+" "+currentMonthyear,date +" "+Monthyear);
		  
	  }
	
  @BeforeTest
  public void beforeTest() 
  {
	   driver=new ChromeDriver();
	driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() 
  {
	  driver.close();
  }

}
