package oct.selenium.demo;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class EndToEndTest {

	public static void main(String[] args) {
	
	//LOGIN
		
	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\Trapti\\Selenium\\ExeFiles\\chromedriver.exe");
	 WebDriver driver = new ChromeDriver();
	 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	 driver.get("https://www.nobroker.in");
	 driver.manage().window().maximize();
	 
	//Click On Buy 
	driver.findElement(By.xpath("//button[contains(text(),'Buy')]")).click();	 
	
	//Click On CitySelector
	driver.findElement(By.id("nbCitySelector")).click();
	
	List<WebElement>allOptions =driver.findElements(By.xpath("//a[contains(@class,'cityoption')]"));
	int allOption=allOptions.size();
	System.out.println("City names-->"+allOption);
	String expectedValue="Mumbai";
	for(WebElement value:allOptions)
	{
		String text=value.getText();
		System.out.println(""+text);
		if(text.equalsIgnoreCase(expectedValue))
		{
			
			value.click();
			break;
		}
	}

	driver.findElement(By.name("locationGoogle")).sendKeys("Malad");
	
	driver.findElement(By.xpath("//span[contains(text(),'Malad East - Malkani Estate')]")).click();
		
	driver.findElement(By.name("locationGoogle")).sendKeys("Malad");
	
	driver.findElement(By.xpath("//span[contains(text(),'Malad west - Sundar Ln')]")).click();
	
	
 	driver.findElement(By.xpath("//div[contains(@id,'nbBHKSelector')]")).click();
	
	String checkToBeSelected="3";
	List<WebElement> checkboxList =driver.findElements(By.xpath("//input[@type='checkbox']"));
	
	for(int i=0;i<checkboxList.size();i++)
	{
		if(checkboxList.get(i).getAttribute("value").equalsIgnoreCase(checkToBeSelected)){
			checkboxList.get(i).click();
			break;
		}
	}
	
	
	driver.findElement(By.xpath("//div[contains(@id,'nbBHKSelector')]")).click();

	String checkToBeSelected1="2";
	List<WebElement> checkboxList1 =driver.findElements(By.xpath("//input[@type='checkbox']"));
	
	for(int i=0;i<checkboxList1.size();i++)
	{
		if(checkboxList1.get(i).getAttribute("value").equalsIgnoreCase(checkToBeSelected1)){
			checkboxList1.get(i).click();
			break;
		}
	}
	
	driver.findElement(By.xpath("//span[contains(.,\"Search\")]")).click();
			
	WebElement wbFrame= driver.findElement(By.xpath("//iframe[@title=\"Zendesk Chat widget window\"]"));
	
	driver.switchTo().frame(wbFrame);
	
	driver.findElement(By.xpath("//div[contains(@class,'overlay jx_ui_Widget')]")).click();
	
	driver.switchTo().defaultContent();
	
	
	WebElement propertyLink=driver.findElement(By.xpath("//h2[contains(text(),'3 BHK For Sale in Pratap Nagar Co-Operartive Housing Society, Mal ...')]"));
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView() ",propertyLink);
	
	
	String parentWindowId = driver.getWindowHandle();
	System.out.println("parent window id is "+parentWindowId);
	driver.findElement(By.xpath("//h2[contains(text(),'3 BHK For Sale in Pratap Nagar Co-Operartive Housing Society, Mal ...')]")).click();;
	
	
	Set<String>allwindowHandles = driver.getWindowHandles();
	int count = allwindowHandles.size();
	System.out.println(count);
	for(String windowHandle:allwindowHandles)
	{
		if(!parentWindowId.equalsIgnoreCase(windowHandle))
		{
			driver.switchTo().window(windowHandle);

			WebElement wbFrame1= driver.findElement(By.xpath("//iframe[@title=\"Zendesk Chat widget window\"]"));
			
			driver.switchTo().frame(wbFrame1);
			
			driver.findElement(By.xpath("//div[contains(@class,'overlay jx_ui_Widget')]")).click();
			
			driver.switchTo().defaultContent();
			
			
		WebElement descriptionLink=driver.findElement(By.xpath("//a[contains(text(),'Description & Amenities')]"));
		JavascriptExecutor jse= (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView() ",descriptionLink);
		
		}
	}
	
	driver.close();

	}}
	
