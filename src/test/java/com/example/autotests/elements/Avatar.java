package com.example.autotests.elements;

import com.codeborne.selenide.Condition;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class Avatar {
    By xPathLike = By.xpath("(//ul[@data-l='t,actions']/li[@class='widget-list_i'])[last()]");
    By xPathActiveLike = By.xpath("(//ul[@data-l='t,actions']/li[@class='widget-list_i'])[last()]//div[contains(@class, '__active')]");
    By nameComment = By.name("st.dM");
    By xPathAddComment = By.xpath("//button[@data-l='t,submit']");
    By xPathLastComment = By.xpath("(//div[@class='comments_text textWrap'])[last()]");
    By xPathControlComments = By.xpath("//div[@class='comments_controls-t']");

    public void clickLike() {
        $(xPathLike).click();
    }

    public boolean isLike() {
        $(xPathLike).shouldBe(Condition.visible);
        return $(xPathActiveLike).exists();
    }

    public void writeComment(String comment) {
        $(nameComment).setValue(comment);
        $(xPathAddComment).click();
    }

    public String getLastComment() {
        return $(xPathLastComment).getText();
    }

    public void deleteLastComment() {
        $(xPathControlComments).shouldBe(Condition.visible);
        $(xPathAddComment).click();
    }
}
