package com.example.autotests.tests;

import com.example.autotests.pages.MainPage;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

public class LoginTest extends BaseTest {

    @Test
    public void loginTest() {
        MainPage mainPage = new MainPage();
        assertTrue(mainPage.isLoadCheck(user1.getFullName()));
    }
}
