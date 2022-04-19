package com.example.autotests.tests;

import com.example.autotests.elements.Avatar;
import com.example.autotests.pages.LoginPage;
import com.example.autotests.pages.AvatarPage;
import com.example.autotests.utils.Toolbar;
import com.example.autotests.utils.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class TestLike {
    Toolbar toolbar = new Toolbar();

    @Test
    public void likeTest() {

        open("https://ok.ru");
        //Data Registry
        User user = toolbar.getRandomUserWithAvatar();

        User user1 = toolbar.getUser1();
        LoginPage loginPage = new LoginPage();
        loginPage.login(user1.getLogin(), user1.getPassword());
        open("https://ok.ru/profile/" + user.getId());

        AvatarPage avatarPage = new AvatarPage();
        avatarPage.openAvatar();
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
