package com.example.autotests.tests;

import com.example.autotests.elements.CreatePost;
import com.example.autotests.elements.Post;
import com.example.autotests.pages.ProfilePage;
import com.example.autotests.utils.Utils;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PostTest extends BaseTest{

    @Test
    public void writePost() {
        open("https://ok.ru/post");
        CreatePost createPost = new CreatePost();
        String postText = Utils.generateLine();
        createPost.writePost(postText);
        closeWebDriver();

        open("https://ok.ru");
        loginPage.login(user2.getLogin(), user2.getPassword());
        open("https://ok.ru/profile/" + user1.getId());
        ProfilePage profilePage = new ProfilePage();
        profilePage.openLastPostComments();
        Post post = new Post();
        assertEquals(postText, post.getArticle());
    }
}
