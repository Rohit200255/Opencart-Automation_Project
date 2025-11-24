package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import testBase.BaseClass;

public class TC002_Login extends BaseClass {

    @Test(groups = {"regression","master","sanitary"})
    void LoginUser(){

        logger.info("********        Login Test Started......... ********");
        HomePageObject pg = new HomePageObject(dr);
        logger.info("********        Clicked on MyAccount......... ********");
        pg.selectMyAccount();
        logger.info("********        Clicked on Login......... ********");
        pg.selectLogin();
        LoginPageObject lg = new LoginPageObject(dr);
        logger.info("********        User is entering credentials......... ********");

        lg.setInp_Email(p.getProperty("email"));
        lg.setInp_Pwd(p.getProperty("password"));
        logger.info("********        Clicked on login Button......... ********");
        lg.ClkLogin();


//        String ConfirmLogin = lg.ConfirmMessage2();
//        Assert.assertEquals(ConfirmLogin,"My Account");


        MyAccountPageObject mpg = new MyAccountPageObject(dr);
        boolean status = mpg.MyAccountPagePresent();
        Assert.assertTrue(status,"true");
        logger.info("********        Login Test Finished......... ********");

    }
}

