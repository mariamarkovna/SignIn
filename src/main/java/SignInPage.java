import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Selenide.$;

public class SignInPage {
    AccesPage accesPage = new AccesPage();
    //private static By emailInput = By.id("[id='emailInput']");
    private static By emailInput = By.xpath("//input[@id='emailInput']");

    //private static By passwordInput = By.id("id='passwordInput'");
    private static By passwordInput = By.xpath("//input[@id='passwordInput']");

    private static By submitBtn = By.xpath("//button[@type='submit']");

    public void singIn(String email, String password){
        $(emailInput).val(email);
        $(passwordInput).val(password);
        $(submitBtn).click();
    }



}
