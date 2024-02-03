package pomPages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CategoryPage {
	
	//Declaration
	@FindBy (xpath="//h1[normalize-space(text())='Course List ']")
	private WebElement pageHeader;
	
	@FindBy (xpath="//a[text()=' New']")
	private WebElement newButton;
	
	private String deletePath = "//td[text()='%s]/ancestor::tr/descendent::button[text"
	
	
	@FindBy (name="delete")
	private WebElement deleteButton;
	
	@FindBy (xpath="//b[text()='Add New User']")
	private WebElement pageHeader;
	
	@FindBy (xpath="//b[text()='Add New User']")
	private WebElement pageHeader;
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
