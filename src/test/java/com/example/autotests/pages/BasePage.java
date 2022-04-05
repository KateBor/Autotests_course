package com.example.autotests.pages;

public abstract class BasePage {
    public void check() { //паттерн Loadable Component
        //вариант - использовать в конструкторе через super
        //
        //explicitWait(ExpectedConditions.visibilityOfElementLocated(By.xPath(...)));
    }
}
