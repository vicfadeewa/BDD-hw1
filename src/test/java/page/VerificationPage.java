package page;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import data.DataHelper;

import static com.codeborne.selenide.Selenide.$;

public class VerificationPage {
    private SelenideElement verifyCodeField = $("[data-test-id=code] input");
    private SelenideElement verifyButton = $("[data-test-id=action-verify]");

    public void checkPageVisibility(){
        verifyCodeField.shouldBe(Condition.visible);
    }
    public void validVerity(DataHelper.VerificationCode verificationCode){
        verifyCodeField.setValue(verificationCode.getCode());
        verifyButton.click();
    }
}
