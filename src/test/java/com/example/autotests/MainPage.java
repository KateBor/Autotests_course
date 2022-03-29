package com.example.autotests;

import com.codeborne.selenide.SelenideElement;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

@NoArgsConstructor
public class MainPage {
    String xPathClassFullName = "//div[@class='tico ellip']";
    public String getName() {
        return $(By.xpath(xPathClassFullName)).getText();
    }

}
