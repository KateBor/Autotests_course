package com.example.autotests.tests;

import com.example.autotests.pages.LoginPage;
import com.example.autotests.utils.User;
import org.junit.jupiter.api.BeforeAll;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.concurrent.TimeUnit;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.webdriver;

public class BaseTest {

    static User user1;
    static User user2;
    static LoginPage loginPage = new LoginPage();

    @BeforeAll
    static void init() {
        open("https://ok.ru");
        webdriver().object().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
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

        user1 = new User("Екатерина Борисова",login1, password1, "569442670075");
        user2 = new User("Лев С",login2, password2, "567508353090");
        loginPage.login(user1.getLogin(), user1.getPassword());
    }
}
