package com.demo.actions;

public class Actions {

    private static BookActions bookActions;
    private static MainActions mainActions;
    private static BooksListActions booksListActions;

    public static BookActions bookActions() {
        if (bookActions == null) {
            bookActions = new BookActions();
        }
        return bookActions;
    }

    public static BooksListActions booksListActions() {
        if (booksListActions == null) {
            booksListActions = new BooksListActions();
        }
        return booksListActions;
    }

    public static MainActions mainActions() {
        if (mainActions == null) {
            mainActions = new MainActions();
        }
        return mainActions;
    }
}