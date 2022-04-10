package com.example.autotests.tests;

import com.example.autotests.pages.LoginPage;
import com.example.autotests.pages.AvatarPage;
import com.example.autotests.utils.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.codeborne.selenide.Selenide.open;

public class TestIsAvatar {

    @Test
    public void isAvatarTest() {

        open("https://ok.ru");
        String login1 = null;
        String password1 = null;
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Sources.txt")));
            login1 = reader.readLine();
            password1 = reader.readLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        User user1 = new User("Екатерина Борисова", login1, password1, "569442670075");
        User user2 = new User("Лев С", null, null, "567508353090");

        LoginPage loginPage = new LoginPage();
        loginPage.login(user1.getLogin(), user1.getPassword());

        open("https://ok.ru/profile/" + user1.getId());
        AvatarPage profilePage = new AvatarPage();
        Assertions.assertFalse(profilePage.isAvatar());

        open("https://ok.ru/profile/" + user2.getId());
        Assertions.assertTrue(profilePage.isAvatar());
    }
}

