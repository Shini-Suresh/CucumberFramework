package stepdefinitions;

import Pages.AdminPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class AdminStepDefinitions {
    AdminPage adminPage=new AdminPage();
    @And("user navigates to Admin page")
    public void userNavigatesToAdminPage() {
        adminPage.navigateToAdminPage();
    }

    @And("user searches for a user with username {string}")
    public void userSearchesForAUserWithUsername(String arg0) {
    }

    @Then("user should see the user details")
    public void userShouldSeeTheUserDetails() {
    }
}
