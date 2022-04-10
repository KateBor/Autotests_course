package com.example.autotests.pages;

import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@Getter
public class AvatarPage {
    String xPathAvatarHref = "//div[@class='card_wrp']//a[contains(@href,'/profile')]";

    public boolean isAvatar() {
        return $(By.xpath(xPathAvatarHref)).exists();
    }

    public void openAvatar() {
        $(By.xpath(xPathAvatarHref)).click();
    }
}
