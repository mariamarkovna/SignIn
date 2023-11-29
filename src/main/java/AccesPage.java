import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class AccesPage {
    private static By accButton = By.cssSelector("[data-e2e='pure-accept-ads']");
    private static By accPage = By.xpath("//h2[@class='sc-jTrPJq iucsig pons-components-text pons-components-text-header4 pons-components-text-sans-serif']");

    public void accPageIsExist() {
        $(accPage).isDisplayed();
    }
    public void clickAccBtn() {
        $(accButton).click();
    }

}
