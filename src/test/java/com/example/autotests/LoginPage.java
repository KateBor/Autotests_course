package com.example.autotests;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

@Setter
@Getter
public class LoginPage {

    String xPathLogin = "st.email";
    String xPathPassword = "st.password";
    String xPathButton = "//*[@class='button-pro __wide']";

    public void login(String login, String password) {
        $(By.name(xPathLogin)).setValue(login);
        $(By.name(xPathPassword)).setValue(password);
        $(By.xpath(xPathButton)).click();
    }
}
