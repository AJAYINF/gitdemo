package rahul.fileupload;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class fileuploading {
@Test
public void filesubmit() throws InterruptedException, IOException  {
	String path=System.getProperty("user.dir");
	System.setProperty("webdriver.http.factory", "jdk-http-client");
	HashMap<String, Object>chromeprefs=new HashMap<String, Object>();
	chromeprefs.put("profile.default_content_settings.popups", 0);
	chromeprefs.put("download.default_directory", path);
	
	ChromeOptions co= new ChromeOptions();
	co.addArguments("--start-maximized");
	co.addArguments("--remote-allow-orgins=*");
	co.setExperimentalOption("prefs",chromeprefs);
	WebDriverManager.chromedriver().setup();
	WebDriver driver=new ChromeDriver(co);
	driver.get("https://www.ilovepdf.com/pdf_to_jpg");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//a[@id='pickfiles']")).click();
	Thread.sleep(10000);
	Runtime.getRuntime().exec("C:\\Users\\LENOVO\\Downloads\\Documents\\check\\fileupload.exe");
	Thread.sleep(3000);
	driver.findElement(By.xpath("//button[@id='processTask']")).click();
	File f= new File(path+"/QA_page-0001.jpg");
	if(f.exists()) {
		System.out.println("file found");
	}
	
	
}
}
