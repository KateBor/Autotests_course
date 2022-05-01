package com.example.autotests.utils;

import lombok.NoArgsConstructor;
import java.util.*;
import static com.codeborne.selenide.Selenide.open;

@NoArgsConstructor
public class Utils {

    static Random random = new Random();

    //Data Strategy
    public static String generateLine() {
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
    public static User getRandomUserWithAvatar() {
        Map<String, String> users = new HashMap<>();
        List<String> id = Arrays.asList("589088855467", "567508353090", "592921244707");
        users.put(id.get(0), "Дарья Дюрдева");
        users.put(id.get(1), "Лев С");
        users.put(id.get(2), "Сергей Соин");
        User user = new User();

        int index = Math.abs(random.nextInt() % id.size());
        open("https://ok.ru/profile/" + id.get(index));

        //Builder Pattern
        return new User.UserBuilder()
                .setFullName(user.id)
                .setId(id.get(index))
                .build();
    }
}
