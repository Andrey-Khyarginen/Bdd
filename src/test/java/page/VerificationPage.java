package page;


import com.codeborne.selenide.SelenideElement;
import data.DataGenerator;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

    public class VerificationPage {
        private SelenideElement codeField = $("[data-test-id='code'] input");
        private SelenideElement verifyButton = $("button[data-test-id='action-verify']");

        public VerificationPage() {
            codeField.shouldBe(visible);
        }

        public DashboardPage validVerify(DataGenerator.VerificationCode verificationCode) {
            codeField.setValue(verificationCode.getCode());
            verifyButton.click();
            return new DashboardPage();
        }
}
