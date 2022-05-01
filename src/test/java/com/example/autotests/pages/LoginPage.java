package com.example.autotests.pages;

import lombok.NoArgsConstructor;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class LoginPage {

    By nameLogin = By.name("st.email");
    By namePassword = By.name("st.password");
    By xPathButton = By.xpath("//*[@data-l='t,sign_in']");

    public void login(String login, String password) {
        $(nameLogin).setValue(login);
        $(namePassword).setValue(password);
        $(xPathButton).click();
    }

    public boolean isLoadCheck() {
        return $(nameLogin).exists() && $(namePassword).exists();
    }
}
