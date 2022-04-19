package com.example.autotests.tests;

import com.example.autotests.pages.LoginPage;
import com.example.autotests.pages.AvatarPage;
import com.example.autotests.utils.Toolbar;
import com.example.autotests.utils.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestMethodIsAvatar {

    @Test
    public void isAvatarMethodTest() {
        //проверка одного технического метода на корректность работы
        Toolbar toolbar = new Toolbar();
        open("https://ok.ru");

        User user1 = toolbar.getUser1();
        User user2 = toolbar.getUser2();
        LoginPage loginPage = new LoginPage();
        loginPage.login(user1.getLogin(), user1.getPassword());

        open("https://ok.ru/profile/" + user1.getId());
        AvatarPage profilePage = new AvatarPage();
        Assertions.assertFalse(profilePage.isAvatar());

        open("https://ok.ru/profile/" + user2.getId());
        Assertions.assertTrue(profilePage.isAvatar());
    }
}

