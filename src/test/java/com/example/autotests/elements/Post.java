package com.example.autotests.elements;

import com.codeborne.selenide.Condition;
import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class Post {
    By xPathArticle = By.xpath("//div[@link-class='rev_cnt_a-in-txt']");
    By xPathLastComment = By.xpath("(//div[@class='d_comment_text textWrap'])[last()]");
    By xPathComment = By.xpath("//div[@class='ok-e js-ok-e add-placeholder add-caret __empty']");
    By xPathAddComment = By.xpath("//div[@id='ok-e-d_button']");
    By xPathControlComments = By.xpath("(//a[@title='Удалить комментарий'])[last()]");

    public void writeComment(String comment) {
        $(xPathComment).setValue(comment);
        $(xPathAddComment).click();
    }

    public String getLastComment() {
        return $(xPathLastComment).getText();
    }

    public void deleteLastComment() {
        $(xPathControlComments).shouldBe(Condition.visible);
        $(xPathAddComment).click();
    }

    public String getArticle() {
        return $(xPathArticle).getText();
    }
}
