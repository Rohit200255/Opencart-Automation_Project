package testCases;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import testBase.BaseClass;

public class TC001_Register extends BaseClass {



        @Test(groups = {"regression"})
        void RegisterUser () {
            try {

                logger.info("****** Starting TC001_Register Test   ********");

                HomePageObject pg = new HomePageObject(dr);
                logger.info("****** clicked MyAccount   ********");
                pg.selectMyAccount();
                logger.info("****** clicked Register option   ********");
                pg.selectRegister();
                RegisterPageObject rg = new RegisterPageObject(dr);
                logger.info("****** Taking User's Details...   ********");
                rg.setFName(RandomAlphabets().toUpperCase());
                rg.setLName(RandomAlphabets().toUpperCase());
                rg.setEmail(RandomAlphabets() + "@gmail.com");
                rg.setPhone(RandomNumbers());
                rg.clickSubscribe();
                String password = RandomAlphaNumeric();
                rg.setPwd(password);
                rg.setCnfPwd(password);
                rg.clickSubscribe();
                rg.setAgree();
                logger.info("****** Register Button is clicked..   ********");
                rg.clickRegister();

                String ConfirmRegister = rg.ConfirmMessage();
                Assert.assertEquals(ConfirmRegister, "Your Account Has Been Created!");

            } catch (Exception e) {
                logger.error("Test Failed..");
                logger.debug("Debug logs..");
                Assert.fail();

            }
            logger.info("********        Register Test Finished......... ********");
        }
}

