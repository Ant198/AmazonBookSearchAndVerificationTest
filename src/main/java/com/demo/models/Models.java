package com.demo.models;

public class Models {
    private static BookModels bookModels;

    public static BookModels bookModels() {
        if (bookModels == null) {
            bookModels = new BookModels();
        }
        return bookModels;
    }


}
