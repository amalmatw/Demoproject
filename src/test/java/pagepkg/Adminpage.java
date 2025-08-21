package pagepkg;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Adminpage {
	
	WebDriver d;
	
	By Admin=By.xpath("//ul[@class='oxd-main-menu']/li[1]");
	By Add=By.xpath("//div[@class='orangehrm-paper-container']/div/button");
	By role=By.xpath("//form[@class='oxd-form']/div/div/div[1]/div/div/div");
	By employee=By.xpath("//form[@class='oxd-form']/div/div/div[2]/div/div/div");
	By status=By.xpath("//form[@class='oxd-form']/div/div/div[3]/div/div/div");
	By username=By.xpath("//form[@class='oxd-form']/div/div/div[4]/div/div[2]/input");
	By password=By.xpath("//div[@class='oxd-form-row user-password-row']/div/div[1]/div/div[2]/input");
	By Cpass=By.xpath("//div[@class='oxd-form-row user-password-row']/div/div[2]/div/div[2]/input");
	
	public Adminpage(WebDriver d)
	{
		this.d=d;
	}
	
	public void admin()
	{
		d.findElement(Admin).click();
		d.findElement(Add).click();
		d.findElement(role).click();
		
		
		
	}
	
	

}
