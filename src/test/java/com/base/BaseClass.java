package com.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;


/**
 * 
 * @author Vignesh
 * @see Reusabe method in selenium
 * @Date 02/01/2023
 */
public class BaseClass {
	
	public static WebDriver driver;
	/**
	 * @see Initial the browser
	 */
	//WebdriverManager launch URL
	public static void getDriverweb() {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		
	}
	/**
	 * 
	 * @param tagName
	 * @return
	 * @see Find element by using tagName
	 */
	public WebElement trLocator(String tagName) {
		WebElement findElement = driver.findElement(By.tagName(tagName));
		return findElement;
	}
	/**
	 * 
	 * @param url
	 * @see Launch the URL
	 */
	// 1)Enter URL
	public static void getURL(String url) {
		driver.get(url);
	}
	/**
	 * 
	 * @param element
	 * @param data
	 * @see Send the value to element
	 */
	//send keye
	public void sendvalue(WebElement element,String data) {
		element.sendKeys(data);
	}
	/**
	 * @see Maximize the browser
	 */
	// 2)Maximize Window
	public static void maxiWindow() {
		driver.manage().window().maximize();
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Get the text from element
	 */
	// 3)Insert value in Text Box
	public String valueTextbox(WebElement element) {
		String text = element.getText();
		return text;
	}
	/**
	 * 
	 * @param Data
	 * @See Click the webelement
	 */
	// 4)Click Button
	public void elementClick(String Data ) {
		WebElement findElement = driver.findElement(By.xpath(Data));
		findElement.click();
	}
	/**
	 * 
	 * @param element
	 * @see Click the WebElement
	 */
	public void getClick(WebElement element ) {
		element.click();
	}
	/**
	 * 
	 * @return
	 * @see Accept the alert
	 */
	// 5)Click OK Alert
	public Alert getAcceptAlert() {
		Alert alert = driver.switchTo().alert();
		alert.accept();
		return alert;
	}
	/**
	 * 
	 * @return
	 * @see Dismiss the alert
	 */
	// 6)Click cancel in Alert
	public Alert dismissAlert() {
		Alert alert = driver.switchTo().alert();
		alert.dismiss();
		return alert;
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Get the text from webelement
	 */
	// 7)Get the text From webpage
	public String webpageText(WebElement element) {
		String text = element.getText();
		return text;
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Get the Attribute value from webelement
	 */
	// 8)Get the Inserted value from Text
	public String getAttributevalue(WebElement element) {
		String attribute = element.getAttribute("value");
		return attribute;
	}
	/**
	 * @see Close the all window
	 */
	// 9)Close all window
	public void closeAllwin() {
		driver.quit();
	}
	/**
	 * @see Close the current window
	 */
	// 10)Close current Window
	public void closeCurrentwin() {
		driver.close();
	}
	/**
	 * 
	 * @return
	 * @see Get the title from webpage
	 */
	// 11)Get The Title
	public String webpageTitle() {
		String title = driver.getTitle();
		return title;
	}
	/**
	 * 
	 * @return
	 * @see Get the current URL
	 */
	// 12)Get the Enetered URL
	public String webpageURL() {
		String currentUrl = driver.getCurrentUrl();
		return currentUrl;
	}
	/**
	 * 
	 * @param element
	 * @param text
	 * @see Select the dropdown by using visible text
	 */
	// 13)Select dropDown option by Text
	public void dropDownText(WebElement element, String text) {
		Select sl = new Select(element);
		sl.selectByVisibleText(text);
	}
	/**
	 * 
	 * @param element
	 * @see Select the dropdown by using value
	 */
	// 14)Select dropdown option by Attribute
	public void dropDownAttribute(WebElement element) {
		Select sl = new Select(element);
		sl.selectByValue("value");
	}
	/**
	 * 
	 * @param element
	 * @param index
	 * @Select the dropdown by using Index text
	 */
	// 15)Select dropdown option by Index
	public void dropDownIndex(WebElement element, int index) {
		Select sl = new Select(element);
		sl.selectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @param name
	 * @return
	 * @see Send value by using JS
	 */
	// 16)Insert Value in text box by using JV
	public JavascriptExecutor textInsertJV(WebElement element, String name) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		Object executeScript = js.executeScript("arguments[0].setAttribute('value'," + name + "')", element);
		return (JavascriptExecutor) executeScript;
	}
	/**
	 * 
	 * @param element
	 * @see Click the webelement by using JS
	 */
	// 17)Click button by JS
	public void clickusingJS(WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}
	/**
	 * @see Initial the webbrowser
	 */
	// 18)Launch the chrome Browser
	public void browserLaunch() {
		WebDriver driver = new ChromeDriver();
	}
	/**
	 * @see Switch the control to window
	 */
	// 19)swith to child window
	public void childWin() {
		String windowHandle = driver.getWindowHandle();
		Set<String> windowHandles = driver.getWindowHandles();
		for (String x : windowHandles) {
			if (!windowHandle.equals(windowHandles)) {
				driver.switchTo().window(x);
			}
		}
	}
	/**
	 * 
	 * @param index
	 * @return
	 * @see Switch the control to frame by using index
	 */
	// 20)Swith to Frame by Index
	public WebElement framebyIndex(int index) {
		WebDriver frame = driver.switchTo().frame(index);
		return (WebElement) frame;
	}
	/**
	 * 
	 * @param index
	 * @return
	 * @see Switch the control to frame by using index
	 */
	// 21)Swith to frame by ID
	public WebElement framebyID(int index) {
		WebDriver frame = driver.switchTo().frame(index);
		return (WebElement) frame;
	}
	/**
	 * 
	 * @param id
	 * @return
	 * @see By using locator id to find the element
	 */
	// 22)Find Locator by ID
	public WebElement locatorID(String id) {
		WebElement findElement = driver.findElement(By.id(id));
		return findElement;
	}
	/**
	 * 
	 * @param id
	 * @return
	 * @see By using locator name to find the element
	 */
	// 23)Find Locator by Name
	public WebElement locatorname(String id) {
		WebElement findElement = driver.findElement(By.name(id));
		return findElement;
	}
	/**
	 * 
	 * @param id
	 * @return
	 * @see By using locator className to find the element
	 */
	// 24)Find Locator by Name
	public WebElement locatorClassname(String id) {
		WebElement findElement = driver.findElement(By.className(id));
		return findElement;
	}
	/**
	 * 
	 * @param id
	 * @return
	 * @see By using locator xpath to find the element
	 */
	// 25)Find Locator by Xpath
	// 23)Find Locator by Name
	public WebElement locatorXpath(String id) {
		WebElement findElement = driver.findElement(By.xpath(id));
		return findElement;
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Get the all text from dropdown
	 */
	// 26)Get All options From Dropdown as a Text
	public String dropdownAllText(WebElement element) {
		Select sl = new Select(element);
		List<WebElement> options = sl.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String text = webElement.getText();
			return text;

		}
		return null;
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Get the all attribute from dropdown
	 */
	// 27)Get All options From Dropdown as a Attribute
	public String dropdownAllAttribute(WebElement element) {
		Select sl = new Select(element);
		List<WebElement> options = sl.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement webElement = options.get(i);
			String attribute = webElement.getAttribute("value");
			return attribute;

		}
		return null;
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Get the first selected option from dropdown
	 */
	// 28)Get the First Selected option Text in Dropdown
	public String firstSelectedText(WebElement element) {
		Select sl = new Select(element);
		WebElement firstSelectedOption = sl.getFirstSelectedOption();
		String text = firstSelectedOption.getText();
		return text;
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Check the dropdown whether it's multi select or not
	 */
	// 29)Verify In dropDown isMultiple
	public boolean dopdownMulti(WebElement element) {
		Select sl = new Select(element);
		boolean multiple = sl.isMultiple();
		return multiple;
	}
	/**
	 * 
	 * @param time
	 * @see Implicity wait use
	 */
	// 30)Implicity wait
	public void implicitywait(int time) {
		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
	}
	/**
	 * 
	 * @param timeout
	 * @see Explicity wait
	 */
	// 31)Explicity wait for Visibility of
	private void explicityWait(Duration timeout) {
		WebDriver wait = (WebDriver) new WebDriverWait(driver, timeout);
	}
	/**
	 * 
	 * @param input
	 * @see FluentWait
	 */
	// 32)Fluent Wait
	public void fluentWait(String input) {
		WebDriver wait = (WebDriver) new FluentWait(input);
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Check the element whether it's displayed or not
	 */
	// 33)Verify isDisplayed
	public boolean webelemetnisDisplayed(WebElement element) {
		boolean displayed = element.isDisplayed();
		return displayed;
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Check the element whether it's isEnabled or not
	 */
	// 34)Verify isEnabled
	public boolean webelemetnEnaled(WebElement element) {
		boolean displayed = element.isEnabled();
		return displayed;
	}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Verify the element is selected or not
	 */
	// 35)Verify isSelected
	public boolean webelemetnisSelected(WebElement element) {
		boolean displayed = element.isSelected();
		return displayed;
	}
	/**
	 * 
	 * @param element
	 * @param index
	 * @see Deselected value in dropdown by using index
	 */
	// 36)DeSelect by Index
	public void unselectedIndex(WebElement element, int index) {
		Select sl = new Select(element);
		sl.deselectByIndex(index);
	}
	/**
	 * 
	 * @param element
	 * @see Deselected value in dropdown by using value
	 */
	// 37)DeSelect by Attribute
	public void unselectedAttribute(WebElement element) {
		Select sl = new Select(element);
		sl.deselectByValue("value");
	}
	/**
	 * 
	 * @param element
	 * @param text
	 * @see Deselected value in dropdown by using visible text
	 */
	//38)DeSelect by Text
			public void unselectedText(WebElement element,String text) {
				Select sl=new Select(element);
				sl.deselectByVisibleText(text);
			}
	/**
	 * 
	 * @param element
	 * see Deselect all in dropdown
	 */
	//39)DeSelect by All
			public void unselectedAll(WebElement element) {
				Select sl=new Select(element);
				sl.deselectAll();
			}
	/**
	 * 
	 * @return
	 * @see Get the parent window
	 */
	//40)Get the parent Window
			public String parentWin() {
				String windowHandle = driver.getWindowHandle();
				return windowHandle;
			}
	/**
	 * 
	 * @return
	 * @see Get the all window
	 */
	//41)Get the parent Window
			public Set<String> childWin1() {
				Set<String> windowHandles = driver.getWindowHandles();
				return windowHandles;
			}
	/**
	 * 
	 * @param element
	 * @see Clear the value to webelement
	 */
	//42)Clear Text Box
			public void textClear(WebElement element) {
				element.clear();
			}
	/**
	 * 
	 * @return
	 * @see Take the screen shot formate as BYTES
	 */
	//43)TakeScreenShot
			public byte[] screenshot() {
				TakesScreenshot ts=(TakesScreenshot) driver;
				byte[] screenshotAs = ts.getScreenshotAs(OutputType.BYTES);
				return screenshotAs;
			}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Take the screen shot formate as FILE
	 */
	//44)TakeScreenShot for Element
			public File screenshotElemennt(WebElement element) {
				TakesScreenshot ts=(TakesScreenshot) driver;
				File screenshotAs = element.getScreenshotAs(OutputType.FILE);
				return screenshotAs;
			}
	/**
	 * 
	 * @param element
	 * @see Curser move to desired element
	 */
	//45)Mouse over actions for Single options
			public void mouseover(WebElement element) {
				Actions as=new Actions(driver);
				as.moveToElement(element).perform();
			}
	/**
	 * 
	 * @param source
	 * @param target
	 * @see Perform the drag and drop
	 */
	//46)Drag and Drop
			public void dragandDrop(WebElement source,WebElement target) {
				Actions as=new Actions(driver);
				as.dragAndDrop(source, target).perform();
			}
	/**
	 * 
	 * @param element
	 * @see Perform the right click
	 */
	//47)Right Click
			public void rightclickElement(WebElement element) {
				Actions as=new Actions(driver);
				as.contextClick(element).perform();;
			}
	/**
	 * 
	 * @param element
	 * @see Perform the double click
	 */
	//48)Double Click
			public void doubleclickElement(WebElement element) {
				Actions as=new Actions(driver);
				as.doubleClick(element).perform();
			}
	/**
	 * 
	 * @param element
	 * @param keysToSend
	 * @see Send the value and click by using ENTER
	 */
	//49)Insert Value in Textbox and Enter
			public void textintoTextbox(WebElement element,String keysToSend) {
				element.sendKeys(keysToSend,Keys.ENTER);
			}
	/**
	 * @see Refresh the webpage by using navigate
	 */
	//50)Refresh Webpage
			public void referesh() {
				driver.navigate().refresh();
			}
	/**
	 * @see Forward the webpage by using navigate
	 */
	//51)Forward to webpage
			public void forward() {
				driver.navigate().forward();
			}
	/**
	 * @see Back the webpage by using navigate
	 */
	//52)Backward to webpage
			public void back() {
			driver.navigate().back();
		}
	/**
	 * 
	 * @param url
	 * @see Launch the url on webpage by using navigate
	 */
	//53)Get URL using navigate
			public void urlGet(String url) {
			driver.navigate().to(url);
		}
	/**
	 * 
	 * @return
	 * @see Get the text from alert prompt
	 */
	//54)Text get from Alert
			public String alertText() {
				String text = driver.switchTo().alert().getText();
				return text;
			}
	/**
	 * 
	 * @param element
	 * @return
	 * @see ScrollDown by using JS
	 */
	//55)Scroll up using JS scrip
			public Object scrollupJS(WebElement element) {
				JavascriptExecutor js=(JavascriptExecutor) driver;
				Object executeScript = js.executeScript("arguments[0].scrollIntoView(true)", element);
				return executeScript;
			}
	/**
	 * 
	 * @param element
	 * @return
	 * @see ScrollUp by using JS
	 */
	//56)Scroll up using JS scrip
			public Object scrollDownJS(WebElement element) {
				JavascriptExecutor js=(JavascriptExecutor) driver;
				Object executeScript = js.executeScript("arguments[0].scrollIntoView(false)", element);
				return executeScript;
			}
		
	/**
	 * 
	 * @param element
	 * @return
	 * @see Select all option in dropdown
	 */
	//57)Dropdown Get All Selected option
			public List<WebElement> allSelect(WebElement element) {
				Select sl=new Select(element);
				List<WebElement> allSelectedOptions = sl.getAllSelectedOptions();
				return allSelectedOptions;				
			}
	/**
	 * 
	 * @return
	 * @see Get the page source
	 */
	//58)Get webpage sourse
			public String webpageSource() {
				String pageSource = driver.getPageSource();
				return pageSource;
			}
	/**
	 * 
	 * @return
	 * @see Check on webpage if frame on html
	 */
	//59)Verify the webpage frame source present or not
			public boolean frameSource() {
				String pageSource = driver.getPageSource();
				boolean contains = pageSource.contains("frame");
				return contains;				
			}
	/**
	 * 
	 * @return
	 * @see Control move to webpage
	 */
	//60)Frame to webpage
			public WebElement switchtoweb() {
				WebDriver defaultContent = driver.switchTo().defaultContent();
				return null;
			}
	/**
	 * 
	 * @return
	 * @see Driver control move child to parent
	 */
	//61)Child frame to parent frame control swith
			public WebElement parentDirectaccess() {
				WebDriver parentFrame = driver.switchTo().parentFrame();
				return null;
			}
	/**
	 * 
	 * @param element
	 * @return
	 * @see Get the dimension of the element
	 */
	//62)Element size
			public Dimension webRow(WebElement element) {
				Dimension size = element.getSize();
				return size;
				
			}
	/**
	 * 
	 * @throws InterruptedException
	 * @see Static wait
	 */
	//63)Static wait
			public void staticWait() throws InterruptedException {
				Thread.sleep(3000);
			}
	/**
	 * 
	 * @param name
	 * @see Get the excel path
	 */
	//64)ExcelPath
			public void excelPath(String name) {
				File file=new File(name);
			}
	/**
	 * 
	 * @param name
	 * @return
	 * @throws IOException
	 * @see Get the work book from excel
	 */
	//65)Create Workbook for excel
			public Workbook workBook(String name) throws IOException {
				File file=new File(name);
				FileInputStream stream=new FileInputStream(file);
				Workbook workbook=new XSSFWorkbook(stream);
				return workbook;
			}
	/**
	 * 
	 * @param name
	 * @param sheetName
	 * @return
	 * @throws IOException
	 * @see Get the sheet from excel
	 */
	//66)Create Sheet for excel
			public Sheet sheetfromworkbook(String name,String sheetName) throws IOException {
				File file=new File(name);
				FileInputStream stream=new FileInputStream(file);
				Workbook workbook=new XSSFWorkbook(stream);
				Sheet sheet = workbook.getSheet(sheetName);
				return sheet;
			}
	/**
	 * 
	 * @param name
	 * @param sheetName
	 * @param rownum
	 * @return
	 * @throws IOException
	 * @see Get the sheet from excel
	 */
	//67)Row from sheet
			public Row rowfromSheet(String name,String sheetName,int rownum) throws IOException {
				File file=new File(name);
				FileInputStream stream=new FileInputStream(file);
				Workbook workbook=new XSSFWorkbook(stream);
				Sheet sheet = workbook.getSheet(sheetName);
				Row row = sheet.getRow(rownum);
				return row;
			}
	/**
	 * 
	 * @param name
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 * @see Get the cell from excel
	 */
	//68)Cell fom row
			public Cell cellfromSheet(String name,String sheetName,int rownum,int cellnum) throws IOException {
				File file=new File(name);
				FileInputStream stream=new FileInputStream(file);
				Workbook workbook=new XSSFWorkbook(stream);
				Sheet sheet = workbook.getSheet(sheetName);
				Row row = sheet.getRow(rownum);
				Cell cell = row.getCell(cellnum);
				return cell;
			}
	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @return
	 * @throws IOException
	 * @see Read the value from excel
	 */
	//69)Read value from Excel sheet
			
			public String readCellData(String sheetName,int rownum,int cellnum) throws IOException {
				String res="";
				File file=new File("C:\\Users\\ggowt\\eclipse-workspace\\Test\\Excel\\Book1.xlsx");
				FileInputStream stream=new FileInputStream(file);
				Workbook workbook=new XSSFWorkbook(stream);
				Sheet sheet = workbook.getSheet(sheetName);
				Row row = sheet.getRow(rownum);
				Cell cell = row.getCell(cellnum);
				CellType type = cell.getCellType();
				switch (type) {
				case STRING:
					res=cell.getStringCellValue();
					break;
				case NUMERIC:
					if(DateUtil.isCellDateFormatted(cell)) {
						Date dateCellValue = cell.getDateCellValue();
						SimpleDateFormat date=new SimpleDateFormat("DD/MM/YYYY");
						res=date.format(dateCellValue);
					}else {
						double numericCellValue = cell.getNumericCellValue();
						BigDecimal valueof=BigDecimal.valueOf(numericCellValue);
						res=valueof.toString();
						
					}
				default:
					break;
				}
				
				return res;
				
			}
	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param oldData
	 * @param newData
	 * @throws IOException
	 * @see Update the value to excel
	 */
		//70)Update value into excell
			public void updateCellData(String sheetName,int rownum,int cellnum,String oldData,String newData) throws IOException {
				File file=new File("C:\\Users\\ggowt\\eclipse-workspace\\\\Test\\Excel\\Book2.xlsx");
				FileInputStream stream=new FileInputStream(file);
				Workbook workbook=new XSSFWorkbook(stream);
				Sheet sheet = workbook.getSheet(sheetName);
				Row row = sheet.getRow(rownum);
				Cell cell = row.getCell(cellnum);
				String value = cell.getStringCellValue();
				if(value.equals(oldData)) {
					cell.setCellValue(newData);
				}
				FileOutputStream out=new FileOutputStream(file);
				workbook.write(out);
			}
	/**
	 * 
	 * @param sheetName
	 * @param rownum
	 * @param cellnum
	 * @param data
	 * @throws IOException
	 * @see 
	 */
		//71)Write the Data into Excel
			public void writeCellData(String sheetName,int rownum,int cellnum,String data) throws IOException {
				File file=new File("C:\\Users\\ggowt\\eclipse-workspace\\Test\\Excel\\Book1.xlsx");
				FileInputStream stream=new FileInputStream(file);
				Workbook workbook=new XSSFWorkbook(stream);
				Sheet sheet = workbook.getSheet(sheetName);
				Row row = sheet.getRow(rownum);
				Cell cell = row.getCell(cellnum);
				cell.setCellValue(data);
				FileOutputStream out=new FileOutputStream(file);
				workbook.write(out);
			}
	/**
	 * 
	 * @throws AWTException
	 * @see Key board perform
	 */
			
			public void enterKeyRobot() throws AWTException {
				Robot r=new Robot();
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				r.keyPress(KeyEvent.VK_TAB);
				r.keyRelease(KeyEvent.VK_TAB);
				r.keyPress(KeyEvent.VK_ENTER);
				r.keyPress(KeyEvent.VK_ENTER);
			}
	/**
	 * 
	 * @return
	 * @see Get project path
	 */
			public static String getProjectPath() {
				String property = System.getProperty("user.dir");
				return property;
			}
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 * @see Read value from properties file
	 */
			public static String getPropertyFileValue(String key) throws IOException {
				Properties properties=new Properties();
				
				properties.load(new FileInputStream(getProjectPath()+"\\config\\config.properties"));
				Object object = properties.get(key);
				String value=(String) object;
				return value;	
			}
	/**
	 * 
	 * @param browserType
	 * @see Access multi browser
	 */
			public static void getDriver(String browserType) {
				switch (browserType) {
				case "Chrome":
					WebDriverManager.chromedriver().setup();
					driver=new ChromeDriver();
					break;
				case "FireFox":
					WebDriverManager.firefoxdriver().setup();
					driver=new FirefoxDriver();
					break;
				case "ie":
					WebDriverManager.iedriver().setup();
					driver=new InternetExplorerDriver();
					break;
				case "Edge":
					WebDriverManager.edgedriver().setup();
					driver=new EdgeDriver();
					break;
				default:
					break;
				}
				
			}
			
}
	
			
			
			

