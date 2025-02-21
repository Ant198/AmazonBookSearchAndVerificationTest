package com.demo;

import com.demo.actions.Actions;
import com.demo.actions.BookActions;
import com.demo.actions.BooksListActions;
import com.demo.core.base.BaseTest;
import com.demo.pages.BookPage;
import com.demo.pages.HomePage;
import com.demo.pages.Pages;
import com.demo.utils.Constants;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import org.testng.Assert;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Selenide.*;
import java.util.List;

@Epic("Test Epic")
@Feature("Test feature")
@Owner("QA Fedorov Anton")

public class BookSearchAndVerificationTest extends BaseTest {

    @Test(description = "FirstTest")
    public void bookSearchAndVerificationTest() {
        String searchWord = System.getProperty("myArg", "Java");
        String fillterWord = System.getProperty("myArg", "Books");
        String currentUrl;
        String bookPageUrl = "https://www.amazon.com/Head-First-Java-Brain-Friendly-Guide/dp/1491910771/ref=sr_1_3?dib=eyJ2IjoiMSJ9.VhdqJr59jl-7CJ3ERsIzDhwY0Yqmtq6zSQ3g-YBLqcuH4jbxNxHxI_oaEJ34po07SuLg5VeaNDQSHs0b7IdSteKVObRDXSpWsnrJnaOk_jnbqJ6cG5Iov4rmDUctlouQ6jc8Nlgu0fjfRedgr6fThsNLGcBZaVUtUtoxqTCXdprGIIOGGOEKqJ7Ftvu7ZR3qsZ-dObChiFblwTaFQh9hG65ByHgb-OnPk_hWafBE25E.u6ZcV2uYDzTAJIF7BT6z4WyyCgQjC4m8qR-hYxBO7jg&dib_tag=se&keywords=Java&qid=1728470947&s=books&sr=1-3";
        logInfo("searchWord is " + searchWord);

        Pages.homePage().setFilter(fillterWord);
        Pages.homePage().typeText(searchWord);
        Pages.searchResultPage().setBooksList();

        open(bookPageUrl);

        Pages.bookPage().setBook();

        for(BookActions book : Pages.searchResultPage().getBooksList()) {
            Assert.assertTrue(book.getTitle().contains(searchWord), "some books do not have 'java' in a title");
        }
        Assert.assertTrue(Actions.mainActions().getCurrentUrl().contains(Constants.URL), "page not found");
        Assert.assertTrue(Pages.homePage().getDropdownBox(fillterWord).isSelected(), "filter not selected");
        Assert.assertFalse(Pages.searchResultPage().getBooksList().isEmpty(), "book list is empty, information does not save");
        Assert.assertTrue(Pages.searchResultPage().getBooksList().contains(Pages.bookPage().getBook()), "expected book not exist");
    }
}