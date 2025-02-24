package com.demo.models;

import java.util.Objects;

public class BookModels {
    private String title;
    private String author;
    private String price;
    private String bestSeller;

    public void setTitle(String text) {
        this.title = text;
    }
    public String getTitle() { return title; }
    public void setAuthor(String text) {
        this.author = text;
    }
    public void setPrice(String text) {
        this.price = text;
    }
    public void setBestSeller(String text) {
        this.bestSeller = text;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BookModels book = (BookModels) obj;
        return Objects.equals(title, book.title)
                && Objects.equals(author, book.author)
                && Objects.equals(price, book.price)
                && Objects.equals(bestSeller, book.bestSeller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, author, price, bestSeller);
    }

}
