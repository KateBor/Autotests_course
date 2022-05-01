package com.example.autotests.elements;

import com.codeborne.selenide.Condition;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class Avatar {
    String xPathLike = "(//ul[@data-l='t,actions']/li[@class='widget-list_i'])[last()]";
    String xPathActiveLike = "(//ul[@data-l='t,actions']/li[@class='widget-list_i'])[last()]//div[contains(@class, '__active')]";
    String nameComment = "st.dM";
    String xPathAddComment = "//button[@data-l='t,submit']";
    String xPathLastComment = "(//div[@class='comments_text textWrap'])[last()]";
    String xPathControlComments = "//div[@class='comments_controls-t']";

    public void clickLike() {
        $(By.xpath(xPathLike)).click();
    }

    public boolean isLike() {
        $(By.xpath(xPathLike)).shouldBe(Condition.visible);
        return $(By.xpath(xPathActiveLike)).exists();
    }

    public void writeComment(String comment) {
        $(By.name(nameComment)).setValue(comment);
        $(By.xpath(xPathAddComment)).click();
    }

    public String getLastComment() {
        return $(By.xpath(xPathLastComment)).getText();
    }

    public void deleteLastComment() {
        $(By.xpath(xPathControlComments)).shouldBe(Condition.visible);
        $(By.xpath(xPathAddComment)).click();
    }
}
