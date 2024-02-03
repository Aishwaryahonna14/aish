package genericUtilities;

import org.openqa.selenium.WebDriver;

import pomPages.AddNewCategoryPage;
import pomPages.AddNewCoursePage;
import pomPages.CategoryPage;
import pomPages.CourseList;
import pomPages.HomePage;
import pomPages.UsersPage;
import pomPages.loginPage;

public class BaseClass {
	
	 private static final String IConstantPath = null;
	protected WebDriver driver;
	 protected propertiesutility property;
	 protected JavaUtility  jutil;
	 protected WebDriverUtility web;
	 protected ExcelUtility excel;
	
	protected loginPage login;
	protected HomePage hpme;
	protected UsersPage users;
	protected CourseList courseList;
	protected CategoryPage category;
	protected AddNewUserPage adduser;
	protected AddNewCoursePage addcourse;
	protected AddNewCategoryPage addcategory;
	
	//@BeforeSuite
	//@BeforeTest
	 
	@BeforeClass
	public void classSetup() {
		web = new WebDriverUtility();
		jutil = new JavaUtility();
		property = new PropertiesUtility();
		excel = new ExcelUtility();
		
	property.propertiesInit(IConstantPath.PROPERTIES_FILE_PATH);
	
	driver = web.launchrBrowserAndMaximize(property.readFromProperties("browser"));
	web.waitTillElementFound(Long.parseLong(property.readFromProperties("timeouts")));
		
	}
	@BeforeMethod
	public void methodSetup() {
		login = new loginPage(driver);
		home = new HomePage(driver);
		users = new UsersPage(driver);
		courseList = new CourseListPage(driver);
		category = new CategoryPage(driver);
		adduser = new AddNewUserPage(driver);
		addCourse = new AddNewCoursePage(driver);
		
		excel.excelInit(IConstantPath."EXCEL_PATH_SHEET1");
	
		Web.navigateTOApp(property.readFromProperties("url"));
		login.loginToApp(property.readFromProperties("username"), property.readFromProperties("password"));

	}
	
	//@AfterMethod
	public void methodTearDown() {
		excel.closeExcel();
	}
    //	@AfterClass
	public void classTearDown() {
		web.quitAllWindows();
	}
	
	
	@AfterTest
	@AfterSuite
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
