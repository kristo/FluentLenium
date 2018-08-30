package org.fluentlenium.adapter.cucumber.integration.driverperfeature.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.fluentlenium.adapter.cucumber.integration.driverperfeature.BaseTest;
import org.fluentlenium.adapter.cucumber.integration.page.LocalPage;
import org.fluentlenium.core.annotation.Page;

import static org.assertj.core.api.Assertions.assertThat;

public class SimpleFeatureMultiStep2 extends BaseTest {

    @Page
    protected LocalPage page2;

    @When(value = "feature multi2 I click on next page")
    public void step2() {
        el("a#linkToPage2").click();
    }

    @Then(value = "feature multi2 I am on the second page")
    public void step3() {
        page2.isAt();
    }
}