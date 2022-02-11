package frameWorkParameterozation_Assertions;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ReadExcel {

	Workbook workbook;
	FileInputStream input;
	Sheet sheet;

	@Before
	public void getExcel() throws Exception {

		input = new FileInputStream(new File(
				"C:\\Users\\TRUE GRIT\\Desktop\\Infosys\\Assignment\\Selenium Final\\SeleniumAssignments\\src\\test\\resources\\data.xlsx"));
		// get the excel sheet file location
		workbook = new XSSFWorkbook(input);
		// get the sheet which needs read operation
				sheet = workbook.getSheetAt(0);
	}

	@Test
	public void testExcel() throws Exception {
		
		// get the total row count in the excel sheet
		int rowcount = sheet.getLastRowNum();
		System.out.println("::Excel data::");
		for (int i = 0; i <= rowcount; i++) {

			// get the total cell count in the excel sheet
			int cellcount = sheet.getRow(i).getLastCellNum();
			for (int j = 0; j < cellcount; j++) {
				// get cell value at the given position [i][j]
				String value = sheet.getRow(i).getCell(j).getStringCellValue();
				// print the cell value
				System.out.print(value + "\t\t");

			}
			System.out.println();
		}
	}

	@After
	public void teardown() throws Exception {

		workbook.close();
		input.close();

	}

}