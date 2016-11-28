import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class kindle {
	
	public static void main(String[] args) throws IOException, InterruptedException {
		int rowId=1;
		FileReader r = null;
		File f = new File("C:\\Users\\rkmantra\\AppData\\Local\\Amazon\\Kindle\\Cache\\Logs\\1");
		File f1 = new File("C:\\Users\\rkmantra\\AppData\\Local\\Amazon\\Kindle\\Cache\\Logs\\2");
		try{
			f.delete();
			f1.delete();
		}catch(Throwable t){
			System.out.println("lol");
		}
        Runtime.getRuntime().exec("C:\\Users\\rkmantra\\Desktop\\kinstart.bat");  
        
		Thread.sleep(15000); 
		closeKindle();
		r= new FileReader("C:\\Users\\rkmantra\\AppData\\Local\\Amazon\\Kindle\\Cache\\Logs\\1");
		BufferedReader bfr = new BufferedReader(r);
		String x = "";
		HashMap<String, String> hmap = new HashMap<String, String>();
		while((x=bfr.readLine())!=null){
			//System.out.println(x);
			if(x.contains("settingName")){
				String words[] = x.split(" ");
				for(int i=0; i<words.length;i++){
					if(words[i].contains("settingValue")){
						String gotit[] = x.split("settingValue:");
						String gotit2[] = gotit[1].split("- isChange");
						String text = gotit2[0].trim();
						hmap.put(words[i-2], text);
						System.out.println(words[i-2] +"---"+text);
					}
				}
			}
		}
		
		
		FileInputStream data = new FileInputStream(new File("C:\\Users\\rkmantra\\Desktop\\snifftestdata.xlsx"));
		XSSFWorkbook workbook = new XSSFWorkbook(data);
		XSSFSheet sheet = workbook.getSheetAt(0);
		Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext()) 
        {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            Cell cell = cellIterator.next();
            if(rowId>1){
            	
            	String hmapVal = hmap.get(cell.toString().trim());
            	
            	cell = cellIterator.next();
            	String xl = cell.toString().trim();
            	if(hmapVal!=null){
            		if(hmapVal.equals(xl)){
                		
                		cell=cellIterator.next();
                		cell.setCellValue("pass");
                	}else
                	{
                		cell=cellIterator.next();
                		cell.setCellValue(hmapVal);
                	}
            	}
            	
            }
            rowId++;

        }
        
        FileOutputStream fileOut = new FileOutputStream("C:\\Users\\rkmantra\\Desktop\\sniff-result.xlsx");
        workbook.write(fileOut);
		fileOut.flush();
		fileOut.close();
	}
	
	static void closeKindle() throws IOException{
		Runtime.getRuntime().exec("C:\\Users\\rkmantra\\Desktop\\closeKin.bat");
	}

}

