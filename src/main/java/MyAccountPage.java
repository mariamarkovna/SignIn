import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static com.codeborne.selenide.Selenide.$;
import static org.testng.Assert.assertTrue;

public class MyAccountPage {

    private static By logOutBtn = By.xpath("//body/div[@id='app-root']/div[@class='columns container']/div[@id='single-spa-application:@pons/iam-mf-nav']/div[@class='sc-kOHTFB ivJeFg']/ul[@data-e2e='side-navigation']/li[10]/div[1]");
    public void singOut(){
        $(logOutBtn).click();
    }

}
