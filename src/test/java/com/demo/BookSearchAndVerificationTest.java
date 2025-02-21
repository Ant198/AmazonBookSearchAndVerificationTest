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

        HomePage homePage = Pages.homePage();
        currentUrl = Actions.mainActions().getCurrentUrl();
        homePage.setFilter(fillterWord);
        homePage.typeText(searchWord);
        BooksListActions booksListActions = Actions.booksListActions();
        booksListActions.setBooksList();
        List<BookActions> books = booksListActions.getBooksList();

        open(bookPageUrl);

        BookPage bookPage = Pages.bookPage();
        BookActions expectedBook = bookPage.getBook();

        for(BookActions book : books) {
            Assert.assertTrue(book.getTitle().contains(searchWord), "some books do not have 'java' in a title");
        }
        Assert.assertTrue(currentUrl.contains(Constants.URL), "page not found");
        Assert.assertTrue(homePage.getDropdownBox(fillterWord).isSelected(), "filter not selected");
        Assert.assertFalse(books.isEmpty(), "book list is empty, information does not save");
        Assert.assertTrue(books.contains(expectedBook), "expected book not exist");
    }
}