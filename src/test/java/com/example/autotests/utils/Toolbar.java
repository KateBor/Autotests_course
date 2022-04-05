package com.example.autotests.utils;
import org.openqa.selenium.By;
import java.util.Random;

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
}
