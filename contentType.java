import java.awt.AWTException;
import java.awt.Desktop;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;

public class contentType {
	static String res = null;
	static String res1 = null;
	static File result = null;
	static FileWriter w = null;
	static BufferedWriter out = null;
	public static void main(String[] args) throws FindFailed, IOException, InterruptedException, AWTException  {
		result = new File("C:\\Users\\rkmantra\\Desktop\\result.txt");
		result.createNewFile();
		w = new FileWriter("C:\\Users\\rkmantra\\Desktop\\result.txt");
		out = new BufferedWriter(w);
	for(int i=1;i<15;i++){
		switch (i) {
        case 1: 
        	sniffTest(i);
        	res = "YJ";
			bookType();
			type(i);
			closeApp();
                 break;
        case 2:  
        	sniffTest(i);
        	res="Legacy";
			bookType();
			type(i);
			closeApp();
                 break;
        case 3:  
        	sniffTest(i);
        	res="Legacy";
        	bookType();
        	type(i);
        	closeApp();
        	res="Legacy";
        	bookType();
        	type(i);
        	closeApp();
                 break;
        case 4:  
        	sniffTest(i);
        	res="Legacy";
        	bookType();
        	type(i);
    		closeApp();
    		res="Legacy";
    		bookType();
    		type(i);
    		closeApp();
                 break;
        case 5:  
        	sniffTest(i);
        	res="Legacy";
        	bookType();
        	type(i);
    		closeApp();
    		res = "YJ";
    		bookType();
    		type(i);
    		closeApp();
                 break;
        case 6:  
        	sniffTest(i);
        	res = "YJ";
			bookType();
			type(i);
			closeApp();
                 break;
        case 7:  
        	sniffTest(i);
        	res="Legacy";
			bookType();
			type(i);
			closeApp();
                 break;
        case 8:  
        	sniffTest(i);
        	res="Legacy";
        	bookType();
        	type(i);
    		closeApp();
    		res="Legacy";
    		bookType();
    		type(i);
    		closeApp();
                 break;
        case 9:  
        	sniffTest(i);
        	res="Legacy";
        	bookType();
        	type(i);
    		closeApp();
    		res="Legacy";
    		bookType();
    		type(i);
    		closeApp();
                 break;
        case 10: 
        	sniffTest(i);
        	res="Legacy";
        	bookType();
        	type(i);
    		closeApp();
    		res = "YJ";
    		bookType();
    		type(i);
    		closeApp();
                 break;
        case 11: 
        	sniffTest(i);
        	res = "YJ";
        	bookType();
        	type(i);
    		closeApp();
    		res = "YJ";
    		bookType();
    		type(i);
    		closeApp();
                 break;
        case 12: 
        	sniffTest(i);
        	res="Legacy";
			bookType();
			type(i);
			closeApp();
                 break;
        case 13: 
        	sniffTest(i);
        	res = "YJ";
        	bookType();
        	type(i);
    		closeApp();
    		res="Legacy";
    		bookType();
    		type(i);
    		closeApp();
            break;
        case 14: 
        	sniffTest(i);
        	res = "YJ";
        	bookType();
        	type(i);
    		closeApp();
    		res="Legacy";
    		bookType();
    		type(i);
    		closeApp();
            break;
        default: 
                 break;
		 }
	}
		out.flush();
	}
	
public static void type(int i) throws IOException{
	if(res.equals(res1)){
		out.write("Test Case "+i+": Pass");
		out.newLine();
	}else{
		out.write("Test Case "+i+": Fail");
		out.newLine();
	}
}
public static void sniffTest(int j) throws IOException{
	System.out.println("test case "+j);
	File myFile = new File("C:\\Users\\rkmantra\\Desktop\\sniff\\restore.bat");
    Desktop.getDesktop().open(myFile);
	myFile = new File("C:\\Users\\rkmantra\\Desktop\\sniff\\runsniff"+j+".bat");
    Desktop.getDesktop().open(myFile);
}
public static void bookType()throws IOException, InterruptedException, FindFailed, AWTException{
		FileReader r = null;
		FileUtils.deleteDirectory(new File("C:\\Users\\rkmantra\\AppData\\Local\\Amazon\\Kindle\\Cache\\Logs"));
		try{
			FileUtils.deleteDirectory(new File("C:\\Users\\rkmantra\\Documents\\My Kindle Content\\B00MG7BCQG_EBOK"));
		}catch(Throwable t){
			System.out.println(t.getMessage().toString());
		}
		
		/*File f = null;
		File f1 = null;
		try{
			f = new File("C:\\Users\\rkmantra\\AppData\\Local\\Amazon\\Kindle\\Cache\\Logs\\1");
			f.delete();
			f1 = new File("C:\\Users\\rkmantra\\AppData\\Local\\Amazon\\Kindle\\Cache\\Logs\\2");
			f1.delete();
		}catch(Throwable t){
			System.out.println("lol");
		}*/
		Runtime.getRuntime().exec("C:\\Users\\rkmantra\\Desktop\\kinstart.bat");      
		Thread.sleep(15000); 
		
		//download the book using sikuli
		Screen screen = new Screen();
		Pattern collection = new Pattern("C:\\Users\\rkmantra\\Desktop\\sikuliImages\\myCollection.png");
		screen.click(collection);
		Pattern book = new Pattern("C:\\Users\\rkmantra\\Desktop\\sikuliImages\\redsari.png");
		screen.doubleClick(book);
		Thread.sleep(20000);
		//Pattern lib = new Pattern("C:\\Users\\rkmantra\\Desktop\\sikuliImages\\lib.png");
		//screen.click(lib);
		//Thread.sleep(5000);
		r= new FileReader("C:\\Users\\rkmantra\\AppData\\Local\\Amazon\\Kindle\\Cache\\Logs\\1");
		BufferedReader bfr = new BufferedReader(r);
		String x = "";
		while((x=bfr.readLine())!=null){
		if(x.contains("BookDownloadFinished") && x.contains("ContentType-application_x-kfx-ebook")){
			System.out.println("YJ");
			res1="YJ";
		}else if (x.contains("BookDownloadFinished") && x.contains("ContentType-application_x-mobi8-ebook")){
			System.out.println("Legacy");
			res1="Legacy";
		}
		}
		r.close();
		/*try{
			f.delete();
			f1.delete();
		}catch(Throwable t){
			System.out.println("lol");
		}*/
	}
	static void closeApp() throws IOException, InterruptedException{
		Runtime.getRuntime().exec("C:\\Users\\rkmantra\\Desktop\\closeKin.bat");
		Thread.sleep(10000);
		FileUtils.deleteDirectory(new File("C:\\Users\\rkmantra\\Documents\\My Kindle Content\\B00MG7BCQG_EBOK"));
		//FileUtils.deleteDirectory(new File("C:\\Users\\rkmantra\\AppData\\Local\\Amazon\\Kindle\\Cache\\Logs"));
}
	//pls ignore this code
	public static void waitAndDownloadAgain() throws FindFailed, InterruptedException, IOException, AWTException{
		FileReader r = null;
		Screen screen2 = new Screen();
		Pattern book2 = new Pattern("C:\\Users\\rkmantra\\Desktop\\sikuliImages\\redsari.png");
		screen2.rightClick(book2);
		Pattern remove = new Pattern("C:\\Users\\rkmantra\\Desktop\\sikuliImages\\removeFromDevice.png");
		screen2.click(remove);
		Thread.sleep(10000);
		Robot robo = new Robot();
		robo.keyPress(KeyEvent.VK_ENTER);
		robo.keyRelease(KeyEvent.VK_ENTER);
		screen2.doubleClick(book2);
		Thread.sleep(20000);
		Pattern lib = new Pattern("C:\\Users\\rkmantra\\Desktop\\sikuliImages\\lib.png");
		screen2.click(lib);
		Thread.sleep(5000);
		r= new FileReader("C:\\Users\\rkmantra\\AppData\\Local\\Amazon\\Kindle\\Cache\\Logs\\1");
		BufferedReader bfr = new BufferedReader(r);
		String x = "";
		while((x=bfr.readLine())!=null){
		if(x.contains("BookDownloadFinished") && x.contains("ContentType-application_x-kfx-ebook")){
			System.out.println("YJ");
		}else if (x.contains("BookDownloadFinished") && x.contains("ContentType-application_x-mobi8-ebook")){
			System.out.println("Legacy");
		}
		}
		
	}
}
