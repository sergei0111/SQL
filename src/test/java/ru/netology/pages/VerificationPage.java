package ru.netology.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement codeSelector = $("[data-test-id='code'] input");
    private final SelenideElement buttonVerifySelector = $("[data-test-id='action-verify']");
    private final SelenideElement errorNotification = $("[data-test-id='error-notification'] .notification__content");

    public void verifyErrorNotification(String errorText) {
        errorNotification.shouldHave(exactText(errorText)).shouldBe(visible);
    }
    public DashboardPage validVerify(String verificationCode) {
        verify(verificationCode);
        return new DashboardPage();
    }
    public void verify(String verificationCode) {
        codeSelector.setValue(verificationCode);
        buttonVerifySelector.click();
    }
}
