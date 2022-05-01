package com.example.autotests.pages;

import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class ProfilePage {
    By xPathAvatarHref = By.xpath("//div[@class='card_wrp']//a[contains(@href,'/profile')]");
    By xPathLastPostComments = By.xpath("(//div[@class='feed-w']//span[@class='widget_tx'])[1]");
    By xPathUniqueElem = By.xpath("//h1[@class='__user-profile-name-decorator']");

    public boolean checkAvatar() {
        return $(xPathAvatarHref).exists();
    }

    public void openAvatar() {
        $(xPathAvatarHref).click();
    }

    public void openLastPostComments() {
        $(xPathLastPostComments).click();
    }

    public boolean isLoadCheck(String name) {
        return $(xPathUniqueElem).exists() && $(xPathUniqueElem).getText().equals(name);
    }
}
