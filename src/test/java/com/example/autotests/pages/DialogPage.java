package com.example.autotests.pages;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Getter
@Setter
@NoArgsConstructor
public class DialogPage {
    String xPathMessage = "//msg-input";
    String xPathButton = "//msg-button[@data-tsid='button_send']";
    String xPathLastMessage = "(//msg-message[not(@mine)]//div/msg-parsed-text)[last()]";

    public void sendMessage(String message) {
        $(By.xpath(xPathMessage)).setValue(message);
        $(By.xpath(xPathButton)).click();
    }

    public String getLastMessage() {
        return $(By.xpath(xPathLastMessage)).getText();
    }
}
