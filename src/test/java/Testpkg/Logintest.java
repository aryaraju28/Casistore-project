package Testpkg;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.Test;

import Basepkg.Baseclass;
import Pagepkg.Loginpage;
import Utilities.Exelutilities;



public class Logintest extends Baseclass {
	@Test(priority = 1)
	public void logo()
	{
		
		boolean logo=driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div[2]/div/div/header/div[1]/div/div[2]/div[2]/div/a/img[1]")).isDisplayed();
		if(logo)
		{
			System.out.println("logo is displayed");
			
		}
		else {
			System.out.println("logo is not displayed");
			
		}
	}
	
	
	@Test(priority = 2)
	public void links() throws IOException
	{
		List<WebElement>list=driver.findElements(By.tagName("a"));
		System.out.println("No of links: "+list.size());
		for(WebElement element:list)
		{
			String links=element.getAttribute("href");
			verifyresponse(links);
		}
		
		
	}
	private void verifyresponse(String links) throws IOException {
		// TODO Auto-generated method stub
		try {
			URL url=new URL(links);
			HttpURLConnection connection=(HttpURLConnection)url.openConnection();
			int code=connection.getResponseCode();
			if(code==200)
			{
				System.out.println("success"+links);
				
			}
			else if (code==404){
				System.out.println("failed"+links);
				
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	
	@Test(priority = 3)
	public void verifylogin() throws Exception
	{

		Loginpage loginpage=new Loginpage(driver);
		String xl="E:\\hmexcel.xlsx";
		String Sheet="Sheet1";
		int rowCount=Exelutilities.getRowCount(xl, Sheet);
		for(int i=1;i<=rowCount;i++)
		{
			driver.navigate().refresh();
			String usernameString=Exelutilities.getCellValue(xl, Sheet, i, 0);
			System.out.println(usernameString);
			String pwdString=Exelutilities.getCellValue(xl, Sheet, i, 1);
			System.out.println(pwdString);
			loginpage.setValues(usernameString, pwdString);
			loginpage.clickLoginBtn();
			String exString="https://thecaistore.com/account";
			String acString=driver.getCurrentUrl();
			if(acString.equals(exString))
			{
				
				System.out.println("pass");
			}
			else {
				System.out.println(acString);
				System.out.println("failed");
			}
			
		}
	driver.findElement(By.xpath("/html/body/div[1]/div/main/div/header/a"))	.click();
	driver.findElement(By.xpath("/html/body/div[1]/div/div[1]/div[3]/div[2]/div/div/header/div[1]/div/div[3]/div/div/a[1]")).click();
	}
	@Test(priority = 4)
	public void forgotpassword()
	{
		driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[2]/form/div/div[2]/small/a")).click();
		driver.findElement(By.name("email")).sendKeys("arya281996@gmail.com");
		driver.findElement(By.xpath("/html/body/div[1]/div/main/div/div[3]/div/form/p/button")).click();
	}
	
	
	
	}
