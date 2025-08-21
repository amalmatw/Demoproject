package utilpkg;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Screenshot {
	
	public static String sshot(String name,WebDriver d) throws Exception
	{
		
		File src=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
		FileHandler.copy(src, new File("./Report/"+name+".png"));
		String path="./Report/"+name+".png";
		
		return path;
		
		
	
		


}
}
