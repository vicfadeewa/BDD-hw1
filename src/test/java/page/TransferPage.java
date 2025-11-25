package page;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class TransferPage {
    private SelenideElement amountField = $("[data-test-id='amount'] input");
    private SelenideElement fromCardField = $("[data-test-id='from'] input");
    private SelenideElement transferButton = $("[data-test-id='action-transfer']");

    public TransferPage setAmount(int amount) {
        amountField.clear();
        amountField.setValue(String.valueOf(amount));
        return this;
    }
    public TransferPage setFromCard(String cardNumber) {
        fromCardField.clear();
        fromCardField.setValue(cardNumber);
        return this;
    }
    public void clickTransfer() {
        transferButton.click();
    }

}
