package teatcases;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class handleDropdown 
{
	public static void handledropdown(WebElement ele, String value) 
	{
		Select select = new Select(ele);
		List<WebElement> optons = select.getOptions();
		for(WebElement element : optons)
		{
			if(element.getText().equals(value));
			{
				element.click();
				break;
			}
		}
	}

	public static void main(String[] args) 
	{
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		System.out.println(driver.getTitle());
		
		driver.findElement(By.xpath("//input[@name='username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@name='password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[@type='submit']")).click();
		
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
		WebElement EmploymentStatus = driver.findElement(By.xpath("//div[@class='oxd-table-filter']//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]"));
		handledropdown(EmploymentStatus, "Freelance");
		
		WebElement include = driver.findElement(By.xpath("//div[contains(text(),'Current Employees Only')]"));
		handledropdown(include, "Past Employees Only");
		
		WebElement JobTitle = driver.findElement(By.xpath("//div[@class='oxd-table-filter']//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]"));
		handledropdown(JobTitle, "Account Assistant");
		
		WebElement subUnit = driver.findElement(By.xpath("//div[@class='oxd-table-filter']//div[3]//div[1]//div[2]//div[1]//div[1]//div[1]"));
		handledropdown(subUnit, "Engineering");
		
		
		

	}

}
