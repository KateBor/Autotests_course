package com.example.autotests.elements;

import com.codeborne.selenide.Condition;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class CreatePost {
    static By xPathPostFrame = By.xpath("//div[@data-module='postingForm/mediaText']");
    static By xPathPostButton = By.xpath("//div[@data-l='t,button.submit']");

    public void writePost(String text) {
        $(xPathPostFrame).setValue(text);
        $(xPathPostButton).shouldBe(Condition.visible);
        $(xPathPostButton).click();
    }
}
