package Pagepkg;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage {
	WebDriver driver;
	@FindBy(name = "customer[email]")
	WebElement emailElement;
	@FindBy(name = "customer[password]")
	WebElement passElement;

	
	@FindBy(xpath = "/html/body/div[1]/div/main/div/div[2]/form/p[1]/button")
	WebElement loginElement;
	 
	public Loginpage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
	
	public void clickLoginBtn() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(40));
		
		loginElement.click();
		
	}
	public void setValues(String email,String pass)
	{
		emailElement.sendKeys(email);
		passElement.sendKeys(pass);
	}

}
