package com.example.autotests.utils;

import org.openqa.selenium.By;

import java.util.*;

import static com.codeborne.selenide.Selenide.$;

public class Toolbar {
    public void exit() {
        String xPathToolBar = "//div[@class='ucard-mini toolbar_ucard js-toolbar-menu']";
        String xPathChangeProfile = "//a[@class='button-pro __small __sec __wide']";
        $(By.xpath(xPathToolBar)).click();
        $(By.xpath(xPathChangeProfile)).click();
    }

    Random random = new Random();

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

    public User getRandomUserNameAndId() {
        Map<String, String> users = new HashMap<>();
        List<String> id = Arrays.asList("569442670075", "567508353090", "592921244707", "589088855467");
        users.put(id.get(0), "Екатерина Борисова");
        users.put(id.get(1), "Лев С");
        users.put(id.get(2), "Сергей Соин");
        users.put(id.get(3), "Дарья Дюрдева");
        int index = Math.abs(random.nextInt() % id.size());
        User user = new User();

        user.setId(id.get(index));
        user.setFullName(user.id);
        return user;
    }
}
