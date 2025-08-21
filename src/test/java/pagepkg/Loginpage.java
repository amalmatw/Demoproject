package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Loginpage {
	
	WebDriver d;
	
	By username=By.name("username");
	By password=By.name("password");
	By button=By.xpath("//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']");
	
	public Loginpage(WebDriver d)
	{
		this.d=d;
	}
	
	public void login(String id, String pass)
	{
		d.findElement(username).sendKeys(id);
		d.findElement(password).sendKeys(pass);
		d.findElement(button).click();
		
		
				
	}
	

}
