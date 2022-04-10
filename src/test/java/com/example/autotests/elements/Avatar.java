package com.example.autotests.elements;

import com.codeborne.selenide.Condition;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class Avatar {
    String xPathLike = "(//ul[@data-l='t,actions']/li[@class='widget-list_i'])[last()]";
    String xPathActiveLike = "(//ul[@data-l='t,actions']/li[@class='widget-list_i'])[last()]//div[contains(@class, '__active')]";

    public void clickLike() {
        $(By.xpath(xPathLike)).click();
    }

    public boolean isLike() {
        $(By.xpath(xPathLike)).shouldBe(Condition.visible);
        return $(By.xpath(xPathActiveLike)).exists();


    }
}
