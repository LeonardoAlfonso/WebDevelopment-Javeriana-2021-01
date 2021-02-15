package com.webDevelopment.solid.useCases;

import com.webDevelopment.solid.models.Book;
import com.webDevelopment.solid.services.Formatter;

public class BookCardFinder {

    private final Book book;

    public BookCardFinder() {
        book = new Book("1984", "George Orwell", 1949, 20d);
    }

    public String execute(Formatter formatter) {
        return formatter.Format(book.createBookCard());
    }
}
