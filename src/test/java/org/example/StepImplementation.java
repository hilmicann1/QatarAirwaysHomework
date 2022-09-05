package org.example;

import com.thoughtworks.gauge.Gauge;
import com.thoughtworks.gauge.Step;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class StepImplementation extends BaseTest {


    @Step("<seconds> kadar saniye bekle")
    public void waitBySeconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds*1000);
    }

    @Step("ID'si <locator> olan elementi bul ve <text> yazdır.")
    public void sendKeysToElement(String locator, String text){
        appiumDriver.findElement(By.id(locator)).sendKeys(text);
    }

    @Step("ID'si <locator> olan elementi bul ve tıkla")
    public void clickElementWithID(String locator){
        appiumDriver.findElement(By.id(locator)).click();
        System.out.println("Element tıklandı.");
    }

    @Step("XPath'si <locator> olan elementi bul ve tıkla")
    public void clickElementWithXPath(String locator){
        appiumDriver.findElement(By.xpath(locator)).click();
        System.out.println("Element tıklandı.");
    }

    @Step("Accessability ID si <locator> olan elementi bul ve tıkla")
    public void clickElementWithAccid(String locator){
        appiumDriver.findElementByAccessibilityId((locator)).click();
        System.out.println("Element tıklandı.");
    }

    @Step("<xpath> Xpath'li elementler arasında rasgele bir tanesine tıkla")
    public void clickByrandomElement(String xpath){
        List<MobileElement> elements = appiumDriver.findElements(By.xpath(xpath));
        System.out.println("Total elements : " + elements.size());
        Random rand = new Random();
        int index = rand.nextInt(elements.size()-1);
        System.out.println("idex====" + index);
        elements.get(index).click();
    }
}
