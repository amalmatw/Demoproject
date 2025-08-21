package utilpkg;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class Excelhandler {

	public static int counter(String path, String sheet)
	{
		try
		{
		File f=new File(path);
		FileInputStream f1=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(f1);
		XSSFSheet sh=wb.getSheet(sheet);
		
		return sh.getLastRowNum();
		
		
	}catch(Exception e)
		{
		return 0;
		}
}
	
	public static String details(String path, String sheet, int i, int r)
	{
		try
		{
		File f=new File(path);
		FileInputStream f1=new FileInputStream(f);
		XSSFWorkbook wb=new XSSFWorkbook(f1);
		XSSFSheet sh=wb.getSheet(sheet);
		
		XSSFCell cell=(XSSFCell)sh.getRow(i).getCell(r);
		
		if(cell.getCellType()==CellType.STRING)
		{
			return cell.getStringCellValue();
		}
		else
		{
			return cell.getRawValue();
		}
		}
		catch(Exception e)
		{
			return e.getMessage();
		}
		
		syso"hello";
		
	}
}
