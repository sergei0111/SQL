package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import ru.netology.data.DataHelper;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage {
    private final SelenideElement loginSelector = $("[data-test-id='login'] input");
    private final SelenideElement passwordSelector = $("[data-test-id='password'] input");
    private final SelenideElement buttonSelector = $("[data-test-id='action-login']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");

    public void verifyErrorNotification(String errorText) {
        errorNotification.shouldHave(exactText(errorText)).shouldBe(Condition.visible);
    }

    public VerificationPage validLogin (DataHelper.AuthInfo info) {
        loginSelector.setValue(info.getLogin());
        passwordSelector.setValue(info.getPassword());
        buttonSelector.click();
        return new VerificationPage();
    }
}