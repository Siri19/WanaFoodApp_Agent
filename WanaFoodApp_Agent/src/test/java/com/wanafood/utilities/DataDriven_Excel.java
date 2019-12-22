package com.wanafood.utilities;


	import java.io.FileInputStream;
	import java.io.IOException;
	import java.util.HashMap;

	import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
	import org.apache.poi.ss.usermodel.DataFormatter;
	import org.apache.poi.ss.usermodel.Sheet;
	import org.apache.poi.ss.usermodel.Workbook;
	import org.apache.poi.ss.usermodel.WorkbookFactory;

	public class DataDriven_Excel {

		public static Workbook wb;
		public static Sheet sheet;
		public static int  row;
		public static  int cell;
		
		public static Object[][] getData(String FilePath,String SheetNo) throws InvalidFormatException, IOException {
			FileInputStream fis=new FileInputStream(FilePath);
			wb=WorkbookFactory.create(fis);
			sheet=wb.getSheet(SheetNo);
			row=sheet.getLastRowNum();
			//row=sheet.getPhysicalNumberOfRows();
			cell=sheet.getRow(0).getLastCellNum();
			System.out.println("No of Rows---------->"+row);
			System.out.println("No of cells------------>"+cell);
			Object[][] obj=new Object[row][1];
			
			for(int i=1;i<=row;i++) {
				HashMap<String , String> hash=new HashMap<>();
				for(int j=0;j<cell;j++) {
					DataFormatter s=new DataFormatter();
					String key=s.formatCellValue(sheet.getRow(0).getCell(j));
					String val=s.formatCellValue(sheet.getRow(i).getCell(j));
					hash.put(key, val);
				}
				obj[i-1][0]=hash;
			}
			return obj;
			
		}

}
