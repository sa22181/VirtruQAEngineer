package selpackage;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class VirtruAssignment {

	public static void main(String[] args) throws InterruptedException {

		//Start		
	    System.setProperty("webdriver.chrome.driver", "C:\\Users\\Ghost\\Downloads\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://accounts.google.com/signin/v2/identifier?service=mail&passive=true&rm=false&continue=https%3A%2F%2Fmail.google.com%2Fmail%2F&ss=1&scc=1&ltmpl=default&ltmplcache=2&emr=1&osid=1&flowName=GlifWebSignIn&flowEntry=ServiceLogin");
		String winHandleBefore = driver.getWindowHandle();
		 
		//timeout check
		Thread.sleep(3000);	
		
		//login user name
		driver.findElement(By.id("identifierId")).sendKeys("qatest22181@gmail.com");
		driver.findElement(By.cssSelector("#identifierNext > content > span")).click();
		
		Thread.sleep(3000);
		
		//login password
		driver.findElement(By.name("password")).sendKeys("Test@!0322");
		Thread.sleep(3000);
		driver.findElement(By.id("passwordNext")).click();	
		Thread.sleep(4000);

		// Click encrypted email
		List<WebElement> a = driver.findElements(By.xpath("//*[@class='yW']/span"));
		System.out.println(a.size());
		            for(int i=0;i<a.size();i++){
		                System.out.println(a.get(i).getText());
		                if(a.get(i).getText().equals("me")){ 
		                    a.get(i).click();
		                }
		            }

		Thread.sleep(4000);  
		
		//Click unlock button
        driver.findElement(By.xpath("//*[@id=\":6t\"]/div[1]/div[1]/div[2]/table/tbody/tr/td/table/tbody/tr[2]/td/table/tbody/tr/td/a")).click();
        Thread.sleep(3000);
        
       // Switch to new tab
        for(String winHandle : driver.getWindowHandles()){
        driver.switchTo().window(winHandle);
        }
        
        // New tab
        driver.findElement(By.xpath("//span[@class='userEmail']")).click();
        Thread.sleep(3000);
        driver.findElement(By.cssSelector("#content > div > div > div > div.auth-choice-button-container > a.btn.btn-lg.auth-choice-btn.sendEmailButton")).click();
        Thread.sleep(3000);

        // Close the new tab
        driver.close();

        // Switch driver back to original tab
        driver.switchTo().window(winHandleBefore);
        driver.findElement(By.xpath("//*[@id=\":5\"]/div[2]/div[1]/div/div[1]/div/div")).click();
        Thread.sleep(6000);
        
        //Click verify email
		List<WebElement> b = driver.findElements(By.xpath("//*[@class='yW']/span"));
		System.out.println(b.size());
		            for(int i=0;i<b.size();i++){
		                System.out.println(b.get(i).getText());
		                if(b.get(i).getText().equals("verify")){ 
		                    b.get(i).click();
		                }
		                
		            }
		
		Thread.sleep(4000);
		
		//Click verify button
		driver.findElement(By.xpath("//*[@id=\":6y\"]/div[2]/table/tbody/tr/td/table/tbody/tr[4]/td/table/tbody/tr[2]/td/table/tbody/tr/td/a")).click();       
		
	}
	
}

//End