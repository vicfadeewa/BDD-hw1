package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private final SelenideElement verifyCodeField = $("[data-test-id=code] input");
    private final SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public VerificationPage() {
        verifyCodeField.shouldBe(Condition.visible);
    }

    public DashBoardPage validVerity(DataHelper.VerificationCode verificationCode) {
        verifyCodeField.setValue(verificationCode.getCode());
        verifyButton.click();
        return new DashBoardPage();
    }
}
