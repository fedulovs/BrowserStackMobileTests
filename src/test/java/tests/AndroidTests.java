package tests;

import io.appium.java_client.MobileBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static io.qameta.allure.Allure.step;

@Tag("selenide_android")
public class AndroidTests extends TestBase {

    @Test
    @DisplayName("Successful search in wikipedia android app")
    void searchTest() {
        step("Type search", () -> {
            $(MobileBy.AccessibilityId("Search Wikipedia")).click();
            $(MobileBy.id("org.wikipedia.alpha:id/search_src_text")).val("BrowserStack");
        });
        step("Verify content found", () ->
                $$(MobileBy.id("org.wikipedia.alpha:id/page_list_item_container"))
                        .shouldHave(sizeGreaterThan(0)));
    }

    @Test
    @DisplayName("Check if bookmark page has empty placeholder")
    void openBookmarksTest() {
        step("Open bookmarks page", () -> {
            $(MobileBy.AccessibilityId("My lists")).click();
        });
        step("Assert empty list displayed", () -> {
            $(MobileBy.id("org.wikipedia.alpha:id/empty_title")).isDisplayed();
            $(MobileBy.id("org.wikipedia.alpha:id/empty_image")).isDisplayed();
            $(MobileBy.id("org.wikipedia.alpha:id/empty_messagee")).isDisplayed();
        });
    }

    @Test
    @DisplayName("Check if tab bar is displayed")
    void openMainPageTest() {
        step("Assert Explore tab is present", () -> {
            $(MobileBy.id("Explore")).isDisplayed();
        });
        step("Assert My lists tab is present", () -> {
            $(MobileBy.id("My lists")).isDisplayed();
        });
        step("Assert Explore tab is present", () -> {
            $(MobileBy.id("History")).isDisplayed();
        });
        step("Assert Explore tab is present", () -> {
            $(MobileBy.id("Nearby")).isDisplayed();
        });
    }
}
