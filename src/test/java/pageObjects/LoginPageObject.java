package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPageObject extends BasePage {
    public LoginPageObject(WebDriver dr) {
        super(dr);
    }

    @FindBy(xpath = "//input[@id='input-email']")
    WebElement inp_Email;
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement inp_Pwd;
    @FindBy(xpath = "//input[@value='Login']")
    WebElement btn_Login;


    public void setInp_Email(String email) {
        inp_Email.sendKeys(email);
    }

    public void setInp_Pwd(String pwd) {
        inp_Pwd.sendKeys(pwd);
    }

    public void ClkLogin() {
        btn_Login.click();
    }
}
