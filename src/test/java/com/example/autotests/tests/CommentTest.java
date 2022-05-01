package com.example.autotests.tests;

import com.example.autotests.elements.Avatar;
import com.example.autotests.elements.Post;
import com.example.autotests.pages.ProfilePage;
import com.example.autotests.utils.Utils;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.*;

public class CommentTest extends BaseTest {
    static ProfilePage profilePage;
    static Avatar avatar;
    static Post post;

    @BeforeAll
    static void initPost() {

        profilePage = new ProfilePage();
        avatar = new Avatar();
        post = new Post();
    }

    @ParameterizedTest
    @ValueSource(strings = {"589088855467", "567508353090", "569442670075"})
    void commentPostTest(String id) {
        open("https://ok.ru/profile/" + id);
        profilePage.openLastPostComments();
        String comment = Utils.generateLine();
        post.writeComment(comment);
        assertEquals(comment, post.getLastComment());
        post.deleteLastComment();
    }

    @ParameterizedTest
    @ValueSource(strings = {"589088855467", "567508353090"})
    void commentAvatarTest(String id) {
        open("https://ok.ru/profile/" + id);
        profilePage.openAvatar();
        String comment = Utils.generateLine();
        avatar.writeComment(comment);
        assertEquals(comment, avatar.getLastComment());
        avatar.deleteLastComment();
    }
}
