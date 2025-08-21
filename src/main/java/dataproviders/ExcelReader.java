package dataproviders;

import java.io.File;
import java.io.IOException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReader 
{
	
	public static Object[][] getDataFromExcel(String sheetName)
	{
		
		XSSFWorkbook wb;
		
		Object[][]arr=null;
		
		try 
		{
			File src=new File("./TestData/ApplicationTestData.xlsx");
			
			wb = new XSSFWorkbook(src);
			
			XSSFSheet sheet1=wb.getSheet(sheetName);
			
			int row=sheet1.getPhysicalNumberOfRows();
			
			int columns=sheet1.getRow(0).getPhysicalNumberOfCells();
			
			System.out.println("***Number Of Test To Be Executed ***"+row);
			
			System.out.println("***Number Of Columns To Be Passed ***"+columns);
			
			arr=new Object[row][columns];
			
			
			// outer loop will run based on number of rows
			for(int i=0;i<row;i++)
			{
				
				for(int j=0;j<columns;j++)
				{
					
					arr[i][j]=sheet1.getRow(i).getCell(j).getStringCellValue();
					
				}
				
				
			}
			
			wb.close();
			
		} catch (InvalidFormatException e) 
		{
			System.out.println("Sorry we dont support this format "+e.getMessage());
			
		} catch (IOException e) 
		{
			System.out.println("Something went wrong could not read the excel "+e.getMessage());

		}
		
		return arr;
		
		
	}

}
