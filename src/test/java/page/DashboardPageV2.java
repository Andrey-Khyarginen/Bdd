package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class DashboardPageV2 {
    private SelenideElement title = $("h1");
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement fromField = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");
    private SelenideElement errorNotification = $("[data-test-id='error-notification']");

    public DashboardPageV2() {
        title.shouldHave(text("Пополнение карты"), Condition.visible);
    }

    public DashboardPage cardReplenishment(String amount, DataGenerator.Card card) {
        amountField.setValue(amount);
        fromField.setValue(card.getCard());
        transferButton.click();
        return new DashboardPage();
    }

    public void cardReplenishmentError(String amount, DataGenerator.Card card) {
        amountField.setValue(amount);
        fromField.setValue(card.getCard());
        transferButton.click();
        errorNotification.shouldBe(visible);
    }
}
