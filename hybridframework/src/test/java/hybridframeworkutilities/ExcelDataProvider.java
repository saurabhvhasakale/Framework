package hybridframeworkutilities;

import java.io.File;
import java.io.FileInputStream;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataProvider {
	
	XSSFWorkbook wb;
	
	public ExcelDataProvider()
	{
		File src=new File("./TestData/Data.xlsx");
		try {
			FileInputStream fis=new FileInputStream(src);
			 wb=new XSSFWorkbook(fis);
		} catch (Exception e) {
			// TODO Auto-generated catch block
          System.out.println("Excel is not found"+e.getMessage());		
	}
	}
	
	public String getStringData(int SheetNo,int Row,int Column)
	{
		return wb.getSheetAt(SheetNo).getRow(Row).getCell(Column).getStringCellValue();
	}
	
	public String getStringData(String SheetName,int Row,int Column)
	{
		return wb.getSheet(SheetName).getRow(Row).getCell(Column).getStringCellValue();
	}
	public double getNumericData(String SheetName,int Row,int Column)
	{
		return wb.getSheet(SheetName).getRow(Row).getCell(Row).getNumericCellValue();
	}
}
