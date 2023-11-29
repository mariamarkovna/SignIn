import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class OpenPageTest {
    public WebDriver driver;
    SignInPage signInPage= new SignInPage();
    AccesPage accesPage= new AccesPage();
    MyAccountPage myAccountPage = new MyAccountPage();




    @BeforeMethod
    public void init(){
        driver= new FirefoxDriver();
        //driver.get("https://letcode.in");
        driver.get("https://apfel:baum@account.pons.me/de/public/signin");
        WebDriverRunner.setWebDriver(driver);

    }
    @Test
    public void openPage() throws InterruptedException {
        Thread.sleep(5000);
        signInPage.accesPage.accPageIsExist();
        signInPage.accesPage.clickAccBtn();
        signInPage.singIn("m.isaeva.pons@gmail.com","Datagroup02!");
        myAccountPage.singOut();
    }

    @AfterMethod(enabled = true)
    public void tearDown() {
        driver.quit();
    }
}
