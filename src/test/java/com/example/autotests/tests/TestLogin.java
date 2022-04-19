package com.example.autotests.tests;
import com.example.autotests.utils.Toolbar;
import com.example.autotests.utils.User;
import com.example.autotests.pages.LoginPage;
import com.example.autotests.pages.MainPage;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.Selenide.*;

public class TestLogin {

    Toolbar toolbar = new Toolbar();

    @Test
    public void loginTest() {
        open("https://ok.ru");

        User user = toolbar.getUser1();
            LoginPage loginPage = new LoginPage();
            loginPage.login(user.getLogin(), user.getPassword());
            MainPage mainPage = new MainPage();
            assertEquals(mainPage.getName(), user.getFullName());
            System.out.println("Correct");
    }
}
