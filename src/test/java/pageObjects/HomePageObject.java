package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePageObject  extends BasePage {
    public HomePageObject(WebDriver dr){
        super(dr);
    }
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement clcOpenAccount;
    @FindBy(xpath = "//a[normalize-space()='Register']") WebElement clcRegister;
    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']") WebElement clk_Login;

    public void selectMyAccount(){
        clcOpenAccount.click();

    }
    public void selectRegister(){
        clcRegister.click();
    }
    public void selectLogin(){
        clk_Login.click();
    }
}
