import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.util.SystemOutLogger;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public XSSFWorkbook workbook;
	protected FileInputStream fis;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		ReadExcel re = new ReadExcel();
		re.readExcel();
	}

	public void readExcel() throws IOException {
		fis = new FileInputStream(new File(".//TargetComple.xlsx"));
		//FileOutputStream fos = new FileOutputStream(new File(".///TargetComple.xlsx"));
		workbook= new XSSFWorkbook(fis);
		XSSFSheet sheet = workbook.getSheet("PreparationData");
		int rowCount = sheet.getLastRowNum();
		int colCount = sheet.getRow(0).getLastCellNum();
		Iterator<Row> rowIterator = sheet.rowIterator();
		while(rowIterator.hasNext()) {
		Iterator<Cell> cellIterator=	rowIterator.next().cellIterator();
		while(cellIterator.hasNext()) {
			System.out.print(cellIterator.next());
		//XSSFCell cell= (XSSFCell) cellIterator.next();
		}
		System.out.println("------------------");
		}
	}

}
