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
    @DisplayName("Successful search in wikipedia android app")
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

//    @Test
//    @DisplayName("Successful search in wikipedia android app")
//    void settingsTest() {
//        step("Open dropdown", () -> {
//            $(MobileBy.id("org.wikipedia.alpha:id/menu_overflow_button")).click();
//        });
//        step("Click on settings button", () ->
//                $(MobileBy.id("org.wikipedia.alpha:id/explore_overflow_settings")).click());
//
//        step("Check that settings screen is opened", () ->
//                $(MobileBy.className("android.widget.TextView")).shouldHave());
//
//        step("Check that settings screen is opened", () ->
//                $(MobileBy.id("org.wikipedia.alpha:id/action_bar")).$(Selectors.ByText("13"))).shouldBe(Condition.visible);
//    }
}
