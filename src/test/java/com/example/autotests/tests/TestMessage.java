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
        String login1 = null;
        String password1 = null;
        String login2 = null;
        String password2 = null;
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Sources.txt")));
            login1 = reader.readLine();
            password1 = reader.readLine();
            login2 = reader.readLine();
            password2 = reader.readLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        User user1 = new User("Екатерина Борисова",login1, password1, "569442670075");
        User user2 = new User("Лев С",login2, password2, "567508353090");
        LoginPage loginPage = new LoginPage();
        loginPage.login(user1.getLogin(), user1.getPassword());
        DialogPage dialogPage = new DialogPage();

        //отправляем сообщение
        open("https://ok.ru/messages/" + user2.getId());
        String message = toolbar.generateLine();
        dialogPage.sendMessage(message);
        toolbar.exit();

        //заходим с другого аккаунта и проверяем получение сообщения
        loginPage.login(user2.getLogin(), user2.getPassword());
        open("https://ok.ru/messages/" + user1.getId());
        String last = dialogPage.getLastMessage();
        System.out.println(last);
        assertEquals(message, last);
    }

}
