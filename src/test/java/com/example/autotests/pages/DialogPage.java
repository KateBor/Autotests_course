package com.example.autotests.pages;

import lombok.NoArgsConstructor;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class DialogPage {
    By xPathMessage = By.xpath("//msg-input");
    By xPathButton = By.xpath("//msg-button[@data-tsid='button_send']");
    By xPathLastMessage = By.xpath("(//msg-message[not(@mine)]//div/msg-parsed-text)[last()]");

    public void sendMessage(String message) {
        $(xPathMessage).setValue(message);
        $(xPathButton).click();
    }

    public String getLastMessage() {
        return $(xPathLastMessage).getText();
    }

    public boolean isLoadCheck() {
        return $(By.className("content chat-messages")).exists();
    }
}
