package org.cts;

import java.awt.AWTException;
import java.awt.Robot;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base {
	public static WebDriver driver;
	//Browser launch
	public static  void getChromeDrive() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
	}
	//Load url
	public static void loadUrl(String data) {
		driver.get(data);
		driver.manage().window().maximize();
	}
	//SendKeys
	public static void enterType(WebElement element,String value) {
		element.sendKeys(value);
	}
	//Get page title
	public static void title() {
		String title = driver.getTitle();
		System.out.println(title);
	}
	//Get page Url
	public static void pageUrl(String url) {
		driver.getCurrentUrl();
		System.out.println(url);
	}
	//Get ID
	public static WebElement id(String name) {
		WebElement element = driver.findElement(By.id(name));
		return element;
	}
	//Get Nmae
	public static WebElement name(String data) {
		WebElement element = driver.findElement(By.name(data));
		return element;
	}
	//Get ClassName
	public static WebElement className(String data) {
		WebElement element = driver.findElement(By.className(data));
		return element;
	}
	//Get xpath
	public static WebElement xPath(String data) {
		WebElement element = driver.findElement(By.xpath(data));
		return element;
	}
	//navigate to
	public static void navigateUrl(String data) {
		driver.navigate().to(data);
		driver.manage().window().maximize();
	}
	//navigate refresh
	public static void refresh() {
		 driver.navigate().refresh();
	}
	//navigate forward
	public static void forward() {
		 driver.navigate().forward();
	}
	//navigate backward
	public static void backward() {
		 driver.navigate().back();
	}
	//Is enabled
	public static void enable(WebElement element) {
		boolean enabled = element.isEnabled();
		System.out.println(enabled);
	}
	//is disaplayed
	public static void display(WebElement element) {
		boolean displayed= element.isDisplayed();
		System.out.println(displayed);
	}
	//is selected
	public static void select(WebElement element) {
		boolean select= element.isSelected();
		System.out.println(select);
	}
	//select class-index
	public  static void select(WebElement element,int index) {
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	//select class-value
	public static void selectValue(WebElement element,String value) {
		Select select=new Select(element);
		select.selectByValue(value);
	}
	//select class-text
	public static void selectText(WebElement element,String text) {
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	//select class-Delete-text
	public static void selectDelText(WebElement element,String text) {
		Select select=new Select(element);
		select.deselectByVisibleText(text);
	}
	//select class-Delete-index
	public static void selectDelValue(WebElement element,int index) {
		Select select=new Select(element);
		select.deselectByIndex(index);
	}
	//select class-Delete-text
	public static void selectDelIndex(WebElement element,String value) {
		Select select=new Select(element);
		select.deselectByValue(value);
	}
	//select class-Delete-all
	public static void selectDelAll(WebElement element) {
		Select select=new Select(element);
		select.deselectAll();
	}
	//select class-getOptions-text
	public static void getOptionsText(WebElement element) {
		Select select=new Select(element);
		List<WebElement> options = select.getOptions();
		for (int i = 0; i < options.size(); i++) {
			select.selectByVisibleText(options.get(i).getText());
			System.out.println(options.get(i).getText());
			}
	}
	//select class-getOptions-value
		public static void getOptionsValue(WebElement element) {
			Select select=new Select(element);
			List<WebElement> options = select.getOptions();
			for (WebElement webElement : options) {
				select.selectByValue(webElement.getAttribute("value"));
				System.out.println(webElement.getAttribute("value"));
			}
		}
	//select class-getOptions-index
		public  static void getOptionsIndex(WebElement element,int index) {
			Select select=new Select(element);
			List<WebElement> options = select.getOptions();
			for (int i = 0; i < options.size(); i++) {
				WebElement webElement = options.get(i);
				String text = webElement.getText();
				select.selectByIndex(index);
				System.out.println(text);
			}
		}
	//select-getAllSelectedOptions
		public static void getAllSelectedOptions(WebElement element) {
			Select select=new Select(element);
			List<WebElement> allSelectedOptions = select.getAllSelectedOptions();
			for (WebElement web : allSelectedOptions) {
				String text = web.getText();
				System.out.println(text);
			}
	}
	//select-getFirstSelectedOption
	public static void getFirstSelectedOption(WebElement element) {
		Select select=new Select(element);
		WebElement firstSelectedOption = select.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		System.out.println(text);
	}
	//Frame-index
	public static void frame(int arg) {
		driver.switchTo().frame(arg);
	}
	//Frame-string/id
	public static void frameIdString(String arg) {
		driver.switchTo().frame(arg);
	}
	//Frame-WebElement
	public static void frameW(WebElement element) {
		driver.switchTo().frame(element);
	}
	//Frame to Window
	public static void frameToWindow() {
		driver.switchTo().defaultContent();
	}
	//click
	public static void btn(WebElement element) {
		element.click();
	}
	//Robot
	public static void robotClass(int i) throws AWTException {
		Robot robot=new Robot();
		robot.keyPress(i);
		robot.keyRelease(i);
	}
	//Robot using Loop
	public static void robotLoop(int i,int j) throws AWTException {
		Robot robot=new Robot();
		for(int k=1;k<i;k++) {
		robot.keyPress(j);
		robot.keyRelease(j);
		}
	}
	//Actions-using keyBoard
	public static void actionKey(WebElement element,String value) {
		Actions actions=new Actions(driver);
		actions.keyDown(element,Keys.SHIFT).sendKeys(element,value).keyUp(element,Keys.SHIFT).perform();
	}
	//Actions-using  Mouse Over Action
	public static void actiontMouse(WebElement element) {
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	
	//Actions-using Drag and Drop
	public static void actionDaD(WebElement element,WebElement value) {
		Actions actions=new Actions(driver);
		actions.dragAndDrop(element, value).perform();
	}
	//Actions-using RightClick
	public static void actionRightClick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	//Actions-using Double Click
	public static void actionDoubleClick(WebElement element) {
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	//JavaScripExecutor-sendKey
	public static void javaSendKey(String arg,WebElement element) {
		JavascriptExecutor executor=(JavascriptExecutor) driver;
		executor.executeScript(arg, element);
	}
	//Window Handling-single child window
	public static void windowHandling() {
		String pWind = driver.getWindowHandle();
		Set<String> allWind = driver.getWindowHandles();
		for (String switchWind : allWind) {
			if(!pWind.equals(switchWind)) {
			driver.switchTo().window(switchWind);
			}
		}
	}
	//Window Handling-Count(more no of child window)
	public static void windowHandlingCount(int n) {
		String pWind = driver.getWindowHandle();
		System.out.println(pWind);
		Set<String> allWind = driver.getWindowHandles();
		int count=0;
		for (String switchWind : allWind) {
			if(count==n) {
			driver.switchTo().window(switchWind);
			}
			count++;
		}
	}
	//Window Handling more no of window using Index
	public static void windowHandlingList(int i) {
		String pWind = driver.getWindowHandle();
		System.out.println(pWind);
		Set<String> allWind = driver.getWindowHandles();
		List<String>list=new ArrayList<String>();
		list.addAll(allWind);
		driver.switchTo().window(list.get(i));
	}
	//Parent Window
	public static void parentWindow() {
		String pWind = driver.getWindowHandle();
		driver.switchTo().window(pWind);
	}
	//clear
	public  static void delete(WebElement element) {
		element.clear();
	}
	//Close
	public static  void close() {
		driver.close();
	}
	//Quit
	public static void shutDown() {
		driver.quit();
	}
	//Excel-Read
	public static String excelType(String path,String name,int rowNo,int cellNo) throws IOException {
		File file =new File(path);
		FileInputStream inputStream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(name);
		Row row = sheet.getRow(rowNo);
		Cell cell = row.getCell(cellNo);
		String value="";
		int type = cell.getCellType();
	if(type==1) {
		value = cell.getStringCellValue();
	}else if(DateUtil.isCellDateFormatted(cell)){
		Date date=new Date();
		SimpleDateFormat dateFormat=new SimpleDateFormat("dd-mm-yyyy");
		value = dateFormat.format(date);
		}
	else {
		double d = cell.getNumericCellValue();
		long l=(long)d;
		value=String.valueOf(l);
		}
	return value;
	}
	//GetText
	public static  void getTxt(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}
	//GetAttribute
	public static  void getAtt(WebElement element) {
		String attribute = element.getAttribute("value");
		System.out.println(attribute);
	}
	//excel-write
	public static void excelSetType(String path,String name,String arg,int rowNo,int cellNo) throws IOException {
		File file =new File(path);
		FileInputStream inputStream=new FileInputStream(file);
		Workbook workbook=new XSSFWorkbook(inputStream);
		Sheet sheet = workbook.getSheet(name);
		Row row = sheet.getRow(rowNo);
		Cell createCell = row.createCell(cellNo);
		createCell.setCellValue(arg);
		FileOutputStream outputStream=new FileOutputStream(file);
		workbook.write(outputStream);
		System.out.println("Done");
	}
	//alert-ok
	public static  void alertOk() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
	}
	//alert-cancel
	public static  void alertCancel() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
	}
	//alert-sendkeys(cancel)
	public static void alertSendKeys(String arg) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(arg);
		alert.dismiss();
	}
	//alert-send keys(OK)
	public static void alertSendKeys1(String arg) {
		Alert alert = driver.switchTo().alert();
		alert.sendKeys(arg);
		alert.accept();
	}
	//alert-text-cancel
	public static void alertText() {
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.dismiss();
	}
	//alert-text-OK
	public static void alertText1() {
		Alert alert = driver.switchTo().alert();
		alert.getText();
		alert.accept();
	}
	//screenshot
	public static void screenShot(String arg) throws IOException{
		TakesScreenshot shot =(TakesScreenshot) driver;
		File screenshotAs = shot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs,new File(arg));
		System.out.println("Taked");
	}
}

