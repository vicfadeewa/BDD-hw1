package test;

import data.DataHelper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import page.DashBoardPage;
import page.LoginPage;

import static com.codeborne.selenide.Selenide.open;
import static data.DataHelper.generateValidAmount;
import static org.junit.jupiter.api.Assertions.assertAll;

public class MoneyTransferTest {
    DashBoardPage dashboardPage;
    DataHelper.CardInfo firstCardInfo;
    DataHelper.CardInfo secondCardInfo;
    int firstCardBalance;
    int secondCardBalance;


    @BeforeEach
    void setUp() {
        var loginPage = open("http://localhost:9999", LoginPage.class);
        var authInfo = DataHelper.getAuthInfo();
        var verificationPage = loginPage.validLogin(authInfo);
        var verificationCode = DataHelper.getVerificationCode();

        verificationPage.validVerity(verificationCode);
        firstCardInfo = DataHelper.getFirstCardInfo();
        secondCardInfo = DataHelper.getSecondCardInfo();
        firstCardBalance = dashboardPage.getCardBalance(firstCardInfo);
        secondCardBalance = dashboardPage.getCardBalance(secondCardInfo);

    }

    @Test
    void shouldTransferFromFirstToSecond() {
        var amount = generateValidAmount(firstCardBalance);
        var expectedBalanceFirstCard = firstCardBalance - amount;
        var expectedBalanceSecondCard = secondCardBalance + amount;
        var transferPage = dashboardPage.selectCardToTransfer(secondCardInfo);
        dashboardPage = transferPage.makeValidTransfer(String.valueOf(amount), firstCardInfo);
        dashboardPage.reloadDashboardPage();
        assertAll(
                () -> dashboardPage.checkCardBalance(firstCardInfo, expectedBalanceFirstCard),
                () -> dashboardPage.checkCardBalance(secondCardInfo, expectedBalanceSecondCard)
        );
    }
}

