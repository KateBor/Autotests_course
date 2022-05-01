package com.example.autotests.tests;

import com.example.autotests.elements.Avatar;
import com.example.autotests.pages.ProfilePage;
import com.example.autotests.utils.Utils;
import com.example.autotests.utils.User;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class LikeTest extends BaseTest {
    static Avatar avatar = new Avatar();
    static ProfilePage profilePage = new ProfilePage();

    @BeforeAll
    static void checkEmptyLike() {
        //если был лайк - убираем
        User user = Utils.getRandomUserWithAvatar();
        open("https://ok.ru/profile/" + user.getId());
        profilePage.openAvatar();
        if (avatar.isLike()) {
            avatar.clickLike();
        }
    }
    @Test
    public void likeTest() {
        avatar.clickLike();
        assertTrue(avatar.isLike());
    }

    @AfterAll
    static void deleteLike() {
        avatar.clickLike();
        assertFalse(avatar.isLike());
    }
}
