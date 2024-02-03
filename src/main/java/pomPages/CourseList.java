package pomPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CourseList {

	//Declaration
	@FindBy (xpath="//h1[normalize-space(text())='Course List ']")
	private WebElement pageHeader;
	
	@FindBy (xpath="//a[text()=' New']")
	private WebElement newButton;
	
	//td[text()='+coursename+']/ancestor::tr/descendent::button[text()='Delete']
	
	
	@FindBy (xpath="")
	private WebElement pageHeader;
	
	@FindBy (xpath="//b[text()='Add New User']")
	private WebElement pageHeader;
	//td[text()='+coursename+']/ancestor::tr/descendent::button[text()='delete']
	@FindBy (xpath="//b[text()='Add New User']")
	private WebElement pageHeader;
	
	
}
//Initialization 
public Cousre