package com.example.autotests.tests;

import com.example.autotests.elements.Avatar;
import com.example.autotests.pages.LoginPage;
import com.example.autotests.pages.AvatarPage;
import com.example.autotests.utils.Toolbar;
import com.example.autotests.utils.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.codeborne.selenide.Selenide.open;

public class TestLike {
    Toolbar toolbar = new Toolbar();

    @Test
    public void likeTest() {

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
        //Data Registry (СПЕЦИАЛЬНО)
        User user = toolbar.getRandomUserNameAndId();
        User user1 = new User("Екатерина Борисова", login1, password1, "569442670075");
        LoginPage loginPage = new LoginPage();
        loginPage.login(user1.getLogin(), user1.getPassword());
        open("https://ok.ru/profile/" + user.getId());

        //ставим лайк на аватарку, если ее нет - пропускаем
        AvatarPage profilePage = new AvatarPage();
        if (!profilePage.isAvatar()) {
            return;
        }
        profilePage.openAvatar();
        Avatar avatar = new Avatar();

        if (!avatar.isLike()) {
            avatar.clickLike();
        }

        Assertions.assertTrue(avatar.isLike());

        //убираем лайк
        avatar.clickLike();
        Assertions.assertFalse(avatar.isLike());
    }
}
