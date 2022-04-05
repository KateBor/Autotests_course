package com.example.autotests.tests;
import com.example.autotests.utils.User;
import com.example.autotests.pages.LoginPage;
import com.example.autotests.pages.MainPage;
import org.junit.jupiter.api.*;

import java.io.*;

import static org.junit.jupiter.api.Assertions.*;
import static com.codeborne.selenide.Selenide.*;

public class TestLogin {

    @Test
    public void loginTest() {
        open("https://ok.ru");
        String login = null;
        String password = null;
        try{
            BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("Sources.txt")));
            login = reader.readLine();
            password = reader.readLine();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        User user = new User("Екатерина Борисова",login, password, null);
            LoginPage loginPage = new LoginPage();
            loginPage.login(user.getLogin(), user.getPassword());
            MainPage mainPage = new MainPage();
            assertEquals(mainPage.getName(), user.getFullName());
            System.out.println("Correct");
    }
}
