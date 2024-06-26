package org.texo.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import static org.texo.steps.Hook.driver;

public class GuidesPage {

    @FindBy(xpath = "//a[@href='/albums/1/photos']")
    private WebElement album1PhotosLink;

    private final By divJsonData = By.cssSelector("body > pre");

    public GuidesPage() {
        PageFactory.initElements(new AjaxElementLocatorFactory(driver, 20), this);
    }

    public void clickOnAlbum1PhotosLink() {
        album1PhotosLink.click();
    }

    public String getJsonDataAsString() {

        WebElement divText = driver.findElement(divJsonData);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        String hiddenText = (String) jsExecutor.executeScript("return arguments[0].textContent;", divText);
        return hiddenText;
    }

}
