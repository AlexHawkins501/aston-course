package com.alex;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainTest {
    @Test
    public void main() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        TestPayment page = new TestPayment(driver);
        driver.get("https://mts.by");
        page.setCookiesAgree();
        page.findPayWindow();
        page.checkLogoPaymentSys();
        page.changeHeaderPaymentHomeInternet();
        page.changeHeaderPaymentInstallmentPlan();
        page.changeHeaderPaymentArrears();
        page.changeHeaderPaymentPhone();
        page.checkLinkWork();
        page.paymentPhoneNumber();
    }
}