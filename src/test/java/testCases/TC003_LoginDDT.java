package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC003_LoginDDT extends BaseClass {

    @Test(dataProvider="LoginData", dataProviderClass= DataProviders.class , groups = "dataDriven")
    void LoginDDt(String email , String pwd , String expected){

        //HomePage:-
        logger.info("*******      Starting TC003_LoginDDT Test  ***********");
        HomePageObject hp1 = new HomePageObject(dr);
        hp1.selectMyAccount();
        hp1.selectLogin();

        //Login:-

        LoginPageObject lg = new LoginPageObject(dr);
        lg.setInp_Email(email);
        lg.setInp_Pwd(pwd);
        lg.ClkLogin();


        //My Account:

        MyAccountPageObject mpg = new MyAccountPageObject(dr);
        boolean targetPage = mpg.MyAccountPagePresent();

        if (expected.equalsIgnoreCase("Valid")){
            if(targetPage){

                Assert.assertTrue(true);
                mpg.getLogout();
                logger.info("Test Passed");

            }
            else {

                Assert.fail();
                logger.info("Test Failed");
                HomePageObject hp = new HomePageObject(dr);
                hp.selectMyAccount();
                hp.selectLogin();

            }
        }

        if(expected.equalsIgnoreCase("Invalid")){
            if(targetPage){
                Assert.fail();
                HomePageObject hp = new HomePageObject(dr);
                hp.selectMyAccount();
                hp.selectLogin();
                logger.info("*******     Test Failed ***********");

            }
            else {
                logger.info("*******     Test Passed ***********");
                Assert.assertTrue(true);
                mpg.getLogout();
            }
        }


        logger.info("*******      Finished TC003_LoginDDT Test  ***********");
    }

}
