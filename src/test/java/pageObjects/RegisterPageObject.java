package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisterPageObject extends BasePage {

    public RegisterPageObject(WebDriver dr)
    {
        super(dr);
    }
    @FindBy(xpath = "//input[@id='input-firstname']")
    WebElement inp_Fname;
    @FindBy(xpath = "//input[@id='input-lastname']")
    WebElement inp_Lname;
    @FindBy(xpath = "//input[@id='input-email']")
    WebElement inp_Email;
    @FindBy(xpath = "//input[@id='input-telephone']")
    WebElement inp_Phone;
    @FindBy(xpath = "//label[normalize-space()='Yes']//input[@name='newsletter']")
    WebElement clkSubs;
    @FindBy(xpath = "//input[@id='input-password']") WebElement inp_Pwd;
    @FindBy(xpath = "//input[@id='input-confirm']") WebElement cnf_Pwd;
    @FindBy(xpath = "//input[@name='agree']") WebElement agree;
    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btn_Register;
    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']") WebElement Heading;

    public void setPwd(String pwd){ inp_Pwd.sendKeys(pwd); }
    public void setCnfPwd(String pwd2){ cnf_Pwd.sendKeys(pwd2); }

    public void setFName(String fname) {
        inp_Fname.sendKeys(fname);
    }

    public void setLName(String lname) {
        inp_Lname.sendKeys(lname);
    }

    public void setEmail(String email) {
        inp_Email.sendKeys(email);
    }

    public void setPhone(String pwd) {
        inp_Phone.sendKeys(pwd);
    }

    public void clickSubscribe() {
        clkSubs.click();
    }
    public void setAgree(){ agree.click();}

    public void clickRegister() {
        btn_Register.click();
    }

    public String ConfirmMessage(){
        return Heading.getText();
    }
}
