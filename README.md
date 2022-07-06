# asana-pom
Page Object Model based test automation framework with Java and TestNG


===================

package util;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MatrixCreator {

	public static void main(String[] args) throws IOException {
		geekforgeeks();
	}

	public static void geekforgeeks() throws IOException{
        
        XSSFWorkbook workbook=new XSSFWorkbook();
        XSSFSheet sheet=workbook.createSheet("sheet1");
           
           // Creating HashMap and entering data
           LinkedHashMap<String,String> map=new LinkedHashMap<String,String>();
           map.put("Qtest TC id","Product;Type;Sub-type;Count");
           map.put("TC-122", "ASM;Generate;;1");
           map.put("TC-178", "ASM;Reject;;1");
           map.put("TC-877", "TFS;buy;existing;1");
           map.put("TC-9900", "TFS;Sell;new;1");
             
           int rowno = 0;
             
           for(HashMap.Entry<String,String> entry:map.entrySet()) {
               XSSFRow row=sheet.createRow(rowno++);
               row.createCell(0).setCellValue((String)entry.getKey());
               String arr[] = ((String)entry.getValue()).split(";");
               for(int i = 0 ;i < arr.length;i++) {
            	   row.createCell(i+1).setCellValue(arr[i]);
               }
               
           }
      
           FileOutputStream file = new FileOutputStream("Hash.xlsx");
           workbook.write(file);
           file.close();
           System.out.println("Data Copied to Excel");
        
   }
}
