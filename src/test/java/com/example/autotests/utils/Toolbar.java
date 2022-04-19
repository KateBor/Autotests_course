package com.example.autotests.utils;

import com.example.autotests.pages.AvatarPage;
import lombok.Getter;
import org.openqa.selenium.By;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

@Getter
public class Toolbar {

    User user1, user2;

    public Toolbar() {
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
    }

    public void exit() {
        String xPathToolBar = "//div[@class='ucard-mini toolbar_ucard js-toolbar-menu']";
        String xPathChangeProfile = "//a[@class='button-pro __small __sec __wide']";
        $(By.xpath(xPathToolBar)).click();
        $(By.xpath(xPathChangeProfile)).click();
    }

    Random random = new Random();

    //Data Strategy
    public String generateLine() {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        return buffer.toString();
    }

    //Data Strategy
    public User getRandomUserWithAvatar() {
        Map<String, String> users = new HashMap<>();
        List<String> id = Arrays.asList("569442670075", "567508353090", "592921244707", "589088855467");
        users.put(id.get(0), "Екатерина Борисова");
        users.put(id.get(1), "Лев С");
        users.put(id.get(2), "Сергей Соин");
        users.put(id.get(3), "Дарья Дюрдева");
        User user = new User();

        int index = Math.abs(random.nextInt() % id.size());
        open("https://ok.ru/profile/" + id.get(index));
        AvatarPage avatarPage = new AvatarPage();

        while (!avatarPage.isAvatar()) {
            index = Math.abs(random.nextInt() % id.size());
            open("https://ok.ru/profile/" + id.get(index));
        }

        //Builder Pattern
        return new User.UserBuilder()
                .setFullName(user.id)
                .setId(id.get(index))
                .build();
    }

    //опционально: добавить метод проверки на корректный вход для других тестов для безопасной проверки
    //для проверки сообщений использовать 2 веб драйвера
    //добавить JUnit 5
    //добавить пакеты
    //добавить абстрактный класс над тестами для входа?
}
