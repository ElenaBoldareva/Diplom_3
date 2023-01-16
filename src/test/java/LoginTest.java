import io.qameta.allure.junit4.DisplayName;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import pageobjects.ForgotPasswordPage;
import pageobjects.LoginPage;
import pageobjects.MainPage;
import pageobjects.RegisterPage;

@RunWith(Parameterized.class)
public class LoginTest extends BaseTest {

    public LoginTest(String browser) {
        super(browser);
    }

    @Test
    @DisplayName("Check login using the button Login to your account on the main page")
    public void checkLogIn() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.waitForLoad(DEFAULT_TIMEOUT);
        mainPage.clickSingInButton();
        loginPage.waitForLoad(DEFAULT_TIMEOUT);
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickSignInButton();
        mainPage.waitForLoad(DEFAULT_TIMEOUT);

        Assert.assertEquals(HOST, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check login through the button Personal account")
    public void checkLogInAccount() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);

        mainPage.waitForLoad(DEFAULT_TIMEOUT);
        mainPage.clickAccountLink();
        loginPage.waitForLoad(DEFAULT_TIMEOUT);
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickSignInButton();
        mainPage.waitForLoad(DEFAULT_TIMEOUT);

        Assert.assertEquals(HOST, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check the login through the button in the registration form")
    public void checkLogInFormRegister() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        RegisterPage registerPage = new RegisterPage(driver);

        mainPage.waitForLoad(DEFAULT_TIMEOUT);
        mainPage.clickAccountLink();
        loginPage.waitForLoad(DEFAULT_TIMEOUT);
        loginPage.clickRegisterLink();
        registerPage.waitForLoad(DEFAULT_TIMEOUT);
        registerPage.clickLoginLink();
        loginPage.waitForLoad(DEFAULT_TIMEOUT);
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickSignInButton();
        mainPage.waitForLoad(DEFAULT_TIMEOUT);

        Assert.assertEquals(HOST, driver.getCurrentUrl());
    }

    @Test
    @DisplayName("Check the login through the button in the password recovery form")
    public void checkLogInForgotPassword() {
        MainPage mainPage = new MainPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        ForgotPasswordPage forgotPasswordPage = new ForgotPasswordPage(driver);

        mainPage.waitForLoad(DEFAULT_TIMEOUT);
        mainPage.clickAccountLink();
        loginPage.waitForLoad(DEFAULT_TIMEOUT);
        loginPage.clickForgotPasswordLink();
        forgotPasswordPage.waitForLoad(DEFAULT_TIMEOUT);
        forgotPasswordPage.clickLoginLink();
        loginPage.setEmail(user.getEmail());
        loginPage.setPassword(user.getPassword());
        loginPage.clickSignInButton();
        mainPage.waitForLoad(DEFAULT_TIMEOUT);

        Assert.assertEquals(HOST, driver.getCurrentUrl());
    }
}
