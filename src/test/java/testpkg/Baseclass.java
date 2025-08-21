package testpkg;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Baseclass {
	
	WebDriver d;
	ExtentSparkReporter ehr;
	protected ExtentReports er;
	protected ExtentTest et;
	
	@BeforeTest
	public void setup()
	{
		ehr=new ExtentSparkReporter("./Report/new01.html");
		ehr.config().setDocumentTitle("Automation Report");
		ehr.config().setReportName("Functional report");
		ehr.config().setTheme(Theme.DARK);
		
		er=new ExtentReports();
		er.attachReporter(ehr);
		er.setSystemInfo("Version","1.0.0");
		er.setSystemInfo("OS", "Windows");
		er.setSystemInfo("Browser", "Chrome");
		er.setSystemInfo("Tester", "Amal");
		
		WebDriverManager.chromedriver().setup();
		ChromeOptions c=new ChromeOptions();
		c.addArguments("--remote-allow-origins=*");
		d=new ChromeDriver(c);
	}

}
