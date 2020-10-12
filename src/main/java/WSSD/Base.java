package WSSD;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;
import java.util.concurrent.TimeUnit;



import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {

	public WebDriver driver;
	public Properties prop;

	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				"D:\\Paresh\\WSSD\\Automation\\src\\main\\java\\resources\\data.properties");
		prop.load(fis);
		String browsweName = prop.getProperty("browser");

		System.out.println(browsweName);

		if (browsweName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver",
					"D:\\Paresh\\Automation\\ChromeDriver_Version85\\chromedriver.exe");
			driver = new ChromeDriver();
		} else if (browsweName.equals("firefox")) {
			System.setProperty("webdriver.firefox.driver", "Need to download and set a path for this like chrome");
			driver = new FirefoxDriver();
		} else if (browsweName.equals("IE")) {
			System.setProperty("webdriver.IE.driver", "Need to download and set a path for this like chrome");
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;

	}

	public String getScreenShotPath(String testCaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png";
		FileUtils.copyFile(source, new File(destinationFile));
		return destinationFile;

	}

	public ArrayList<String> getData(String testcaseName, String moduleName) throws IOException {
		// fileInputStream argument
		ArrayList<String> a = new ArrayList<String>();

		FileInputStream fis = new FileInputStream("D://Paresh//Automation//DataForTesting.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);

		int sheets = workbook.getNumberOfSheets();
		for (int i = 0; i < sheets; i++) {
			//if (workbook.getSheetName(i).equalsIgnoreCase("TestData")) {
			if (workbook.getSheetName(i).equalsIgnoreCase(moduleName)) {
			
				XSSFSheet sheet = workbook.getSheetAt(i);
				// Identify Testcase's column by scanning the entire 1st row

				Iterator<Row> rows = sheet.iterator();// sheet is collection of
														// rows
				Row firstrow = rows.next();
				Iterator<Cell> ce = firstrow.cellIterator();// row is collection
															// of cells
				int k = 0;
				int coloumn = 0;
				while (ce.hasNext()) {
					Cell value = ce.next();

					if (value.getStringCellValue().equalsIgnoreCase("Testcases")) {
						coloumn = k;

					}

					k++;
				}
				System.out.println(coloumn);

				//// once column is identified then scan entire testcase's column
				while (rows.hasNext()) {

					Row r = rows.next();

					if (r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(testcaseName)) {

						//// after you grab testcase's row = pull all the
						//// data of that row and feed into test

						Iterator<Cell> cv = r.cellIterator();
						while (cv.hasNext()) {
							Cell c = cv.next();
							if (c.getCellTypeEnum() == CellType.STRING) {

								a.add(c.getStringCellValue());
							} else {

								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));

							}
						}
					}

				}

			}
		}
		return a;

	}
	
/*	public WebElement waitForVisibility(WebElement element) throws Error{
        return new WebDriverWait(driver, 60)
             .until(ExpectedConditions.visibilityOf(element));
 }*/

	
	
}
