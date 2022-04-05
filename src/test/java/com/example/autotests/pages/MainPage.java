package com.example.autotests.pages;

import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class MainPage {
    String xPathClassFullName = "//div[@class='tico ellip']";
    public String getName() {
        return $(By.xpath(xPathClassFullName)).getText();
    }

}
