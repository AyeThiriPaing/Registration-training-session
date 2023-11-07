package test_apachePOI_API;

import java.io.File;
import java.io.FileInputStream;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class test_poi {

	static XSSFRow row;
	   public static void main(String[] args) throws Exception {
		   //Excel File Location
	        FileInputStream fis= new FileInputStream(new File("D:\\Lithan_Module5\\TestMVCServlet\\WebContent\\test_excel_file.xlsx"));
		   
	      
	      //Prepare to read the excel data
	      XSSFWorkbook workbook = new XSSFWorkbook(fis);
	      
	      //Define Which Sheet of data you want to read
	      XSSFSheet spreadsheet = workbook.getSheetAt(0);
	      
	      //looping the row
	      Iterator < Row >  rowIterator = spreadsheet.iterator();
	      
	      while (rowIterator.hasNext()) {
	    	 //check next row
	         row = (XSSFRow) rowIterator.next();
	         
	         //Loop the column (cell)
	         Iterator < Cell >  cellIterator = row.cellIterator();
	         
	         //check next cell or not
	         while ( cellIterator.hasNext()) {
	            Cell cell = cellIterator.next();
	            
	            switch (cell.getCellType()) {
	               case NUMERIC:
	                  System.out.print(cell.getNumericCellValue() + " \t\t ");
	                  break;
	               
	               case STRING:
	                  System.out.print(
	                  cell.getStringCellValue() + " \t\t ");
	                  break;
	            }
	         }
	         System.out.println();
	      }//end row
	      
	      fis.close();
	   }
}
