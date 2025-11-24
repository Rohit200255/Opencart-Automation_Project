package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import testBase.BaseClass;

public class MyAccountPageObject extends BasePage {
    public MyAccountPageObject(WebDriver dr){
        super(dr);
    }
    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement MyAccountHeading;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']") WebElement Logout;

    public void getLogout(){
        Logout.click();
    }

    public boolean MyAccountPagePresent(){
        try {
            return MyAccountHeading.isDisplayed();
        }
        catch(Exception e){
            return false;
        }


    }
}

