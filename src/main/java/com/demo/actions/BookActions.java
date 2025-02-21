package com.demo.actions;

import java.util.Objects;

public class BookActions {
    private String name;
    private String author;
    private String price;
    private String bestSeller;

    public void setName(String text) {
        this.name = text;
    }
    public String getName() { return name; }
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
        BookActions book = (BookActions) obj;
        return Objects.equals(name, book.name)
                && Objects.equals(author, book.author)
                && Objects.equals(price, book.price)
                && Objects.equals(bestSeller, book.bestSeller);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, author, price, bestSeller);
    }

}
