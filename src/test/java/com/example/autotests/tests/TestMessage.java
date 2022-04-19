package com.example.autotests.tests;

import com.example.autotests.utils.Toolbar;
import com.example.autotests.utils.User;
import com.example.autotests.pages.DialogPage;
import com.example.autotests.pages.LoginPage;
import org.junit.jupiter.api.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMessage {

    Toolbar toolbar = new Toolbar();
    @Test
    public void messageTest() {

        open("https://ok.ru");

        User user1 = toolbar.getUser1();
        User user2 = toolbar.getUser2();

        LoginPage loginPage = new LoginPage();
        loginPage.login(user1.getLogin(), user1.getPassword());
        DialogPage dialogPage = new DialogPage();

        //отправляем сообщение
        open("https://ok.ru/messages/" + user2.getId());
        String message = toolbar.generateLine();
        dialogPage.sendMessage(message);
        //toolbar.exit();

        //заходим с другого аккаунта и проверяем получение сообщения
        //переделать на 2 хром драйвера
        loginPage.login(user2.getLogin(), user2.getPassword());
        open("https://ok.ru/messages/" + user1.getId());
        String last = dialogPage.getLastMessage();
        System.out.println(last);
        assertEquals(message, last);
    }

}
