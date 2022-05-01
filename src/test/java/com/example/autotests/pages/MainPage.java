package com.example.autotests.pages;

import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class MainPage {
    By xPathClassFullName = By.xpath("//div[@class='tico ellip']");
    public String getName() {
        return $(xPathClassFullName).getText();
    }

    public boolean isLoadCheck(String name) {
        return $(xPathClassFullName).getText().equals(name);
    }
}
