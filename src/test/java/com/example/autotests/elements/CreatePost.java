package com.example.autotests.elements;

import com.codeborne.selenide.Condition;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class CreatePost {
    static String xPathPostFrame = "//div[@data-module='postingForm/mediaText']";
    static String xPathPostButton = "//div[@data-l='t,button.submit']";

    public void writePost(String text) {
        $(By.xpath(xPathPostFrame)).setValue(text);
        $(By.xpath(xPathPostButton)).shouldBe(Condition.visible);
        $(By.xpath(xPathPostButton)).click();
    }
}
