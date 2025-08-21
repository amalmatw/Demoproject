package testpkg;

import java.io.File;
import java.time.Duration;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import pagepkg.Adminpage;
import pagepkg.Loginpage;
import utilpkg.Excelhandler;
import utilpkg.Screenshot;

public class Test01 extends Baseclass {
	
	@BeforeMethod
	public void url()
	{
		d.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		d.manage().window().maximize();
	}
	
	@Test (priority =1)
	public void signup()
	{
		et=er.createTest("Login verification");
		d.manage().timeouts().implicitlyWait(Duration.ofSeconds(5000));
		
		String path="C:\\Users\\Techfriar\\OneDrive\\Desktop\\New folder\\Test01.xlsx";
		String Sheet="Sheet1";

		int rowcount=Excelhandler.counter(path, Sheet);
		
		for(int i=1;i<=rowcount;i++)
		{
			String user=Excelhandler.details(path, Sheet, i,0);
			String pass=Excelhandler.details(path, Sheet, i,1);
			Loginpage lp=new Loginpage(d);
			lp.login(user,pass);
		}
		
		
		String requrl="https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index";
		String cururl=d.getCurrentUrl();
		System.out.println(cururl);
		
		Assert.assertEquals(cururl, requrl);
		
//		SoftAssert sa=new SoftAssert();
		
	//	sa.assertEquals(cururl, requrl, "Url does match");
		
		
		
	}
	
	@Test (priority =2, enabled=false)
	public void admin()
	{
		Adminpage ap=new Adminpage(d);
		ap.admin();
	}
		
	@AfterMethod
	public void report(ITestResult I) throws Exception
	{
		if(I.getStatus()==ITestResult.FAILURE)
		{
			et.log(Status.FAIL,"Failed Test"+I.getName() );
			et.log(Status.FAIL, "Failure reason"+I.getThrowable());
			
			String path=Screenshot.sshot(I.getName(),d);
			
			et.addScreenCaptureFromPath(new File(path).getAbsolutePath());
			
		}
		else if(I.getStatus()==ITestResult.SKIP)
		{
			et.log(Status.SKIP, "Skipped Test"+I.getName());
			
		}
		else if(I.getStatus()==ITestResult.SUCCESS)
		{
			et.log(Status.PASS,"Passed Test"+I.getName());
		}
		
	}
	
	@AfterTest
	public void closing()
	{
		er.flush();
		d.close();
	}
	

}
