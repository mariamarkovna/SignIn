
import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverConditions.url;
import static org.openqa.selenium.devtools.v109.debugger.Debugger.pause;
import static org.testng.Assert.assertTrue;


public class OpenPageTest {
    public WebDriver driver;
    SignInPage signInPage= new SignInPage();
    AccesPage accesPage= new AccesPage();
    MyAccountPage myAccountPage = new MyAccountPage();
    private String baseUrl="https://apfel:baum@account.pons.me";

    public void checkUrlPath(String path) {
        String currentUrl = driver.getCurrentUrl();
        assertTrue(currentUrl.contains(path), "URL не содержит "+ path);
    }




    @BeforeMethod
    public void init(){
        driver= new FirefoxDriver();
        driver.get(baseUrl);
        checkUrlPath("/public/signin");
        WebDriverRunner.setWebDriver(driver);


//
//        // Проверяем, содержится ли в текущем URL подстрока "/public/signin"
//        if (currentUrl.contains("/public/signIn")) {
//            System.out.println("URL содержит /public/signin");
//        } else {
//            System.out.println("URL не содержит /public/signin");
//        }
//        //$ (baseUrl).shouldHave(contain("/public/signin"));



    }
    @Test
    public void logiInExistUser() throws InterruptedException {
        signInPage.accesPage.accPageIsExist();
        signInPage.accesPage.clickAccBtn();
        signInPage.singIn("m.isaeva.pons@gmail.com","Datagroup02!");

        String expectedUrlSubstring = "/private";
        String currentUrl = driver.getCurrentUrl();

        Assert.assertTrue(currentUrl.contains(expectedUrlSubstring),
                "URL не содержит ожидаемую подстроку " + expectedUrlSubstring);
        myAccountPage.singOut();
    }

    @Test
    public void logiInWithWrongData() throws InterruptedException {
        signInPage.accesPage.accPageIsExist();
        signInPage.accesPage.clickAccBtn();
        signInPage.singIn("" +
                "   ","Datagroup02!");
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }
}
